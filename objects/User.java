package objects;
import java.util.Scanner;
import utility.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class User {
  private String name;
  private String email;
  private int phone;
  private String appointment;
  private Scanner input = new Scanner(System.in);

  public User(String name, String email, int phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  } // constructor

  public User(String appointment) {
    this.appointment = appointment;
  } // constructor

  //===============>>
  // GETTERS
  public String getName() {
    return this.name;
  }
  public String getEmail() {
    return this.email;
  }
  public int getPhone() {
    return this.phone;
  }
  public String getAppointment() {
    return appointment;
  }

  //===============>>
  // SETTERS
  public void setName(String name) {
    this.name = name;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setPhone(int phone) {
    this.phone = phone;
  }
  public void setAppointment(String bookAnAppointment) {
    this.appointment = bookAnAppointment;
  }
  public String bookAnAppointment() {
    System.out.println(Ink.ANSI_CYAN + "Please select a time slot below... \n" + Ink.ANSI_RESET);
    System.out.println(Ink.ANSI_CYAN + "1. Mon: 8am - 4pm" + Ink.ANSI_RESET);
    System.out.println(Ink.ANSI_CYAN + "2. Tues: 8am - 4pm" + Ink.ANSI_RESET);
    System.out.println(Ink.ANSI_CYAN + "3. Wed: 8am - 4pm" + Ink.ANSI_RESET);
    System.out.println(Ink.ANSI_CYAN + "4. Thurs: 8am - 4pm" + Ink.ANSI_RESET);
    System.out.println(Ink.ANSI_CYAN + "5. Fri: 8am - 4pm" + Ink.ANSI_RESET);
    System.out.println(Ink.ANSI_CYAN + "Press 0 to go back...\n" + Ink.ANSI_RESET);
    System.out.println(Ink.ANSI_BG_BLACK + Ink.ANSI_RED + "Closed on weekends... " + Ink.ANSI_RESET); 
  
    int number = input.nextInt(); // takes an input to go thru the cases
    String appointment = "";

    switch (number) {
      case 1: System.out.println(Ink.ANSI_CYAN + " --- Appointment for Mon between 8am - 4pm has been set. --- \n" + Ink.ANSI_RESET); 
        appointment = "Monday: 8am - 4pm";
        break;
      case 2: System.out.println(Ink.ANSI_CYAN + " --- Appointment for Tues between 8am - 4pm has been set. --- \n" + Ink.ANSI_RESET);
        appointment = "Tuesday: 8am - 4pm";
        break;
      case 3: System.out.println(Ink.ANSI_CYAN + " --- Appointment for Wed between 8am - 4pm has been set.--- \n" + Ink.ANSI_RESET);
        appointment = "Wednesday: 8am - 4pm";
        break;
      case 4: System.out.println(Ink.ANSI_CYAN + " --- Appointment for Thurs between 8am - 4pm has been set. --- \n" + Ink.ANSI_RESET);
        appointment =  "Thursday: 8am - 4pm";
        break;
      case 5: System.out.println(Ink.ANSI_CYAN + " --- Appointment for Fri between 8am - 4pm has been set. --- \n" + Ink.ANSI_RESET);
        appointment = "Friday: 8am - 4pm";
        break;
      default: System.out.println(Ink.ANSI_CYAN + " --- Appointments can only be setup during business hours mon - fri ---" + Ink.ANSI_RESET);
        appointment = "Monday: 8am - 4pm";
        break;
      }
      return appointment;
    } // bookAnAppointment

    // Save appointment details to a file
  public void saveAppointmentToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("appointment.txt"))) {
      writer.write(Ink.ANSI_YELLOW + "Name: " + Ink.ANSI_RESET + name + "\n");
      writer.write(Ink.ANSI_YELLOW + "Email: " + Ink.ANSI_RESET + email + "\n");
      writer.write(Ink.ANSI_YELLOW + "Phone: " + Ink.ANSI_RESET + phone + "\n");
      writer.write("Appointment: " + appointment + "\n");
      System.out.println(Ink.ANSI_YELLOW + "Appointment saved successfully." + Ink.ANSI_RESET);
    } catch (IOException e) {
      System.out.println("An error occurred while saving the appointment.");
      e.printStackTrace();
    }
  } // saveAppointmentToFile

  // Load appointment details from a file
  public void loadAppointmentFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader("appointment.txt"))) {
        name = reader.readLine().split(": ")[1];
        email = reader.readLine().split(": ")[1];
        String phoneString = reader.readLine().split(": ")[1]; // Read phone number as a string
        phone = Integer.parseInt(phoneString); // Parse the string into an integer
        appointment = reader.readLine().split(": ")[1];
        System.out.println("Appointment loaded successfully.\n");
    } catch (IOException e) {
        System.out.println("An error occurred while loading the appointment.");
        e.printStackTrace();
    } catch (NumberFormatException e) {
        System.out.println("Invalid phone number format in the file.");
        e.printStackTrace();
    }
}
// loadAppointmentFromFile
}// class