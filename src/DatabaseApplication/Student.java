package DatabaseApplication;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = "";
    private int tuitionBalance;
    private static int courseCost = 600;
    private static int id = 1000;

    // Constructor that prompts user to enter student's name and year
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.println("\n1. Freshman\n2. Sophomore\n3. Junior\n4. Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();

        setStudentID();
    }


    // Generate an ID
    private void setStudentID(){
        // Grade level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    // Enroll in courses
    public void enroll(){
        boolean t = true;
        // Run a loop until user hits Q
        do {
            System.out.println("\nEnter course to enroll (Q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.next();
            if(!course.equals("Q")){
                this.courses = courses + "\n" + course;
                this.tuitionBalance = tuitionBalance + courseCost;
            }
            else{
                break;
            }
        } while (t);
    }

    // View balance
    public void viewBalance(){
        System.out.println("\nYour tuition balance is: $" + tuitionBalance);
    }

    // Pay tuition
    public void payTuition(){
        boolean t = true;
        viewBalance();
        int payment;

        while (t){
            System.out.println("\nEnter payment amount = ");
            Scanner in = new Scanner(System.in);
            payment = in.nextInt();

            if ((payment > 0) & (payment <= tuitionBalance)){
                t = false;
                tuitionBalance = tuitionBalance - payment;
                System.out.println("Thank you for your payment of $" + payment);
            }
            else if (payment < 0){
                System.out.println("Please enter amount greater than $0. ");
            }
            else {
                System.out.println("Payment amount cannot exceed tuition balance. ");
            }
        }

        viewBalance();
    }

    // Show status
    public String showInfo(){
        return "\nName: " + firstName + " " + lastName +
                "\nGrade level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nCourses enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
