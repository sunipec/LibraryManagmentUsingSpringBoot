package com.springBoot.LMS.springbootLMS.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.LMS.springbootLMS.Payload.purchaseDTO;
import com.springBoot.LMS.springbootLMS.Service.PurchaseService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseBookController {

	private PurchaseService purchaseService;

	public PurchaseBookController(PurchaseService purchaseService) {
		super();
		this.purchaseService = purchaseService;
	}
	
	@PostMapping("/book")
	public ResponseEntity<purchaseDTO> PurchaseBook(@RequestBody purchaseDTO purDto){
		return new ResponseEntity<purchaseDTO>(purchaseService.PurchaseBook(purDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/View/{pid}")
	public purchaseDTO ViewPurchaseById(@PathVariable("pid") int pid) {
		return purchaseService.ViewPurchase(pid);
	}
	
	@PostMapping("/delete/{pid}")
	public void DeleteBook(@PathVariable("pid")  int pid) {
		 purchaseService.deletePurchase(pid);
		
	}
	
}
