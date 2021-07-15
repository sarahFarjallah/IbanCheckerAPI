package main.java.service;


import java.util.ArrayList;
import main.java.dao.IbanChecker;
import main.java.common.Constants;
public class IbanCheckerResult {
public String accountNumber;
public IbanChecker checker;

	/**
	 * constructor defines the account number and creates an instance of IbanChecker class to use it later on
	 * @param acountNumber
	 */
	public IbanCheckerResult(String accountNumber) {
		this.accountNumber = accountNumber;
		this.checker = new IbanChecker(accountNumber);
	}
	
	/**
	 * method calls all the validation methods and 
	 * return a list of object each object having the name of the check being made along with the status if passed or failed and the message to be displayed on the ui
	 * @return [{check:"check IBAN Length", status:"Failed", message:"IBAN length is incorrect"},{...},{...}]
	 */
	public ArrayList<TableRowHM> validateIban() {
		ArrayList<TableRowHM> result = new ArrayList<TableRowHM>();
		result.add(this.callCheckLength());
		result.add(this.callCheckCountryCode());
		result.add(this.callCheckCountryIBANLength());
		result.add(this.callCheckIBANStructure());
		result.add(this.callCheckDigits());
		return result;
	}
	
	/**
	 * method calls the checkLength method in IbanChecker Class
	 * @return {check:"check IBAN Length", status:"Failed", message:"IBAN length is incorrect"}
	 */
	public TableRowHM callCheckLength() {
		Boolean valid = this.checker.checkLength();
		TableRowHM row = new TableRowHM();
		row.put(Constants.STATUS, valid ? Constants.PASSED : Constants.FAILED);
		row.put(Constants.CHECK, Constants.CHECK_LENGTH);
		row.put(Constants.MESSAGE, !valid ? Constants.CHECK_LENGTH_MESSAGE :"");
		return row;
	}
	
	/**
	 * method calls the callCheckCountryCode method in IbanChecker Class
	 * @return {check:"Country Code Check", status:"Passed", message:""}
	 */
	public TableRowHM callCheckCountryCode() {
		Boolean valid = this.checker.checkValidCountryCode();
		TableRowHM row = new TableRowHM();
		row.put(Constants.STATUS, valid ? Constants.PASSED : Constants.FAILED);
		row.put(Constants.CHECK, Constants.CHECK_CC);
		row.put(Constants.MESSAGE, !valid ? Constants.CHECK_CC_MESSAGE :"");
		return row;
	}
	
	/**
	 * method calls the callCheckCountryIBANLength method in IbanChecker Class
	 * @return {check:"Country Code Check", status:"Passed", message:""}
	 */
	public TableRowHM callCheckCountryIBANLength() {
		Boolean valid = this.checker.checkIbanCountryLength();
		TableRowHM row = new TableRowHM();
		row.put(Constants.STATUS, valid ? Constants.PASSED : Constants.FAILED);
		row.put(Constants.CHECK, Constants.CHECK_COUNTRY_IBAN_LENGTH);
		row.put(Constants.MESSAGE, !valid ? Constants.CHECK_COUNTRY_IBAN_LENGTH_MESSAGE :"");
		return row;
	}
	
	/**
	 * method calls the callCheckIBANStructure method in IbanChecker Class
	 * @return {check:"check IBAN Structure", status:"Passed", message:""}
	 */
	public TableRowHM callCheckIBANStructure() {
		Boolean valid = this.checker.checkValidStructure();
		TableRowHM row = new TableRowHM();
		row.put(Constants.STATUS, valid ? Constants.PASSED : Constants.FAILED);
		row.put(Constants.CHECK, Constants.CEHCK_IBAN_STRUCTURE);
		row.put(Constants.MESSAGE, !valid ? Constants.CEHCK_IBAN_STRUCTURE_MESSAGE :"");
		return row;
	}
	
	/**
	 * method calls the callCheckDigits method in IbanChecker Class
	 * @return {check:"check Digits", status:"Passed", message:""}
	 */
	public TableRowHM callCheckDigits() {
		Boolean valid = this.checker.checkDigits();
		TableRowHM row = new TableRowHM();
		row.put(Constants.STATUS, valid ? Constants.PASSED : Constants.FAILED);
		row.put(Constants.CHECK, Constants.CHECK_DIGITS);
		row.put(Constants.MESSAGE, !valid ? Constants.CHECK_DIGITS_MESSAGE :"");
		return row;
	}
}
