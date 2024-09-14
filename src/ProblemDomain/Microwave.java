package ProblemDomain;

import Enums.MicrowaveRoomType;

public class Microwave extends Appliance {
    public Double capacity;
    public String roomType;

    public Microwave(String itemNumber, String brand, Integer quantity,
                     Integer wattage, String color, Double price,
                     Double capacity, String roomType) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.capacity = capacity;
        this.roomType = roomType;
    }

    /**
     * Method to determine the room type of the microwave
     */
    public MicrowaveRoomType getRoomType() {
        return switch (this.roomType) {
            case "Kitchen" -> MicrowaveRoomType.Kitchen;
            case "Worksite" -> MicrowaveRoomType.WorkSite;
            default -> throw new IllegalStateException("Unexpected value: " + this.roomType);
        };
    }

    /**
     * Method to determine the room type of the microwave
     */
    public String displayRoomType() {
        return switch (this.getRoomType()) {
            case MicrowaveRoomType.Kitchen -> "Kitchen";
            case MicrowaveRoomType.WorkSite -> "Worksite";
        };
    }

    /**
     * Method to format all the properties of the microwave for a file
     */
    @Override
    public String formatForFile() {
        String commonFormatted = super.formatForFile();

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
        return "ItemNumber: " + itemNumber +
                "\nBrand: " + brand +
                "\nQuantity: " + quantity +
                "\nWattage: " + wattage +
                "\nColor: " + color +
                "\nPrice: " + price +
                "\nCapacity: " + capacity +
                "\nRoom Type: " + roomType + "\n";
    }
}
