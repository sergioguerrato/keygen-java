package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] params = Input.input();
        String key = Generator.key(params);
        Output.post(params, key);
    }
}


class Input{
    public static int[] input() {
        Scanner scanner = new Scanner(System.in);
        int[] params = new int[6];

        System.out.printf("Set the parameters for key generator: \n");

        System.out.printf("Memorable: "); //bin
        params[0] = scanner.nextBoolean() ? 1: 0;

        System.out.printf("Alphabetical: "); //bin
        params[1] = scanner.nextBoolean() ? 1: 0;

        System.out.printf("Numerical: "); //bin
        params[2] = scanner.nextBoolean() ? 1: 0;

        System.out.printf("Symbols: "); //bin
        params[3] = scanner.nextBoolean() ? 1: 0;

        System.out.printf("Crypto: "); //bin
        params[4] = scanner.nextBoolean() ? 1: 0;

        System.out.printf("Size: "); //decimal
        params[5] = scanner.nextInt();

        scanner.close();
        return params;
    }
}

class Generator {
    public static String key(int[] params) {
        // params[0] = memorable, [1] = alphabetical, [2] = numerical
        // params[3] = symbols,   [4] = crypto,       [5] = size

        String alphabetical = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numerical    = "0123456789";
        String symbols      = "!@#$%^&*()-_=+[]{}|;:,.<>?";
        int iterator = 0;

        String pool = "";
        if (params[1] == 1) pool += alphabetical;
        if (params[2] == 1) pool += numerical;
        if (params[3] == 1) pool += symbols;

        if (pool.isEmpty()) pool = alphabetical;

        java.util.Random random = new java.util.Random();
        StringBuilder stg = new StringBuilder();

        while (iterator < params[5]) {
            int index = random.nextInt(pool.length());
            stg.append(pool.charAt(index));
            iterator = iterator + 1;
        }

        return stg.toString();
    }
}

class Output {
    public static void post(int[] params, String key) {
        System.out.printf("--- Params --- \n");
        System.out.printf("Memorable: %b%n", params[0]);
        System.out.printf("Alphabetical: %b%n", params[1]);
        System.out.printf("Numerical: %b%n", params[2]);
        System.out.printf("Symbols: %b%n", params[3]);
        System.out.printf("Crypto: %b%n", params[4]);
        System.out.printf("Size: %d%n", params[5]);

        System.out.printf("\n ------------- KEY -------------");
        System.out.printf("\n %s", key);
        System.out.printf("\n -------------------------------");
    }
}