package com.springBoot.LMS.springbootLMS.Service;

import com.springBoot.LMS.springbootLMS.Payload.SubscriptionDTO;

public interface SubscriptionService {

	SubscriptionDTO SubscribePlan(SubscriptionDTO subsDto);
	
	void removeSubscription(int id);
	
	SubscriptionDTO ViewSubscription(int id);
}
