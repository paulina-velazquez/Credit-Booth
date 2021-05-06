package com.paulinavelazquez.creditbooth.newcreditapplication;

import com.paulinavelazquez.creditbooth.config.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(Constants.API_VERSION)
public class NewCreditApplicationController {

    private final NewCreditApplicationService newCreditApplicationService;

    public NewCreditApplicationController(NewCreditApplicationService newCreditApplicationService) {
        this.newCreditApplicationService = newCreditApplicationService;
    }

    @PostMapping(path = "/newcreditapplication", consumes = "application/json", produces = "application/json")
    public String acceptNewCreditApplication(NewCreditApplicationDTO newCreditApplicationDTO) {
        log.info("Accepting a New Request. New Credit Application dto = {}", newCreditApplicationDTO);
        newCreditApplicationService.handleNewCreditApplication(newCreditApplicationDTO);
        return "ok";
    }
}
