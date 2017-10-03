package helloworld;
import java.util.Scanner;

public class guess {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       String answer = "RANDOM";
       String result = "";

       while (true) {

           System.out.println("Enter a string to guess the word: ");
           String guess = input.nextLine().trim().toUpperCase();
           if (guess.equals(answer)) {
               System.out.println(" is the right answer, well done!");
               break;
           }

           for (int i = 0; i < answer.length(); i++) {
               if (i >= guess.length()) {
                   break;
               }

               if (answer.charAt(i) == guess.charAt(i)) {
                   result += answer.charAt(i);
               } else {
                   result += "?";
               }
           }

           System.out.println(result);
           result = "";
       }
   }
}