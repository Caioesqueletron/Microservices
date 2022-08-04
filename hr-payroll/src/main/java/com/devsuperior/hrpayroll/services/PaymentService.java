package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PaymentService {



   @Autowired
   private WorkerFeignClient workerFeignClient;
    public Payment getPayment(long workerId, int days){


       Optional<Worker> worker = workerFeignClient.findById(String.valueOf(workerId)).getBody();
        return new Payment(worker.get().getName(), worker.get().getDailyIncome(), days);
    }
}
