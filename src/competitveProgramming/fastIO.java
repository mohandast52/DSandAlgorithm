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

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Reader reader = new Reader();
        int t = reader.nextInt();
        int n = reader.nextInt();

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int fishSize = reader.nextInt();
            int eatingFactor = reader.nextInt();

            ArrayList<Integer> listTemp = null;
            if (map.containsKey(eatingFactor)) {
                listTemp = map.get(eatingFactor);
                listTemp.add(fishSize);
                Collections.sort(listTemp);
                map.put(eatingFactor, listTemp);
            } else {
                listTemp = new ArrayList<>();
                listTemp.add(fishSize);
                map.put(eatingFactor, listTemp);
            }
        }

        // System.out.println(map);

        int count = 0;
        int maxCount = 0;

        Object[] keysetarr = map.keySet().toArray();
        out.flush();

        int start = 0;
        int i = 1;
        while (i < keysetarr.length) {
            ArrayList<Integer> startList = map.get(keysetarr[start]);
            if (startList.size() == 1) {
                if (startList.get(0) <= (Integer) (keysetarr[i])) {
                    maxCount = Math.max(maxCount, i - start);
                    // System.out.println(count);
                    count = count - 1;
                    start++;
                }
                ++i;
                ++count;
            } else {
                int j = 0;
                while (j < startList.size()) {
                    if (startList.get(j) <= (Integer) (keysetarr[i])) {
                        maxCount = Math.max(maxCount, i - start);
                        // System.out.println(count);
                        count = count - 1;
                    }
                    ++count;
                    ++j;
                }
            }
        }
        System.out.println((i - maxCount));

    }
}

/*

1
7
1 4
2 5
3 3
7 4
7 4
5 4
7 8

1
3
4 6
5 4
3 5


*/

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



