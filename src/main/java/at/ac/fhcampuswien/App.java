package at.ac.fhcampuswien;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void oneMonthCalendar(int days, int start) {
        int n = 1;
        int row = 1;
        int count = 0;
        for (int i = 1; start > i; i++)
        {
            System.out.print("   ");
            n++;
        }
        for (int j = 1; j <= days; j++)
        {
            if (j < 10)
            {
                System.out.print(" " + j + " ");
            }
            else
            {
                System.out.print(j + " ");
            }
            count++;
            n++;
            if (n == 8)
            {
                row++;
                n = 1;
                System.out.println();
            }
            if (row == 5 && count == days)
            {
                System.out.println();
            }
        }
    }

    @Contract(pure = true)
    public static long @NotNull [] lcg(long seed)
    {
        long[] randomNumbers = new long[10];
        int m = 2147483647;
        int c = 12345;
        int a = 1103515245;

        for (int i = 0; randomNumbers.length > i; i++){
            seed = (a * seed + c) % (m+1);
            randomNumbers[i] = seed;
        }

        return randomNumbers;

    }

    public static void guessingGame(int numberToGuess) {
        int i = 1, y = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Guess number " + i + ": ");
            y = sc.nextInt();

            if (i == 10)
            {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            }
            else if (y < numberToGuess)
            {
                System.out.println("The number AI picked is higher than your guess.");

            }
            else if (y > numberToGuess)
            {
                System.out.println("The number AI picked is lower than your guess.");

            }
            else if (y == numberToGuess)
            {
                System.out.println("You won wisenheimer!");
            }
            i++;
        } while (y != numberToGuess && i != 11);
    }
    public static int randomNumberBetweenOneAndHundred()
    {
        int randomNumber = 1 + (int) (Math.random() * ((100 - 1) + 1));
        return randomNumber;
    }

    public static boolean swapArrays(int[] first, int[]second)
    {
        int[] help;
        if (first.length == second.length)
        {
            help = new int[first.length];
            for (int i = 0; i < first.length; i++)
            {
                help[i] = first[i];
                first[i] = second[i];
                second[i] = help[i];
            }
        }
        else
        {
            return false;
        }
        return true;
    }

    public static String camelCase(String sentence)
    {
        char[] cs = sentence.toCharArray();
        boolean big = true;
        boolean small = false;
        StringBuilder resut = new StringBuilder();
        for (int i = 0; i < cs.length; i++)
        {
            if(cs[i] == 32)
            {
                big = true;
                small = false;

            } else if(big && (cs[i] <= 90 && cs[i] >= 65 || cs[i] >= 97 && cs[i] <= 122))
            {
                if (cs[i] >= 97 && cs[i] <= 122)
                {
                    resut.append((char) (cs[i] - 32));
                }
                else
                {
                    resut.append(cs[i]);
                }
                big = false;
                small = true;
            } else if (small && (cs[i] <= 90 && cs[i] >= 65 || cs[i] >= 97 && cs[i] <= 122)) {
                if (cs[i] >= 65 && cs[i] <= 90)
                {
                    resut.append((char) (cs[i] + 32));
                }
                else
                {
                    resut.append(cs[i]);
                }
            }

        }
        return resut.toString();
    }

    public static int checkDigit(int[] code)
    {
        int sum = 0;
        for(int i = 0; i < code.length;i++)
        {
            code[i] *= (i+2);
            sum += code[i];
        }
        int rest = sum%11;
        int psumme = 11-rest;
        if(psumme == 10)
        {
            psumme = 0;
        } else if(psumme == 11)
        {
            psumme = 5;
        }
        return psumme;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days =  scan.nextInt();
        int start = scan.nextInt();
        oneMonthCalendar(days,start);
        long[] randomNumbers = lcg(0);

        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }
}