
/*Create an employee class with data member like emp_id, name, designation, year_of_join, year_of_birth,
basic_salary. This class contains a pension compute method with prototype int penson_compute() such that
it should compute the pension of the particular employee object (those who are retiring in 2020) that has
invoked the method. The criteria for pension computation is mentioned below.

To be eligible for the pension,

The employee must have completed at least 10 years of service (including the retiring year)

Must have attended 60 years of age in 2020.

If any one of these conditions i.e either a or b fails then the employee is not eligible for pension and the
particular cause of such failure will be notified through proper user defined exception object. Hence two
user defined exception classes should be created for handling a and b condition and they will be thrown
under proper circumstances. Note that for computing the year of experience/service and age, the
year_of_join and year_of_birth should be subtracted from 2020. For other valid cases the criteria for
pension computation will be-

For designation= ‘faculty’,

Pension=basic_salary+20000*(2020-Year_of_experince)+10000(2020-Year_of_birth)

For designation= ‘Technical_Asst’,

Pension=basic_salary+10000*(2020-Year_of_experince)+5000(2020-Year_of_birth)

For designation= ‘Staff’,

Pension=basic_salary+5000*(2020-Year_of_experince)+2000(2020-Year_of_birth)

Now based on these information carry out the following operations

User supplies emp_id, such that the pension of that employee will be
displayed.

User supplies the designation, such that the pension of all the employees with
that designation will be displayed.

User supplies a particular pension amount and the designation, such that all
the employee with that designation receiving pension above that amount will
be displayed.

User supplies a particular age value, such that the pension amount of all those
employees who have crossed that age will be displayed.

User supplies number of years in service i.e experience, such that the pension
amount of all those employees who have given minimum service of that many
number of years will be displayed .
*/
import java.io.*;
import java.util.*;

class PensionException extends Exception {
    public PensionException(String s) {
        // Call constructor of parent Exception
        super(s);
    }
}

class employee {
    int emp_id;
    String name;
    String designation;
    int year_of_join;
    int year_of_birth;
    int basic_salary;

    employee() {
        emp_id = 0;
        name = "";
        designation = "";
        year_of_join = 0;
        year_of_birth = 0;
        basic_salary = 0;
    }

    employee(int id, String nm, String dg, int j, int b, int bs) {
        emp_id = id;
        name = nm;
        designation = dg;
        year_of_join = j;
        year_of_birth = b;
        basic_salary = bs;
    }

    int compute_pension() {
        int pension = 0;
        int year_of_experince = 2020 - year_of_join;
        int age = 2020 - year_of_birth;
        if (year_of_experince >= 10 && age >= 60) {
            if (designation.equals("faculty")) {
                pension = basic_salary + 20000 * year_of_experince + 10000 * age;
            } else if (designation.equals("Technical_Asst")) {
                pension = basic_salary + 10000 * year_of_experince + 5000 * age;
            } else {
                pension = basic_salary + 5000 * year_of_experince + 2000 * age;
            }
        }
        return pension;
    }

    void pensionById(int id, employee e[]) {
        for (int i = 0; i < e.length; i++) {
            if (id == e[i].emp_id) {
                System.out.println(e[i].compute_pension());
            }
        }

    }

    void pensionByDesignation(String designation, employee e[]) {
        for (int i = 0; i < e.length; i++) {
            if (designation.equals(e[i].designation)) {
                System.out.println(e[i].compute_pension());
            }
        }
    }

    void morePensionByDesignation(String designation, employee e[], int pension) {
        for (int i = 0; i < e.length; i++) {
            if (designation.equals(e[i].designation)) {
                if (pension < e[i].compute_pension()) {
                    System.out.println(e[i].name);
                }
            }
        }
    }

    void pensionByAge(int age, employee e[]) {
        for (int i = 0; i < e.length; i++) {
            if (2020 - e[i].year_of_birth > age) {
                System.out.println(e[i].compute_pension());
            }
        }
    }

    void pensionByExperience(int experience, employee e[]) {
        for (int i = 0; i < e.length; i++) {
            if (2020 - e[i].year_of_join > experience) {
                System.out.println(e[i].compute_pension());
            }
        }
    }

}

public class Assignment6 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of Employees : ");
        int n = sc.nextInt();
        employee e[] = new employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Employee ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Name: ");
            String nm = "";
            nm = br.readLine();
            System.out.println("Enter Designation: ");
            String dg = "";
            dg = br.readLine();
            System.out.println("Enter Year of Join: ");
            int j = sc.nextInt();
            System.out.println("Enter Year of Birth: ");
            int b = sc.nextInt();
            System.out.println("Enter Basic Salary: ");
            int bs = sc.nextInt();
            e[i] = new employee(id, nm, dg, j, b, bs);
        }

        employee emp = new employee();

        System.out.println("Enter Employee id: ");
        int id = sc.nextInt();
        emp.pensionById(id, e);

        System.out.println("Enter Designation: ");
        String designation = "";
        designation = br.readLine();
        emp.pensionByDesignation(designation, e);

        System.out.println("Enter Designation: ");
        designation = br.readLine();
        System.out.println("Enter Pension: ");
        int pension = sc.nextInt();
        emp.morePensionByDesignation(designation, e, pension);

        System.out.println("Enter Employee Age: ");
        int age = sc.nextInt();
        emp.pensionByAge(age, e);

        System.out.println("Enter Employee Experience: ");
        int experience = sc.nextInt();
        emp.pensionByExperience(experience, e);

        sc.close();
    }
}
