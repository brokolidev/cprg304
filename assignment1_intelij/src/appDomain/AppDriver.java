package appDomain;

import shapes.*;
import utilities.ShapeComparatorFactory;

import java.awt.*;
import java.io.*;
import java.util.Comparator;

import static utilities.Sorting.*;


public class AppDriver
{
	public static void main( String[] args )
	{
		// Assume args contains the "-t" option and the comparison type (h, v, or a)
		if (args.length != 3) {
			System.out.println("Usage: java -jar AppDriver.jar -ffile_name -tv -sb");
			return;
		}

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
				sortingAlgorithm = arg.substring(2).toLowerCase();  // Get sorting algorithm (b, s, i, m, q)
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
		}
    }

	// Method to read shapes from the file
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

	// Function to sort the shapes array using the specified algorithm
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
				quickSort(shapes, comparator, 0, shapes.length - 1);
				break;
			default:
				throw new IllegalArgumentException("Invalid sorting algorithm: " + sortType);
		}
	}
}
