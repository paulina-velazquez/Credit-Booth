package com.paulinavelazquez.creditbooth.newcreditapplication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NewCreditApplicationService {

        private final NewCreditApplicationRepositoryInterface newCreditApplicationRepository;
        private final ExperianCommunicator experianCommunicator;

        public NewCreditApplicationService(@Qualifier("newCreditApplicationArrayListRepository") NewCreditApplicationRepositoryInterface newCreditApplicationRepositoryInterface,
                                           final ExperianCommunicator experianCommunicator) {
            this.newCreditApplicationRepository = newCreditApplicationRepositoryInterface;
            this.experianCommunicator = experianCommunicator;
        }


        public void handleNewCreditApplication(NewCreditApplicationDTO newCreditApplicationDTO) {
            log.info("Handling a new credit application");
            newCreditApplicationRepository.save(newCreditApplicationDTO);
            experianCommunicator.postNewApplication(newCreditApplicationDTO);
        }
}
