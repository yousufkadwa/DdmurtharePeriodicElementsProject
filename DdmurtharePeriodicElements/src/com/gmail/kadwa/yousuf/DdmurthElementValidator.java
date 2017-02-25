package com.gmail.kadwa.yousuf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Yousuf
 */
public class DdmurthElementValidator {
    
    private String elementName;
    private String elementSymbol;
    
    private Matcher matcher;
    
    private static final String ELEMENT_SYMBOL_PATTERN = "^[a-zA-Z]{2,2}$";
    private static final String ELEMENT_NAME_PATTERN = "^[A-Za-z]+$";

    /**
     * This will print out the result if the element symbol is valid for the element name
     * @param elementName
     * @param elementSymbol
     * @throws com.gmail.kadwa.yousuf.ElementException
     */
    private DdmurthElementValidator(String elementName, String elementSymbol) throws ElementException {
        if(elementName == null || elementSymbol == null) {
            throw new ElementException("input parameters cannot be null");
        }
        Pattern pattern;

        pattern = Pattern.compile(ELEMENT_SYMBOL_PATTERN);
        if(!validInputParameter(pattern, elementSymbol)) {
            throw new ElementException("the element symbol is invalid. it must be 2 chars long and cannot be null : " + elementSymbol);
        }

        pattern = Pattern.compile(ELEMENT_NAME_PATTERN);
        if(!validInputParameter(pattern, elementName)) {
            throw new ElementException("the element name provided is invalid. it must contain chars only and cannot be null : " + elementName);
        }        
        this.elementName = elementName;
        this.elementSymbol = elementSymbol;
        printResult();
    }
    
    private boolean validInputParameter(Pattern pattern, String input) {
        matcher = pattern.matcher(input);
	return matcher.matches();
    }

    private boolean doesSymbolAppearInElementName() {
        // converting to lowercase as A != a
        if(elementName.toLowerCase().contains(elementSymbol.toLowerCase().charAt(0) + "")) {
            if(elementName.toLowerCase().contains(elementSymbol.toLowerCase().charAt(1)  + "")) {
                return true;
            }
        }
        return false;
    }
    
    private boolean doesSymbolAppearInOrderInElementName() {
        // get the first char in name
        int index = elementName.toLowerCase().indexOf(elementSymbol.toLowerCase().charAt(0));
        if(elementName.substring(index + 1).indexOf(elementSymbol.charAt(1)) > -1 ) {
            return true;
        }
        return false;
    }
    
    private void printResult() {
        System.out.println(elementName + ", " + elementSymbol + " -> " +
               String.valueOf(doesSymbolAppearInElementName() && doesSymbolAppearInOrderInElementName()));
    }

    /**
     * I just used this main method for testing purposes as i did not write any JUnit tests
     */
    public static void main(String[] array) throws ElementException {
        // testing - prints results by default
        DdmurthElementValidator dev = new DdmurthElementValidator("Mercury", "Hg");
        
        // testing - set and print
        dev.elementSymbol = "Cy";
        dev.printResult();
        
        dev.elementName = "Silver";
        dev.elementSymbol = "Vr";
        dev.printResult();
        
        dev.elementSymbol = "Rv";
        dev.printResult();
        
        dev.elementName = "Magnesium";
        dev.elementSymbol = "Ma";
        dev.printResult();
        
        dev.elementSymbol = "Am";
        dev.printResult();
        
        dev.elementName = "Xenon";
        dev.elementSymbol = "Nn";
        dev.printResult();
        
        dev.elementSymbol = "Xx";
        dev.printResult();
        
        dev.elementSymbol = "Oo";
        dev.printResult();
        
        dev.elementName = "Spenglerium";
        dev.elementSymbol = "Ee";
        dev.printResult();
        
        dev.elementName = "Zeddemorium";
        dev.elementSymbol = "Zr";
        dev.printResult();
        
        dev.elementName = "Venkmine";
        dev.elementSymbol = "Kn";
        dev.printResult();
        
        dev.elementName = "Stantzon";
        dev.elementSymbol = "Zt";
        dev.printResult();
        
        dev.elementName = "Melintzum";
        dev.elementSymbol = "Nn";
        dev.printResult();
        
        dev.elementName = "Tullium";
        dev.elementSymbol = "Ty";
        dev.printResult();        
    }
}
