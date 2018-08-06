package com.cg.paytmwallet.dao;

import com.cg.paytmwallet.bean.Account;
import com.cg.paytmwallet.exception.PaytmWalletException;

public interface PaytmWalletDao {
	String createAccount(Account acc) throws PaytmWalletException;
	double showBalance(String mobileNo) throws PaytmWalletException;
	Account deposit(String mobileNo,double depAmount) throws PaytmWalletException;
	Account withdraw(String mobileNo,double withdraw) throws PaytmWalletException;
	Account printTransactionDetails(String mobileNo) throws PaytmWalletException;

}
