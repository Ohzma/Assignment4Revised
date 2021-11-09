/* Class: CMSC203 CRN 22297
 *Program: Assignment 4
 *Instructor: Grigoriy Grinberg
 *Summary of Description: (A property management company manages individual properties they 
 will build to rent, and charges them a management fee as the percentages of the monthly rental 
 amount. The properties cannot overlap each other, and each property must be within the limits of 
 the management company’s plot.  Write an application that lets the user create a management company 
 and add the properties managed by the company to its list. Assume the maximum number of properties 
 handled by the company is 5.  
 *Due Date: 25OCT2021
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *Student: Daniel Cortes Gratacos
 */

public class Property 
{
	// Class Variables
	private String Name = "";
	private String City = "";
	private String Owner = "";
	private double RentAmount = 0;
	private Plot Plot;

	/*
	 * Basic constructor, no arguments
	 */
	public Property() 
	{
		this.Plot = new Plot();
	}

	/*
	 * Constructor with Name, City, Rent, Owner
	 */
	public Property(String N, String C, double R, String O) 
	{
		this.RentAmount = R;
		this.Name = N;
		this.City = C;
		this.Plot = new Plot();
		this.Owner = O;
	
	}
	
	/*
	 * Constructor to duplicate a property
	 */
	public Property(Property P) 
	{
		this.RentAmount = P.getRentAmount();
		this.Name = P.getPropertyName();
		this.City = P.getCity();
		this.Plot = P.getPlot();
		this.Owner = P.getOwner();
	}
	

	/*
	 * Constructor with Name, City, Rent, Owner, X, Y, Width, Depth
	 */
	public Property(String N, String C, double R, String O, int X, int Y, int W, int D) 
	{
		this.RentAmount = R;
		this.Name = N;
		this.City = C;
		this.Plot = new Plot(X, Y, W, D);
		this.Owner = O;
	}

	/*
	 * Get property city
	 */
	public String getCity() 
	{ 
		return this.City; 
	}
	
	/*
	 * Set property rent amount
	 */
	public void setRentAmount(double R) 
	{
		this.RentAmount = R; 
	}
	
	/*
	 * Get property name
	 */
	public String getPropertyName() 
	{ 
		return this.Name;
	}

	/*
	 * Set property city
	 */
	public void setCity(String S) 
	{ 
		this.City = S; 
	}
	
	/*
	 * Get property owner
	 */
	public String getOwner() 
	{ 
		return this.Owner; 
	}

	/*
	 * Get property plot
	 */
	public Plot getPlot() 
	{ 
		return this.Plot; 
	}

	/*
	 * Get property rent
	 */
	public double getRentAmount() 
	{ 
		return this.RentAmount;
	}
	/*
	 * Set property owner
	 */
	public void setOwner(String O) 
	{ 
		this.Owner = O; 
	}

	public String toString() 
	{
		// Variables
		String r = "";

		// Append
		r += "Property Name: " + this.getPropertyName();
		r += "\n" + "Located in " + this.getCity();
		r += "\n" + "Rent Amount: " + this.getRentAmount();
		r += "\n" + "Belonging to: " + this.getOwner();
		r += " ";

		// Return
		return r;
	}
	
	/*
	 * Set property name
	 */
	public void setPropertyName(String N) 
	{
		this.Name = N; 
	}
}