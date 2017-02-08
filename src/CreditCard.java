package com.Sam;

/**
 * Created by samagbeh on 2/8/17.
 */

import java.util.Scanner;

public class CreditCard {

    static Scanner stringScanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Ask user for credit card number. store number as a String.
        System.out.println("Please enter the credit card number, digits only:");
        String cardNumber = stringScanner.nextLine();
        boolean isValid = isValidCreditCard(cardNumber); // calls the isValidCreditCard method

        if (isValid == true) {
            System.out.println("This seems to be a valid credit card number");
        } else {
            System.out.println("This is **not** a valid credit card number.");
        }

        stringScanner.close();
    }

    public static boolean isValidCreditCard(String cardNumber) {

        int[] numArray = new int[cardNumber.length()]; // creates int[] with the length of the card number entered
        int x = 0; //initializes the counter
        // values will get stored in an array
        //if the remainder of the counter/2 is 0, the card number digit should be multiplied by two
        for (x = 0; x < cardNumber.length(); x++) {
            if (x % 2 == 0) {
                numArray[x] = Integer.parseInt(String.valueOf(cardNumber.charAt(x))) * 2;
                // if the multiplied number is a two digit number, 1 should be added to the remainder of the multiplied number/10
                if (numArray[x] > 9)
                    numArray[x] = 1 + numArray[x] % 10;
                // numbers that are not to be doubled will simply get added to the array
            } else
                numArray[x] = Integer.parseInt(String.valueOf(cardNumber.charAt(x)));
        }
        //initialized the sum counter
        int sum = 0;
        //sums the values in the array
        int y = 0;
        for (y = 0; y < numArray.length; y++) {
            sum += numArray[y];


        }

        if (numArray.length != 16) { //checks to see if there are 16 digits in the array
            return false;

        } else if (numArray[0] != 8) { // checks to see if the first digit starts with a 4
            return false;

        } else if (sum % 10 != 0) { // checks to see if sum has a 0 remainder
            return false;

        } else { // if there are 16 digits in the array, the first digit starts with 4 and the sum of the digits in the array is 0, the card is valid
            return true;
        }
    }

}