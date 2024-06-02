import java.util.Arrays;
import java.util.Scanner;

public class Student implements Comparable<Student> {
    //Declare variables
    private int studentID;
    private String studentName;
    private float testScore;
    private boolean passingStatus;

    //Constructor created to initialise attributes for Student
    public Student (int studentID, String studentName, float testScore){
        this.studentID = studentID;
        this.studentName = studentName;
        this.testScore = testScore;
        this.determinePassStatus();
    }

    //Setter functions
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public void setTestScore(float testScore) {
        this.testScore = testScore;
        this.determinePassStatus();
    }

    //Getter functions
    public int getStudentID() {
        return studentID;
    }
    public String getStudentName() {
        return studentName;
    }
    public float getTestScore() {
        return testScore;
    }

    //Method used to determine the pass status based on a test score
    private void determinePassStatus() {
        this.passingStatus = this.testScore >= 50.0f;
    }

    //Method to display student details
    public void displayStudentDetails(){
        System.out.println("Student ID: " + studentID);
        System.out.println("Student Name: " + studentName);
        System.out.println("Test Score: " + testScore);
        System.out.println("Passing Status:" + passingStatus);
        System.out.println("------------------------");
    }

    //Method for sorting by test score using Comparable
    @Override
    public int compareTo(Student other){
        return Float.compare(other.testScore, this.testScore);
    }

    public static void main(String[] args){
        //Initialise scanner for user input
        Scanner in = new Scanner(System.in);

        //Get number of students
        System.out.println("Enter the number of students: ");
        int numStudents = in.nextInt();

        //Create object array of student
        Student[] students = new Student[numStudents];

        //Input student details
        for (int i = 0; i < students.length; i++){
            System.out.println("Enter details for student " + (i+1) + ":");
            System.out.println("Student ID: ");
            int id = in.nextInt();
            System.out.println("Student Name: ");
            String name = in.next();
            System.out.println("Test Score: ");
            float score = in.nextFloat();

            //Store student details in array
            students[i] = new Student(id, name, score);
        }

        //Using Arrays class to sort students on their test scores
        Arrays.sort(students);

        //Display student information using foreach loop
        for (Student student : students){
            student.displayStudentDetails();
        }
    }
}
