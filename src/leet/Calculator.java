package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Calculator {
	public static void main(String[] args) {
		System.out.println(calculate("-(((3)))-(+(1 + 1))"));
	}
	public static int calculate(String s) {
        int aggr =0; 
        // Keep track of the signs 
        Stack <Boolean> sign = new Stack<Boolean>();
        // immediately previous sign
        boolean prevSign = true; 
        
        for (int i=0; i<s.length(); i++){        	
            char token = s.charAt(i);
            
            if (token == ' '){
                        
            } else if (token == '-'){
                prevSign = false; 
            }else if (token == '+'){
                prevSign = true; 
            }
            else if (token == '('){                
                sign.push(prevSign);
            } else if (token == ')'){
                sign.pop();
            } else if (token >= '0' && token <= '9'){
            	boolean op = prevSign;
            	if (sign.size()>0){            		            		
            		// crucial step: aggregate the signs 
            		for (boolean b: sign){
            			op = op && b;	
            		}
            	}        

                aggr = aggr + ((op == true)? (token-'0'): -(token-'0'));
            }
        }

                
        return aggr;
    }
}
