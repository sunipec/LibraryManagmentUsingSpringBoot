package com.springBoot.LMS.springbootLMS.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.LMS.springbootLMS.Entity.Subscription;
import com.springBoot.LMS.springbootLMS.Payload.SubscriptionDTO;
import com.springBoot.LMS.springbootLMS.Repository.SubscriptionRepository;
import com.springBoot.LMS.springbootLMS.Repository.UserRepository;
import com.springBoot.LMS.springbootLMS.Service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
     
	@Autowired
	private SubscriptionRepository susbsRepo;
	
	@Autowired
	private UserRepository userRepo;

//	public SubscriptionServiceImpl(SubscriptionRepository susbsRepo) {
//		super();
//		this.susbsRepo = susbsRepo;
//	}
	
	SubscriptionDTO getFromEntity(Subscription subs) {

		SubscriptionDTO subsDto = new SubscriptionDTO();
		subsDto.setSid(subs.getSid());
		subsDto.setPlan(subs.getPlan());
		subsDto.setCost(subs.getCost());
		subsDto.setDate(subs.getDate());
		subsDto.setUid(subs.getUser().getId());
		
		

		return subsDto;
	}

	Subscription getFromDTO(SubscriptionDTO  subsDto) {

		Subscription subs = new Subscription();
		subs.setSid(subsDto.getSid());
		subs.setPlan(subsDto.getPlan());
		subs.setCost(subsDto.getCost());
		subs.setDate(subsDto.getDate());
		subs.setUser(userRepo.findById(subsDto.getUid()).orElse(null));
		return subs;
	}

	@Override
	public SubscriptionDTO SubscribePlan(SubscriptionDTO subsDto) {
		
		Subscription subs = getFromDTO(subsDto);
		

			
		Subscription subsNew = susbsRepo.save(subs);

		SubscriptionDTO subsDtoNew = getFromEntity(subsNew);
		
		return (subsDtoNew);
		
	}

	@Override
	public void removeSubscription(int id) {
		susbsRepo.deleteById(id);
		
	}

	@Override
	public SubscriptionDTO ViewSubscription(int id) {
		
	Subscription subs = susbsRepo.findById(id).orElse(null);
	
	SubscriptionDTO newsubsDto = getFromEntity(subs);
	
	return newsubsDto;
	
	
	}
	
	
}
