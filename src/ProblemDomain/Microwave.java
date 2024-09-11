package ProblemDomain;

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
