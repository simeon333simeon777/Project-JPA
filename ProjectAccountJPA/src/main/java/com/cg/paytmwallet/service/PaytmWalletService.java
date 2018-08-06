package com.cg.paytmwallet.service;

import com.cg.paytmwallet.bean.Account;
import com.cg.paytmwallet.exception.PaytmWalletException;

public interface PaytmWalletService {
	String createAccount(Account acc) throws PaytmWalletException;
	double showBalance(String mobileNo) 
			throws PaytmWalletException;
	Account deposit(String mobileNo,double depositAmount) throws PaytmWalletException;
	Account withdraw(String mobileNo,double withdrawAmount) throws PaytmWalletException;
	boolean fundTransfer(String sourceMobileNo,String destinationMobileNo,double transferAmount)
			throws PaytmWalletException;
	Account printTransactionDetails(String mobileNo) throws PaytmWalletException;

}
