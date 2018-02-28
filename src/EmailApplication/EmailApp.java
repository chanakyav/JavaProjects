package EmailApplication;

public class EmailApp {

    public static void main(String[] args){
        Email email1 = new Email("John", "Smith");
        email1.setAltEmail("john123@newmail.com");
        email1.setMailCapacity(12);
        System.out.println(email1.showInfo());
    }
}
