import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Testing {
    public static void main(String[] args) {
        System.out.println("hello\nsir");

        FileReader fileReaderForCsv;
        try {
            fileReaderForCsv = new FileReader("task01/thankyou.csv");
            BufferedReader bufferedReaderForCsv = new BufferedReader(fileReaderForCsv);
            bufferedReaderForCsv.readLine();

            String line = bufferedReaderForCsv.readLine();
            String[] lineArray = line.split(",");
            String address = lineArray[2];
            address = address.replace("\n", "\n");
            System.out.println(String.format(address));
            System.out.println("221b Baker St\nLondon");
            


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {

        }
     


    }
    
}
