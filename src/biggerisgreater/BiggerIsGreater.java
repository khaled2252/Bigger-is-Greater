/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biggerisgreater;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Khaled
 */
public class BiggerIsGreater {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        char[] string = scanner.next().toCharArray();

        int n = string.length - 1;
        int i;
        int minimumCharIndex = -1;

        for (i = n - 1; i >= 0; i--) { //decrements from 2nd last element to the first element
            for (int j = n; j > i; j--) { //decrements from the last element to i
                if (string[j] > string[i]) {
                    if (minimumCharIndex==-1) { //first minimum char
                        minimumCharIndex = j;
                    } else { //compares each new character with the minumum
                        if (string[minimumCharIndex] >= string[j]) {
                            minimumCharIndex = j;
                        }
                    }
                }
            }
            if (minimumCharIndex > -1) {//Swaps if found at least one character greater than i
                char temp = string[minimumCharIndex];
                string[minimumCharIndex] = string[i];
                string[i] = temp;
                break;
            }
        }
        if (minimumCharIndex == -1) {
            System.out.println("No answer");
        } else {//Sort rest of the array after swapping 
            Arrays.sort(string, i + 1, string.length);
            System.out.println(string);

        }
    }
}
