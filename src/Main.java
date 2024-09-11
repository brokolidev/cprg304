import ProblemDomain.Appliance;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main( String[] args ) throws IOException {
        // read line by line from a file in /res folder
        String path = "res/appliances.txt";
        FileReader file = new FileReader(path);
        BufferedReader data = new BufferedReader(file);

        // get total number of lines to determine the number of appliances
        long noOfLines = -1;

        try(LineNumberReader lineNumberReader =
                    new LineNumberReader(new FileReader(new File(path)))) {
            //Skip to last line
            lineNumberReader.skip(Long.MAX_VALUE);
            noOfLines = lineNumberReader.getLineNumber() + 1;
        }

        // define an array of appliances
        Appliance[] appliances = new Appliance[(int) noOfLines];

        // check if the file exists
        if(new File(path).exists()) {
//            String line = data.readLine();
//
//            // create an appliance object
//            Appliance appliance = createAppliance(line);
//            appliances[] = appliance;


            // print the appliance object
//            System.out.println(appliance);


//            while (line != null) {
//                System.out.println(line);
//                // read next line
//                line = data.readLine();
//            }

            data.close();
        } else {
            System.out.println("File does not exist");
        }

    }
}