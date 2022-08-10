import java.util.Scanner;

class main {
    public static void main(String[] args) {
        boolean squarePrinted = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows and columns please");
        do {
            String userInput = scanner.nextLine();
            if(CheckUserInput(userInput)){
                if(Integer.parseInt(userInput) < 0){
                    System.out.println("Please enter a non-negative whole number");
                    continue;
                }
               PrintSquare(userInput);
               squarePrinted = true;
            }
        }
        while(!squarePrinted);
    }
    public static boolean CheckUserInput(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a non-negative whole number");
            return false;
        }
    }
    public static void PrintSquare(String userInput){
        int dims = Integer.parseInt(userInput);
        if(dims==1){
            System.out.println("*");
            return;
        }
        if((dims - 5) > 0){
            PrintDoubleSquare(userInput);
            return;
        }
        StringBuilder whitespace = new StringBuilder();
        for (int i = 0; i < dims; i++){
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < dims - 2; i++){
            whitespace.append(" ");
        }
        for (int i = 0; i < dims - 2; i++){
            System.out.println("*" + whitespace + "*");
        }
        for (int i = 0; i < dims; i++){
            System.out.print("*");
        }
    }
    public static void PrintDoubleSquare(String userInput){
        int dims = Integer.parseInt(userInput);
        StringBuilder whitespace = new StringBuilder();
        StringBuilder doubleSquareSides = new StringBuilder();
        StringBuilder doubleSquareTopBottom = new StringBuilder();
        StringBuilder insideSquareTopBottom = new StringBuilder();
        for (int i = 0; i < dims; i++){
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < dims - 2; i++){
            whitespace.append(" ");
        }
        System.out.println("*" + whitespace + "*");

        for (int i = 0; i < dims; i++){
            doubleSquareSides.append(" ");
        }
        doubleSquareSides.replace(0, 1,"*");
        doubleSquareSides.replace(dims-1, dims,"*");
        doubleSquareSides.replace(2, 3,"*");
        doubleSquareSides.replace(dims-3, dims-2,"*");

        doubleSquareTopBottom.replace(0,dims, doubleSquareSides.toString());
        for (int i = 0; i < dims-6; i++){
            insideSquareTopBottom.append("*");
        }
        doubleSquareTopBottom.replace(3,dims-3,insideSquareTopBottom.toString());
        System.out.println(doubleSquareTopBottom);
        for (int i = 0; i < dims - 6; i++){
            System.out.println(doubleSquareSides);
        }
        System.out.println(doubleSquareTopBottom);
        System.out.println("*" + whitespace + "*");
        for (int i = 0; i < dims; i++){
            System.out.print("*");
        }
    }
}

//made by Toeb
//something else
//and again
