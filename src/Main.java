import Enums.Options;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        ModernAppliance modernAppliances = new ModernAppliance();
        Options option = Options.None;

        while (option != Options.SaveExit) {
            modernAppliances.displayMenu();

            System.out.println("Enter option:");

            option = Options.values()[Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())];

            switch (option) {
                case Checkout:
                    modernAppliances.checkout();
                    break;
                case Find:
                    modernAppliances.find();
                    break;
                case DisplayType:
                    modernAppliances.displayType();
                    break;
                case RandomList:
                    modernAppliances.randomList();
                    break;
                case SaveExit:
//                    modernAppliances.save();
                    break;
                default:
                    System.out.println("Invalid option entered. Please try again.");
                    break;
            }
        }
    }
}