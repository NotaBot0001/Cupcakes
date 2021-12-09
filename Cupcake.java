import java.text.*;

public class Cupcake {
	// Call out the data fields
	private int Quantity = 0;
	private String baseFlavor = "";
	private String frostingFlavor = "";
	private String topping = "";
	private String decoration = "";

	// Premade variables
	private double costOfPremades = 0.0;
	private int premadeQuantity = 0;
	private String premadeCupcakes = "";
	private final int INDIVIDUAL = 1;
	private final int HALF_DOZEN = 6;
	private final int DOZEN = 12;


	// Create arrays for creating cupcakes
	private String[] cakeFlavorArray = {"[1] Vanilla", "[2] Chocolate", "[3] Dark Chocolate", "[4] Strawberry"};
	private String[] frostingArray = {"[1] Chocolate", "[2] Vanilla", "[3] Peanut Butter", "[4] Cream Cheese", "[5] Strawberry"};
	private String[] toppingsArray = {"[1] Sprinkles", "[2] Toasted nuts", "[3] Small candies"};
	private String[] decorationArray = {"[1] Candle", "[2] Edible picture", "[3] Hot wheels car"};
	// Array for premades
	private String[] premadeCupcakesArray = {"Vanilla cake / Chocolate frosting", "Chocolate cake / Vanilla frosting", "Strawberry cake / Cream cheese frosting",
											 "Dark chocolate cake / Strawberry frosting"};

	/*********************************************************************
	 * 								Objects
	**********************************************************************/
	// Currency object
	NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();

	// Object to get data from currency class
	CupcakeBusiness cupcakeBusiness = new CupcakeBusiness();

	/********************************************************************
	 * 						Getters and setters
	 ********************************************************************/
	// Getter for quantity
	public int getQuantity() {
		return Quantity;
	}

	// Setter for quantity
	public void setQuantity(int Quantity) {
		this.Quantity = Quantity;
	}

	// Getter for base type
	public String getBaseFlavor() {

		return baseFlavor;
	}

	// Setter for base type
	public void setBaseFlavor(String baseFlavor) {  

		this.baseFlavor = baseFlavor;
	}

	// Getter for frosting flavor
	public String getFrostingFlavor() {
		return frostingFlavor;
	}

	// Setter for frosting flavor
	public void setFrostingFlavor(String frostingFlavor) {
		this.frostingFlavor = frostingFlavor;
	}
	// Getter for topping
	public String getTopping() {
		return topping;
	}

	// Setter for topping
	public void setTopping(String topping) {
		this.topping = topping;
	}

	// Getter for decoration
	public String getDecoration() {
		return decoration;
	}

	// Setter for decoration
	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	// Gets flavor by index from arraylist 
	public String getFlavor(int x) {
		return cakeFlavorArray[x];
	}

	// Get the premade options
	public String getPremadeCupcakes()
	{
		return premadeCupcakes;
	}
	// Set the premade option
	public void setPremadeCupcakes(String premadeCupcakes)
	{
		this.premadeCupcakes = premadeCupcakes;
	}
	// Get the premade quantity
	public int getPremadeQuantity()
	{
		return premadeQuantity;
	}
	// Set the premade quantity
	public void setPremadeQuantity(int premadeQuantity)
	{
		this.premadeQuantity = premadeQuantity;
	}


