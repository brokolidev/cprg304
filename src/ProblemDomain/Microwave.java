package ProblemDomain;

import Enums.MicrowaveRoomType;

public class Microwave extends Appliance {
    public Double capacity;
    public String roomType;

    public Microwave(Integer itemNumber, String brand, Integer quantity,
                     Integer wattage, String color, Double price,
                     Double capacity, String roomType) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.capacity = capacity;
        this.roomType = roomType;
    }

    /**
     * Method to determine the room type of the microwave
     */
    public MicrowaveRoomType roomTypeDisplay()
    {
        return switch (this.roomType) {
            case "Kitchen" -> MicrowaveRoomType.Kitchen;
            case "Worksite" -> MicrowaveRoomType.WorkSite;
            default -> throw new IllegalStateException("Unexpected value: " + this.roomType);
        };
    }

    /**
     * Method to format all the properties of the microwave for a file
     */
    public String FormatForFile()
    {
        String commonFormatted = super.FormatForFile();

        // join all the properties with a semicolon
        return String.join(
                ";",
                commonFormatted,
                capacity.toString(),
                roomType
        );
    }

    // redefine the toString method
    @Override
    public String toString() {
        return "Microwave{" +
                "itemNumber=" + itemNumber +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", wattage=" + wattage +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}
