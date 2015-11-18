import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinarySearchQuizzer2 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int score = 0;
		while(true) {
			System.out.println("Do you want to participate in binary search?	Answer: yes or no");
			if(input.nextLine().equals("yes")) {
				if(Quizzer()) {
					score ++;
				}
				System.out.println("Score: " + score);
			} else {
				System.out.println("See you on judgement day");
				break;
			}
		}
	}	
	public static boolean Quizzer() {
		ArrayList <Integer> numList = new ArrayList<Integer>();
		
		System.out.println("Input integers from 1 through 20 inclusive");
		
		//Add Integers
		int n = 0;
		while(n != -1) {
			n = input.nextInt();
			if(numList.contains(n) == true) {
				System.out.println("That integer has already been used");
			} else if((n < 1 || n > 20) && n != -1) {
				System.out.println("You can only input numbers between 1 - 20 inclusive");
			} else if(n != -1) {
				numList.add(n);
			}
		}
		//Print ArrayList
		Collections.sort(numList);
		for(int i : numList){
			System.out.print(i + " ");
		}
		//Choose Target
		int target;
		while(true) {
			target = (int)(Math.random()*20 + 1);
			if(numList.contains(target)) {
				System.out.println("\nLet's start the binary search for the integer " + target);
				break;
			}
		}
		//Quiz
		int pass = 0;
		int left = 0;
		int right = numList.size() - 1;
		int middle = (left + right)/2;
		int middleNum = numList.get(middle);
		boolean done = false;
		while(true) {
			pass++;
			System.out.println("Give me left limit");
			if(input.nextInt() != left) {
				System.out.println("The correct left limit is " + left);
			}	
			System.out.println("Give me right limit");
			if(input.nextInt() != right) {
				System.out.println("The correct right limit is " + right);
			}	
			System.out.println("Give me middle position");
			if(input.nextInt() != middle) {
				System.out.println("The correct middle position is " + middle);
			}	
			System.out.println("Give me the middle integer");
			if(input.nextInt() != middleNum) {
				System.out.println("The correct middle integer is " + middleNum);
			}	
			
			System.out.println("Pass#" + pass + "  Left: " + left + "  Right: " + right + "  middle: " + middle + "  middle value: " + middleNum);
			if(middleNum == target) {
				done = true;
			} else if(target < middleNum){
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right)/2;
			middleNum = numList.get(middle);
			if(done) {
				System.out.println("Binary Search Concluded");
				break;
			}
		}
		//Scanner from int to String, removes \n
		input.nextLine();
		return done;
	}
}
