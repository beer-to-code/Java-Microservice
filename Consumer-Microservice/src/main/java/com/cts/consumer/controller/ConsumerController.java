package com.cts.consumer.controller;

import javax.validation.Valid;

import java.util.List;
import org.assertj.core.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cts.consumer.ConsumerMicroserviceApplication;
import com.cts.consumer.model.Property;
import com.cts.consumer.payload.request.BusinessPropertyRequest;
import com.cts.consumer.payload.request.ConsumerBusinessRequest;
import com.cts.consumer.payload.response.BusinessPropertyDetails;
import com.cts.consumer.payload.response.ConsumerBusinessDetails;
import com.cts.consumer.payload.response.MessageResponse;
import com.cts.consumer.repository.BusinessRepository;
import com.cts.consumer.repository.ConsumerRepository;
import com.cts.consumer.repository.PropertyRepository;
import com.cts.consumer.service.ConsumerService;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.spring.web.json.Json;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ConsumerController {
	
    private static final Logger log = LoggerFactory.getLogger(ConsumerMicroserviceApplication.class);


	@Autowired
	private ConsumerService consumerService;

	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private PropertyRepository propertyRepository;

	@PostMapping("/createConsumerBusiness")
	@HystrixCommand(fallbackMethod = "sendConsumerErrorResponse")
	public MessageResponse createConsumerBusiness(@Valid @RequestBody ConsumerBusinessRequest consumerBusinessRequest) throws Exception {
		log.info("Start createConsumerBusiness");
		if (!consumerService.checkBusinessEligibility(consumerBusinessRequest)) {
			return (new MessageResponse("Sorry!!, You are Not Eligibile for Insurance"));
		}
		MessageResponse messageResponse = consumerService.createConsumerBusiness(consumerBusinessRequest);
		log.debug("ConsumerBusiness Status: {}", messageResponse);
		log.info("End createConsumerBusiness");
		return (messageResponse);
	}

	@PostMapping("/updateConsumerBusiness")
	@HystrixCommand(fallbackMethod = "sendConsumerErrorResponse")
	public MessageResponse updateConsumerBusiness(@Valid @RequestBody ConsumerBusinessDetails consumerBusinessDetails) {
		log.info("Start updateConsumerBusiness");
		if (!consumerRepository.existsById(consumerBusinessDetails.getConsumerId())) {
			return (new MessageResponse("Sorry!!, No Consumer Found!!"));
		}
		if (!businessRepository.existsByConsumerId(consumerBusinessDetails.getConsumerId())) {
			return (new MessageResponse("Sorry!!, No Business Found!!"));
		}
		if (!businessRepository.existsById(consumerBusinessDetails.getBusinessid())) {
			return (new MessageResponse("Sorry!!, No Business Found!!"));
		}
		MessageResponse messageResponse = consumerService.updateConsumerBusiness(consumerBusinessDetails);
		log.debug("ConsumerBusiness Status: {}", messageResponse);
		log.info("End updateConsumerBusiness");
		return (messageResponse);
	}

	@GetMapping("/viewConsumerBusiness")
	@HystrixCommand(fallbackMethod = "sendConsumerErrorResponse")
	public ResponseEntity<?> viewConsumerBusiness(@Valid @RequestParam Long consumerid) {
		log.info("Start viewConsumerBusiness");
		if (!consumerRepository.existsById(consumerid)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Sorry!!, No Consumer Found!!"));
		}
		if (!businessRepository.existsByConsumerId(consumerid)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Sorry!!, No Business Found!!"));
		}
		ConsumerBusinessDetails consumerBusinessDetails = consumerService.viewConsumerBusiness(consumerid);
		log.debug("ConsumerBusiness Details: {}", consumerBusinessDetails);
		log.info("End viewConsumerBusiness");
		return ResponseEntity.ok(consumerBusinessDetails);
	}

	@GetMapping("/viewConsumerBusinessByPolicy")
	@HystrixCommand(fallbackMethod = "sendConsumerErrorResponse")
	public ConsumerBusinessDetails viewConsumerBusinessbypolicy(@Valid @RequestParam Long consumerid) {
		log.info("Start viewConsumerBusinessByPolicy");
		ConsumerBusinessDetails consumerBusinessDetails = consumerService.viewConsumerBusiness(consumerid);
		log.debug("ConsumerBusiness Details: {}", consumerBusinessDetails);
		log.info("End viewConsumerBusinessByPolicy");
		return consumerBusinessDetails;
	}

	@PostMapping("/createBusinessProperty")
	@HystrixCommand(fallbackMethod = "sendPropertyErrorResponse")
	public MessageResponse createBusinessProperty(@Valid @RequestBody BusinessPropertyRequest businessPropertyRequest) throws Exception {
		log.info("Start createBusinessProperty");
		if (!consumerRepository.existsById(businessPropertyRequest.getConsumerId())) {
			return (new MessageResponse("Sorry!!, No Consumer Found!!"));
		}
		if (!businessRepository.existsByConsumerId(businessPropertyRequest.getConsumerId())) {
			return (new MessageResponse("Sorry!!, No Business Found!!"));
		}
		if (!businessRepository.existsById(businessPropertyRequest.getBusinessId())) {
			return (new MessageResponse("Sorry!!, No Business Found!!"));
		}
		if (!consumerService.checkPropertyEligibility(businessPropertyRequest.getPropertytype(),
				businessPropertyRequest.getInsurancetype(), businessPropertyRequest.getBuildingtype(),businessPropertyRequest.getBuildingage())) {
			return (new MessageResponse("Sorry!!, You are Not Eligibile for Insurance"));
		}
		MessageResponse messageResponse = consumerService.createBusinessProperty(businessPropertyRequest);
		log.debug("BusinessProperty Status: {}", messageResponse);
		log.info("End createBusinessProperty");
		return (messageResponse);
	}

	@PostMapping("/updateBusinessProperty")
	@HystrixCommand(fallbackMethod = "sendPropertyErrorResponse")
	public MessageResponse updateBusinessProperty(@Valid @RequestBody BusinessPropertyDetails businessPropertyDetails) {
		log.info("Start updateBusinessProperty");
		if (!propertyRepository.existsById(businessPropertyDetails.getPropertyId())) {
			return (new MessageResponse("Sorry!!, No Property Found!!"));
		}
		if (!consumerRepository.existsById(businessPropertyDetails.getConsumerId())) {
			return (new MessageResponse("Sorry!!, No Consumer Found!!"));
		}
		if (!businessRepository.existsByConsumerId(businessPropertyDetails.getConsumerId())) {
			return (new MessageResponse("Sorry!!, No Business Found!!"));
		}
		if (!businessRepository.existsById(businessPropertyDetails.getBusinessId())) {
			return (new MessageResponse("Sorry!!, No Business Found!!"));
		}
		MessageResponse messageResponse = consumerService.updateBusinessProperty(businessPropertyDetails);
		log.debug("BusinessProperty Status: {}", messageResponse);
		log.info("End updateBusinessProperty");
		return (messageResponse);
	}

	@GetMapping("/viewConsumerProperty")
	@HystrixCommand(fallbackMethod = "sendPropertyErrorResponse")
	public ResponseEntity<?> viewConsumerProperty(@Valid @RequestParam Long consumerid, @RequestParam Long propertyid) {
		log.info("Start viewConsumerProperty");
		if (!propertyRepository.existsById(propertyid)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Sorry!!, No Property Found!!"));
		}
		if (!consumerRepository.existsById(consumerid)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Sorry!!, No Consumer Found!!"));
		}
		if (!businessRepository.existsByConsumerId(consumerid)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Sorry!!, No Business Found!!"));
		}
		Property property = consumerService.viewConsumerProperty(consumerid, propertyid);
		log.debug("BusinessProperty Details: {}", property);
		log.info("End viewConsumerProperty");
		return ResponseEntity.ok(property);
	}
	
//	@GetMapping(value="/redirect",consumes=MediaType.ALL_VALUE)
//    public String getApiDocs() {
//		String url="http://localhost:9090/consumer-api/v2/api-docs";
//		RestTemplate restTemplate=new RestTemplate();
//		
//		final String  apiData = restTemplate.getForObject(url, String.class);
////		System.out.println(restTemplate.getForObject(url, Object[].class));
//		System.out.println(apiData.toString());
////		return Arrays.asList(apiData);
//        return apiData;
//    }
	

	public MessageResponse sendPropertyErrorResponse() {
		return (new MessageResponse("(Property Error Response!!"));

	}

	public MessageResponse sendConsumerErrorResponse() {
		return (new MessageResponse("(Consumer Error Response!!"));

	}

}

