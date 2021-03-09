import java.util.*;

public class SaddlePoint {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[][] = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {

            // To check for lowest value in row
            int svg = 0;
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] < arr[i][svg]) {
                    svg = j;
                }
            }

            // To check for the highest value in column
            int flag = 1;
            for (int k = 0; k < arr.length; k++) {
                if (arr[k][svg] > arr[i][svg]) {
                    flag = 0;
                    break;
                }
            }

            if (flag == 1) {
                System.out.println(arr[i][svg]);
                return;
            }
        }
        System.out.println("Invalid input");
    }

}