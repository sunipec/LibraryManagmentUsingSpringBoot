package com.springBoot.LMS.springbootLMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.LMS.springbootLMS.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
