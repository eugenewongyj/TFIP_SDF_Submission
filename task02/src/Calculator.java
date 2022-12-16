import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Welcome.");

        double storedResult = 0;

 
        Scanner scanner = new Scanner(System.in);

        System.out.print("> ");
        String userInput = scanner.nextLine().trim();

        while (!userInput.equals("exit")) {
            String[] arguments = userInput.split(" ");
        
            String operation = arguments[1];
            double number1 = arguments[0].equals("$last") ? storedResult : Double.parseDouble(arguments[0]);
            double number2 = arguments[2].equals("$last") ? storedResult : Double.parseDouble(arguments[2]);
   

            switch (operation) {
                case "+":
                    storedResult = number1 + number2;
                    System.out.println(storedResult);
                    break;
                case "-":
                    storedResult = number1 - number2;
                    System.out.println(storedResult);
                    break;
                case "x":
                    storedResult = number1 * number2;
                    System.out.println(storedResult);
                    break;
                case "/":
                    storedResult = number1 / number2;
                    System.out.println(storedResult);
                    break;
                default:
                    System.out.println("This operation is not executable.");

                    
            }


            System.out.print("> ");
            userInput = scanner.nextLine().trim();
        }

        scanner.close();
        System.out.println("Bye bye");
    }
    
}
