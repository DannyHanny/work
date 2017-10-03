package helloworld;
import java.util.Random;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class lotterySelector {
    public static void main(String[] args) throws IOException{
        Boolean[] lotteryNumbers = new Boolean[50];
        int numberOfSelectedBalls = 0;
        Random rand = new Random();
        int winningBall = 0;
        FileWriter fw = new FileWriter("lottery.txt");
        BufferedWriter myFile = new BufferedWriter(fw);

        while(numberOfSelectedBalls != 0){
            do {
                winningBall = rand.nextInt() *50;
            }while(winningBall == 0);
            if(lotteryNumbers[winningBall].equals(Boolean.FALSE)){
                lotteryNumbers[winningBall] = true;
                numberOfSelectedBalls++;
            }
        }
        for(int i = 1; i< 50;i++ ){
            if (lotteryNumbers[i].equals(Boolean.TRUE)){
                myFile.write(i + "\t");
                myFile.write("\n");
            }
        }
        myFile.close();

    }
}
