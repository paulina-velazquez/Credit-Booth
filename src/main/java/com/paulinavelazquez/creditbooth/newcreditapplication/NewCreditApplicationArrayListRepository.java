package com.paulinavelazquez.creditbooth.newcreditapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Slf4j
@Repository
public class NewCreditApplicationArrayListRepository implements NewCreditApplicationRepositoryInterface {

    ArrayList<NewCreditApplicationDTO> arrayListRepository = new ArrayList<>();

    @Override
    public void save(NewCreditApplicationDTO newCreditApplicationDTO) {
        arrayListRepository.add(newCreditApplicationDTO);
        log.info("Saved a new credit application.");
    }

    @Override
    public NewCreditApplicationDTO find(String socialSecurity) {
//        NewCreditApplicationDTO newCreditApplicationDTOToReturn = null;
//        for (NewCreditApplicationDTO newCreditApplicationDTO : arrayListRepository) {
//            if ((socialSecurity != null) && (socialSecurity.equals(newCreditApplicationDTO.getSocialSecurity()))) {
//                newCreditApplicationDTOToReturn = newCreditApplicationDTO;
//                break;
//            }
//        }
//        return newCreditApplicationDTOToReturn;

        // JAVA STREAM: (functional programming)
        // The boolean inside .filter() should always be true in order to continue to the next function aka .findAny
        return arrayListRepository.stream()
                .filter(dto -> (socialSecurity != null) && (socialSecurity.equals(dto.getSocialSecurity())))
                .findAny()
                .orElse(null);
    }

    @Override
    public ArrayList<NewCreditApplicationDTO> findAlL() {
        return arrayListRepository;
    }
}
