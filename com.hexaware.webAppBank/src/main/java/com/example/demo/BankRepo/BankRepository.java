package com.example.demo.BankRepo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entities.Bank;



public interface BankRepository extends CrudRepository<Bank, Integer> {

}
