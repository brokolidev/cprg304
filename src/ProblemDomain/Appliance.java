package ProblemDomain;

public class Appliance {
    public Integer itemNumber;
    public String brand;
    public Integer quantity;
    public Integer wattage;
    public String color;
    public Double price;

    public Appliance(Integer itemNumber, String brand, Integer quantity, Integer wattage, String color, Double price) {
        this.itemNumber = itemNumber;
        this.brand = brand;
        this.quantity = quantity;
        this.wattage = wattage;
        this.color = color;
        this.price = price;
    }

    // redefine the toString method
    @Override
    public String toString() {
        return "Appliance{" +
                "itemNumber=" + itemNumber +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", wattage=" + wattage +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}

