import java.util.*;

public class Main
{
    public static ArrayList<String> sub(String s){
        if(s.length()==0){
            ArrayList<String> blist=new ArrayList<>();
            blist.add(""); // as empty string has also value [""] also 2^0=1.
            return blist;
        }
        char ch=s.charAt(0); // a
        ArrayList<String> res=sub(s.substring(1)); //bc
        ArrayList<String> ans=new ArrayList<>();
        for(int i=0; i<res.size(); i++){ // adding a and "" to the ans that will come from bc ->[ ,b,c,bc]
            ans.add(""+res.get(i)); 
            ans.add(ch+res.get(i));
        }
        return ans;
    }
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s=in.next();
		System.out.println(sub(s));
	}
}


//*******************************************************************************************************//
//*******************************************************************************************************//

import java.util.*;

public class Main
{
    public static void sub(String s, String p, List<String> list){
        if(s.length()==0){
            list.add(p);
            return;
        }
        char ch=s.charAt(0);
        s=s.substring(1);
        sub(s,p+ch,list); // call to select a character.
        sub(s,p,list); // call to not select a character.
    }
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s=in.next();
		List<String> list=new ArrayList<>();
		sub(s,"",list);
		System.out.println(list);
	}
}
