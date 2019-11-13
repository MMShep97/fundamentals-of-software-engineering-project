//package com.canvas.config.services;
//
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.canvas.config.model.Account;
//import com.canvas.config.repo.AccountRepository;
//
//@Service
//public class AccountService {
//	@Autowired
//	AccountRepository repo;
//	
//	public List<Account> listAll(){
//		return repo.findAll();
//	}
//	
//	public boolean save(Account account) {
//		 if(repo.save(account) != null) {
//			 return true;
//		 }
//		return false;
//	}
//	
//	public Account getById(Long accountId) {
//		if(accountId == null) {
//			return null;
//		}
//		Account account  = repo.findAll().stream().filter(u -> u.getAccountId()== accountId).findFirst().get();
//		return  account;
//	}
//	
//	public void delete(Long accountId) {
//		repo.deleteById(accountId);
//	}
//	
//	public Account getByUsername(String username) {
//		Account account = repo.findAll().stream().filter(u -> u.getUsername().equalsIgnoreCase(username)).findFirst().get();
//		return account;
//	}
//}
