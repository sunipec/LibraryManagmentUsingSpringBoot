package com.springBoot.LMS.springbootLMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.LMS.springbootLMS.Entity.Purchase;

public interface purchaseRepo extends JpaRepository< Purchase, Integer> {

}
