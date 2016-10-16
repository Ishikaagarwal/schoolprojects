package com.company;

public class Testing {
    public static void main(String[] args){
        System.out.println(power(2, 4));
    }

    private static long factorial(long n) {
        return n == 1 ? 1 : factorial(n - 1) * n;
    }

    private static long power(int n, int m){
        return m == 0 ? 1 : power(n, m-1) * n;
    }
}


