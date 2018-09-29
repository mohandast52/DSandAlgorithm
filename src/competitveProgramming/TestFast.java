package competitveProgramming;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class TestFast {

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

    static TrieNode root;

    static class TrieNode {
        Map<Character, TrieNode> childrens;
        boolean isWord;

        public TrieNode() {
            this.childrens = new HashMap<>();
            isWord = false;
        }

        @Override
        public String toString() {
            return childrens.toString();
        }
    }


    public void insert(String[] dict) {
        for (String key : dict) {
            TrieNode parent = root;
            for (Character currentChar : key.toCharArray()) {
                // System.out.println(parent);
                TrieNode child = parent.childrens.get(currentChar);
                if (child == null) {
                    child = new TrieNode();
                    parent.childrens.put(currentChar, child);
                }
                parent = child;
            }
            parent.isWord = true; // last word
        }
    }

    private boolean isWordComplete(String word) {
        TrieNode parent = root;
        for (Character currentChar : word.toCharArray()) {
            // System.out.println(parent);
            TrieNode child = parent.childrens.get(currentChar);
            if (child == null) {
                return false;
            }
            parent = child;
        }
        return parent.isWord;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Reader reader = new Reader();

        TestFast parent = new TestFast();
        root = new TrieNode();

        int t = reader.nextInt();
        String[] line = new String[t];
        for (int i = 0; i < t; i++) {
            line[i] = reader.readLine();
        }
        parent.insert(line);
        t = reader.nextInt();
        while (t-- > 0) {

        }
        out.flush();
    }
}


/*
number of square numbers till n is floor(square root of n)
number of cube numbers till n is floor(cube root of n)
for(int i = 1; i <= 10; i++){
    System.out.println(Math.pow(i, 6));
    // prints every cubes of a number!! ie. x^6
}
*/

/*

int t = reader.nextInt();
while (t-- > 0) {
int N = reader.nextInt();
int[] arr = new int[N];
for (int i = 0; i < N; i++) {
    arr[i] = reader.nextInt();
}
}
// out.println();
out.flush();



*/
