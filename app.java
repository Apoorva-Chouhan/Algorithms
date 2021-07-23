import java.util.*;
import java.lang.*;
import java.io.*;

/* IMPORTANT: class-name must be equal to file-name, here file-name is 'app.java', hence class-name is 'class app' */

class app
{
    public static void main (String[] args) throws java.lang.Exception
    {
      File input = new File("./input.txt");  // declare input
        Scanner scanner1 = new Scanner(input);  // declare scanner

      String word1 = scanner1.next();         // scan first-word
      String word2 = scanner1.next();         // scan second-word

      String word3 = word1 + " " + word2;
      // String line1 = sc1.nextLine();      // in-case if you want to scan complete line

      System.out.print(word3);         // output "<word1> <word2>"
      scanner1.close();
    }
}