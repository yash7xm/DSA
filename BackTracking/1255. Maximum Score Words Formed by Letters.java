import java.util.*;

public class Main
{
    public static int solve(String[] words, int[] freq, int[] score, int index){
        if(index==words.length){
            return 0; // as there is no words left 
        }
        int no=solve(words,freq,score,index+1); // calculating in the case we didn't chose a word
        int sword=0; // for keeping the score the individual word
        boolean flag=true;
        String word=words[index];
        for(int i=0; i<word.length(); i++){
            char ch=word.charAt(i);
            if(freq[ch-'a']==0) flag=false; // if freq is negative or zero that means we can't use it 
            freq[ch-'a']--;
            sword+=score[ch-'a'];
        }
        int yes=0;
        if(flag){
            yes=sword+solve(words,freq,score,index+1);
        }
        for(int i=0; i<word.length(); i++){
            char ch=word.charAt(i);
            freq[ch-'a']++; // reviving the freq or backtracking it
        }
        return Math.max(no,yes);
    }
	public static void main(String[] args) {
		String[] words={"dog","cat","dad","good"};
		char[] letters={'a','a','c','d','d','d','g','o','o'};
		int[] score={1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        
        // first we will form out frequency array by using letters array.
        int[] freq=new int[26];
        for(int i=0; i<letters.length; i++){
            freq[letters[i]-'a']++;
        }
        // now will call our fxn which will calculate the max
        int ans=solve(words,freq,score,0);
        System.out.println(ans);
	}
}
