package com.Assignment1.FindPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindPath {
	/*
	Title: A Simulation Experiment Assignment
	File Name: FindPath.java
	Name: Akhil Reddy Baddam
	Email Id: akhilreddybaddam@lewisu.edu
	Course and Section Number: FA21-CPSC-60500-002
	Date: 26/September/2021
	Here we are calculating the remain steps to meet A and B.
	As the forest gets bigger, the time and steps will also increase
	for Pat and Chris to meet. 
	
	Mode of submission: here I'm submitting my assignment as a java file
	and also providing github link
	
	*/

	public static void main(String[] args) {
		// We need to enter values for A abd B
		//Value needs to be in between 2 and 50
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter A");
		int A = scanner.nextInt();
		while (A <= 2 || A >= 50) {
			System.out.println("Invalid Input, Please try again");
			A = scanner.nextInt();
		}
		System.out.println("Enter B");
		int B = scanner.nextInt();
		while (B <= 2 || B >= 50) {
			System.out.println("Invalid Input, Please try again");
			B = scanner.nextInt();
		}
		System.out.println("Press Enter to Simulate");
		String start = scanner.nextLine();
		if (scanner.hasNextLine())
			start = scanner.nextLine();
		else
			start = null;
		int number_of_attempts = findPath(A, B);
		System.out.println("**********************************");
		System.out.println("They will meet after " + number_of_attempts);
		System.out.println("**********************************");
		System.out.println("Press Enter to Halt");
		String end = scanner.nextLine();

	}
//This method calculates the nubmer of steps are remaining to meet A and B.
	private static int findPath(int A, int B) {

		int patXCoordinate = 0;
		int patYCoordinate = B - 1;
		int chrisXCoordinate = A - 1;
		int chrisYCoordinate = 0;
		int numberOfSteps = 0;
		List<Integer> randomDirections = new ArrayList<Integer>();
		randomDirections.add(-1);
		randomDirections.add(0);
		randomDirections.add(1);
		Random random = new Random();
		while (numberOfSteps < 1000000) {
			numberOfSteps++;
			patXCoordinate += randomDirections.get(random.nextInt(randomDirections.size()));
			patYCoordinate += randomDirections.get(random.nextInt(randomDirections.size()));
			chrisXCoordinate += randomDirections.get(random.nextInt(randomDirections.size()));
			chrisYCoordinate += randomDirections.get(random.nextInt(randomDirections.size()));

			if (patXCoordinate >= A) {
				patXCoordinate = A - 1;
			} else if (patXCoordinate < 0) {
				patXCoordinate = 0;
			}

			if (patYCoordinate >= B) {
				patYCoordinate = B - 1;
			} else if (patYCoordinate < 0) {
				patYCoordinate = 0;
			}

			if (chrisXCoordinate >= A) {
				chrisXCoordinate = A - 1;
			} else if (chrisXCoordinate < 0) {
				chrisXCoordinate = 0;
			}

			if (chrisYCoordinate >= B) {
				chrisYCoordinate = B - 1;
			} else if (chrisYCoordinate < 0) {
				chrisYCoordinate = 0;
			}

			if (patXCoordinate == chrisXCoordinate && patYCoordinate == chrisYCoordinate) {
				return numberOfSteps;
			}

		}
		return numberOfSteps;

	}

}
