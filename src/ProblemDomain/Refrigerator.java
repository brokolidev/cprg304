package ProblemDomain;

import Enums.NumOfDoors;

public class Refrigerator extends Appliance {
    public Integer doors;
    public Integer height;
    public Integer width;

    public Refrigerator(String itemNumber, String brand, Integer quantity,
                        Integer wattage, String color, Double price,
                        Integer doors, Integer width, Integer height) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.doors = doors;
        this.height = height;
        this.width = width;
    }

    /**
     * Method to determine the formatted number of doors
     */
    public NumOfDoors getNumberOfDoors() {
        return switch (this.doors) {
            case 2 -> NumOfDoors.Double;
            case 3 -> NumOfDoors.Three;
            case 4 -> NumOfDoors.Four;
            default -> null;
        };
    }

    /**
     * Method to display the number of doors
     */
    public String displayNumberOfDoors() {
        return switch (this.getNumberOfDoors()) {
            case Double -> "Double Door";
            case Three -> "Three Doors";
            case Four -> "Four Doors";
            default -> "Unknown";
        };
    }

    /**
     * Method to format the all properties for a file
     */
    @Override
    public String formatForFile() {
        String commonFormatted = super.formatForFile();

        return String.join(
                ";",
                commonFormatted,
                doors.toString(),
                width.toString(),
                height.toString()
        );
    }

    // redefine the toString method
    @Override
    public String toString() {
        String baseString = super.toString();
        return baseString +
                "\nNumber of Doors: " + this.displayNumberOfDoors() +
                "\nHeight: " + height +
                "\nWidth: " + width + "\n";
    }
}
