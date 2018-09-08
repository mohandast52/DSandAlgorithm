package competitveProgramming;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class fastIO {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static boolean[] visited = null;
    static List<Integer> arrayOfList[] = null;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Reader reader = new Reader();

        int t = reader.nextInt();
        while (t-- > 0) {
            int string = reader.nextInt();
            int a = reader.nextInt();
            int h = reader.nextInt();
            int lowest = Integer.MAX_VALUE;
            Set<Integer> visited = new LinkedHashSet<>();
            Queue<Integer> stack = new ArrayDeque<>();
            stack.add(string);
            while (!stack.isEmpty()) {
                int currNumber = stack.remove();
                if (!visited.contains(currNumber)) {

                    visited.add(currNumber);
                    if (lowest > currNumber) {
                        lowest = currNumber;
                    }
                    int seraValue = seraDef(currNumber, h);
                    int xhakaValue = xhakaDef(currNumber, a);

                    if (!visited.contains(seraValue)) {
                       // visited.add(seraValue);
                        stack.add(seraValue);
                    }

                    if (!visited.contains(xhakaValue)) {
                       // visited.add(xhakaValue);
                        stack.add(xhakaValue);
                    }
                }
            }
            System.out.println(visited.toString());
            out.println(lowest);
        }
        out.println();
        out.flush();
    }

    private static int seraDef(int current, int h) {
        String s = (current + "");
        for (int i = 0; i < h; i++) {
            char[] currNumber = s.toCharArray();
            char[] newNumber = new char[currNumber.length];

            for (int j = 0; j < currNumber.length; j++) {
                if (j == currNumber.length - 1) {
                    newNumber[0] = currNumber[j];
                } else {
                    newNumber[j + 1] = currNumber[j];
                }
            }

            s = String.copyValueOf(newNumber);
        }

        return Integer.parseInt(s);
    }

    private static int xhakaDef(int s, int a) {
        char[] charArray = (s + "").toCharArray();

        for (int i = 1; i < charArray.length; i = i + 2) {
            int charElement = Character.getNumericValue(charArray[i]);
            charElement = (charElement + a) % 10;
            charArray[i] = Character.forDigit(charElement, 10);
        }

        return Integer.parseInt(String.valueOf(charArray));
    }
}


/*
        int n = reader.nextInt();
        int families = reader.nextInt();
        int[] A = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = reader.nextInt();
        }

        int row = reader.nextInt();
        int col = reader.nextInt();
        int[][] B = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                B[i][j] = reader.nextInt();
            }
        }

        for (int i = 0; i <=families ; i++) {
            arr[0][i] = 1;
        }
*/

/*
number of square numbers till n is floor(square root of n)
number of cube numbers till n is floor(cube root of n)
for(int i = 1; i <= 10; i++){
    System.out.println(Math.pow(i, 6));
    // prints every cubes of a number!! ie. x^6
}
*/

