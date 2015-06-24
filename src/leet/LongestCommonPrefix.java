package leet;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String [] strs ={"hello", "hell", "helly"};  
        int counter = -1; 
        
        boolean outerLoop = true;
        while(outerLoop){
            counter++;
            for (String s: strs){
                if (s.length()-1<counter || s.charAt(counter)!=strs[0].charAt(counter)){
                    outerLoop = false; 
                    break;
                } 
            }
            
        }
        System.out.println(strs[0].substring(0,counter));
	}
}
