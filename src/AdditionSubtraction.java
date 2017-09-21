import javax.swing.JOptionPane;

public class AdditionSubtraction {

	public static void main(String[] args) {

		int correct = 0;
		int inputNum, answer, goalNum, num1, num2;

		do {

			try {
				String goal = JOptionPane.showInputDialog("What is your goal of correct answers today?");
				goalNum = Integer.parseInt(goal);
			} catch (Exception e) { // if the input is not a number, change to 150 (which is >50)
				goalNum = 150;
			}

			if (goalNum > 50) {
				JOptionPane.showMessageDialog(null, "Please input a goal between 1 and 50.");
			}
		} while (goalNum > 50); // keep re-asking while their input is >50

		String[] MathTypes = { "Division", "Multiplication", "Subtraction", "Addition" }; // add = 0, sub = 1, etc...
		int returnValue = JOptionPane.showOptionDialog(null, "What kind of math would you like to do today?",
				"MathChoices", JOptionPane.WARNING_MESSAGE, 1, null, MathTypes, MathTypes[0]);

		if (returnValue == 3) {
			do {

				num1 = (int) (Math.random() * 101);
				num2 = (int) (Math.random() * 101);
				answer = num1 + num2;

				do {
					try {
						String input = JOptionPane.showInputDialog("What is " + num1 + " + " + num2 + "?");
						inputNum = Integer.parseInt(input);
					} catch (Exception e) {
						inputNum = 500;
						JOptionPane.showMessageDialog(null, "The answer must be a number between 0 and 200.");
					}
				} while (inputNum == 500);

				correct = CorrectMessages(correct, answer, inputNum); // has to reset correct as method's "correct"
			} while (correct < goalNum);

			GoalMessage(correct, goalNum);
		}

		if (returnValue == 2) {

			do {
				do {
					num1 = (int) (Math.random() * 101);
					num2 = (int) (Math.random() * 101);
					answer = num1 - num2;
				} while (answer < 0); // if the result is negative, generate new numbers

				do {
					try {
						String input = JOptionPane.showInputDialog("What is " + num1 + " - " + num2 + "?");
						inputNum = Integer.parseInt(input);
					} catch (Exception e) {
						inputNum = 500;
						JOptionPane.showMessageDialog(null, "The answer must be a number between 0 and 100.");
					}
				} while (inputNum == 500);

				correct = CorrectMessages(correct, answer, inputNum); // has to reset correct as method's "correct"
			} while (correct < goalNum);

			GoalMessage(correct, goalNum);

		}

		if (returnValue == 1) {
			do {

				num1 = (int) (Math.random() * 26);
				num2 = (int) (Math.random() * 26);
				answer = num1 * num2;

				do {
					try {
						String input = JOptionPane.showInputDialog("What is " + num1 + " x " + num2 + "?");
						inputNum = Integer.parseInt(input);
					} catch (Exception e) {
						inputNum = 10001;
						JOptionPane.showMessageDialog(null, "The answer must be a number between -2500 and 2500.");
					}
				} while (inputNum == 10001);

				correct = CorrectMessages(correct, answer, inputNum); // has to reset correct as method's "correct"
			} while (correct < goalNum);

			GoalMessage(correct, goalNum);

		}

		if (returnValue == 0) {
			do {

				num1 = (int) (Math.random() * 260);
				num2 = (int) (Math.random() * 25 + 1);
				num1 = num1 - (num1 % num2);

				answer = num1 / num2;

				do {
					try {
						String input = JOptionPane.showInputDialog("What is " + num1 + " ÷ " + num2 + "?");
						inputNum = Integer.parseInt(input);
					} catch (Exception e) {
						inputNum = 10001;
						JOptionPane.showMessageDialog(null, "The answer must be a number between -2500 and 2500.");
					}
				} while (inputNum == 10001);

				correct = CorrectMessages(correct, answer, inputNum); // has to reset correct as method's "correct"
			} while (correct < goalNum);

			GoalMessage(correct, goalNum);

		}

	}

	public static void GoalMessage(int correct, int goalNum) {
		if (correct == goalNum) {
			JOptionPane.showMessageDialog(null, "Good job! You reached your goal of " + goalNum + " correct answers.");
		}
	}

	public static int CorrectMessages(int correct, int answer, int inputNum) {
		if (inputNum == answer) {
			correct++;
			JOptionPane.showMessageDialog(null, "Correct! The answer was " + answer + ".");
			JOptionPane.showMessageDialog(null, "You now have " + correct + " correct.");
		} else {
			JOptionPane.showMessageDialog(null, "That's not correct, sorry. Keep going!");
			JOptionPane.showMessageDialog(null, "You still have " + correct + " correct.");
		}

		return correct; // has to be at the end because stops the code at that point
	}

}

// make show goal method
// make correct/incorrect method
// methods do not change what it outside, you have to "return _" for it to
// change what is in the main BUT it has to be by end of method