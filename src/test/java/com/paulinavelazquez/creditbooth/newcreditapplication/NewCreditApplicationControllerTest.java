package com.paulinavelazquez.creditbooth.newcreditapplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NewCreditApplicationControllerTest {

    @Mock
    private NewCreditApplicationService newCreditApplicationServiceMock;

    @InjectMocks
    private NewCreditApplicationController newCreditApplicationController;

    @BeforeEach
    void setUp() {
        newCreditApplicationController = new NewCreditApplicationController(newCreditApplicationServiceMock);
    }

    @Test
    void givenANewCreditApplicationDTOReturnOK() {
        final NewCreditApplicationDTO dtoThatIAmPassingInTheController = new NewCreditApplicationDTO();
        doNothing().when(newCreditApplicationServiceMock).handleNewCreditApplication(any(NewCreditApplicationDTO.class));
        final String responseReturnedFromController = newCreditApplicationController.acceptNewCreditApplication(dtoThatIAmPassingInTheController);
        Assertions.assertEquals("ok",responseReturnedFromController);
        verify(newCreditApplicationServiceMock).handleNewCreditApplication(any(NewCreditApplicationDTO.class));
    }

    @Test
    void givenANewCreditApplicationDTOInvokeNewCreditApplicationServiceOnce() {
        final NewCreditApplicationDTO dtoThatIAmPassingInTheController = new NewCreditApplicationDTO();
        doNothing().when(newCreditApplicationServiceMock).handleNewCreditApplication(dtoThatIAmPassingInTheController);
        newCreditApplicationController.acceptNewCreditApplication(dtoThatIAmPassingInTheController);
        verify(newCreditApplicationServiceMock).handleNewCreditApplication(any(NewCreditApplicationDTO.class));
    }

    @Test
    void givenANullDTOReturnOK() {
        String response = newCreditApplicationController.acceptNewCreditApplication(null);
        Assertions.assertEquals("ok", response);
    }

    @Test
    void givenHandleNewCreditApplicationThrewExceptionReturnServerError() {
        assertThrows(RuntimeException.class, () -> {
            NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
            doThrow(new RuntimeException("can't handle new credit application - unit test")).when(newCreditApplicationServiceMock).handleNewCreditApplication(any(NewCreditApplicationDTO.class));
            newCreditApplicationController.acceptNewCreditApplication(newCreditApplicationDTO);
        });
    }
}