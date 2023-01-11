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
