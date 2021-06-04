package com.paulinavelazquez.creditbooth.newcreditapplication;

import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;


public class NewCreditApplicationArrayListRepositoryTest {

    private final NewCreditApplicationArrayListRepository tested = new NewCreditApplicationArrayListRepository();

    @Test
    public void givenCreditApplicationDTOThenSaveToRepository() {
        final NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
        tested.save(newCreditApplicationDTO);
        final ArrayList<NewCreditApplicationDTO> repositoryReturned = tested.findAlL();
        assertEquals(1, repositoryReturned.size());
        assertTrue(repositoryReturned.contains(newCreditApplicationDTO));
    }

    @Test
    public void givenSocialSecurityReturnDTO() {
        final NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
        String fullName = "Rami Del Toro";
        String socialSecurity = "123";
        newCreditApplicationDTO.setFullName(fullName);
        newCreditApplicationDTO.setSocialSecurity(socialSecurity);
        tested.save(newCreditApplicationDTO);
        NewCreditApplicationDTO foundDTO = tested.find(socialSecurity);
        assertSame(foundDTO, newCreditApplicationDTO);
    }

    @Test
    public void givenDTONotFoundReturnNull() {
        String socialSecurity = null;
        final NewCreditApplicationDTO newCreditApplicationDTOFound = tested.find(socialSecurity);
        assertNull(newCreditApplicationDTOFound);
    }

    @Test
    public void givenDTONullSocialSecurityReturnNull() {
        final NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
        String fullName = "Rami Del Toro";
        String socialSecurity = null;
        newCreditApplicationDTO.setFullName(fullName);
        newCreditApplicationDTO.setSocialSecurity(socialSecurity);
        tested.save(newCreditApplicationDTO);

        final NewCreditApplicationDTO newCreditApplicationDTOFound = tested.find(socialSecurity);
        assertNull(newCreditApplicationDTOFound);
    }

    @Test
    public void findAllDTOsInRepository() {
        NewCreditApplicationDTO newCreditApplicationDTO = new NewCreditApplicationDTO();
        for (int i = 0; i < 10; i++) {
            newCreditApplicationDTO = new NewCreditApplicationDTO();
            tested.save(newCreditApplicationDTO);
        }
        final ArrayList<NewCreditApplicationDTO> repositoryReturned = tested.findAlL();
        assertEquals(10, repositoryReturned.size());
    }
}