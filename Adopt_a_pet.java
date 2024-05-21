import utility.*;
import objects.*;
import java.util.Scanner;

public class Adopt_a_pet {
   private static Scanner input = new Scanner(System.in);
   private static Ink ink = new Ink();
   private static User user;
   private static Shelter shelter = new Shelter();
   private static Pet pet;
   private static Form form = new Form(null, 0, null);
   //private static Form fillFormUser = new Form(null, 0, null); in case createuser is not there

   private static int choice;
   private static boolean isDone = false;
   private static boolean goBack = false;

   public static void main(String[] args) {
    // form.fillForm(); //method call to fill out form in case create user is not there
    createUser(); // create the user
    createPets(); // helper pets
    ink.printWelcome(); //print welcome message

    while(!isDone) {
      choice = ink.validateMainMenu();
      
      switch (choice) {
        case 1: // print available pets
          ink.printAvailablePets(shelter.getPets());
          while(!goBack) {
            int pick = input.nextInt();
            if(pick != 0) {
              ink.printPetDetails(shelter.getPet(pick - 1));
              String answer = input.next();
              if(answer.equalsIgnoreCase("Y")) {
                shelter.adopt(pick - 1, user.getName());
                goBack = !goBack;
              }
              else {
                goBack = !goBack;
              }
            }
            else {
              goBack = !goBack;
            }
          } // while
          break;
        case 2: // print shelter details
          ink.printShelterDetails(shelter);
            while(!goBack) {
              input.nextLine();
              goBack = !goBack;
            } // while
          break;
        case 3: // book an appointment menu
          while(!goBack) {  
            String appointment = user.bookAnAppointment(); 
            user.setAppointment(appointment);
              goBack = !goBack;
            } //while
          break;
        case 4:
          user.saveAppointmentToFile(); //Save appointment 
          goBack = !goBack;
          break;
        case 5: // Display appointment
        user.loadAppointmentFromFile();
        System.out.println("Your appointment:");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone: " + user.getPhone());
        System.out.println("Appointment: " + user.getAppointment());
        goBack = !goBack;
        break;
      } // switch
      goBack = false; // seems wrong but it is NOT wrong
    } // while(main)
    ink.printGoodday();
  } // main()

  // 100% for test data!
  public static void createPets() {
    pet = new Pet("spot", "dog",
      3, "black", "hound");
    shelter.addPet(pet);
    pet = new Pet("cleveland", "dog",
      7, "brown", "boxer");
    shelter.addPet(pet);
    pet = new Pet("monster", "cat",
      1, "calico", "calico");
    shelter.addPet(pet);
  } // createPets()

  public static void createUser() {
    String name, email;
    int phone;
    System.out.println(Ink.ANSI_RED + "What is your name? " + Ink.ANSI_RESET);
    name = input.nextLine();
    System.out.println(Ink.ANSI_RED + "What is your email? " + Ink.ANSI_RESET);
    email = input.nextLine();
    System.out.println(Ink.ANSI_RED + "What is your phone? " + Ink.ANSI_RESET);
    phone = input.nextInt();
    System.out.println("");
    user = new User(name, email, phone);
  } // createUser()

  // printForm method
  public static void printForm() {
    System.out.println(Ink.ANSI_BG_CYAN + Ink.ANSI_BG_RED + " *** See your details below in the form *** " + Ink.ANSI_RESET);
    System.out.println("Name: " + form.getName() + "Phone #: " + form.getPhoneNumber() + "Address is: " + form.getAddress());
  }
} // class