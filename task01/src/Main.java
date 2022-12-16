
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // To run application
        // <program> <CSV file> <template file>
       
        String csvFile = args[0];
        String textFile = args[1];

        List<String> textLineList = new ArrayList<>();
        Map<String, String> variableNameToValueMap = new HashMap<>();

        try {
            FileReader fileReaderForText = new FileReader(textFile);
            BufferedReader bufferedReaderForText = new BufferedReader(fileReaderForText);
            String textLine = "";

            while ((textLine = bufferedReaderForText.readLine()) != null) {
                textLineList.add(textLine);
            }

            bufferedReaderForText.close();

            FileReader fileReaderForCsv = new FileReader(csvFile);
            BufferedReader bufferedReaderForCsv = new BufferedReader(fileReaderForCsv);

            String headers = bufferedReaderForCsv.readLine();
            String[] variableNameArray = headers.split(",");
            List<String> variableNameList = Arrays.asList(variableNameArray);
            // Checking to see whether variableNameList is correct
            // System.out.println(variableNameList);

            String csvLine = "";
            while ((csvLine = bufferedReaderForCsv.readLine()) != null) {
                String[] valueArray = csvLine.split(",");
                for (int i = 0; i < valueArray.length; i++) {
                    valueArray[i] = valueArray[i].replaceAll("\\\\n", System.lineSeparator());
                }
                
                // Process the template
                for (String line : textLineList) {
           
                    // find all the words with <<>>
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if (word.contains("<<")) {
                            String newWord = word.substring(word.indexOf("<<") + 2, word.indexOf(">"));
                        
                            // look up the value of the new word
                            int i = variableNameList.indexOf(newWord);
                            String value = valueArray[i];
                

                            line = line.replace("<<" + newWord + ">>", value);
    
                        }
                    }
         
                    System.out.println(line);
                }

            }

            bufferedReaderForCsv.close();

            // Notes
            // Cannot create a class to store the variables because the variable name change
            // Combine template list into 








        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {

        }
    }
}