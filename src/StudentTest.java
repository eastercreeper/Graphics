public class StudentTest {
    public static void main(String[] args) {
        Student jim = new Student();
        jim.addGrades();
        jim.roundUpgrades();
        jim.removeLowestGrade();
        jim.displayGrades();
        System.out.println(jim.getAverageGrade());

    }
}
