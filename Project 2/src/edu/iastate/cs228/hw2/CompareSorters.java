package edu.iastate.cs228.hw2;

/**
 *  
 * @author Omar Taylor
 *
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the 
 * execution times of these algorithms on the same input. 
 *
 */

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CompareSorters {
	/**
	 * Repeatedly take integer sequences either randomly generated or read from
	 * files. Perform the four sorting algorithms over each sequence of
	 * integers, comparing points by x-coordinate or by polar angle with respect
	 * to the lowest point.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws InputMismatchException
	 **/
	public static void main(String[] args) throws InputMismatchException,
			FileNotFoundException {
		AbstractSorter[] sorters = new AbstractSorter[4];
		System.out
				.println("Comparison of Four Sorting Algorithms\n\nkeys:  1 (random integers)  2 (file input)  3 (exit)");
		Scanner scan = new Scanner(System.in);
		int key = 0;
		System.out.println("order: 1 (by x-coordinate)  2 (by polar angle)");
		int order;
		int trialCount = 1;
		while (true) {
			System.out.println("\nEnter key then order: ");
			key = scan.nextInt();
			if (key == 3) {
				System.exit(0);
			}
			order = scan.nextInt();
			if (key == 1) {
				Random generator = new Random();
				System.out.print("Trial " + trialCount++ + ": " + key
						+ "\nEnter number of random points: ");
				int userRandPoints = scan.nextInt();
				System.out.println("\nOrder used in sorting: " + order);
				Point[] randArray = generateRandomPoints(userRandPoints,
						generator);
				sorters[0] = new SelectionSorter(randArray);
				sorters[1] = new InsertionSorter(randArray);
				sorters[2] = new MergeSorter(randArray);
				sorters[3] = new QuickSorter(randArray);
				System.out
						.println("\n\nalgorithm\tsize\ttime (ns)\n------------------------------------\n");
				for (int i = 0; i < sorters.length; i++) {
					sorters[i].sort(order);
					sorters[i].writePointsToFile();
					System.out.println(sorters[i].stats());
				}
			} else if (key == 2) {
				System.out
						.print("Trial "
								+ trialCount++
								+ ": "
								+ key
								+ "\nPoints from a file\nEnter file (i.e output.txt): ");
				String filename = scan.next();
				System.out.println("\nOrder used in sorting: " + order);
				sorters[0] = new SelectionSorter(filename);
				sorters[1] = new InsertionSorter(filename);
				sorters[2] = new MergeSorter(filename);
				sorters[3] = new QuickSorter(filename);
				System.out
						.println("\n\nalgorithm\tsize\ttime (ns)\n------------------------------------\n");
				for (int i = 0; i < sorters.length; i++) {
					sorters[i].sort(order);
					sorters[i].writePointsToFile();
					System.out.println(sorters[i].stats());
				}
			}
		}

		//
		// Conducts multiple sorting rounds. In each round, performs the
		// following:
		//
		// a) If asked to sort random points, calls generateRandomPoints() to
		// initialize an array
		// of random points.
		// b) Reassigns to elements in the array sorters[] (declared below) the
		// references to the
		// four newly created objects of SelectionSort, InsertionSort, MergeSort
		// and QuickSort.
		// c) Based on the input point order, carries out the four sorting
		// algorithms in a for
		// loop that iterates over the array sorters[], to sort the randomly
		// generated points
		// or points from an input file.
		// d) Meanwhile, prints out the table of runtime statistics.
		//
		// A sample scenario is given in Section 2 of the project description.
		//

		// Within a sorting round, every sorter object write its output to the
		// file
		// "select.txt", "insert.txt", "merge.txt", or "quick.txt" if it is an
		// object of
		// SelectionSort, InsertionSort, MergeSort, or QuickSort, respectively.

	}

	/**
	 * This method generates a given number of random points to initialize
	 * randomPoints[]. The coordinates of these points are pseudo-random numbers
	 * within the range [-50,50] × [-50,50]. Please refer to Section 3 on how
	 * such points can be generated.
	 * 
	 * Ought to be private. Made public for testing.
	 * 
	 * @param numPts
	 *            number of points
	 * @param rand
	 *            Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException
	 *             if numPts < 1
	 */
	public static Point[] generateRandomPoints(int numPts, Random rand)
			throws IllegalArgumentException {
		Point[] randomPoints = new Point[numPts];
		if (numPts < 1)
			throw new IllegalArgumentException("Error: Nothing to sort.");
		for (int i = 0; i < randomPoints.length; i++) {
			randomPoints[i] = new Point(rand.nextInt(101) - 50,
					rand.nextInt(101) - 50);
		}
		return randomPoints;
	}
}
