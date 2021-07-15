package main.java.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Constants {

	public static final String CHECK_LENGTH = "IBAN length check";
	public static final String CHECK_LENGTH_MESSAGE = "Your IBAN's length is not withing the range of IBAN (minimum 15 and maximum 34)";

	public static final String CHECK_CC = "IBAN country code check";
	public static final String CHECK_CC_MESSAGE = "Your IBAN's country code is not valid";

	public static final String CHECK_COUNTRY_IBAN_LENGTH = "Country's IBAN length check";
	public static final String CHECK_COUNTRY_IBAN_LENGTH_MESSAGE = "Your IBAN's length doesn't match your country's IBAN length";

	public static final String CEHCK_IBAN_STRUCTURE = "Country's IBAN structure check";
	public static final String CEHCK_IBAN_STRUCTURE_MESSAGE = "Your IBAN is not well formatted";

	public static final String CHECK_DIGITS = "IBAN check digits check";
	public static final String CHECK_DIGITS_MESSAGE = "Your IBAN's number is incorrect";

	public static final String PASSED = "Passed";
	public static final String FAILED = "Failed";
	public static final String CHECK = "check";
	public static final String STATUS = "status";
	public static final String MESSAGE = "message";
	public static  HashMap<String, ArrayList<String>> COUNTRIES_IBAN = new HashMap<String, ArrayList<String>>(){
		private static final long serialVersionUID = 1L;
	{
		COUNTRIES_IBAN.put("AD", (ArrayList<String>) Arrays.asList("24", "AD\\d{10}[A-Z0-9]{12}","Andorra"));  
	    COUNTRIES_IBAN.put("AE", (ArrayList<String>) Arrays.asList("23", "AE\\d{21}","United Arab Emirates"));  
	    COUNTRIES_IBAN.put("AL", (ArrayList<String>) Arrays.asList("28", "AL\\d{10}[A-Z0-9]{16}","Albania"));  
	    COUNTRIES_IBAN.put("AT", (ArrayList<String>) Arrays.asList("20", "AT\\d{18}" ,"Austria"));  
	    COUNTRIES_IBAN.put("AZ", (ArrayList<String>) Arrays.asList("28", "AZ\\d{2}[A-Z]{4}[A-Z0-9]{20}","Republic of Azerbaijan"));    
	    COUNTRIES_IBAN.put("BA", (ArrayList<String>) Arrays.asList("20", "BA\\d{18}" ,"Bosnia and Herzegovina"));    
	    COUNTRIES_IBAN.put("BE", (ArrayList<String>) Arrays.asList("16", "BE\\d{14}" ,"Belgium"));  
	    COUNTRIES_IBAN.put("BG", (ArrayList<String>) Arrays.asList("22", "BG\\d{2}[A-Z]{4}\\d{6}[A-Z0-9]{8}","Bulgaria"));  
	    COUNTRIES_IBAN.put("BH", (ArrayList<String>) Arrays.asList("22", "BH\\d{2}[A-Z]{4}[A-Z0-9]{14}" ,"Bahrain"));  
	    COUNTRIES_IBAN.put("BR", (ArrayList<String>) Arrays.asList("29", "BR\\d{25}[A-Z]{1}[A-Z0-9]{1}","Brazil"));  
	    COUNTRIES_IBAN.put("BY", (ArrayList<String>) Arrays.asList("28", "BY\\d{2}[A-Z0-9]{4}\\d{4}[A-Z0-9]{16}","Republic of Belarus")); 
	    COUNTRIES_IBAN.put("CH", (ArrayList<String>) Arrays.asList("21", "CH\\d{7}[A-Z0-9]{12}","Switzerland"));  
	    COUNTRIES_IBAN.put("CR", (ArrayList<String>) Arrays.asList("22", "CR\\d{20}","Costa Rica"));  
	    COUNTRIES_IBAN.put("CY", (ArrayList<String>) Arrays.asList("28", "CY\\d{10}[A-Z0-9]{16}","Cyprus"));  
	    COUNTRIES_IBAN.put("CZ", (ArrayList<String>) Arrays.asList("24", "CZ\\d{22}","Czech Republic"));  
	    COUNTRIES_IBAN.put("DE", (ArrayList<String>) Arrays.asList("22", "DE\\d{20}","Germany"));  
	    COUNTRIES_IBAN.put("DK", (ArrayList<String>) Arrays.asList("18", "DK\\d{16}","Denmark"));  
	    COUNTRIES_IBAN.put("DO", (ArrayList<String>) Arrays.asList("28", "DO\\d{2}[A-Z0-9]{4}\\d{20}","Dominican Republic"));  
	    COUNTRIES_IBAN.put("EE", (ArrayList<String>) Arrays.asList("20", "EE\\d{18}","Estonia"));  
	    COUNTRIES_IBAN.put("ES", (ArrayList<String>) Arrays.asList("24", "ES\\d{22}","Spain"));  
	    COUNTRIES_IBAN.put("FI", (ArrayList<String>) Arrays.asList("18", "FI\\d{16}","Finland"));  
	    COUNTRIES_IBAN.put("FO", (ArrayList<String>) Arrays.asList("18", "FO\\d{16}","Denmark"));   
	    COUNTRIES_IBAN.put("FR", (ArrayList<String>) Arrays.asList("27", "FR\\d{12}[A-Z0-9]{11}\\d{2}","France"));  
	    COUNTRIES_IBAN.put("GB", (ArrayList<String>) Arrays.asList("22", "GB\\d{2}[A-Z]{4}\\d{14}","United Kingdom"));  
	    COUNTRIES_IBAN.put("GE", (ArrayList<String>) Arrays.asList("22", "GE\\d{2}[A-Z]{2}\\d{16}","Georgia"));  
	    COUNTRIES_IBAN.put("GI", (ArrayList<String>) Arrays.asList("23", "GI\\d{2}[A-Z]{4}[A-Z0-9]{15}","Gibraltar"));  
	    COUNTRIES_IBAN.put("GL", (ArrayList<String>) Arrays.asList("18", "GL\\d{16}","Denmark"));   
	    COUNTRIES_IBAN.put("GR", (ArrayList<String>) Arrays.asList("27", "GR\\d{9}[A-Z0-9]{16}","Greece"));  
	    COUNTRIES_IBAN.put("GT", (ArrayList<String>) Arrays.asList("28", "GT\\d{2}[A-Z0-9]{24}","Guatemala"));  
	    COUNTRIES_IBAN.put("HR", (ArrayList<String>) Arrays.asList("21", "HR\\d{19}","Croatia"));  
	    COUNTRIES_IBAN.put("HU", (ArrayList<String>) Arrays.asList("28", "HU\\d{26}","Hungary"));  
	    COUNTRIES_IBAN.put("IE", (ArrayList<String>) Arrays.asList("22", "IE\\d{2}[A-Z]{4}\\d{14}","Ireland"));  
	    COUNTRIES_IBAN.put("IL", (ArrayList<String>) Arrays.asList("23", "IL\\d{21}","Israel"));  
	    COUNTRIES_IBAN.put("IS", (ArrayList<String>) Arrays.asList("26", "IS\\d{24}" ,"Iceland"));  
	    COUNTRIES_IBAN.put("IT", (ArrayList<String>) Arrays.asList("27", "IT\\d{2}[A-Z]{1}\\d{10}[A-Z0-9]{12}","Italy"));  
	    COUNTRIES_IBAN.put("IQ", (ArrayList<String>) Arrays.asList("23", "IQ\\d{2}[A-Z]{4}\\d{15}","Iraq"));  
	    COUNTRIES_IBAN.put("JO", (ArrayList<String>) Arrays.asList("30", "JO\\d{2}[A-Z]{4}\\d{4}[A-Z0-9]{18}","Jordan"));  
	    COUNTRIES_IBAN.put("KW", (ArrayList<String>) Arrays.asList("30", "KW\\d{2}[A-Z]{4}[A-Z0-9]{22}","Kuwait"));  
	    COUNTRIES_IBAN.put("KZ", (ArrayList<String>) Arrays.asList("20", "KZ\\d{5}[A-Z0-9]{13}","Kazakhstan"));  
	    COUNTRIES_IBAN.put("LB", (ArrayList<String>) Arrays.asList("28", "LB\\d{6}[A-Z0-9]{20}","Lebanon"));  
	    COUNTRIES_IBAN.put("LC", (ArrayList<String>) Arrays.asList("32", "LC\\d{2}[A-Z]{4}[A-Z0-9]{24}","Saint Lucia"));  
	    COUNTRIES_IBAN.put("LI", (ArrayList<String>) Arrays.asList("21", "LI\\d{7}[A-Z0-9]{12}","Liechtenstein"));   
	    COUNTRIES_IBAN.put("LT", (ArrayList<String>) Arrays.asList("20", "LT\\d{18}","Lithuania"));  
	    COUNTRIES_IBAN.put("LU", (ArrayList<String>) Arrays.asList("20", "LU\\d{5}[A-Z0-9]{13}","Luxembourg"));  
	    COUNTRIES_IBAN.put("LV", (ArrayList<String>) Arrays.asList("21", "LV\\d{2}[A-Z]{4}[A-Z0-9]{13}","Latvia"));  
	    COUNTRIES_IBAN.put("MC", (ArrayList<String>) Arrays.asList("27", "MC\\d{12}[A-Z0-9]{11}\\d{2}","Monaco"));  
	    COUNTRIES_IBAN.put("MD", (ArrayList<String>) Arrays.asList("24", "MD\\d{2}[A-Z0-9]{20}","Moldova"));  
	    COUNTRIES_IBAN.put("ME", (ArrayList<String>) Arrays.asList("22", "ME\\d{20}","Montenegro"));  
	    COUNTRIES_IBAN.put("MK", (ArrayList<String>) Arrays.asList("19", "MK\\d{5}[A-Z0-9]{10}\\d{2}","Macedonia")); 
	    COUNTRIES_IBAN.put("MR", (ArrayList<String>) Arrays.asList("27", "MR\\d{25}","Mauritania"));  
	    COUNTRIES_IBAN.put("MT", (ArrayList<String>) Arrays.asList("31", "MT\\d{2}[A-Z]{4}\\d{5}[A-Z0-9]{18}","Malta"));  
	    COUNTRIES_IBAN.put("MU", (ArrayList<String>) Arrays.asList("30", "MU\\d{2}[A-Z]{4}\\d{19}[A-Z]{3}","Mauritius"));  
	    COUNTRIES_IBAN.put("NL", (ArrayList<String>) Arrays.asList("18", "NL\\d{2}[A-Z]{4}\\d{10}" ,"The Netherlands"));  
	    COUNTRIES_IBAN.put("NO", (ArrayList<String>) Arrays.asList("15", "NO\\d{13}","Norway"));  
	    COUNTRIES_IBAN.put("PK", (ArrayList<String>) Arrays.asList("24", "PK\\d{2}[A-Z]{4}[A-Z0-9]{16}","Pakistan"));  
	    COUNTRIES_IBAN.put("PL", (ArrayList<String>) Arrays.asList("28", "PL\\d{26}","Poland"));  
	    COUNTRIES_IBAN.put("PS", (ArrayList<String>) Arrays.asList("29", "PS\\d{2}[A-Z]{4}[A-Z0-9]{21}","Palestine"));  
	    COUNTRIES_IBAN.put("PT", (ArrayList<String>) Arrays.asList("25", "PT\\d{23}","Portugal"));  
	    COUNTRIES_IBAN.put("QA", (ArrayList<String>) Arrays.asList("29", "QA\\d{2}[A-Z]{4}[A-Z0-9]{21}","Qatar"));  
	    COUNTRIES_IBAN.put("RO", (ArrayList<String>) Arrays.asList("24", "RO\\d{2}[A-Z]{4}[A-Z0-9]{16}","Romania"));  
	    COUNTRIES_IBAN.put("RS", (ArrayList<String>) Arrays.asList("22", "RS\\d{20}","Serbia"));  
	    COUNTRIES_IBAN.put("SA", (ArrayList<String>) Arrays.asList("24", "SA\\d{4}[A-Z0-9]{18}","Saudi Arabia"));  
	    COUNTRIES_IBAN.put("SC", (ArrayList<String>) Arrays.asList("31", "SC\\d{2}[A-Z]{4}\\d{20}[A-Z]{3}","Seychelles"));  
	    COUNTRIES_IBAN.put("SE", (ArrayList<String>) Arrays.asList("24", "SE\\d{22}","Sweden"));  
	    COUNTRIES_IBAN.put("SI", (ArrayList<String>) Arrays.asList("19", "SI\\d{17}","Slovenia"));  
	    COUNTRIES_IBAN.put("SK", (ArrayList<String>) Arrays.asList("24", "SK\\d{22}","Slovak Republic"));  
	    COUNTRIES_IBAN.put("SM", (ArrayList<String>) Arrays.asList("27", "SM\\d{2}[A-Z]{1}\\d{10}[A-Z0-9]{12}","San Marino"));  
	    COUNTRIES_IBAN.put("ST", (ArrayList<String>) Arrays.asList("25", "ST\\d{23}","Sao Tome and Principe"));  
	    COUNTRIES_IBAN.put("TL", (ArrayList<String>) Arrays.asList("23", "TL\\d{21}","Timor-Leste"));  
	    COUNTRIES_IBAN.put("TN", (ArrayList<String>) Arrays.asList("24", "TN\\d{22}","Tunisia"));  
	    COUNTRIES_IBAN.put("TR", (ArrayList<String>) Arrays.asList("26", "TR\\d{8}[A-Z0-9]{16}","Turkey"));  
	    COUNTRIES_IBAN.put("UA", (ArrayList<String>) Arrays.asList("29", "UA\\d{8}[A-Z0-9]{19}","Ukraine"));  
	    COUNTRIES_IBAN.put("VG", (ArrayList<String>) Arrays.asList("24", "VG\\d{2}[A-Z]{4}\\d{16}","Virgin Islands, British"));  
	    COUNTRIES_IBAN.put("XK", (ArrayList<String>) Arrays.asList("20", "XK\\d{18}","Republic of Kosovo"));  
	}};

	
}
