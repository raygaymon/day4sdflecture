package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = (dirPath + File.separator + fileName);

        File newDir = new File(dirPath);
        if (newDir.exists()) {
            System.out.println(newDir + " already exists");
        } else {
            newDir.mkdir();
            System.out.println(newDir + " created. Have fun!");
        }

        File newFile = new File(dirPathFileName);
        if (newFile.exists()) {
            System.out.println(newFile + " already exists");
        } else {
            System.exit(0);
        }

        // filereader decorator pattern
        FileReader fr = new FileReader(new File(dirPathFileName));
        BufferedReader br = new BufferedReader(fr);

        // using readers to convert stuff into strings
        // stringbuilder turns things into strings???

        StringBuilder sbHorn = new StringBuilder();
        String horn = "";
        while ((horn = br.readLine()) != null) {
            sbHorn.append(horn);
        }
        br.close();
        fr.close();

        String printHorn = sbHorn.toString();
        //System.out.println(printHorn);

        printHorn = printHorn.replace("Rhodes Island", "my account");
        printHorn = printHorn.replace("Rita", "Horn");
        printHorn = printHorn.replace("Victorian", "big-boobied");
        printHorn = printHorn.replace("Victoria", "boobieland");
        printHorn = printHorn.replace("Sargon", "Christians");
        printHorn = printHorn.replace(",", " ");
        printHorn = printHorn.replace(".", " ");
        printHorn = printHorn.replace("'", " ");
        printHorn = printHorn.replace("", " ");
        System.out.println(printHorn);

        String [] hornY = printHorn.split(" ");

        Map<String, Integer> hornHorn = new HashMap<>();

        for (String horns : hornY) {

            Integer boob = hornHorn.get(horns);

            if (boob == null) {
                hornHorn.put(horns, 1);
            } else {
                hornHorn.put(horns, boob + 1);
            }
        }

        System.out.println(hornHorn);
    }
}
