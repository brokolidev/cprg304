package ProblemDomain;

public class Refrigerator extends Appliance {
    public Integer numberOfDoors;
    public Integer height;
    public Integer width;

    public Refrigerator(Integer itemNumber, String brand, Integer quantity,
                        Integer wattage, String color, Double price,
                        Integer numberOfDoors, Integer height, Integer width) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.numberOfDoors = numberOfDoors;
        this.height = height;
        this.width = width;
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
                ", numberOfDoors=" + numberOfDoors +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
