package com.paulinavelazquez.creditbooth.newcreditapplication;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "experian-communicator")
public interface ExperianCommunicator {
    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/newcreditapplication", produces = "application/json")
    String postNewApplication(final NewCreditApplicationDTO newCreditApplicationDTO);
}
