package com.cybage.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Component;

import com.cybage.model.Account;
@Component
public interface AccountService {

	List<Account> accounts =new ArrayList<Account>() ;
	public Account addAccount(Account account);
	
	public default  List<Account> getAllAccount(){
		return new ArrayList<>();
		
	};
	
	public Account auhorization(Account cardDetails);
}