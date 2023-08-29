package com.springBoot.LMS.springbootLMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.LMS.springbootLMS.Entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

}
