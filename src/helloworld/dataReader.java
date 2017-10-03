package helloworld;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class dataReader {
    public static void main(String[] args) throws IOException {
        String line;
        String[][] products = new String[5][5];
        FileReader fr = new FileReader("C:\\Users\\Dan\\data.txt");
        BufferedReader br = new BufferedReader(fr);
        int x = 0;
        int y = 0;

        while ((line = br.readLine()) != null) {
            String code = line.substring(0, 5);
            products[x][0] = code;
            System.out.print(products[x][0] + "\n");
            x += 1;
            String name = line.substring(5);
            products[0][y] = name;
            System.out.print(products[0][y] + "\n");
            y += 1;
        }

    }
}

