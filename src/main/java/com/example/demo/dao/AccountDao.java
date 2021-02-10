package com.example.demo.dao;

import java.util.ArrayList;

import com.example.demo.model.AccountModel;

/**
 * Interface having all abstract method syntax, will use this interface when we
 * will implement its implementation.
 *
 */
public interface AccountDao {
	public void save(AccountModel account);

	public ArrayList<AccountModel> getAllAccounts();
}
