import java.util.Scanner;

public class Matrix5{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize a 3x4 matrix
        int[][] matrix = new int[3][4];

        // Input values for the matrix
        System.out.println("Enter values for the 3x4 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Enter value for element at position (" + (i + 1) + "," + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Print the matrix
        System.out.println("The 3x4 matrix is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // Move to the next row
        }

        scanner.close();
    }
}
