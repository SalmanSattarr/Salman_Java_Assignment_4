package utility;
import objects.Shelter;
import java.util.Scanner;
import java.util.ArrayList;

import objects.Pet;

public class Ink {
  private Scanner input = new Scanner(System.in);
  private int choice;
  
  public void printWelcome() {
    System.out.println(ANSI_BLUE + " -*^*- WELLCOME TO THE PET ADOPTION APP -*^*-" + ANSI_RESET);
    System.out.println(" ");
  } // printWelcome()

  public void printGoodday() {
    System.out.println(ANSI_YELLOW + "Have a great day pet lover. GoodBye!!\n" + ANSI_RESET);
  } // printGoodday()

  public int validateMainMenu() {
    boolean valid = false;

    while(!valid) {
      System.out.println(ANSI_BG_CYAN + ANSI_RED + "##### MAIN MENU #####" + ANSI_RESET);
      System.out.println(ANSI_RED + "(1) View Pets\n(2) Shelter Details\n(3) Book Appointment\n(4) Save Appointment\n(5) Display Saved Appointment\n(6) Exit" + ANSI_RESET);
      try {
        choice = input.nextInt();
        if(choice >= 1 && choice <=6) {
          valid = true; // escapes loop only if choice is correct dt and range
        }
        else {
          System.out.println(ANSI_BG_PURPLE + ANSI_RED + "Please enter a 1 - 4" + ANSI_RESET);
        }
      } 
      catch (Exception e) { // runs on exception
        System.out.println(ANSI_BG_BLACK + ANSI_RED + "That's not a number!" + ANSI_RESET);
      } 
      finally { // always runs!
        input.nextLine();
      }
    } // while
    return choice;
  } // printMenu()

  public void printPetDetails(Pet pet) {
    System.out.printf(ANSI_GREEN + "Name: %s\n" + ANSI_RESET, pet.getName());
    System.out.printf(ANSI_GREEN + "Age: %d\n" + ANSI_RESET, pet.getAge());
    System.out.printf(ANSI_GREEN + "Breed: %s\n" + ANSI_RESET, pet.getBreed());
    System.out.printf(ANSI_GREEN + "Color: %s\n" + ANSI_RESET, pet.getColor());
    System.out.printf(ANSI_GREEN + "Owner: %s\n" + ANSI_RESET, pet.getOwner());
    System.out.printf(ANSI_GREEN + "Is Adopted: %b\n" + ANSI_RESET , pet.getIsAdopted());
    System.out.println(ANSI_GREEN + "Adopt this pet? Y/N" + ANSI_RESET);
  } // printPetDetails()
  
  public void printAvailablePets(ArrayList<Pet> pets) {
    for(int i = 0; i < pets.size(); i++) {
      if(!pets.get(i).getIsAdopted()) {
        System.out.printf(ANSI_RED + "(%d) Name: %s Type: %s Age: %d\n" + ANSI_RED, i + 1,
          pets.get(i).getName(), pets.get(i).getType(), pets.get(i).getAge());
      }
    } // for
    System.out.println(ANSI_BLUE + "Enter 0 to go back" + ANSI_RESET);
  } // printAvailablePets()

  public void printShelterDetails(Shelter shelter) {
    System.out.printf(ANSI_PURPLE + "Shelter Address: %s\n" + ANSI_RESET, shelter.getAddress());
    String[] hours = shelter.getHours();
    for(int i = 0; i < hours.length; i++) {
      System.out.println(ANSI_PURPLE + hours[i] + ANSI_RESET);
    } // for
    System.out.println(ANSI_BLUE + "hit any key to go back" + ANSI_RESET);
  } // printShelterDetails

// color reset
      public static final String ANSI_RESET = "\u001B[0m";
// Text colors
      public static final String ANSI_BLACK = "\u001B[30m";
      public static final String ANSI_RED = "\u001B[31m";
      public static final String ANSI_GREEN = "\u001B[32m";
      public static final String ANSI_YELLOW = "\u001B[33m";
      public static final String ANSI_BLUE = "\u001B[34m";
      public static final String ANSI_PURPLE = "\u001B[35m";
      public static final String ANSI_CYAN = "\u001B[36m";
      public static final String ANSI_WHITE = "\u001B[37m";
// Background colors
      public static final String ANSI_BG_BLACK = "\u001B[40m";
      public static final String ANSI_BG_RED = "\u001B[41m";
      public static final String ANSI_BG_GREEN = "\u001B[42m";
      public static final String ANSI_BG_YELLOW = "\u001B[43m";
      public static final String ANSI_BG_BLUE = "\u001B[44m";
      public static final String ANSI_BG_PURPLE = "\u001B[45m";
      public static final String ANSI_BG_CYAN = "\u001B[46m";
      public static final String ANSI_BG_WHITE = "\u001B[47m";
  
} // class