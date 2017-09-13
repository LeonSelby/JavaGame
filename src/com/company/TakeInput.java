package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeInput {
    static public Scanner sc = new Scanner(System.in);

    //Input
    static public String takeNextLine() {
        return sc.nextLine();
    }

    static public int takeNextInt() {
        boolean badInput = true;
        int tmp = 0;
        while (badInput) {
            try {
                tmp = Integer.parseInt(sc.nextLine());
                badInput = false;
            } catch (InputMismatchException var3) {
                needIntPlease();
            } catch (NumberFormatException var4) {
                needIntPlease();
            }
        }
        return tmp;
    }

    static public int takeNextIntInRange(int min, int max) {
        boolean badInput = true;
        int tmp = 0;

        while (badInput) {
            try {
                tmp = Integer.parseInt(sc.nextLine());

                if (tmp > max || tmp < min) {
                    needIntInRange(min, max);
                    tmp = Integer.parseInt(sc.nextLine());
                } else
                    badInput = false;
            } catch (InputMismatchException var3) {
                needIntInRange(min, max);
            } catch (NumberFormatException var4) {
                needIntInRange(min, max);
            }
        }
        return tmp;
    }


    static public int requestInput(String question) {
        System.out.println(question);
        int ans = takeNextInt();
        return ans;
    }

    static public int requestInputInRange(String question, int min, int max) {
        System.out.println(question);
        int ans = takeNextIntInRange(min, max);
        return ans;
    }

    static public int requestInputInRange(String question, int max) {
        System.out.println(question);
        int ans = takeNextIntInRange(0, max);
        return ans;
    }

    static public boolean requestYesOrNo(String question) {
        System.out.println(question);
        boolean isYes = false;
        boolean answerNotGiven = true;
        while (answerNotGiven) {
            switch (TakeInput.takeNextLine().toLowerCase()) {
                case "yes":
                case "y":
                    isYes = true;
                    answerNotGiven = false;
                    break;
                case "no":
                case "n":
                    isYes = false;
                    answerNotGiven = false;
                    break;
                default:
                    TakeInput.needYesOrNo();
                    System.out.println(question);
                    break;
            }
        }
        return isYes;
    }
    //Errors
    static private void needIntPlease() {
        System.out.println("We're sorry! Please input a number!");
    }

    static public void intTooHigh(int cap) {
        System.out.println("We're sorry that number is too high! Please give a number below "+cap+".");
    }

    static public void needIntInRange(int min, int max) {
        System.out.printf("We're sorry! Please input a number between " + min + " and " + max + ".");
    }

    static public void needYesOrNo() {
        System.out.println("We're sorry! Please enter yes or no, y or n is accepted also.");
    }
}
