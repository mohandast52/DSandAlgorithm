package competitveProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

class TestClass1 {
    public static class Trie {
        Trie[] map;
        int count;

        Trie() {
            map = new Trie[26];
            count = 0;
        }
    }

    public static void main(String[] sp) throws Exception {

        InputReader ir = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = ir.nextInt();
        StringBuilder sb = new StringBuilder();
        Trie root = new Trie();
        while (n-- > 0) {
            String op = ir.readString();
            String key = ir.readString();
            if (op.equals("add"))
                add(root, key);
            else
                sb.append(find(root, key) + "\n");
        }
        pw.print(sb);
        pw.close();
    }

    public static void add(Trie curr, String s) {
        for (char c : s.toCharArray()) {
            int i = (c - 'a');
            if (curr.map[i] == null)
                curr.map[i] = new Trie();
            curr = curr.map[i];
            ++curr.count;
        }
    }

    public static int find(Trie curr, String s) {
        boolean flag = false;
        for (char c : s.toCharArray()) {
            int i = (c - 'a');
            if (curr.map[i] != null)
                curr = curr.map[i];
            else {
                flag = true;
                break;
            }
        }
        if (flag)
            return 0;
        return curr.count;
    }

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}


