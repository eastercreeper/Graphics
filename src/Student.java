import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    ArrayList<Integer> grades;

    public Student() {
        grades = new ArrayList<Integer>();
    }
    public void displayGrades() {
        for (Integer grade : grades) {
            System.out.println(grade);
        }
     }
    public void addGrades() {

        Scanner addgradess = new Scanner(System.in);
        boolean Continue = true;
        while(Continue) {
            System.out.println("Enter a grade -1 to stop");
            int grade = Integer.parseInt(addgradess.nextLine());
            if(grade == -1) {
                Continue = false;
            } else {

                grades.add(grade);
            }
        }
    }

    public double getAverageGrade() {
        double average = 0;
        int funny =0;
        for (Integer grade : grades) {
            average += grade;
            funny++;
        }
        return average/funny;
    }

    public void roundUpgrades() {
        for(int i = 0; i < grades.size(); i++) {
            if(grades.get(i) == 69 || grades.get(i) == 79 ||grades.get(i) == 89) {
                grades.set(i, grades.get(i) +1);
            }
        }
    }
    public void removeLowestGrade() {
        int lowest = 0;
        for(int i = 0; i < grades.size(); i++) {
            if(grades.get(lowest) > grades.get(i)) {
                lowest = i;
            }
        }
        grades.remove(lowest);
    }
}
