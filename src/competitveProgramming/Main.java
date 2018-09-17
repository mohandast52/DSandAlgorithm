package competitveProgramming;


//In submission class declaration should be default not public

import java.util.*;
import java.io.*;

public class Main {

    private static InputStream stream;
    private static byte[] buf = new byte[1024];
    private static int curChar;
    private static int numChars;
    private static SpaceCharFilter filter;
    private static PrintWriter out;
    static int[][] s;
    static int n;

    /*

    */
    private static void solution() {
        int n = nextInt();
        int[] arr = nextIntArray(n);
        // System.out.println(Arrays.toString(arr));
        System.out.println((largestNumber(arr)));
    }


    public static String largestNumber(final int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }

        Collections.sort(list, (o1, o2) -> {
            String s_1 = o1.toString();
            String s_2 = o2.toString();
            String case1 = s_1 + s_2;
            String case2 = s_2 + s_1;
            return case2.compareTo(case1);

        });

        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i));
        }

        while (answer.charAt(0) == '0' && answer.length() > 1) {
            answer.delete(0, 1);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        InputReader(System.in);
        out = new PrintWriter(System.out);
        solution();
        out.close();
    }


    // To Get Input
    // Some Buffer Methods

    public static void InputReader(InputStream stream1) {
        stream = stream1;
    }

    private static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private static boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    private static int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    private static int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    private static long nextLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    private static String nextToken() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    private static String nextLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    private static int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }

    private static long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i] + " ");
        }
        out.println();
        return;
    }

    private static void printArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return;
    }

    private static boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }

    private interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }

}

