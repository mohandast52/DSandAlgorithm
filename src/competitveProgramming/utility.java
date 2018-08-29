package competitveProgramming;

public class utility {


    public static int getAllDivisors(int n) {
        int temp = 1;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    temp *= i;
                } else {
                    temp *= i;
                    temp *= (n / i);
                }
            }
        }
        return temp;
    }

    private static boolean isPerfectSqaure(int n) {
        int root_n = (int) Math.sqrt(n);
        return (root_n * root_n == n);
    }


    // only till 10^6
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;

        prime[0] = prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * 2; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;
    }

    // after 10^6
    public static boolean isPrime(int num) {
        // if sum > 10^5
        if (num > 2 && num % 2 == 0) {
            return false;
        }
        int top = (int) Math.sqrt(num) + 1;
        for (int i = 3; i < top; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
