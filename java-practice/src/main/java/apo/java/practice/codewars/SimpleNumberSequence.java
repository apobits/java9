package apo.java.practice.codewars;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class SimpleNumberSequence {
    public static void main(String[] args) {
	assertEquals(900003, missing("900001900002900004900005900006"));
    }

    public static int missing(String s) {
	for (int i = 1; i < 10; i++) {
	    var missingNumberList = new ArrayList<Integer>();
	    var length = i;
	    var value = Integer.parseInt(s.substring(0, i));
	    for (int j = i; j + length <= s.length(); ) {
		length = String.valueOf(++value).length();
		if (value != Integer.parseInt(s.substring(j, j + length))) {
		    missingNumberList.add(value);
		    if (missingNumberList.size() > 2) {
			break;
		    }
		}else{
		    j += length;
		}
	    }
	    if (missingNumberList.size() == 1) {
		return missingNumberList.get(0);
	    }
	}
	return -1;
    }

}
