package utility;
import java.util.Scanner;

public class Form {
    private String name;
    private int phoneNumber;
    private String address;
    private Scanner input = new Scanner(System.in);

// Constructors **************************************

public Form(String name, int phoneNumber, String address) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.address = address;
}

// Getters ********************************************

public String getName(){
    return name;
}

public int getPhoneNumber(){
    return phoneNumber;
}

public String getAddress(){
    return address;
}

// Setters ********************************************

public void setName(String name) {
    this.name = name;
}

public void setphoneNumber(int phoneNumber) {
    this.phoneNumber = phoneNumber;
}

public void setAddress(String address) {
    this.address = address;
}

// Methods **********************************************

public void fillForm() {
    System.out.println(Ink.ANSI_YELLOW + "Enter your name please: " + Ink.ANSI_RESET);
    name = input.nextLine();
    System.out.println(Ink.ANSI_YELLOW + "Enter your address please: " + Ink.ANSI_RESET);
    address = input.nextLine();
    System.out.println(Ink.ANSI_YELLOW + "Enter your phone number please " + Ink.ANSI_RESET);
    phoneNumber = input.nextInt();
    }

} //class
