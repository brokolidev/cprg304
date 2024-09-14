import Enums.ApplianceTypes;
import ProblemDomain.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ModernAppliance {
    // data file path
    final String APPLIANCES_TEXT_FILE = "res/appliances.txt";

    private List<Appliance> applianceList;

    // constructor
    public ModernAppliance() throws FileNotFoundException {
        this.applianceList = readAppliances();
    }

    public void displayMenu() {
        System.out.println("\nWelcome to Modern Appliances!");
        System.out.println("How may we assist you?");
        System.out.println("1 - Check out Appliance");
        System.out.println("2 - Find appliances by brand");
        System.out.println("3 - Display appliances by type");
        System.out.println("4 - Produce random appliance list");
        System.out.println("5 - Save and exit");
    }

    /**
     * Menu option 1
     * Check out an appliance
     */
    public void checkout() {
        System.out.println("Enter the item number of an appliance");

        // read the item number from the user
        Scanner scanner = new Scanner(System.in);
        String inputItemNumber = scanner.nextLine();

        Appliance foundAppliance = null;

        // find the appliance in the list
        for (Appliance appliance : applianceList) {
            if (appliance.itemNumber.equals(inputItemNumber)) {
                foundAppliance = appliance;
                break;
            }
        }

        if (foundAppliance == null) {
            System.out.println("No appliance found with that item number");
        } else {
            if (foundAppliance.quantity > 0) {
                foundAppliance.quantity--;
                System.out.println("Appliance " + foundAppliance.itemNumber + " has been checked out.");
            } else {
                System.out.println("The appliance is not available to be checked out.");
            }
        }
    }

    /**
     * Menu option 2
     * Find appliances by brand
     */
    public void find() {
        System.out.println("Enter brand to search for");

        // read the brand from the user
        Scanner scanner = new Scanner(System.in);
        String inputBrand = scanner.nextLine();
        inputBrand = inputBrand.trim().toLowerCase();

        // create a list for found appliances
        List<Appliance> foundAppliances = new java.util.ArrayList<>();

        // find the appliance in the list
        for (Appliance appliance : applianceList) {
            if (appliance.brand.toLowerCase().equals(inputBrand)) {
                foundAppliances.add(appliance);
            }
        }

        // display the found appliances
        this.displayAppliancesFromList(foundAppliances, ApplianceTypes.Appliance);
    }

    /**
     * Print out appliances in the list
     *
     * @param appliances
     */
    public void displayAppliancesFromList(List<Appliance> appliances, ApplianceTypes type) {

        if (appliances.isEmpty()) {
            System.out.println("No appliances found.");
            return;
        }

        System.out.println("Matching " + type.toString().toLowerCase() + "s:\n");
        for (Appliance appliance : appliances) {
            System.out.println(appliance);
        }
    }

    public void displayType() {
        System.out.println("Appliance Types");
        System.out.println("1 - Refrigerators");
        System.out.println("2 - Vacuums");
        System.out.println("3 - Microwaves");
        System.out.println("4 - Dishwashers");
        System.out.println("Enter type of appliance:");

        // read the type from the user
        Scanner scanner = new Scanner(System.in);

        try {
            int inputType = scanner.nextInt();

            switch (inputType) {
                case 1:
                    displayRefrigerators();
                    break;
                case 2:
                    displayVacuums();
                    break;
                case 3:
//                    displayMicrowaves();
                    break;
                case 4:
//                    displayDishwashers();
                    break;
                default:
                    System.out.println("Invalid input. Input was not a valid type.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Input was not a number.");
        }

    }

    /**
     * Display refrigerators with the number of doors
     */
    public void displayRefrigerators() {

        System.out.println("Enter number of doors: " +
                "2 (double door), 3 (three doors) or 4 (four doors)");

        List<Appliance> appliances = getRefrigerators();

        if (appliances.isEmpty()) {
            System.out.println("No refrigerators found with that number of doors.");
        } else {
            System.out.println("Matching Refrigerators:");
            this.displayAppliancesFromList(appliances, ApplianceTypes.Refrigerator);
        }
    }

    /**
     * Get refrigerators with the number of doors
     *
     * @return
     */
    private List<Appliance> getRefrigerators() {
        Scanner scanner = new Scanner(System.in);
        Integer inputDoorNumber = scanner.nextInt();

        // create a list for matching refrigerators
        List<Appliance> appliances = new java.util.ArrayList<>();

        // find the appliance in the list
        for (Appliance appliance : applianceList) {
            if (appliance instanceof Refrigerator) {
                Refrigerator refrigerator = (Refrigerator) appliance;
                if (refrigerator.doors == inputDoorNumber) {
                    appliances.add(refrigerator);
                }
            }
        }
        return appliances;
    }

    /**
     * Get vacuums with the voltage
     */
    public void displayVacuums() {
        System.out.println("Enter battery voltage value. 18V(low) or 24V(high)");

        List<Appliance> appliances = getVacuums();

        if (appliances.isEmpty()) {
            System.out.println("No vacuums found with that grade.");
        } else {
            this.displayAppliancesFromList(appliances, ApplianceTypes.Vacuum);
        }
    }

    /**
     * Get vacuums with the voltage
     *
     * @return
     */
    private List<Appliance> getVacuums() {
        Scanner scanner = new Scanner(System.in);
        Integer inputVoltage = scanner.nextInt();

        // create a list for matching refrigerators
        List<Appliance> appliances = new java.util.ArrayList<>();

        // find the appliance in the list
        for (Appliance appliance : applianceList) {
            if (appliance instanceof Vacuum) {
                Vacuum vacuum = (Vacuum) appliance;
                if (vacuum.voltage == inputVoltage) {
                    appliances.add(vacuum);
                }
            }
        }
        return appliances;
    }

//    public void DisplayDishwashers();
//    public void DisplayMicrowaves();

//    public void DisplayVacuums();
//    public void Find();
//    public void RandomList();

    /**
     * Read the appliances from the text file
     *
     * @return
     * @throws FileNotFoundException
     */
    private List<Appliance> readAppliances() throws FileNotFoundException {
        File dataFile = new File(APPLIANCES_TEXT_FILE);
        Scanner scanner = null;

        // create a new appliance list
        List<Appliance> appliances = new java.util.ArrayList<>();

        try {
            scanner = new Scanner(dataFile);

            // read the file line by line and create an appliance object
            // add the appliance object to the list
            while (scanner.hasNextLine()) {
                Appliance appliance = createAppliance(scanner.nextLine());
                appliances.add(appliance);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return appliances;
    }

    private Appliance createAppliance(String line) {

        Appliance appliance = null;

        // create an appliance object from the line variable
        String[] lineArray = line.split(";");
        String itemNumber = lineArray[0];

        // check if the id is not null and not empty
        if (Objects.nonNull(itemNumber) && !itemNumber.isEmpty()) {

            // determine the type of the appliance first.
            ApplianceTypes type = Appliance.getApplianceType(itemNumber);

            // get the appliance properties
            String brand = lineArray[1];
            Integer quantity = Integer.parseInt(lineArray[2]);
            Integer wattage = Integer.parseInt(lineArray[3]);
            String color = lineArray[4];
            Double price = Double.parseDouble(lineArray[5]);

            switch (type) {
                case Refrigerator:
                    // create a refrigerator object
                    appliance = new Refrigerator(itemNumber, brand, quantity, wattage, color, price,
                            Integer.parseInt(lineArray[6]), // door
                            Integer.parseInt(lineArray[7]), // height
                            Integer.parseInt(lineArray[8])); // width
                    break;
                case Vacuum:
                    // create a vacuum object
                    appliance = new Vacuum(itemNumber, brand, quantity, wattage, color, price,
                            lineArray[6], // grade
                            Integer.parseInt(lineArray[7])); // voltage
                    break;
                case Microwave:
                    // create a microwave object
                    appliance = new Microwave(itemNumber, brand, quantity, wattage, color, price,
                            Double.parseDouble(lineArray[6]), // capacity
                            lineArray[7]); // room type
                    break;
                case Dishwasher:
                    // create a dishwasher object
                    appliance = new Dishwasher(itemNumber, brand, quantity, wattage, color, price,
                            lineArray[6], // feature
                            lineArray[7]); // sound rating
                    break;
                case Appliance:
                    break;
            }
        }

        return appliance;
    }
}
