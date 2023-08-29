package com.springBoot.LMS.springbootLMS.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.LMS.springbootLMS.Entity.Purchase;
import com.springBoot.LMS.springbootLMS.Payload.purchaseDTO;
import com.springBoot.LMS.springbootLMS.Repository.BookRepository;
import com.springBoot.LMS.springbootLMS.Repository.UserRepository;
import com.springBoot.LMS.springbootLMS.Repository.purchaseRepo;
import com.springBoot.LMS.springbootLMS.Service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private purchaseRepo purRepo;
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private UserRepository userRepo;

//	public PurchaseServiceImpl(purchaseRepo purRepo) {
//
//		this.purRepo = purRepo;
//	}

	purchaseDTO getFromEntity(Purchase purchase) {

		purchaseDTO purDto = new purchaseDTO();
		purDto.setPid(purchase.getPid());
		purDto.setUid(purchase.getUser().getId());
		purDto.setBid(purchase.getBook().getBid());
		purDto.setBname(purchase.getBname());
		purDto.setCost(purchase.getCost());

		return purDto;
	}

	Purchase getFromDTO(purchaseDTO purDto) {

		Purchase purchase = new Purchase();
		purchase.setPid(purDto.getPid());
		purchase.setUser(userRepo.findById(purDto.getUid()).orElse(null));
		purchase.setBook(bookRepo.findById(purDto.getBid()).orElse(null));
		purchase.setBname(purDto.getBname());
		purchase.setCost(purDto.getCost());

		return purchase;
	}

	@Override
	public purchaseDTO PurchaseBook(purchaseDTO purchaseDto) {

		
		

			Purchase purchase = getFromDTO(purchaseDto);
			
//			
				
			Purchase purchaseNew = purRepo.save(purchase);

			purchaseDTO purDtoNew = getFromEntity(purchaseNew);
			return (purDtoNew);
//		}
//		
			
		
		
		
	
	}

	@Override
	public purchaseDTO ViewPurchase(int id) {
		Purchase purchase = purRepo.findById(id).orElse(null);
		
		purchaseDTO purDto=getFromEntity(purchase);
		return purDto;
	}
	
	
	@Override
	public void deletePurchase(int id) {
		purRepo.deleteById(id);
	}

}
