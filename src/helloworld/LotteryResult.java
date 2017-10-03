package helloworld;

import java.util.List;

public class LotteryResult {
    List<Integer> lotteryBalls;
    Integer bonusBall;

    public LotteryResult(List<Integer> lotteryBalls, Integer bonusBall) {
        this.lotteryBalls = lotteryBalls;
        this.bonusBall = bonusBall;
    }
}
