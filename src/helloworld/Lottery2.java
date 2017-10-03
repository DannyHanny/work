package helloworld;
import java.util.Scanner;

public class Lottery2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int num;
		int num2;
		int num3;
		int num4;
		int num5;
		int num6;
		int bonusBall;
		
		do {
		System.out.println("Enter a number between 1 and 49 for the lottery: ");
		num = input.nextInt();
		} while (num >= 1 && num <= 49);
		
		do {
		System.out.println("Enter a number between 1 and 49 for the lottery: ");
		num2 = input.nextInt();
		} while (num2 >= 1 && num2 <= 49);
		
		do {
		System.out.println("Enter a number between 1 and 49 for the lottery: ");
		num3 = input.nextInt();
		} while (num3 >= 1 && num3 <= 49);
		
		do {
		System.out.println("Enter a number between 1 and 49 for the lottery: ");
		num4 = input.nextInt();
		} while (num4 >= 1 && num4 <= 49);
		
		do {
		System.out.println("Enter a number between 1 and 49 for the lottery: ");
		num5 = input.nextInt();
		} while (num5 >= 1 && num5 <= 49);
		
		do {
		System.out.println("Enter a number between 1 and 49 for the lottery: ");
		num6 = input.nextInt();
		} while (num6 >= 1 && num6 <= 49);
		
		do {
		System.out.println("Enter a number for the bonus ball between 1 and 49 for the lottery: ");
		bonusBall = input.nextInt();
		} while (bonusBall >= 1 && bonusBall <= 49);
	}

}
