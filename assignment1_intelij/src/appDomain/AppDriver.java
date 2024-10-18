package appDomain;

import shapes.*;
import utilities.ShapeComparatorFactory;

import java.io.*;
import java.util.Comparator;

import static utilities.Sorting.*;

/**
 * The AppDriver class is the entry point for the application.
 * It reads shapes from a file, sorts them using a specified algorithm,
 * and prints the first, second last, and last elements of the sorted array.
 *
 * @constructor AppDriver
 */
public class AppDriver
{
	/**
	 * The main method reads shapes from a file, sorts them using a specified algorithm,
	 *
	 * @param args the command-line arguments
	 */
	public static void main( String[] args )
	{
		// Assume args contains the "-t" option and the comparison type (h, v, or a)
		if (args.length != 3) {
			System.out.println("Usage: java -jar AppDriver.jar -ffile_name -tv -sb");
			return;
		}

		long startTime = System.currentTimeMillis();

		String filePath = null;

		// default values
		String comparisonType = "h";
		String sortingAlgorithm = "b";

		// Parse the command-line options
		for (String arg : args) {
			if (arg.startsWith("-f") || arg.startsWith("-F")) {
				filePath = arg.substring(2);  // Get file path without the "-f"
			} else if (arg.startsWith("-t") || arg.startsWith("-T")) {
				comparisonType = arg.substring(2).toLowerCase();  // Get compare type (h, v, a)
			} else if (arg.startsWith("-s") || arg.startsWith("-S")) {
				sortingAlgorithm = arg.substring(2).toLowerCase();  // Get sorting algorithm (b, s, i, m, q, g)
			}
		}

		if (filePath == null) {
			System.out.println("No file path provided. Use -f followed by the file name.");
			return;
		}

        // Read shapes from file
        Shape3D[] shapes = readShapesFromFile("res/" + filePath);

        // Get the appropriate comparator based on user input
        Comparator<Shape3D> comparator = ShapeComparatorFactory.getComparator(comparisonType);

        // Sort the array using the chosen sorting algorithm
        sortShapes(shapes, comparator, sortingAlgorithm);

        // Print sorted shapes
		if (shapes.length > 0) {
			System.out.printf("First element is: The polygons.%s has a Volume of: %f\n",
					shapes[0].getClass().getSimpleName(), shapes[0].getVolume());

			// Loop through the array and print every 1000th element
			for (int i = 999; i < shapes.length; i += 1000) {
				System.out.printf("%d-th element is: The polygons.%s has a Volume of: %f\n",
						i + 1, shapes[i].getClass().getSimpleName(), shapes[i].getVolume());
			}

			// Print the second last element
			System.out.printf("Second last element is: The polygons.%s has a Volume of: %f\n",
					shapes[shapes.length - 2].getClass().getSimpleName(), shapes[shapes.length - 2].getVolume());

			// Print the last element
			System.out.printf("Last element is: The polygons.%s has a Volume of: %f\n",
					shapes[shapes.length - 1].getClass().getSimpleName(), shapes[shapes.length - 1].getVolume());

			// calculate the run time and print it as the last line
			System.out.println("Run time: " + (System.currentTimeMillis() - startTime) + " milliseconds");

			// Print which sorting algorithm was used and the comparison type
			System.out.println("Sorting algorithm: " + sortingAlgorithm);
			System.out.println("Comparison type: " + comparisonType);
		}
    }

	/**
	 * Read shapes from a file and return an array of Shape3D objects
	 *
	 * @param fileName the name of the file to read
	 * @return an array of Shape3D objects
	 */
	private static Shape3D[] readShapesFromFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			int numberOfShapes = Integer.parseInt(br.readLine().trim());
			Shape3D[] shapes = new Shape3D[numberOfShapes];

			String line;
			int index = 0;

			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(" ");
				String shapeType = tokens[0];
				double height = Double.parseDouble(tokens[1]);
				double value = Double.parseDouble(tokens[2]);

				switch (shapeType) {
					case "Cylinder":
						shapes[index++] = new Cylinder(value, height);
						break;
					case "Cone":
						shapes[index++] = new Cone(value, height);
						break;
					case "Pyramid":
						shapes[index++] = new Pyramid(value, height);
						break;
					case "SquarePrism":
						shapes[index++] = new SquarePrism(value, height);
						break;
					case "TriangularPrism":
						shapes[index++] = new TriangularPrism(value, value, height);
						break;
					case "PentagonalPrism":
						shapes[index++] = new PentagonalPrism(value, height);
						break;
					case "OctagonalPrism":
						shapes[index++] = new OctagonalPrism(value, height);
						break;
					default:
						System.out.println("Unknown shape type: " + shapeType);
						break;
				}
			}
			return shapes;
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			return null;
		}
    }

	/**
	 * Sort the array of shapes using the specified sorting algorithm
	 *
	 * @param shapes the array of shapes to sort
	 * @param comparator the comparator to use for sorting
	 * @param sortType the type of sorting algorithm to use
	 */
	private static void sortShapes(Shape3D[] shapes, Comparator<Shape3D> comparator, String sortType) {
		switch (sortType) {
			case "b":
				bubbleSort(shapes, comparator);
				break;
			case "s":
				selectionSort(shapes, comparator);
				break;
			case "i":
				insertionSort(shapes, comparator);
				break;
			case "m":
				mergeSort(shapes, comparator);
				break;
			case "q":
				quickSort(shapes, comparator);
				break;
			case "g":
				bogobogoSort(shapes, comparator);
				break;
			default:
				throw new IllegalArgumentException("Invalid sorting algorithm: " + sortType);
		}
	}
}
