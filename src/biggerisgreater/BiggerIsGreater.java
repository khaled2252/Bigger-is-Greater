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
        char temp = 0;
        int replacedCharIndex = -1;
        int toBeReplacedCharIndex = -1;
        int minimumCharIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j > i; j--) {
                if (string[j] > string[i]) {
                    if (toBeReplacedCharIndex == -1) {
                        toBeReplacedCharIndex = i;
                        minimumCharIndex = j;

                    } else {
                        if (string[minimumCharIndex] > string[j]) {
                            minimumCharIndex = j;
                        }
                    }

                }
            }
            if (minimumCharIndex > -1) {
                temp = string[minimumCharIndex];
                string[minimumCharIndex] = string[toBeReplacedCharIndex];
                string[toBeReplacedCharIndex] = temp;
                replacedCharIndex = toBeReplacedCharIndex;
                break;
            }
        }
        if (replacedCharIndex == -1) {
            System.out.println("No answer");
        } else {
            Arrays.sort(string, replacedCharIndex + 1, string.length);
            System.out.println(string);

        }

}
