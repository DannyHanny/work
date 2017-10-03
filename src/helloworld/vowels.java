package helloworld;
import java.util.Scanner;

public class vowels {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int vowelcount = 0;
		int consonantcount = 0;
		String newString = ("aeiou");
		String str ="";
		
		
		System.out.println("Input a string: ");
		str = input.nextLine();
		System.out.println(str);
		if (str == ""){
			System.out.println("Input a string: ");
			str = input.nextLine();
		}
		str = str.toLowerCase();
		str = str.replaceAll("\\s+", "");
		
		for (int x = 0; x < newString.length() ; x++ ){
			for (int i = 0; i < str.length(); i++){
				if(str.charAt(i) == newString.charAt(x)){
					vowelcount++;
				}
				
			}
			
		}
		System.out.println("The string has " +vowelcount + " vowels");
		System.out.println("The string has " + (consonantcount = str.length() - vowelcount) + " consonants");
	}

}
