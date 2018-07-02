/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical3a;

import java.util.Scanner;

/**
 *
 * @author taruc
 */
public class Practical3A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scn = new Scanner(System.in);
        String word;
        
        do {
            System.out.print("Your expression (press enter to exit) : ");
            word = scn.nextLine();
            if (word.length() > 0) {
                String result = (isPalindromeQuick(word)) ? "Is Palindrome" : "Not Palindrome";
                System.out.println(result);
            }
        } while (word.length() != 0);
    }
    
    public static boolean isPalindromeQuick(String word) {
        return word.replace(" ","").trim().equals(new StringBuilder(word.replace(" ","").trim()).reverse().toString());
    }
    
    public static boolean isPalindrome(String word) {
        StackInterface<Character> s = new ArrayStack<>();
        QueueInterface<Character> q = new ArrayQueue<>();
        
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if(Character.isLetter(c)) {
                s.push(c);
                q.enqueue(c);
            }
        }
        
        int numItems = s.size();
        boolean result = false;
        for(int j = 0; j < numItems; j++) {
            Character c = s.pop();
            Character cx = q.dequeue();
            if(c.equals(cx) && cx.equals(c)) {
                result = true;
            }
        }
        
        return result;
    }
    
}
