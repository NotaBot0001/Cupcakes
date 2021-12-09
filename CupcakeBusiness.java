/**
 * Filename: CupcakeBusiness (class)
 * Written by Tommy Rose
 * Written on 10.27.21
 * Purpose: Track business data
 */
import java.text.*;

public class CupcakeBusiness 
{
    // Variables involving profit and cupcakes sold
    private int cupcakesSold = 0;
    private double expenses = 0;
    private double sales = 0;
    private double profit = 0;
    private final static double COST_PER_CUPCAKE = 0.50;
    // Create constants for prices of premade menu:
	private final static double PRICE_PER_CUPCAKE = 3.00;
	private final static double PRICE_HALF_DOZEN = 15.00;
	private final static double PRICE_DOZEN = 24.00;

    /**************************** 
     *          Objects
    ****************************/
    // Currency object
	NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();

    /***********************
     * Getters and setters
     **********************/
    public int getCupcakesSold()
    {
        return cupcakesSold;
    }
    public void setCupcakesSold(int cupcakesSold)
    {
        this.cupcakesSold += cupcakesSold;
    }
    public double getSales()
    {
        return sales;
    }
    public void setSales(double sales)
    {
        this.sales += sales;
    }
    public double getExpenses()
    {
        return expenses;
    }
    public void setExpenses(double expenses)
    {
        this.expenses = expenses;
    }
    public double getProfit()
    {
        return profit;
    }
    public void setProfit(double profit)
    {
        this.profit = profit;
    }
    	// Getter for price per cupcake
	public double getPricePerCupcake()	{
		return PRICE_PER_CUPCAKE;
	}

	// Getter for price per half dozen
	public double getPriceHalfDozen()	{
		return PRICE_HALF_DOZEN;
	}

	// Getter for price per dozen
	public double getPricePerDozen()	{
		return PRICE_DOZEN;
	}

    /****************************************
     *      End of getters and setters
     ***************************************/

    /***************************************
     *             Calculations
    **************************************/

    // Create method for calculating sales
    public double sales(int cupcakesSold)
    {
        sales = cupcakesSold * PRICE_PER_CUPCAKE;
        return sales;
    }

    // Create method for calculating expenses
    public double expenses(int cupcakesSold)
    {
        expenses = cupcakesSold * COST_PER_CUPCAKE;
        return expenses; 
    }

    // Create method for calculating profit
    public double profit()
    {
        profit = sales - expenses;
        return profit;
    }

    /*****************************************
     *        End of Calculations
     *****************************************/

    /*****************************************
     *         Display method(s)
     ****************************************/
    public void displayPremadePrices()
    {
        System.out.println("Prices: \t[1] Individual: " + currencyInstance.format(PRICE_PER_CUPCAKE) + "\n" 
		+  "		[2] Half dozen: " + currencyInstance.format(PRICE_HALF_DOZEN) + "\n" 
		+  "		[3] One dozen: " + currencyInstance.format(PRICE_DOZEN) + "\n");
        System.out.print("Enter choice here: ");
    }
    public void displayCustomerPurchase() 
    {
        // Display the bill for the user
        System.out.println("Quantity bought: " + cupcakesSold);    // Display quantity
        System.out.println("Total cost: " + currencyInstance.format(sales));   // Display total cost for customer
    }
    public void displayCupcakeBusiness() {
        // Display: profit, expenses, quantity sold
        System.out.println("Cupcakes sold: " + getCupcakesSold());
        System.out.println("Sales: " + currencyInstance.format(getSales()));
        System.out.println("Expenses: " + currencyInstance.format(getExpenses()));
        System.out.println("Profit: " + currencyInstance.format(profit()));
    }

    /*******************************************
     *              Constructors
     ******************************************/
    public CupcakeBusiness()
    {

    }
}
