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
        // Cannot create a class to store the variables because the variable name change
        List<String> txtLineList = new ArrayList<>();
        Map<String, String> variableNameToValueMap = new HashMap<>();

        try {
            FileReader fileReaderForTxt = new FileReader("task01/thankyou.txt");
            BufferedReader bufferedReaderForTxt = new BufferedReader(fileReaderForTxt);
            String txtLine = "";

            while ((txtLine = bufferedReaderForTxt.readLine()) != null) {
                txtLineList.add(txtLine);
            }

            bufferedReaderForTxt.close();

            FileReader fileReaderForCsv = new FileReader("task01/thankyou.csv");
            BufferedReader bufferedReaderForCsv = new BufferedReader(fileReaderForCsv);

            String headers = bufferedReaderForCsv.readLine();
            String[] variableNames = headers.split(",");
            List<String> variableNameList = Arrays.asList(variableNames);
            // Checking to see whether variableNameList is correct
            // System.out.println(variableNameList);

            String csvLine = "";
            while ((csvLine = bufferedReaderForCsv.readLine()) != null) {
                String[] values = csvLine.split(",");
                
                // Process the template
                for (String line : txtLineList) {
           
                    // find all the words with <<>>
                    String[] words = line.split(" ");
                    for (String word : words) {
                        if (word.startsWith("<<")) {
                            String newWord = word.substring(2, word.indexOf(">"));
                        
                            // look up the value of the new word
                            int i = variableNameList.indexOf(newWord);
                            String value = values[i];

                            line = line.replace("<<" + newWord + ">>", value);
                        }
                    }
                    System.out.println(line);
                }


            }

            bufferedReaderForCsv.close();








        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {

        }
    }
}