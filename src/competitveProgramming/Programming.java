package competitveProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Programming {
    public static void main(String args[]) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = 1000;
        int length = (int) (Math.log10(t) + 1);
        System.out.println(Math.pow(10, length));

        char[] str = (123457 + "").toCharArray();
        int a = 4;
        for (int i = 1; i < str.length; i += 2) {
            System.out.println((int) str[i]);
            str[i] = Character.forDigit((Character.getNumericValue(str[i]) + a) % 10, 10);
        }
        System.out.println(String.valueOf(str));
        out.flush();
    }
}

/*
            int C = Integer.parseInt(line1[1]);

            String[] line2 = reader.readLine().trim().split("\\s+");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(line2[i]);
            }



            int t = Integer.parseInt(reader.readLine().trim());
            while (t-- > 0) {
            String[] line1 = reader.readLine().trim().split("\\s+");
            int X = Integer.parseInt(line1[0]);
            int Y = Integer.parseInt(line1[1]);


            out.println();
        }
*/
