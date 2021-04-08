import java.util.Arrays;
import java.util.Scanner;

public class GuessGame {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String phrase = "that was hard";
		
		String[] words = phrase.split(" ", 0);

		String[] hidden = new String[phrase.length()];
		
		int index = 0;
		
		for(int i=0; i<words.length; i++) {
			for(int j=0; j<words[i].length(); j++) {
				hidden[index]="_";
				index+=1;
			}
			if(i!=words.length-1) {
				hidden[index]=" ";
				index+=1;
			}			
		}	
		
		String num = "(";
		
		for(int i=0; i<words.length; i++) {
			num += words[i].length();
			if(i<words.length-1) {
				num += "/";
			}
		}		
		num += ")";
		
		int guess_rem = 5;
		char inp;
		boolean win = false;
		
		System.out.println("You have 5 chances to guess the word correctly!\n");
		
		while(guess_rem>0) {		
			System.out.print("The Secret Phrase is: ");		
			System.out.println(String.join("", hidden) + " " + num);
			System.out.print("Your guess is: ");
			
			inp = sc.next().charAt(0);
			int flag = 0 ;
			
			for(int i=0;i<phrase.length();i++) {
				if(inp==phrase.charAt(i)) {
					hidden[i] = Character.toString(inp);
					flag=1;
				}
			}
			
			if(flag==1) {
				System.out.println("Correct: You have "+guess_rem+" incorrect guesses remaining.\n");
			}
			else {
				guess_rem-=1;
				System.out.println("Incorrect: You have "+guess_rem+" incorrect guesses remaining.\n");
			}
			
			boolean available = false;
			for(int k=0;k<hidden.length;k++) {
				if(hidden[k]=="_") {
					available = true;
					break;
				}
			}
			
			if(available==false) {
				win = true;
				System.out.println("Hooray! You guessed it!");
				break;
			}
					
		}
			
		if(win==false) {
			System.out.println("You have lost!");
		}
				
		System.out.println("The secret phrase is: "+phrase);
	}

}
