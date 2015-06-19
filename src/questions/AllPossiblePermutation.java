package questions;

public class AllPossiblePermutation {
	public static void main(String[] args) {
		String s = "ABC";
		perm(s,"");		
	}
	static void perm(String s,String c){
		// System.out.println(s+"\t"+c);
		
		if (s.length()==0)
			System.out.println(c);
		else{
			
			for (int i =0;i<s.length();i++){
				String remaining = s.substring(0,i)+s.substring(i+1,s.length());
				perm(remaining,c+s.charAt(i));
			}
		} 		
	}
}
