/*4. Take the input like GCECT-B-CSE-R21-1001 as string

And print the following details

College name- GCECT

Course – B.Tech (B- B.Tech / M- M.Tech)

Stream- CSE/IT/CT

R- Regular/Lateral

Year of Reg- 21

Roll No. - 1001*/

import java.io.*;

public class Program4 {
    public static void main(String[] args) throws IOException {
        String dstring = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n");

        System.out.print("ENTER YOUR STRING LIKE GCECT-B-CSE-R21-1001: ");

        dstring = br.readLine();
        String result[] = dstring.split("-");

        System.out.println("College name - " + result[0]);
        String course = "";
        if (result[1].charAt(0) == 'B')
            course = "B.Tech";
        else if (result[1].charAt(0) == 'M')
            course = "M.Tech";
        System.out.println("Course - " + course);
        System.out.println("Stream - " + result[2]);
        String type = "";

        if (result[3].charAt(0) == 'R')
            type = "Regular";
        else if (result[3].charAt(0) == 'L')
            type = "Lateral";
        System.out.println(type);
        String year = "";
        for (int i = 1; i < result[3].length(); i++) {
            year += result[3].charAt(i);
        }
        System.out.println("Year of Reg - " + year);
        System.out.println("Roll No. - " + result[4]);
    }
}
