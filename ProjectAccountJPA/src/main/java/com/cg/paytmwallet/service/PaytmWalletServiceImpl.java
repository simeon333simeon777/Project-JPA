package com.cg.paytmwallet.service;

import java.time.LocalDateTime;

import java.util.HashMap;

import com.cg.paytmwallet.bean.Account;
import com.cg.paytmwallet.dao.PaytmWalletDao;
import com.cg.paytmwallet.dao.PaytmWalletImpl;
import com.cg.paytmwallet.exception.PaytmWalletException;

public class PaytmWalletServiceImpl implements PaytmWalletService {
	PaytmWalletDao dao = new PaytmWalletImpl();

	public String createAccount(Account acc) throws PaytmWalletException {
		if (!acc.getMobileNo().matches("\\d{10}")) {
			throw new PaytmWalletException("Mobile number should contain 10 digits");
			}
			if (acc.getName().isEmpty() || acc.getName() == null) {
			throw new PaytmWalletException("Name cannot be empty");
			} else {
			if (!acc.getName().matches("[A-Z][A-Za-z]{3,}")) {
			throw new PaytmWalletException(
			"Name should start with capital letter and should contain only alphabets");
			}
			}
			if (acc.getBalance() < 0) {
			throw new PaytmWalletException("Balance should be greater than zero");
			}
			if (!acc.getEmail().matches("[a-z]+@[a-z]+\\.com")) {
			throw new PaytmWalletException("Enter valid emailid");
			}

			return dao.createAccount(acc);
	}

	public double showBalance(String mobileNo) throws PaytmWalletException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaytmWalletException("Mobile number should contain 10 digits");
			}
			return dao.showBalance(mobileNo);
	}

	public Account deposit(String mobileNo, double depositAmount) throws PaytmWalletException {
		if (!mobileNo.matches("\\d{10}")) {
			throw new PaytmWalletException("Mobile number should contain 10 digits");
			}
			//Account acc=dao.findOne(mobileNo);
			if (depositAmount <= 0) {
			throw new PaytmWalletException(
			"Deposit amount must be greater than zero");
			}
			 
			return dao.deposit(mobileNo,depositAmount);
			//acc1.getBalance();
	}

	public Account withdraw(String mobileNo, double withdrawAmount) throws PaytmWalletException {
		if (!mobileNo.matches("\\d{10}")) {
					throw new PaytmWalletException("Mobile number should contain 10 digits");
				}
				//Account acc=dao.findOne(mobileNo);
				//if (withdrawAmt > acc.getBalance() || withdrawAmt <= 0) {
				if ( withdrawAmount <= 0) {
				throw new PaytmWalletException(
				"The amount to be withdrawn should be greater than available balance and greater than zero");
				}
				//acc.setBalance(acc.getBalance() - withdrawAmt);
				// acc.setDate(LocalDateTime.now());
				Account acc1 = dao.withdraw(mobileNo,withdrawAmount);
				return acc1;
	}

	public boolean fundTransfer(String sourceMobileNo, String destinationMobileNo, double transferAmount)
			throws PaytmWalletException {
		if (!sourceMobileNo.matches("\\d{10}")) {
			throw new PaytmWalletException("Mobile number should contain 10 digits");
			}
			if (!destinationMobileNo.matches("\\d{10}")) {
			throw new PaytmWalletException("Mobile number should contain 10 digits");
			}
			PaytmWalletService service = new PaytmWalletServiceImpl();
			Account acc1 = service.withdraw(sourceMobileNo, transferAmount);
			Account d2 = service.deposit(destinationMobileNo, transferAmount);
			return true;
	}

	public Account printTransactionDetails(String mobileNo) throws PaytmWalletException {
		return dao.printTransactionDetails(mobileNo);
	}

	
	
	
}


