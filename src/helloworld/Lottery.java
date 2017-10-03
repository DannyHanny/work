package helloworld;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Lottery {

	public static void main(String[] args) {
		LotteryResult winners = generateWinners();
		System.out.print(winners.lotteryBalls);
		System.out.print(winners.bonusBall);
		LotteryResult guesses = readGuesses();
		LotteryResult correctGuesses = checkGuess(guesses, winners);
		outputResult(winners, correctGuesses);
	}

	private static LotteryResult generateWinners() {
		List<Integer> winners = new ArrayList<>();
		int bonus = 0;

		while (winners.size() < 6) {
			int winner = (int) Math.ceil(Math.random() * 49);
			if (winners.contains(winner) == false) {
				winners.add(winner);
			}

			int bonusball = (int) Math.ceil(Math.random() * 49);
			if (winners.contains(bonusball) == false) {
				bonus = bonusball;
			}
		}
		return new LotteryResult(winners, bonus);
	}

	private static LotteryResult readGuesses() {
		List<Integer> lotteryBalls = new ArrayList<>();
		int num;

		while (lotteryBalls.size() < 6) {
			num = getBallNumber(lotteryBalls,"Enter a number between 1 and 49 for a lottery ball: ");
			lotteryBalls.add(num);
		}

		int bonusBall = getBallNumber(lotteryBalls,"Enter a number between 1 and 49 for the bonus ball: ");
		return new LotteryResult(lotteryBalls, bonusBall);
	}

	private static int getBallNumber(List<Integer> guesses, String question) {
		int num;
		while (true) {
			System.out.println(question);

			try {
				Scanner input = new Scanner(System.in);
				num = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("not an integer");
				continue;
			}

			if (num < 1 || num > 49) {
				System.out.println("bad range");
				continue;
			}

			if (guesses.contains(num)) {
				System.out.println("already exists");
				continue;
			}
			return num;
		}
	}

	private static LotteryResult checkGuess(LotteryResult guesses, LotteryResult winners) {
		List<Integer> correctGuesses = new ArrayList<>();
		Integer bonusBall = null;
		for (int guess: guesses.lotteryBalls) {
			if (winners.lotteryBalls.contains(guess)) {
				correctGuesses.add(guess);
			}
		}
		if (guesses.bonusBall == winners.bonusBall){
			bonusBall = winners.bonusBall;
		}

		return new LotteryResult(correctGuesses, bonusBall);
	}

	private static void outputResult(LotteryResult winners, LotteryResult correctGuesses) {
		System.out.println("number correct: " + correctGuesses.lotteryBalls.size());
		if (correctGuesses.lotteryBalls.size() == 6){
			System.out.print("You win £1,000,000!");
		}
		else if (correctGuesses.lotteryBalls.size() == 5 && correctGuesses.bonusBall != null){
			System.out.print("You win £100,000!");
		}
		else if (correctGuesses.lotteryBalls.size() == 5){
			System.out.print("You win £10,000!");
		}
		else if (correctGuesses.lotteryBalls.size() == 4){
			System.out.print("You win £100!");
		}
		else if (correctGuesses.lotteryBalls.size() == 3){
			System.out.print("You win £10!");
		}
	}
}