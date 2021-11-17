/*3. List the palindromes in an array of strings*/

import java.io.*;

public class Program3 {
    static boolean checkPalin(String word) {
        int n = word.length();
        word = word.toLowerCase();
        for (int i = 0; i < n; i++, n--)
            if (word.charAt(i) != word.charAt(n - 1))
                return false;
        return true;
    }

    // Function to count palindrome words
    static void Palin(String str) {
        // to check last word for palindrome
        str = str + " ";

        // to store each word
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // extracting each word
            if (ch != ' ')
                word = word + ch;
            else {
                if (checkPalin(word)) {
                    System.out.print(word);
                    System.out.println();
                }

                word = "";
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String pdstring = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n");

        System.out.print("ENTER YOUR STRING: ");

        pdstring = br.readLine();

        Palin(pdstring);

    }
}
