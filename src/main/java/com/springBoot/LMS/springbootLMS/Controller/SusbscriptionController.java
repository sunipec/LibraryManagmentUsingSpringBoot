package com.springBoot.LMS.springbootLMS.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.LMS.springbootLMS.Payload.SubscriptionDTO;
import com.springBoot.LMS.springbootLMS.Service.SubscriptionService;

@RestController
@RequestMapping("/api/Subscribe")
public class SusbscriptionController {

	private SubscriptionService subsService;

	public SusbscriptionController(SubscriptionService subsService) {
		super();
		this.subsService = subsService;
	}
	
	@PostMapping
	public ResponseEntity<SubscriptionDTO> SubscribePlan(@RequestBody SubscriptionDTO subsDto){
		return new ResponseEntity<SubscriptionDTO>(subsService.SubscribePlan(subsDto), HttpStatus.CREATED);
	}
	
	@PostMapping("/remove/{sid}")
	public void removeSubscription(@PathVariable("sid") int id) {
		
		 subsService.removeSubscription(id);
	}
	
	@GetMapping("/view/{sid}")
	public SubscriptionDTO ViewSubscription(@PathVariable("sid") int id) {
		
		 return subsService.ViewSubscription(id);
	}
	
}
