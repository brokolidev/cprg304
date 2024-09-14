import Enums.Options;

import java.io.*;

public class Main {

    public static void main( String[] args ) throws IOException {

        ModernAppliance modernAppliances = new ModernAppliance();
        Options option = Options.None;

        while (option != Options.SaveExit) {
            modernAppliances.DisplayMenu();

            System.out.println("\nEnter option:");

            option = Options.values()[Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())];

            switch (option) {
                case Checkout:
//                    modernAppliances.Checkout();
                    break;
                case Find:
//                    modernAppliances.Find();
                    break;
                case DisplayType:
//                    modernAppliances.DisplayType();
                    break;
                case RandomList:
//                    modernAppliances.RandomList();
                    break;
                case SaveExit:
//                    modernAppliances.Save();
                    break;
                default:
                    System.out.println("Invalid option entered. Please try again.");
                    break;
            }
        }
    }
}