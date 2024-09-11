package ProblemDomain;

public class Vacuum extends Appliance {
    public String grade;
    public Integer voltage;

    public Vacuum(Integer itemNumber, String brand, Integer quantity,
                  Integer wattage, String color, Double price,
                  String grade, Integer voltage) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.grade = grade;
        this.voltage = voltage;
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
