package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class MidtermOutput {
    //COLORS for text retrieved from stackoverflow see code attributions at the end of the code
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static ArrayList<ArrayList<String>> listOfLists = new ArrayList(); //ArrayList that will contain both the name and age ArrayList
    public static ArrayList<String> name = new ArrayList<String>(); //ArrayList for inputting names
    public static ArrayList<String> age = new ArrayList<String>(); //ArrayList for inputting age
    public static Scanner scan = new Scanner(System.in); //Creating Scanner Object
    public static boolean x = true; //Will be used in while loop and for the exit function to exit the program

    //Function to add Entry(name, age) to the ArrayList
    static void addEntry()
    {
        System.out.println("\n=======Add Entry=======");
        System.out.print("Enter Name$ ");
        String nameInput = scan.next();
        System.out.print("Enter Age$ ");
        String ageInput = scan.next();

        name.add(nameInput); //this will add the user input to the name ArrayList with the use of the add method
        age.add(ageInput); //this will add the user input to the age ArrayList with the use of the add method
        System.out.println(ANSI_GREEN + nameInput + "'s name and age were successfully added" + ANSI_RESET); System.out.println("\n");
    }

    //Function to delete(name, age) in the ArrayList where name is given by the user
    static void deleteEntry()
    {
        Boolean foundNum = false;
        System.out.println("\n====================Delete Entry====================");
        System.out.println(ANSI_PURPLE+ "Here are your choices: " + name + ANSI_RESET); //prints the names inside the name ArrayList that can be deleted
        System.out.println("Important: Please mind that this program is case sensitive.");
        System.out.println("            Enter your uppercase and lowercase correctly.");
        System.out.print("\nEnter Name to Delete$ ");
        String nameToDelete = scan.next();

        //Java labeled break statement to search if nameToDelete exists. This code was reused from the snippet which was retrieved from JEDI Course Notes see code attributions at the end of the code
        searchLabel:
        for (String element : name){
            if( element.contains(nameToDelete) ){
                foundNum = true;
            }
        }
        if( foundNum ){
            int nameIndex = 0; //index of name ArrayList in listOfLists. this is not really needed but it's a good implementation.
            int ageIndex = 1; //index of age ArrayList in listOfLists. this is also not really needed but it's a good implementation.
            //index of name to delete in the 'name array list' to be cross-referenced to the age index
            int index = name.indexOf(nameToDelete);
            String ageToDelete = listOfLists.get(ageIndex).get(index);

            //removing the name and age from listOfLists ArrayList using the remove method
            listOfLists.get(nameIndex).remove(nameToDelete); //this can also be listOfLists.get(0).remove(nameToDelete);
            listOfLists.get(ageIndex).remove(ageToDelete); //listOfLists.get(1).remove(ageToDelete)
            System.out.println(ANSI_GREEN + nameToDelete + "'s name and age were successfully deleted" + ANSI_RESET); System.out.println("\n");
        }
        else{
            System.out.println( "No " + nameToDelete + " in the list\n" ); //prints out not found if nameToDelete is not found in the ArrayList

        }
    }

    //Function to view all elements(name and age) in the ArrayList
    static void viewEntry(){
        System.out.println("\n=======View all Entries======");
        for( int i=0; i<listOfLists.size()-1; i++ ){
            for( int j=0; j<name.size(); j++ ){
                System.out.println(listOfLists.get(i).get(j) + " is " + listOfLists.get(i+1).get(j));
                //view name                          //view age
            }
        }
        System.out.println("\n=============================");
        System.out.println("\n");
    }

    //Function to update update(name, age) in the ArrayList where the new updatedName and age is defined by the user
    static void updateEntry()
    {
        Boolean foundNum = false;
        System.out.println("\n====================Update an Entry====================");
        System.out.println(ANSI_PURPLE + "Here are your choices: " + name + ANSI_RESET);
        System.out.println("Important: Please mind that this program is case sensitive.");
        System.out.println("            Enter your uppercase and lowercase correctly.");
        System.out.print("\nEnter Name to Update ");
        System.out.print("$ ");
        String nameToUpdate = scan.next();

        System.out.print("\nEnter New Name$ ");
        String updatedName = scan.next();
        System.out.print("Enter New Age$ ");
        String updatedAge = scan.next();


        //Java labeled break statement to search if the name exists
        searchLabel:
        for (String element : name){
            if( name.contains(nameToUpdate) ){
                foundNum = true;
                break searchLabel;
            }
        }
        if( foundNum ){

            //index of name in the 'name ArrayList' to be cross-referenced to the age index for it to have the same value
            int index = name.indexOf(nameToUpdate);

            name.set(index, updatedName); //updates or replaces the value of name in the name ArrayList
            age.set(index, updatedAge); //updates or replaces the value of age in the age ArrayList
            System.out.println(ANSI_GREEN + updatedName + "'s name and age were successfully updated" + ANSI_RESET); System.out.println("\n");
        }
        else{
            System.out.println( "No " + nameToUpdate + " in the list" ); //prints out not found if nameToUpdate is not found in the ArrayList

        }
    }

    //Function to exit out of the program
    static void exit()
    {
        x = false;
    }

    public static void main(String[] args) {
        //Pre-defined values for ArrayList
        name.add("Chewbacca");
        age.add("235");
        name.add("Yoda");
        age.add("900");
        name.add("C-3PO");
        age.add("67");
        listOfLists.add(name); //adds ArrayList named 'name' to listOfLists ArrayList
        listOfLists.add(age); //adds ArrayList named 'age' to listOfLists ArrayList

        //Main program
        while(x){
            System.out.println(ANSI_YELLOW + "***************************************");
            System.out.println("*      Midterms Output in CIT207      *");
            System.out.println("*  Written by Natalie Jane Pacificar  *");
            System.out.println("***************************************" + ANSI_RESET);
            System.out.println("\n=======Options========");
            System.out.println("1. Add Entry" +
                    "\n2. Delete Entry" +
                    "\n3. View All Elements" +
                    "\n4. Update an Entry" +
                    "\n0. Exit");

            System.out.println("\nSelect an Option");
            System.out.print("$ ");
            int action = scan.nextInt();

            switch (action){
                case 0:
                    exit();
                    break;
                case 1:
                    addEntry();
                    break;
                case 2:
                    deleteEntry();
                    break;
                case 3:
                    viewEntry();
                    break;
                case 4:
                    updateEntry();
                    break;
                default:
                    System.out.println("\n" + "\u001B[31m" + "Please try a valid input. :)");
                    System.out.println("\u001B[0m");
                    break;

            }
        }

    }
}


//Attributions to my code, this program wouldn't be possible without these sources:
//Retrieved making a 2D ArrayList template from here https://www.youtube.com/watch?v=9tBxJoQF74E
//Retrieved ANSI Code for colors from here https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
//Retrieved the snippet of code that searches for a value in a two-dimensional ArrayList from JEDI Course Notes
