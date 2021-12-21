/*Create a class called student under the package gcect. Now the student
class contains data members roll, name, dept, sem and project_id. Now
initialize these data members using constructors. Similarly create
another package called project, and under this package create class
faculty such that one faculty should guide projects of multiple students.
The data member for the faculty class will be faculty name, dept,
project_id, project_topic. Provide constructor for initializing these data
members. Now import these two packages in a third package called
survey, such that this package contains the main method and some other
data searching methods under the searching class. Use array of student
objects and faculty objects in each of these searching methods to carry
out the following searching operations.
a. User supplies a student roll number and the particular student details
with project_id will be displayed.
b. User supplies a student roll number and the faculty supervising that
student project will be displayed including the department
information of that faculty.
c. User supplies a particular project topic and all the faculty guiding out
projects on that topic will be displayed.
d. User supplies a faculty name and all the projects guided by that faculty
will be displayed (no student related data, only the faculty class
related data should be displayed).
e. List those students who are carrying out projects under the same
departmental faculty.*/

package survey.survey;

import java.io.*;
import java.util.*;

import survey.gcect.*;
import survey.project.*;

public class survey {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();
        student s[] = new student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter roll number : ");
            int r = sc.nextInt();
            System.out.print("Enter semister number : ");
            int sem = sc.nextInt();
            System.out.print("Enter Project_ID : ");
            int pid = sc.nextInt();
            System.out.print("Enter Name: ");
            String nm = "";
            nm = br.readLine();
            System.out.print("Enter Department Name: ");
            String dp = "";
            dp = br.readLine();
            s[i] = new student(r, sem, pid, nm, dp);

        }

        System.out.println("Enter the number of Faculties : ");
        int tn = sc.nextInt();
        faculty f[] = new faculty[tn];
        for (int i = 0; i < tn; i++) {

            System.out.print("Enter Name: ");
            String nm = "";
            nm = br.readLine();
            System.out.print("Enter Department Name: ");
            String dp = "";
            dp = br.readLine();
            System.out.print("Enter Project Topic: ");
            String pt = "";
            pt = br.readLine();
            System.out.print("Enter Project_ID : ");
            int pid = sc.nextInt();
            f[i] = new faculty(nm, dp, pt, pid);

        }

        // a. User supplies a student roll number and the particular student details
        // with project_id will be displayed.
        System.out.print("Enter roll number : ");
        int roll = sc.nextInt();
        student s1 = new student();
        s1.show_details(s, roll);

        // b. User supplies a student roll number and the faculty supervising that
        // student project will be displayed including the department
        // information of that faculty.
        faculty f1 = new faculty();
        int project_id = s1.display_project_id(s, roll);
        f1.show_faculty(f, project_id);

        // c. User supplies a particular project topic and all the faculty guiding out
        // projects on that topic will be displayed.
        System.out.print("Enter Project Topic: ");
        String projectName = "";
        projectName = br.readLine();
        f1.show_faculty_name(f, projectName);

        // d. User supplies a faculty name and all the projects guided by that faculty
        // will be displayed (no student related data, only the faculty class
        // related data should be displayed).
        System.out.print("Enter Faculty Name: ");
        String facultyName = "";
        facultyName = br.readLine();
        f1.show_project_name(f, facultyName);

        // e. List those students who are carrying out projects under the same
        // departmental faculty.
        int pid = f1.show_projectid(f, facultyName);
        s1.show_students(s, pid);
        sc.close();
    }

}
