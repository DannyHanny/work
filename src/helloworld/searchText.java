package helloworld;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class searchText {
    public static void main(String[] args) throws IOException {
        selectSearch();
    }

    private static String inputs(String text, String exception) {
        String str;
        while (true) {
            try {
                System.out.print("\n" + text);
                Scanner input = new Scanner(System.in);
                str = input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(exception);
                continue;
            }
            return str;
        }
    }

    private static void fileSearch(String str) throws IOException {
        String line;
        FileReader fr = new FileReader("C:\\Users\\Dan\\terms.txt");
        BufferedReader br = new BufferedReader(fr);
        try {
            String previousLine = null;
            while ((line = br.readLine()) != null) {
                if (line.equals(str)) {
                    System.out.print("FOUND");
                    System.out.print("\n" + br.readLine());
                    return;
                } else if (line.contains(str)) {
                    System.out.print("FOUND FOR " + previousLine);
                    System.out.print("\n" + line + "\n");
                    selectSearch();
                    return;
                }
                previousLine = line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((line = br.readLine()) == null) {
                System.out.print("TERM NOT FOUND" + "\n");
                selectSearch();
            }
        }
        br.close();

    }

    private static void selectSearch() throws IOException {
        System.out.print("1. Search for a term \n2. Search for a keyword in the descriptions \n3. End \nKey in choice");
        while (true) {
            String num = inputs("", "Not a int");
            if (num.equals("1")) {
                SearchByTerm();
            } else if (num.equals("2")) {
                SearchDescriptionsForKeyword();
            } else {
                return;
            }
        }
    }

    private static void SearchByTerm() throws IOException {
        String str = inputs("Term...?", "Not a term");
        fileSearch(str);
    }

    private static void SearchDescriptionsForKeyword() throws IOException {
        String str = inputs("Key Word...?", "Not a key word");
        fileSearch(str);
    }
}