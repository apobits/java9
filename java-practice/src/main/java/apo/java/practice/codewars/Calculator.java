package apo.java.practice.codewars;

import org.junit.Assert;

public class Calculator {

    public static void main(String[] args) {
	var operation = "7 * 7 + 5 * 5";
	Assert.assertEquals("49 + 25", evaluate(operation));
    }

    public static String evaluate(String operation) {
	var operationSB = new StringBuilder(operation);
	var index = -1;
	while ((index = operationSB.indexOf("*")) != -1 || (index = operationSB.indexOf("/")) != -1) {
	    var leftNumber = Integer.parseInt(operationSB.substring(index - 2, index - 1));
	    var rightNumber = Integer.parseInt(operationSB.substring(index + 2, index + 3));
	    var result = 0;
	    if (operationSB.charAt(index) == '*') {
		result = leftNumber * rightNumber;
	    }else{
		result = leftNumber / rightNumber;
	    }
	    operationSB.replace(index - 2, index + 3, String.valueOf(result));
	}

	return operationSB.toString();
    }
}
