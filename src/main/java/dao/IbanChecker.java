package main.java.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class IbanChecker {

    public static final int IBAN_MIN_LEN = 15;
    public static final int IBAN_MAX_LEN = 34;
    public static final BigInteger IBAN_MOD = new BigInteger("97");
    
    public String accountNumber;
    public Map<String, List<String>> countries_iban = new HashMap<String, List<String>>();
    
    	

    public IbanChecker(String accountNumber) {
    	this.accountNumber = accountNumber.trim().replaceAll(" ", "");
    	Map<String, List<String>> countries_iban = new HashMap<String, List<String>>();
    	countries_iban.put("AD", new ArrayList<String>(Arrays.asList("24", "AD\\d{10}[A-Z0-9]{12}","Andorra")));  
        countries_iban.put("AE", new ArrayList<String>( Arrays.asList("23", "AE\\d{21}","United Arab Emirates")));  
        countries_iban.put("AL", new ArrayList<String>( Arrays.asList("28", "AL\\d{10}[A-Z0-9]{16}","Albania")));  
        countries_iban.put("AT", new ArrayList<String>( Arrays.asList("20", "AT\\d{18}" ,"Austria")));  
        countries_iban.put("AZ", new ArrayList<String>( Arrays.asList("28", "AZ\\d{2}[A-Z]{4}[A-Z0-9]{20}","Republic of Azerbaijan")));    
        countries_iban.put("BA", new ArrayList<String>( Arrays.asList("20", "BA\\d{18}" ,"Bosnia and Herzegovina")));    
        countries_iban.put("BE", new ArrayList<String>( Arrays.asList("16", "BE\\d{14}" ,"Belgium")));  
        countries_iban.put("BG", new ArrayList<String>( Arrays.asList("22", "BG\\d{2}[A-Z]{4}\\d{6}[A-Z0-9]{8}","Bulgaria")));  
        countries_iban.put("BH", new ArrayList<String>( Arrays.asList("22", "BH\\d{2}[A-Z]{4}[A-Z0-9]{14}" ,"Bahrain")));  
        countries_iban.put("BR", new ArrayList<String>( Arrays.asList("29", "BR\\d{25}[A-Z]{1}[A-Z0-9]{1}","Brazil")));  
        countries_iban.put("BY", new ArrayList<String>( Arrays.asList("28", "BY\\d{2}[A-Z0-9]{4}\\d{4}[A-Z0-9]{16}","Republic of Belarus"))); 
        countries_iban.put("CH", new ArrayList<String>( Arrays.asList("21", "CH\\d{7}[A-Z0-9]{12}","Switzerland")));  
        countries_iban.put("CR", new ArrayList<String>( Arrays.asList("22", "CR\\d{20}","Costa Rica")));  
        countries_iban.put("CY", new ArrayList<String>( Arrays.asList("28", "CY\\d{10}[A-Z0-9]{16}","Cyprus")));  
        countries_iban.put("CZ", new ArrayList<String>( Arrays.asList("24", "CZ\\d{22}","Czech Republic")));  
        countries_iban.put("DE", new ArrayList<String>( Arrays.asList("22", "DE\\d{20}","Germany")));  
        countries_iban.put("DK", new ArrayList<String>( Arrays.asList("18", "DK\\d{16}","Denmark")));  
        countries_iban.put("DO", new ArrayList<String>( Arrays.asList("28", "DO\\d{2}[A-Z0-9]{4}\\d{20}","Dominican Republic")));  
        countries_iban.put("EE", new ArrayList<String>( Arrays.asList("20", "EE\\d{18}","Estonia")));  
        countries_iban.put("ES", new ArrayList<String>( Arrays.asList("24", "ES\\d{22}","Spain")));  
        countries_iban.put("FI", new ArrayList<String>( Arrays.asList("18", "FI\\d{16}","Finland")));  
        countries_iban.put("FO", new ArrayList<String>( Arrays.asList("18", "FO\\d{16}","Denmark")));   
        countries_iban.put("FR", new ArrayList<String>( Arrays.asList("27", "FR\\d{12}[A-Z0-9]{11}\\d{2}","France")));  
        countries_iban.put("GB", new ArrayList<String>( Arrays.asList("22", "GB\\d{2}[A-Z]{4}\\d{14}","United Kingdom")));  
        countries_iban.put("GE", new ArrayList<String>( Arrays.asList("22", "GE\\d{2}[A-Z]{2}\\d{16}","Georgia")));  
        countries_iban.put("GI", new ArrayList<String>( Arrays.asList("23", "GI\\d{2}[A-Z]{4}[A-Z0-9]{15}","Gibraltar")));  
        countries_iban.put("GL", new ArrayList<String>( Arrays.asList("18", "GL\\d{16}","Denmark")));   
        countries_iban.put("GR", new ArrayList<String>( Arrays.asList("27", "GR\\d{9}[A-Z0-9]{16}","Greece")));  
        countries_iban.put("GT", new ArrayList<String>( Arrays.asList("28", "GT\\d{2}[A-Z0-9]{24}","Guatemala")));  
        countries_iban.put("HR", new ArrayList<String>( Arrays.asList("21", "HR\\d{19}","Croatia")));  
        countries_iban.put("HU", new ArrayList<String>( Arrays.asList("28", "HU\\d{26}","Hungary")));  
        countries_iban.put("IE", new ArrayList<String>( Arrays.asList("22", "IE\\d{2}[A-Z]{4}\\d{14}","Ireland")));  
        countries_iban.put("IL", new ArrayList<String>( Arrays.asList("23", "IL\\d{21}","Israel")));  
        countries_iban.put("IS", new ArrayList<String>( Arrays.asList("26", "IS\\d{24}" ,"Iceland")));  
        countries_iban.put("IT", new ArrayList<String>( Arrays.asList("27", "IT\\d{2}[A-Z]{1}\\d{10}[A-Z0-9]{12}","Italy")));  
        countries_iban.put("IQ", new ArrayList<String>( Arrays.asList("23", "IQ\\d{2}[A-Z]{4}\\d{15}","Iraq")));  
        countries_iban.put("JO", new ArrayList<String>( Arrays.asList("30", "JO\\d{2}[A-Z]{4}\\d{4}[A-Z0-9]{18}","Jordan")));  
        countries_iban.put("KW", new ArrayList<String>( Arrays.asList("30", "KW\\d{2}[A-Z]{4}[A-Z0-9]{22}","Kuwait")));  
        countries_iban.put("KZ", new ArrayList<String>( Arrays.asList("20", "KZ\\d{5}[A-Z0-9]{13}","Kazakhstan")));  
        countries_iban.put("LB", new ArrayList<String>( Arrays.asList("28", "LB\\d{6}[A-Z0-9]{20}","Lebanon")));  
        countries_iban.put("LC", new ArrayList<String>( Arrays.asList("32", "LC\\d{2}[A-Z]{4}[A-Z0-9]{24}","Saint Lucia")));  
        countries_iban.put("LI", new ArrayList<String>( Arrays.asList("21", "LI\\d{7}[A-Z0-9]{12}","Liechtenstein")));   
        countries_iban.put("LT", new ArrayList<String>( Arrays.asList("20", "LT\\d{18}","Lithuania")));  
        countries_iban.put("LU", new ArrayList<String>( Arrays.asList("20", "LU\\d{5}[A-Z0-9]{13}","Luxembourg")));  
        countries_iban.put("LV", new ArrayList<String>( Arrays.asList("21", "LV\\d{2}[A-Z]{4}[A-Z0-9]{13}","Latvia")));  
        countries_iban.put("MC", new ArrayList<String>( Arrays.asList("27", "MC\\d{12}[A-Z0-9]{11}\\d{2}","Monaco")));  
        countries_iban.put("MD", new ArrayList<String>( Arrays.asList("24", "MD\\d{2}[A-Z0-9]{20}","Moldova")));  
        countries_iban.put("ME", new ArrayList<String>( Arrays.asList("22", "ME\\d{20}","Montenegro")));  
        countries_iban.put("MK", new ArrayList<String>( Arrays.asList("19", "MK\\d{5}[A-Z0-9]{10}\\d{2}","Macedonia"))); 
        countries_iban.put("MR", new ArrayList<String>( Arrays.asList("27", "MR\\d{25}","Mauritania")));  
        countries_iban.put("MT", new ArrayList<String>( Arrays.asList("31", "MT\\d{2}[A-Z]{4}\\d{5}[A-Z0-9]{18}","Malta")));  
        countries_iban.put("MU", new ArrayList<String>( Arrays.asList("30", "MU\\d{2}[A-Z]{4}\\d{19}[A-Z]{3}","Mauritius")));  
        countries_iban.put("NL", new ArrayList<String>( Arrays.asList("18", "NL\\d{2}[A-Z]{4}\\d{10}" ,"The Netherlands")));  
        countries_iban.put("NO", new ArrayList<String>( Arrays.asList("15", "NO\\d{13}","Norway")));  
        countries_iban.put("PK", new ArrayList<String>( Arrays.asList("24", "PK\\d{2}[A-Z]{4}[A-Z0-9]{16}","Pakistan")));  
        countries_iban.put("PL", new ArrayList<String>( Arrays.asList("28", "PL\\d{26}","Poland")));  
        countries_iban.put("PS", new ArrayList<String>( Arrays.asList("29", "PS\\d{2}[A-Z]{4}[A-Z0-9]{21}","Palestine")));  
        countries_iban.put("PT", new ArrayList<String>( Arrays.asList("25", "PT\\d{23}","Portugal")));  
        countries_iban.put("QA", new ArrayList<String>( Arrays.asList("29", "QA\\d{2}[A-Z]{4}[A-Z0-9]{21}","Qatar")));  
        countries_iban.put("RO", new ArrayList<String>( Arrays.asList("24", "RO\\d{2}[A-Z]{4}[A-Z0-9]{16}","Romania")));  
        countries_iban.put("RS", new ArrayList<String>( Arrays.asList("22", "RS\\d{20}","Serbia")));  
        countries_iban.put("SA", new ArrayList<String>( Arrays.asList("24", "SA\\d{4}[A-Z0-9]{18}","Saudi Arabia")));  
        countries_iban.put("SC", new ArrayList<String>( Arrays.asList("31", "SC\\d{2}[A-Z]{4}\\d{20}[A-Z]{3}","Seychelles")));  
        countries_iban.put("SE", new ArrayList<String>( Arrays.asList("24", "SE\\d{22}","Sweden")));  
        countries_iban.put("SI", new ArrayList<String>( Arrays.asList("19", "SI\\d{17}","Slovenia")));  
        countries_iban.put("SK", new ArrayList<String>( Arrays.asList("24", "SK\\d{22}","Slovak Republic")));  
        countries_iban.put("SM", new ArrayList<String>( Arrays.asList("27", "SM\\d{2}[A-Z]{1}\\d{10}[A-Z0-9]{12}","San Marino")));  
        countries_iban.put("ST", new ArrayList<String>( Arrays.asList("25", "ST\\d{23}","Sao Tome and Principe")));  
        countries_iban.put("TL", new ArrayList<String>( Arrays.asList("23", "TL\\d{21}","Timor-Leste")));  
        countries_iban.put("TN", new ArrayList<String>( Arrays.asList("24", "TN\\d{22}","Tunisia")));  
        countries_iban.put("TR", new ArrayList<String>( Arrays.asList("26", "TR\\d{8}[A-Z0-9]{16}","Turkey")));  
        countries_iban.put("UA", new ArrayList<String>( Arrays.asList("29", "UA\\d{8}[A-Z0-9]{19}","Ukraine")));  
        countries_iban.put("VG", new ArrayList<String>( Arrays.asList("24", "VG\\d{2}[A-Z]{4}\\d{16}","Virgin Islands, British")));  
        countries_iban.put("XK", new ArrayList<String>( Arrays.asList("20", "XK\\d{18}","Republic of Kosovo")));  
        this.countries_iban = countries_iban;
    }
    
    /**
     * check the total length of IBAN if it's in the range of IBANs minimum and maximum length
     * @return
     */
    public Boolean checkLength() {
        if (this.accountNumber.length() < IBAN_MIN_LEN || this.accountNumber.length() > IBAN_MAX_LEN) {
        	return false;
        }
    	return true;
    }
    
    /**
     * check if country code is upperCase and check if country code enetered exists
     * @return
     */
    public Boolean checkValidCountryCode() { 
        String countryCode = this.accountNumber.substring(0,2);
        if (!Character.isUpperCase(countryCode.charAt(0)) || !Character.isUpperCase(countryCode.charAt(1))) {
        	return false; // country code should be upper case
        }
        if (this.countries_iban.get(countryCode) == null) {
        	return false; // country code not found 
        }
    	return true;
    }
    
    /**
     * check if IBAN's length entered is equal to the IBAN's length of the country it belongs to
     * @return
     */
    public Boolean checkIbanCountryLength() { 
        String countryCode = this.accountNumber.substring(0,2);
        if (this.countries_iban.get(countryCode) != null) {
        	int countryCodeLength = Integer.parseInt(this.countries_iban.get(countryCode).get(0));
        	if (countryCodeLength != this.accountNumber.length()) {
        		return false;
        	}
        	return true;
        }else {
        	return false;
        }
    	
    }
    
    /**
     * check whether the pattern of the IBAN entered matches the IBANS's pattern of the country it belongs to
     * @return
     */
    public Boolean checkValidStructure() { 
        String countryCode = this.accountNumber.substring(0,2);
        if (this.countries_iban.get(countryCode) != null) {
        	String countryPattern = this.countries_iban.get(countryCode).get(1);
        	if (!this.accountNumber.matches(countryPattern)) {
        		return false;
        	}
        	return true;
        }
    	return false;
    }
    
    
    /**
     * check whether the IBAN has valid check digits or not
     * @return
     */
    public Boolean checkDigits() { 
    	//Moving first 4 digits to the end of the string
    	if ((!(this.accountNumber.length() >= IBAN_MIN_LEN && this.accountNumber.length() <= IBAN_MAX_LEN))) {
    		return false;
    	}
        String modifiedAccountNumber = this.accountNumber.substring(4) + this.accountNumber.substring(0, 4);
        
        //Replacing each alphaCharacter with 2 digits 
        StringBuilder NUMIban = new StringBuilder();
        int characterNumber;
        for (int i = 0;i < modifiedAccountNumber.length();i++) {
        	characterNumber = Character.getNumericValue(modifiedAccountNumber.charAt(i));
            if(characterNumber <= -1) {
                return false; 
            } else {
            	NUMIban.append(characterNumber);
            }
        }
        // changing string to big integer and computing its remainder on dividing by 97
        BigInteger BigIbanNumber = new BigInteger(NUMIban.toString());
        
        return BigIbanNumber.mod(IBAN_MOD).intValue() == 1; // if remainder is 1 then true else false
    }
  
}