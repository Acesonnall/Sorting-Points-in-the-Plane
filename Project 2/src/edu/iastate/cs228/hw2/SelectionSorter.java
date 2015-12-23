package edu.iastate.cs228.hw2;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 *  
 * @author Omar Taylor
 *
 */

/**
 * 
 * This class implements selection sort.
 *
 */

public class SelectionSorter extends AbstractSorter {
	// Other private instance variables if you need ...

	/**
	 * The two constructors below invoke their corresponding superclass
	 * constructors. They also set the instance variables algorithm and
	 * outputFileName in the superclass.
	 */

	/**
	 * Constructor takes an array of points.
	 * 
	 * @param pts
	 */
	public SelectionSorter(Point[] pts) {
		super(pts);
		algorithm = "selection sort";
		outputFileName = "select.txt";
	}

	/**
	 * Constructor reads points from a file.
	 * 
	 * @param inputFileName
	 *            name of the input file
	 * @throws FileNotFoundException
	 * @throws InputMismatchException
	 */
	public SelectionSorter(String inputFileName) throws InputMismatchException,
			FileNotFoundException {
		super(inputFileName);
		algorithm = "selection sort";
		outputFileName = "select.txt";
	}

	/**
	 * Apply insertion sort on the array points[] of the parent class
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

		Point min = new Point();
		for (int i = 0; i < points.length; i++) {
			min = points[i];
			int jmin = i;
			for (int j = i + 1; j < points.length; j++) {
				if (pointComparator.compare(points[j], min) < 0) {
					min = points[j];
					jmin = j;
					swap(i, jmin);
				}
			}
		}

		sortingTime = System.nanoTime() - start;
	}
}
