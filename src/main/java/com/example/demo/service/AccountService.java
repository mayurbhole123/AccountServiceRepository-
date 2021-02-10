package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.AccountModel;

/**
 * Service interface is used for implementing abstract methods in service
 * implementation class.
 *
 */
public interface AccountService {
	public void save(AccountModel account);

	public ArrayList<AccountModel> getAllAccounts();
}
