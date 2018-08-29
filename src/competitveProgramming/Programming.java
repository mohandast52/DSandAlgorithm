package competitveProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Programming {
    public static void main(String args[]) throws Exception {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] lineArr = br.readLine().trim().split("\\s+");
            int m = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(lineArr[i]);
            }

            boolean ans = false;
            for (int i = 0; i < n - 3; i++) {
                for (int j = i + 1; j < n - 2; j++) {
                    for (int k = j + 1; k < n - 1; k++) {
                        for (int l = k + 1; l < n; l++) {
                            // System.out.println(arr[i] + " " + arr[j]);
                            if ((arr[i] + arr[j] + arr[k] + arr[l]) == m) {
                                // System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[l]);
                                ans = ans || true;
                            }
                        }
                    }
                }
            }
            System.out.println(ans ? "1" : "0");
            // System.out.println(Arrays.toString(arr));
        }

        out.flush();

    }

}
