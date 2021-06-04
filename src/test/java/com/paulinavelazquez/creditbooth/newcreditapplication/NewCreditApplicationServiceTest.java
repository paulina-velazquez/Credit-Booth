package com.paulinavelazquez.creditbooth.newcreditapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NewCreditApplicationServiceTest {


    private final NewCreditApplicationRepositoryInterface newCreditApplicationRepository = mock(NewCreditApplicationRepositoryInterface.class);
    private final ExperianCommunicator experianCommunicator = mock(ExperianCommunicator.class);

    private NewCreditApplicationService newCreditApplicationService;

    @BeforeEach
    void setUp() {
        newCreditApplicationService = new NewCreditApplicationService(newCreditApplicationRepository, experianCommunicator);
    }

    @Test
    void givenADTOSavesAndPosts() {
        final NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
        newCreditApplicationService.handleNewCreditApplication(newCreditApplicationDTO);
        verify(newCreditApplicationRepository).save(any(NewCreditApplicationDTO.class));
        verify(experianCommunicator).postNewApplication(any(NewCreditApplicationDTO.class));
    }

    @Test
    void givenADTOAndSavesThrowsExceptionThenDontPost() {
        NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
        doThrow(new RuntimeException("can't handle new credit application - unit test")).when(newCreditApplicationRepository).save(any(NewCreditApplicationDTO.class));
        assertThrows(RuntimeException.class, () -> {
            newCreditApplicationService.handleNewCreditApplication(newCreditApplicationDTO);
        });
        verify(experianCommunicator, Mockito.times(0)).postNewApplication(any(NewCreditApplicationDTO.class));
    }

    @Test
    void givenPostThrewExceptionThenSaveAndThrowException() {
        NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
        doThrow(new RuntimeException("network error with experian")).when(experianCommunicator).postNewApplication(any(NewCreditApplicationDTO.class));
        assertThrows(RuntimeException.class, () -> {
            newCreditApplicationService.handleNewCreditApplication(newCreditApplicationDTO);
        });
        verify(newCreditApplicationRepository).save(any(NewCreditApplicationDTO.class));
    }
}