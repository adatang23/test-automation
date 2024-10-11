package java_basics.seventh_topic;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        try {
            // Read the text from the file located at src/main/resources/sample.txt
            File file = new File("src/main/resources/sample.txt");
            String res = FileUtils.readFileToString(file, "UTF-8");
            // Replace all non-alphabetic characters with spaces and convert the string to lowercase
            String modifiedRes = StringUtils.lowerCase(res.replaceAll("[^a-zA-Z]", " "));
            // Save the String[] to a HashSet<>()
            Set<String> strSet = new HashSet<>(Arrays.asList(modifiedRes.split(" ")));
            strSet.remove("");
            // Print the strSet to the console
            System.out.println(strSet);
            // Write the count result of the unique word to the file with the Set size
            FileUtils.write(file, res + "\nThe number of unique words: " + strSet.size());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
