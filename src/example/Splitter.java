package example;

import java.util.Scanner;

public class Splitter {

    public static void main(String[] args){
        System.out.println("Enter a sentence specified by spaces only: ");

        Scanner s = new Scanner(System.in);
        
        while (s.hasNext()) System.out.println(s.next());
        
        
        s.close();
        
    }
}
