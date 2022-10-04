package DataStructures.Compare;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * You are given a list of student information: ID, FirstName, and CGPA. Your
 * task is to rearrange them according to their CGPA in decreasing order. If two
 * student have the same CGPA, then arrange them according to their first name
 * in alphabetical order. If those two students also have the same first name,
 * then order them according to their ID. No two students have the same ID.
 * 
 * Hint: You can use comparators to sort a list of objects. See the oracle docs
 * to learn about comparators.
 * 
 * Input Format
 * 
 * The first line of input contains an integer , representing the total number
 * of students. The next lines contains a list of student information in the
 * following structure:
 * 
 * ID Name CGPA
 * Constraints
 * 
 * 2 <= N <= 1000
 * 0 <= ID <= 100000
 * 5 <= |Name| <= 30
 * 0 <= CGPA <= 4.00
 * 
 * The name contains only lowercase English letters. The contains only integer
 * numbers without leading zeros. The CGPA will contain, at most, 2 digits after
 * the decimal point.
 * 
 * Output Format
 * 
 * After rearranging the students according to the above rules, print the first
 * name of each student on a separate line.
 * 
 * Sample Input
 * 
 * 5
 * 33 Rumpa 3.68
 * 85 Ashis 3.85
 * 56 Samiha 3.75
 * 19 Samara 3.75
 * 22 Fahim 3.76
 * Sample Output
 * 
 * Ashis
 * Fahim
 * Samara
 * Samiha
 * Rumpa
 */

public class SortStudents {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = Double.valueOf(in.next());

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        in.close();

        Collections.sort(studentList);

        try (PrintWriter pwr = new PrintWriter("./Compare/results.txt")) {
            for (Student st : studentList) {
                System.out.println(st.getFname());
                pwr.println(st.getFname());
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        File fa = new File("./Compare/answers.txt");
        Scanner sc = new Scanner(fa);
        List<String> results = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        while (sc.hasNext()) {
            results.add(sc.nextLine());
        }
        File fr = new File("./Compare/results.txt");
        sc = new Scanner(fr);
        while (sc.hasNext()) {
            answers.add(sc.nextLine());
        }
        sc.close();
        System.out.println("///////////////////");
        System.out.println(Objects.equals(results, answers));

        int i = 0;
        while (true && i <= studentList.size() - 1) {
            if (results.get(i).equals(answers.get(i))) {
                i++;
                continue;
            }
            System.out.println(i);
            System.out.println(results.get(i));
            System.out.println(answers.get(i));
            break;
        }
    }

}

class Student implements Comparable<Student> {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int compareTo1(Student st) {

        String stName = st.getFname();
        int stId = st.getId();
        double stCgpa = st.getCgpa();

        // cgpa, name, id, decrasing order
        if (cgpa != stCgpa) {
            return cgpa > stCgpa ? -1 : 1;
        } else if (fname.compareTo(stName) != 0) {
            return fname.compareTo(stName) > 0 ? -1 : 1;
        } else if (id != stId) {
            return id > stId ? -1 : 1;
        }
        return 0;
    }

    public int compareTo(Student o) {
        if (this.cgpa != o.cgpa) {
            if (this.cgpa > o.cgpa)
                return -1;
            else
                return 1;
        } else if (this.fname.equals(o.fname)) {
            return Integer.compare(this.id, o.id);
        } else {
            if (this.fname.compareTo(o.fname) < 0)
                return -1;
            else
                return 1;

        }
    }
}
