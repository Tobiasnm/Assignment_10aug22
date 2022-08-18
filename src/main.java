import java.util.Scanner;

class main {
    public static void main(String[] args) {
        TakeUserInput();
    }

    public static void TakeUserInput() {
        String userInputWidth;
        boolean widthInput = false;
        String userInputHeight;
        boolean heightInput = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width of rectangle");
        do {
            userInputWidth = scanner.nextLine();
            if (CheckUserInput(userInputWidth)) {
                widthInput = true;
            }
        }
        while (!widthInput);
        System.out.println("Enter height of rectangle");
        do {
            userInputHeight = scanner.nextLine();
            if (CheckUserInput(userInputWidth)) {
                heightInput = true;
            }
        }
        while (!heightInput);
        PrintSquare(userInputWidth, userInputHeight);
    }

    public static boolean CheckUserInput(String input) {
        try {
            if (Integer.parseInt(input) > 0) {
                return true;
            }
        } catch (NumberFormatException e) {}
        System.out.println("Please enter a non-negative whole number");
        return false;
    }

    public static void PrintSquare(String userInputWidth, String userInputHeight) {
        int width = Integer.parseInt(userInputWidth);
        int height = Integer.parseInt(userInputHeight);
        StringBuilder whitespace = new StringBuilder();

        if (width == 1 && height == 1) {
            System.out.println("*");
            return;
        }
        if ((width - 5) > 0 && (height - 5) > 0) {
            PrintDoubleSquare(width, height);
            return;
        }
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < width - 2; i++) {
            whitespace.append(" ");
        }
        for (int i = 0; i < height - 2; i++) {
            if (width > 1)
                System.out.println("*" + whitespace + "*");
            else
                System.out.println("*");
        }
        for (int i = 0; i < width; i++) {
            if (height > 1)
                System.out.print("*");
        }
    }

    public static void PrintDoubleSquare(int _width, int _height) {
        int width = _width;
        int height = _height;
        StringBuilder whitespace = new StringBuilder();
        StringBuilder doubleSquareSides = new StringBuilder();
        StringBuilder doubleSquareTopBottom = new StringBuilder();
        StringBuilder insideSquareTopBottom = new StringBuilder();
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < width - 2; i++) {
            whitespace.append(" ");
        }
        System.out.println("*" + whitespace + "*");

        for (int i = 0; i < width; i++) {
            doubleSquareSides.append(" ");
        }
        doubleSquareSides.replace(0, 1, "*");
        doubleSquareSides.replace(width - 1, width, "*");
        doubleSquareSides.replace(2, 3, "*");
        doubleSquareSides.replace(width - 3, width - 2, "*");

        doubleSquareTopBottom.replace(0, width, doubleSquareSides.toString());
        for (int i = 0; i < width - 6; i++) {
            insideSquareTopBottom.append("*");
        }
        doubleSquareTopBottom.replace(3, width - 3, insideSquareTopBottom.toString());
        System.out.println(doubleSquareTopBottom);
        for (int i = 0; i < height - 6; i++) {
            System.out.println(doubleSquareSides);
        }
        System.out.println(doubleSquareTopBottom);
        System.out.println("*" + whitespace + "*");
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
    }
}

//made by Toeb 10aug22
//modified 18aug22 for different width and height input
