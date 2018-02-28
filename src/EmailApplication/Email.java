package EmailApplication;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailCapacity = 100;
    private int defaultPasswordLen = 10;
    private String altEmail;
    private String company = "anycompany.com";

    // Constructors to get first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        // Calling method to find out department that returns it
        this.department = setDepartment();

        // Calling method that returns random password
        this.password = randomPassword(defaultPasswordLen);

        // Combine variables and generating email
        if(department != ""){
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + company;
        }
        else{
            email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + company;
        }

        System.out.println("Your password is: " + this.password);
    }

    // Request Department
    private String setDepartment(){
        System.out.println("New hire: " + firstName + " " + lastName);
        System.out.println("\nDepartments: \n1. for Sales\n2. for Development\n3. for Accounting\n0. for none" );
        System.out.println("\nEnter department code:");

        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();

        if(deptChoice == 1){
            return "Sales";
        }
        else if(deptChoice == 2){
            return "Dev";
        }
        else if(deptChoice == 3){
            return "Acct";
        }
        else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$";
        char[] password = new char[length];

        for (int i =0; i<length; i++){
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }

        return new String(password);
    }

    // Set the mail box capacity
    public void setMailCapacity(int capacity){
        this.mailCapacity = capacity;
    }

    // Set alternate email
    public void setAltEmail(String altEmail){
        this.altEmail = altEmail;
    }

    // Change password
    public void changePassword(String password){
        this.password = password;
    }

    // Getter for mail capacity
    public int getMailCapacit(){
        return mailCapacity;
    }

    // Getter for alternate email
    public String getAltEmail(){
        return altEmail;
    }

    // Getter for password
    public String getPassword(){
        return password;
    }

    // Shows all information of object
    public String showInfo() {
        return "Display name: " + firstName + " " + lastName + " " +
                "\nComapany Email: " + email +
                "\nMail box capacity: " + mailCapacity + " MB" +
                "\nAlternate Email: " + altEmail;
    }
}
