package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 *  
 * @author Omar Taylor
 *
 */

/**
 * 
 * This class implements the mergesort algorithm.
 *
 */

public class MergeSorter extends AbstractSorter {
	// Other private instance variables if you need ...

	/**
	 * The two constructors below invoke their corresponding superclass
	 * constructors. They also set the instance variables algorithm and
	 * outputFileName in the superclass.
	 */

	/**
	 * Constructor accepts an input array of points. in the array.
	 * 
	 * @param pts
	 *            input array of integers
	 */
	public MergeSorter(Point[] pts) {
		super(pts);
		algorithm = "mergesort";
		outputFileName = "merge.txt";
	}

	/**
	 * Constructor reads points from a file.
	 * 
	 * @param inputFileName
	 *            name of the input file
	 * @throws FileNotFoundException
	 * @throws InputMismatchException
	 */
	public MergeSorter(String inputFileName) throws InputMismatchException,
			FileNotFoundException {
		super(inputFileName);
		algorithm = "mergesort";
		outputFileName = "merge.txt";
	}

	/**
	 * Perform mergesort on the array points[] of the parent class
	 * AbstractSorter.
	 * 
	 * @param order
	 *            1 by x-coordinate 2 by polar angle
	 *
	 */
	@Override
	public void sort(int order) {
		setComparator(order);
		long start = System.nanoTime();

		mergeSortRec(points);

		sortingTime = System.nanoTime() - start;
	}

	/**
	 * This is a recursive method that carries out mergesort on an array pts[]
	 * of points. One way is to make copies of the two halves of pts[],
	 * recursively call mergeSort on them, and merge the two sorted subarrays
	 * into pts[].
	 * 
	 * @param pts
	 *            point array
	 */
	private void mergeSortRec(Point[] pts) {
		if (pts.length <= 1) {
			return;
		}
		Point[] left = Arrays.copyOfRange(pts, 0, pts.length / 2);
		Point[] right = Arrays.copyOfRange(pts, (pts.length / 2), pts.length);
		mergeSortRec(left);
		mergeSortRec(right);
		merge(pts, left, right);
	}

	// Other private methods in case you need ...

	/**
	 * Merges and sorts the given left and right into the returned array.
	 * 
	 * @param pts
	 * @param left
	 * @param right
	 * @return
	 */
	private void merge(Point[] pts, Point[] left, Point[] right) {
		int i1 = 0; // left index
		int i2 = 0; // right index

		for (int i = 0; i < pts.length; i++) {
			if (i2 >= right.length
					|| (i1 < left.length && pointComparator.compare(left[i1],
							right[i2]) < 0)) {
				pts[i] = left[i1];
				i1++;
			} else {
				pts[i] = right[i2];
				i2++;
			}
		}
	}

}