	/**********************************************
	 * 			Decision Structures
	 *********************************************/
	// Create a decision structure for the choice they make of premades:
	public void premadeCupcakesDecision(int premadeCupcakesInput)
	{
		// If the user enters 1, they are getting vanilla cake / chocolate frosting:
		if (premadeCupcakesInput == 1)
		{
			// Set cake flavor + frosting flavor:
			this.premadeCupcakes = premadeCupcakesArray[0];
		}
		// else if the user enters 2, they are getting chocolate cake / vanilla frosting:
		else if (premadeCupcakesInput == 2)
		{
			this.premadeCupcakes = premadeCupcakesArray[1];
		}
		// else if the user enters 3, they are getting strawberry cake / cream cheese frosting:
		else if (premadeCupcakesInput == 3)
		{
			this.premadeCupcakes = premadeCupcakesArray[2];
		}
		// else if the user enters 4, they are getting dark chocolate cake / strawberry frosting:
		else if (premadeCupcakesInput == 4)
		{
			this.premadeCupcakes = premadeCupcakesArray[3];
		}
	}
	// Create a decision structure to get the quantity of premades
	public double premadeDecisionQuantity(int premadeQuantity)
	{
		// If they've chosen an individual cupcake
		if (premadeQuantity == 1)
		{
			this.premadeQuantity += INDIVIDUAL;
			// Add quantity and price to the business class for tracking
			cupcakeBusiness.setCupcakesSold(INDIVIDUAL);	// Add 1 cupcake to quantity sold
			cupcakeBusiness.setSales(cupcakeBusiness.getPricePerCupcake());		// Add the amount per cupcake to total bill
			costOfPremades = 3.00;
		}
		// Else if they've chosen a half dozen
		else if (premadeQuantity == 2)
		{
			this.premadeQuantity += HALF_DOZEN;
			cupcakeBusiness.setCupcakesSold(HALF_DOZEN);	// Add 6 cupcakes to quantity sold
			cupcakeBusiness.setSales(cupcakeBusiness.getPriceHalfDozen());	// Add the amount for a half dozen to total bill
			costOfPremades = 15.00;
		}
		// Else if they've chosen a dozen
		else if (premadeQuantity == 3)
		{
			this.premadeQuantity += DOZEN;
			cupcakeBusiness.setCupcakesSold(DOZEN);			// Add 12 cupcakes to the quantity sold
			cupcakeBusiness.setSales(cupcakeBusiness.getPricePerDozen());	// Add the amount for a dozen to total bill
			costOfPremades = 24.00;
		}
		return costOfPremades;
	}

	/*********************************************** 
	 * 				Constructors
	************************************************/

	// set the parameters
	// Constructor for when user does buildACupcake
	public Cupcake(int Quantity, String baseFlavor, String frostingFlavor, String topping, String decoration) { 
		this.Quantity = Quantity;
		this.baseFlavor = baseFlavor;
		this.frostingFlavor = frostingFlavor;
		this.topping = topping;
		this.decoration = decoration;
	}

	// Constructor for premade cupcakes
	// I need to know what premade cupcakes they want and the quantity
	public Cupcake(String premadeCupcakes, int premadeQuantity)
	{
		this.premadeCupcakes = premadeCupcakes;
		this.premadeQuantity = premadeQuantity;
	}
   
   	// Create a default constructor
   	public Cupcake()
   	{}
	
	/***********************************************************
	 * 					Display methods
	 **********************************************************/
	// Add displayCupcake method
	public void displayCupcake()
	{
		System.out.println("Cake flavor: " + baseFlavor);
		System.out.println("Frosting flavor: " + frostingFlavor);
		System.out.println("Topping(s): " + topping);
		System.out.println("Decoration(s): " + decoration);
		System.out.println("Quantity: " + Quantity);
	}

	// Display the cake flavors using array
	public void displayCakeFlavors()
	{
		// For each element in the cakeFlavorArray, print them out
		for (int i = 0; i < cakeFlavorArray.length; i++)
		{
			System.out.println(cakeFlavorArray[i]);
		}
	}
	// Display the frosting flavors using array
	public void displayFrostingFlavors()
	{
		for (int i = 0; i < frostingArray.length; i++)
		{
			System.out.println(frostingArray[i]);
		}
	}
	// Display the toppings using array
	public void displayToppings()
	{
		for (int i = 0; i < toppingsArray.length; i++)
		{
			System.out.println(toppingsArray[i]);
		}
	}
	// Display the decorations using array
	public void displayDecorations()
	{
		for (int i = 0; i < decorationArray.length; i++)
		{
			System.out.println(decorationArray[i]);
		}
	}

	// Display the premade cupcake menu
	public void displayPremadeCupcakes()
	{
		System.out.println("   Premade Cupcakes\n   ---------------");
		System.out.println("[1] Vanilla cake / Chocolate frosting");
		System.out.println("[2] Chocolate cake / Vanilla frosting");
		System.out.println("[3] Strawberry cake / Cream cheese frosting");
		System.out.println("[4] Dark chocolate cake / Strawberry frosting");
		System.out.print("Enter choice here: ");
	}

	// Display premade order
	public void displayPremadeOrder()
	{
		System.out.println("-----Premade Order-----");
		System.out.println("Cupcake: " + premadeCupcakes);
		System.out.println("Quantity: " + premadeQuantity);
	}
}
