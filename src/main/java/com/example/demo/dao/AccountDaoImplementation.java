package com.example.demo.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AccountModel;

/**
 * Account dao class to fetch account details.
 *
 */
@Repository
public class AccountDaoImplementation implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(AccountModel account) {
		sessionFactory.getCurrentSession().save(account);

	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<AccountModel> getAllAccounts() {
		// TODO Auto-generated method stub
		return (ArrayList<AccountModel>) sessionFactory.getCurrentSession().createQuery("from AccountModel")
				.getResultList();
	}

}
