
/*1.List all the repeated strings in the whole array of strings (containing 5 strings)

*/
import java.io.*;

public class Program1 {
    public static void main(String[] args) throws IOException {
        int count;

        String string = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n");

        System.out.print("ENTER YOUR STRING: ");

        string = br.readLine();
        // Converts the string into lowercase
        string = string.toLowerCase();

        // Split the string into words using built-in function
        String words[] = string.split(" ");

        System.out.println("Duplicate words in a given string : ");
        for (int i = 0; i < words.length; i++) {
            count = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                    // Set words[j] to 0 to avoid printing visited word
                    words[j] = "0";
                }
            }

            // Displays the duplicate word if count is greater than 1
            if (count > 1 && words[i] != "0")
                System.out.println(words[i]);
        }

    }
}
