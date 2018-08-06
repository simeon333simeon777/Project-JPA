package com.cg.paytmwallet.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.cg.paytmwallet.bean.Account;
import com.cg.paytmwallet.exception.PaytmWalletException;
import com.cg.paytmwallet.service.PaytmWalletService;
import com.cg.paytmwallet.service.PaytmWalletServiceImpl;

public class PaytmWalletTest {
	private PaytmWalletService service;

	@Before
	public void init() {
	service = new PaytmWalletServiceImpl();
	}
	@Test
	public void testCreateAccountForName() {
	Account ac = new Account();
	ac.setMobileNo("1234567890");
	ac.setName("simeon777");
	ac.setEmail("simeon777@gmail.com");
	ac.setBalance(500.0);
	try {
	service.createAccount(ac);
	} catch (PaytmWalletException e) {
	assertEquals("Name should start with capital letter and should contain only alphabets", e.getMessage());
	}
	}
	@Test
	public void testCreateAccountForEmailId() {
	Account account = new Account();
	account.setMobileNo("1234567890");
	account.setName("Simeon");
	account.setEmail("simeon777@@gmail.com");
	account.setBalance(500.0);
	try {
	service.createAccount(account);
	} catch (PaytmWalletException e) {
	assertEquals("Enter valid emailid", e.getMessage());
	}
	}
	@Test
	public void testCreateAccount1(){
	Account ac = new Account();
	ac.setMobileNo("9999999999");
	ac.setName("Prasad");
	ac.setEmail("Prasad@gmail.com");
	ac.setBalance(200.0);
	 
	try {
	String s=service.createAccount(ac);
	assertNotNull(s);
	} catch (PaytmWalletException e) { 
	}	 
	}
	
	
	
