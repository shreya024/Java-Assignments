/*2.Take command line arguments like

Govt. College of Engineering And Ceramic Technology / Kalyani Govt. Engg. College

And print the abrreviation GCECT / KGEC*/

import java.io.*;

public class Program2 {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < args.length; i++) {

            if (!args[i].contains("And")) {
                char c = args[i].charAt(0);
                if (Character.isUpperCase(c))
                    System.out.print(c);
            }

        }

    }
}
