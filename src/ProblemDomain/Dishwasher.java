package ProblemDomain;

public class Dishwasher extends Appliance {
    public String feature;
    public String soundRating;

    public Dishwasher(Integer itemNumber, String brand, Integer quantity,
                      Integer wattage, String color, Double price,
                      String feature, String soundRating) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.feature = feature;
        this.soundRating = soundRating;
    }

    // redefine the toString method
    @Override
    public String toString() {
        return "Dishwasher{" +
                "itemNumber=" + itemNumber +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", wattage=" + wattage +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", feature='" + feature + '\'' +
                ", soundRating='" + soundRating + '\'' +
                '}';
    }
}
