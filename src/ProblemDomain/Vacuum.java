package ProblemDomain;

import Enums.Voltage;

public class Vacuum extends Appliance {
    public String grade;
    public Integer voltage;

    public Vacuum(String itemNumber, String brand, Integer quantity,
                  Integer wattage, String color, Double price,
                  String grade, Integer voltage) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.grade = grade;
        this.voltage = voltage;
    }

    /**
     * Determine the voltage level of the vacuum
     */
    public Voltage getVoltageLevel() {
        return switch (this.voltage) {
            case 18 -> Voltage.Low;
            case 24 -> Voltage.High;
            default -> Voltage.Any;
        };
    }

    /**
     * Method to display the voltage level
     *
     * @return
     */
    public String displayVoltage() {
        return switch (this.getVoltageLevel()) {
            case Low -> "Low";
            case High -> "High";
            default -> "Any";
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
                grade,
                voltage.toString()
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
                "\nGrade: " + grade +
                "\nVoltage: " + this.displayVoltage() + "\n";
    }
}
