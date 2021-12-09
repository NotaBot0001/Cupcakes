
/**
* Filename: Cupcakemenu.java
* Written by: Cake Bytes- Java group 4 Fall 2021
* Written on: October 5th
* Menu for Cupcake Bakery
*/
import java.util.Scanner; // Import the scanner object
import java.text.*;


public class CupcakeMenu {

    // Constants for menu choices
    private final static int PREMADE_CUPCAKES = 1;
    private final static int MAKE_PURCHASE = 2;
    private final static int CUSTOM_CUPCAKE = 3;
    private final static int CUPCAKE_BUSINESS = 4;
    private final static int RANDOM_CUPCAKE = 5;
    private final static int QUIT = 6;

    private int choice = 0;
    private int premadeCupcakesInput = 0;    // Which of the four options for premade cupcake combos
    private int premadeCupcakesQuantity = 0; // User will enter individual, half dozen, dozen
    private double costOfPremades = 0.0;     // The bill the customer will receive


    /**********************************************
     * Objects
    *********************************************/

    Scanner inputChoice = new Scanner(System.in); // Create a Scanner object

    // Currency object
    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
    // Cupcake object
    Cupcake cupcake1 = new Cupcake();

    // Create a premade cupcake object
    Cupcake premadeCupcakes = new Cupcake(cupcake1.getPremadeCupcakes(), cupcake1.getPremadeQuantity());

    // CupcakeBusiness object
    CupcakeBusiness cupcakeBusiness0 = new CupcakeBusiness();

    /***************************************************************
     * Display customer ordering menu
     ***************************************************************/
    public void displayMenu() {

        // Display the menu and get a choice from the user
        System.out.println("\n*****\t\t\t  *****");
        System.out.println("\\___/ Cupcake Bakery Menu \\___/");
        System.out.println("1. Premade cupcake menu");
        System.out.println("2. Make purchase");
        System.out.println("3. Build a custom cupcake.");
        System.out.println("4. How's the business doing?");
        System.out.println("5. Random cupcake");
        System.out.println("6. Quit the Program");
        System.out.print("Enter your choice: ");
    }

    /***************************************************************
     * Get choice from Customer
     ***************************************************************/
    public void getChoice() {
        // Get menu choice from user
        choice = inputChoice.nextInt(); // Read user input

        /*********************************************************
         * Menu choices with if decisions to navigate the program
         *********************************************************/
        // If user chooses 1 for premade cupcakes menu, do this:
        if (choice == PREMADE_CUPCAKES) {
            // Show the premade menu for customer
            cupcake1.displayPremadeCupcakes();
            // User will choose 1 - 4 for premade cupcakes, take that input and assign:
            premadeCupcakesInput = inputChoice.nextInt();
            // Send premadeCupcakesInput to Cupcake class for decision structure:
            premadeCupcakes.premadeCupcakesDecision(premadeCupcakesInput);
            // Prompt user for the quantity:
            cupcakeBusiness0.displayPremadePrices();
            premadeCupcakesQuantity = inputChoice.nextInt();                                    // Have user input choice
            costOfPremades = premadeCupcakes.premadeDecisionQuantity(premadeCupcakesQuantity);  // Send their choice to the decision structure
            cupcakeBusiness0.setCupcakesSold(premadeCupcakes.getPremadeQuantity());             // Set the premade quantity in the business class
            cupcakeBusiness0.setSales(costOfPremades);                                          // Set the bill for the customer
            premadeCupcakes.displayPremadeOrder();                                              // Display premade order
        }
        // If user chooses 2 for make purchase, do this:
        else if (choice == MAKE_PURCHASE) {
            cupcake1.displayCupcake();
            cupcakeBusiness0.displayCustomerPurchase();
        }
        // If the user chooses 3 for custom cupcake
        else if (choice == CUSTOM_CUPCAKE) {
            // put items here to build a custom cupcake
            int customCupcakePrice =5; //custom cupcakes are $5 each
            int numberOfCupcakes=0;
            int totalDollar =0;
            String customFrost;
            String customFlav;
            String customTopp;

            System.out.print("What flavor of cake? : ");
            customFlav = inputChoice.next();
            System.out.print("What flavor of frosting? : ");
            customFrost = inputChoice.next();
            System.out.print("What kind of toppings? : ");
            customTopp= inputChoice.next();
            System.out.print("How many cupcakes would you like? : ");
            numberOfCupcakes= inputChoice.nextInt();

            totalDollar = numberOfCupcakes * customCupcakePrice;

            //display
            System.out.print("You ordered "+numberOfCupcakes+", "+ customFlav+ " cupcakes with "+ customFrost+ " frosting with "+ customTopp+ " toppings. Your total is $"+totalDollar);


        }
        // If the user chooses to see how the business is doing:
        else if (choice == CUPCAKE_BUSINESS) {
            cupcakeBusiness0.displayCupcakeBusiness();
        }
        // If the user chooses 5, they've chosen a random cupcake
        else if (choice == RANDOM_CUPCAKE)
        {
            // Create a random
        }
        // If they choose 6, quit the program
        else if (choice == QUIT) {
            // Say goodbye
            System.out.println("Do you want to make another purchase? (n for no, y for yes)");
            inputChoice.nextLine();
            String playAgain = inputChoice.nextLine();

            if (playAgain.toUpperCase().equals("Y")) {
                displayMenu();
                getChoice();
            } else {
                System.out.println("Goodbye!");
                System.exit(0); // To get out of the program.
            }
        } else // If user chooses any other number
        {
            System.out.println("Please enter a number 1 - 9");
        }
    }

    /***************************************************************
     * Calculate and Display purchase
     ***************************************************************/


}
