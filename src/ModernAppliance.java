import Enums.ApplianceTypes;
import ProblemDomain.*;

import java.io.*;
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

//    public void Checkout();
//    public void DisplayDishwashers();
//    public void DisplayMicrowaves();
//    public void DisplayRefrigerators();
//    public void DisplayVacuums();
//    public void Find();
//    public void RandomList();

    private List<Appliance> readAppliances() throws FileNotFoundException {
        File dataFile = new File(APPLIANCES_TEXT_FILE);
        Scanner scanner = null;

        // create a new appliance list
        List<Appliance> appliances = new java.util.ArrayList<>();

        try
        {
            scanner = new Scanner( dataFile );

            while (scanner.hasNextLine()) {
                Appliance appliance = createAppliance(scanner.nextLine());
                System.out.println(appliance);
                appliances.add(appliance);
            }

            scanner.close();
        }
        catch( FileNotFoundException e )
        {
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
                case Unknown:
                    break;
            }
        }

        return appliance;
    }
}
