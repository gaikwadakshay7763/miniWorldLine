package com.cybage.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cybage.databaseConnection.ExcelDataHandler;
import com.cybage.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	ExcelDataHandler excelDataHandler;
	
	@Override
	public Account addAccount(Account account) {
		
		accounts.add(account);
		try {
			excelDataHandler.appendData(accounts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public List<Account> getAllAccount() {
		
		List list = new ArrayList<>();
		try {
			 list = excelDataHandler.readData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>(list);
	}

	@Override
	public Account auhorization(Account cardDetails) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
