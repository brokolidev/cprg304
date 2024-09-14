package ProblemDomain;

import Enums.NumOfDoors;

public class Refrigerator extends Appliance {
    public Integer doors;
    public Integer height;
    public Integer width;

    /**
     * Method to determine the formatted number of doors
     */
    public NumOfDoors numberOfDoors()
    {
        return switch (this.doors) {
            case 2 -> NumOfDoors.Double;
            case 3 -> NumOfDoors.Three;
            case 4 -> NumOfDoors.Four;
            default -> null;
        };
    }

    public Refrigerator(String itemNumber, String brand, Integer quantity,
                        Integer wattage, String color, Double price,
                        Integer doors, Integer height, Integer width) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.doors = doors;
        this.height = height;
        this.width = width;
    }


    /**
     * Method to format the all properties for a file
     */
    @Override
    public String formatForFile()
    {
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
        return "ItemNumber: " + itemNumber +
                "\nbrand: " + brand +
                "\nquantity: " + quantity +
                "\nwattage: " + wattage +
                "\ncolor: " + color +
                "\nprice: " + price +
                "\nnumberOfDoors: " + doors +
                "\nheight: " + height +
                "\nwidth: " + width;
    }
}
