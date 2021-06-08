package com.paulinavelazquez.creditbooth.newcreditapplication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
class NewCreditApplicationArrayListRepositoryTest {

    private final NewCreditApplicationArrayListRepository tested = new NewCreditApplicationArrayListRepository();

    @Test
    void givenCreditApplicationDTOThenSaveToRepository() {
        final NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
        tested.save(newCreditApplicationDTO);
        final ArrayList<NewCreditApplicationDTO> repositoryReturned = tested.findAlL();
        Assertions.assertEquals(1, repositoryReturned.size());
        Assertions.assertTrue(repositoryReturned.contains(newCreditApplicationDTO));
    }

    @Test
    void givenSocialSecurityReturnDTO() {
        final NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
        String fullName = "Rami Del Toro";
        String socialSecurity = "123";
        newCreditApplicationDTO.setFullName(fullName);
        newCreditApplicationDTO.setSocialSecurity(socialSecurity);
        tested.save(newCreditApplicationDTO);
        NewCreditApplicationDTO foundDTO = tested.find(socialSecurity);
        Assertions.assertSame(foundDTO, newCreditApplicationDTO);
    }

    @Test
    void givenDTONotFoundReturnNull() {
        String socialSecurity = null;
        final NewCreditApplicationDTO newCreditApplicationDTOFound = tested.find(socialSecurity);
        Assertions.assertNull(newCreditApplicationDTOFound);
    }

    @Test
    void givenDTONullSocialSecurityReturnNull() {
        final NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
        String fullName = "Rami Del Toro";
        String socialSecurity = null;
        newCreditApplicationDTO.setFullName(fullName);
        newCreditApplicationDTO.setSocialSecurity(socialSecurity);
        tested.save(newCreditApplicationDTO);

        final NewCreditApplicationDTO newCreditApplicationDTOFound = tested.find(socialSecurity);
        Assertions.assertNull(newCreditApplicationDTOFound);
    }

    @Test
    void findAllDTOsInRepository() {
        NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
        for (int i = 0; i < 10; i++) {
            newCreditApplicationDTO = new NewCreditApplicationDTO();
            tested.save(newCreditApplicationDTO);
        }
        final ArrayList<NewCreditApplicationDTO> repositoryReturned = tested.findAlL();
        Assertions.assertEquals(10, repositoryReturned.size());
    }
}