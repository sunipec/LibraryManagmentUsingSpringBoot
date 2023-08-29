package com.springBoot.LMS.springbootLMS.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springBoot.LMS.springbootLMS.Payload.purchaseDTO;

public interface PurchaseService {

	purchaseDTO PurchaseBook(purchaseDTO purchaseDto);
	
	purchaseDTO ViewPurchase(int id);
	
	void deletePurchase(int id);
}
