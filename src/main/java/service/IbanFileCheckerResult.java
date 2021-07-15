package main.java.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import main.java.common.Constants;
import main.java.dao.IbanChecker;

public class IbanFileCheckerResult {
	public List<String> accountNumbers = new ArrayList<String>();
	/**
	 * constructor defines the account number and creates an instance of IbanChecker class to use it later on
	 * @param acountNumber
	 */
	public IbanFileCheckerResult(List<String> acountNumbers) {
		this.accountNumbers = acountNumbers;
	}
	
	/**
	 * method calls all the validation methods and 
	 * return a list of object each object having the name of the check being made along with the status if passed or failed and the message to be displayed on the ui
	 * @return [{check:"check IBAN Length", status:"Failed", message:"IBAN length is incorrect"},{...},{...}]
	 */
	public List<TableRowHM> validateIbanFile() {
		List<String> accountNumbers = this.accountNumbers;
		TableRowHM jsonReadyHM = new TableRowHM();
		List<TableRowHM> res = new ArrayList<TableRowHM>();
		for (int i=0; i<accountNumbers.size(); i++) {
			IbanCheckerResult checker = new IbanCheckerResult(accountNumbers.get(i));
			List<TableRowHM> validation = checker.validateIban();
			if (validation.stream().filter(e->e.getAsString(Constants.STATUS).equals(Constants.FAILED)).collect(Collectors.toList()).size() > 0) {
				jsonReadyHM.put(Constants.STATUS, Constants.FAILED);
				res.add(jsonReadyHM);
				return res;
			}
		}
		jsonReadyHM.put(Constants.STATUS, Constants.PASSED);
		res.add(jsonReadyHM);
		return res;
	}
	
}
