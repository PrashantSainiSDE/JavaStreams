package com.stream.practice;

public class FindNthPrime {
    public static boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static int findNthPrime(int n) {
    int count = 0, num = 1;
    while (count < n){
        num++;
        if(isPrime(num)){
            count++;
        }
    }
    return num;
    }
    public static void main(String[] args) {
        int nth1 = 4;
        int nth2 = 5;
        int nthPrime1 = findNthPrime(nth1);
        int nthPrime2 = findNthPrime(nth2);
        System.out.println((nthPrime1 * nthPrime2) - 1);

    }
}
