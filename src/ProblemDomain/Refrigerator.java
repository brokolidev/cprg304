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

    public Refrigerator(Integer itemNumber, String brand, Integer quantity,
                        Integer wattage, String color, Double price,
                        Integer doors, Integer height, Integer width) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.doors = doors;
        this.height = height;
        this.width = width;
    }


    /**
     * Method to format the appliance properties for a file
     */
    @Override
    public String FormatForFile()
    {
        String commonFormatted = super.FormatForFile();

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
        return "Refrigerator{" +
                "itemNumber=" + itemNumber +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", wattage=" + wattage +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", numberOfDoors=" + doors +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
