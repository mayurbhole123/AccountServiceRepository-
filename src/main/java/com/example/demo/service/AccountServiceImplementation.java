package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AccountDao;
import com.example.demo.model.AccountModel;

/**
 * Service implementation class will used to call dao methods from the
 * controller.
 *
 */
@Service
@Transactional
public class AccountServiceImplementation implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Override
	public void save(AccountModel account) {
		// TODO Auto-generated method stub
		accountDao.save(account);
	}

	@Override
	public ArrayList<AccountModel> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountDao.getAllAccounts();
	}

}
