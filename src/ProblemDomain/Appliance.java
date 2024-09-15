package ProblemDomain;

import Enums.ApplianceTypes;

public abstract class Appliance {
    public String itemNumber;
    public String brand;
    public Integer quantity;
    public Integer wattage;
    public String color;
    public Double price;
    public ApplianceTypes type;

    /**
     * Constructor for the Appliance class
     */
    public Appliance(String itemNumber, String brand, Integer quantity, Integer wattage, String color, Double price) {
        this.itemNumber = itemNumber;
        this.brand = brand;
        this.quantity = quantity;
        this.wattage = wattage;
        this.color = color;
        this.price = price;
        this.type = getApplianceType(itemNumber);
    }

    /**
     * method for determining the type of appliance by taking first digit of item number
     * 1 = refrigerators, 2 = vacuums, 3 = microwaves, 4 or 5 = dishwashers
     *
     * @param itemNumber the item number of the appliance
     * @return Appliance type
     */
    public static ApplianceTypes getApplianceType(String itemNumber) {
        char firstDigit = itemNumber.charAt(0);
        return switch (firstDigit) {
            case '1' -> ApplianceTypes.Refrigerator;
            case '2' -> ApplianceTypes.Vacuum;
            case '3' -> ApplianceTypes.Microwave;
            case '4', '5' -> ApplianceTypes.Dishwasher;
            default -> ApplianceTypes.Appliance;
        };
    }

    /**
     * Method to check out an appliance
     */
    public void checkout() {
        quantity -= 1;
    }

    /**
     * Method to format the appliance properties for a file
     */
    public String formatForFile() {
        String strPrice = getProperPrice(price);

        // join all the properties with a semicolon
        return String.join(
                ";",
                itemNumber.toString(), brand, quantity.toString(),
                wattage.toString(), color, strPrice
        );
    }

    private String getProperPrice(Double price) {
        String strPrice = price.toString();
        // get rid of decimal from price if there is no decimal value
        if (price % 1 == 0) {
            Integer intPrice = price.intValue();
            strPrice = intPrice.toString();
        }

        return strPrice;
    }

    @Override
    public String toString() {
        String strPrice = getProperPrice(price);
        return "ItemNumber: " + itemNumber +
                "\nBrand: " + brand +
                "\nQuantity: " + quantity +
                "\nWattage: " + wattage +
                "\nColor: " + color +
                "\nPrice: " + strPrice;
    }
}