	@Test
	public void testCreateAccountForNameIsEmpty() {
	Account ac = new Account();
	ac.setMobileNo("7981123927");
	ac.setName("");
	ac.setEmail("simeon777@gmail.com");
	ac.setBalance(500.0);
	try {
	service.createAccount(ac);
	} catch (PaytmWalletException e) {
	assertEquals("Name cannot be empty", e.getMessage());
	}
	}
	@Test
	public void testShowBalanceForMobileNo() {
	try {
	service.showBalance("95059");
	} catch (PaytmWalletException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testCreateAccount() {
	Account account = new Account();
	account.setMobileNo("7981123927");
	account.setName("Simeon");
	account.setEmail("simeon777@gmail.com");
	account.setBalance(500.0);
	}
/*	@Test
	public void testShowBalanceForName() {
	Account account=new Account();
	account.setMobileNo("8309955996");
	try {
	service.showBalance(account.getMobileNo());
	assertEquals("Simeon", account.getName());
	} catch (AccountWalletException e) {
	assertEquals("Exhausted Resultset",e.getMessage());
	}
	}*/
/*	@Test
	public void testShowBalanceForMobileNoDoesNotExist() {
	try {
	service.showBalance("9849807500");
	} catch (AccountWalletException e) {
	assertEquals("Exhausted Resultset",e.getMessage());
	}
	}*/
	@Test
	public void testDepositForMobileNo() {
	Account account=new Account();
	account.setMobileNo("79811239");
	try {
	service.deposit(account.getMobileNo(), 230);
	} catch (PaytmWalletException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
/*	@Test
	public void testDepositForMobileNoDoesNotExist() {
	Account account=new Account();
	account.setMobileNo("9948167788");
	try {
	service.deposit(account.getMobileNo(), 230);
	} catch (AccountWalletException e) {
	assertEquals("Exhausted Resultset",e.getMessage());
	}
	}*/
/*	@Test
	public void testDeposit() {
	Account account=new Account();
	account.setMobileNo("9505928555");
	try {
	Account account1=service.deposit(account.getMobileNo(), 230);
	assertNotNull(account1);
	} catch (AccountWalletException e) {
	 
	System.out.println(e.getMessage());
	}
	}*/
	 
	@Test
	public void testWithDrawForMobileNo() {
	Account ac=new Account();
	ac.setMobileNo("79811239");
	try {
	service.withdraw(ac.getMobileNo(), 230);
	} catch (PaytmWalletException e) {
    assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testWithdrawForMobileNoDoesNotExist() {
		/*Account ac=new Account();
	ac.setMobileNo("9396216550");
	try {
	service.withdraw(ac.getMobileNo(), 230);
	} catch (AccountWalletException e) {
	assertEquals("Exhausted Resultset",e.getMessage());
	}*/
	}
	@Test
	public void testDepositForDepositAmt1() {
	Account ac=new Account();
	ac.setMobileNo("9949565567");
	try {
	service.deposit(ac.getMobileNo(), -500);
	} catch (PaytmWalletException e) {
	assertEquals("Deposit amount must be greater than zero",e.getMessage());
	}
	}
	@Test
	public void testWithdrawForAmt() {
	Account acc=new Account();
	acc.setMobileNo("9949565567");
	try {
	service.withdraw(acc.getMobileNo(), -530);
	} catch (PaytmWalletException e) {
	assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
	}
	}
	 
	@Test
	public void testFundTransferForMobileNo() {
	Account account=new Account();
	Account account1=new Account();
	account.setMobileNo("7981123");
	account1.setMobileNo("1234");
	try {
	service.fundTransfer(account.getMobileNo(),account1.getMobileNo(), 230);
	} catch (PaytmWalletException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testFundTransferForMobileNoDoesNotExist() {
	Account acc=new Account();
	Account acc1=new Account();
	acc.setMobileNo("7981123927");
	acc1.setMobileNo("9949565567");
	/*try {
	service.fundTransfer(acc.getMobileNo(), acc1.getMobileNo(),  230);
	} catch (AccountWalletException e) {
	assertEquals("The mobile number does not exist",e.getMessage());
	}*/
	}
	//existing number should only given
	@Test
	public void testFundTransferForAmt() {
	Account account=new Account();
	Account account1=new Account();
	account.setMobileNo("9949565567");
	account1.setMobileNo("8309963649");
	try {
	service.fundTransfer(account.getMobileNo(), account1.getMobileNo(),  -500);
	} catch (PaytmWalletException e) {
	assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
	}
	}
	
	/*@Test
	public void testPrinttransactionDetails() {
	Account account=new Account();
	account.setMobileNo("7997776202");
	try {
	Account acc1=service.printTransactionDetails(account.getMobileNo());
	assertNotNull(acc1);
	} catch (AccountWalletException e) {
	System.out.println(e.getMessage());
	}
	 
	}*/
	@Test
	public void testTransfer() {
		/*Account a=new Account();
		Account a2=new Account();
	a.setMobileNo("9396216550");
	a2.setMobileNo("7416594746");
	try {
	assertTrue(service.fundTransfer(a.getMobileNo(), a2.getMobileNo(),  230));
	} catch (AccountWalletException e) {
	System.out.println(e.getMessage());
	}*/
	}
	@Test
	public void testCreateAccountForMobile() {
	Account ac = new Account();
	ac.setMobileNo("9573");
	ac.setName("Simeon");
	ac.setEmail("simeon@gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (PaytmWalletException e) {
	assertEquals("Mobile number should contain 10 digits", e.getMessage());
	}
	}
		@Test
			public void testPrinttransactionDetailsForIncorrectMobileNo() {
			Account ac=new Account();
			ac.setMobileNo("98492285");
		/*	try {
			Account acc=service.printTransactionDetails(ac.getMobileNo());
			assertNotNull(acc);
			} catch (AccountWalletException e) {
				assertEquals("Mobile number should contain 10 digits",e.getMessage());
			}*/
			 
			} 
		@Test
			public void testPrinttransactionDetailsForMObileNoDoesExistInDb() {
			Account ac=new Account();
			ac.setMobileNo("9875486310");
			/*try {
			Account acc=service.printTransactionDetails(ac.getMobileNo());
			assertNotNull(acc);
			} catch (AccountWalletException e) {
				assertEquals("The mobile number does not exist",e.getMessage());
			}*/
			 
			}  
		@Test
			public void testWithDrawForMobileNoInDb() {
				Account acc=new Account();
				acc.setMobileNo("8309963649");
		/*
*/
				} 
		

		@Test
		public void testFundTransferForAmt1() {
		Account ac=new Account();
		Account ac2=new Account();
		ac.setMobileNo("6666666666");
		ac2.setMobileNo("7777777777");
		try {
		service.fundTransfer(ac.getMobileNo(), ac2.getMobileNo(),  -230);
		} catch (PaytmWalletException e) {
		// TODO Auto-generated catch block
		assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
		}

		@Test
		public void testWithdrawForAmtIsZero() {
		Account ac=new Account();
		ac.setMobileNo("6666666666");
		try {
		service.withdraw(ac.getMobileNo(),0);
		} catch (PaytmWalletException e) {
		assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
		}
		}
	
}
