package com.paulinavelazquez.creditbooth.newcreditapplication;

import java.util.ArrayList;

public interface NewCreditApplicationRepositoryInterface {
    void save(NewCreditApplicationDTO newCreditApplicationDTO);
    NewCreditApplicationDTO find(String id);
    ArrayList<NewCreditApplicationDTO> findAlL();
}
