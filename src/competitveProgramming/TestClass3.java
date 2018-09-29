package competitveProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestClass3 {
    public static void main(String args[]) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] line = reader.readLine().trim().split("\\s+");
        int t = Integer.parseInt(line[0]);
        int q = Integer.parseInt(line[1]);
        while (t-- > 0) {
            String[] tpLine = reader.readLine().trim().split("\\s+");
        }

        out.flush();
    }
}
