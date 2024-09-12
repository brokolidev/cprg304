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
    public Voltage voltageLevel()
    {
        return switch (this.voltage) {
            case 18 -> Voltage.Low;
            case 24 -> Voltage.High;
            default -> Voltage.Any;
        };
    }

    /**
     * Method to format the all properties for a file
     */
    @Override
    public String FormatForFile()
    {
        String commonFormatted = super.FormatForFile();

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
        return "Vacuum{" +
                "itemNumber=" + itemNumber +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", wattage=" + wattage +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", grade='" + grade + '\'' +
                ", voltage=" + voltage +
                '}';
    }
}
