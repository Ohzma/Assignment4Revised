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

public class ManagementCompany 
{
	// Class Configuration
	private int MAX_PROPERTY = 5;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;

	// Class Variables
	private String Name = "";
	private String TaxID = "";
	private double ManagementFee = 0.00;
	private Plot ManagementPlot;
	private Property Properties[] = new Property[MAX_PROPERTY];
	private int currentPropertyIndex = -1; // Starts at 0

	/*
	 * Default/Empty constructor
	 * Returns nothing and defaults all values
	 */
	public ManagementCompany() 
	{
		this.ManagementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}

	/*
	 * Basic constructor
	 *  String Name
	 *  String Tax ID #
	 *  Double Management Fee
	 */
	public ManagementCompany(String n, String tid, double mfee) 
	{
		this.Name = n;
		this.TaxID = tid;
		this.ManagementFee = mfee;
		this.ManagementPlot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}

	/*
	 * Basic constructor
	 */
	public ManagementCompany(String n, String tid, double mfee, int x, int y, int w, int d) 
	{
		this.Name = n;
		this.TaxID = tid;
		this.ManagementFee = mfee;
		this.ManagementPlot = new Plot(x, y, w, d);
	}

	/*
	 * Returns the max amount of properties allowed
	 * return Int MAX_PROPERTY
	 */
	public int getMAX_PROPERTY() 
	{
		return this.MAX_PROPERTY;
	}

	/*
	 * Returns the management property plog
	 * return Plot plot
	 */
	public Plot getPlot() 
	{ 
		return this.ManagementPlot; 
	}

	/*
	 * Returns the management company name
	 * return String name
	 */
	public String getName() 
	{ 
		return this.Name; 
	}

	/*
	 * Returns the total rent due
	 * return Double rent total
	 */
	public double totalRent() 
	{
		// Variables
		double total = 0;

		// Loop
		for (int i = 0; i < this.Properties.length; i++)
		{
			// Checks
			if (this.Properties[i] == null) 
			{ 
				continue; 
			}

			// Variables
			Property p = this.Properties[i];
			total += p.getRentAmount();
		}

		// Return
		return (this.Properties.length > 0 ? total : 0.00);
	}

	/*
	 * Returns the highest rent property
	 */
	public Double maxRentProp() 
	{
		// Variables
		double highest = 0;
		String stringified = "";

		// Loop
		for (int i = 0; i < this.Properties.length; i++) 
		{
			// Variables
			Property p = this.Properties[i];

			if (p == null) 
			{ 
				continue; 
			}
			if (p.getRentAmount() > highest) 
			{
				highest = p.getRentAmount();
				//stringified = p.toString();
			}
		}


		// Return
		//return (highest > 0 ? stringified : "");
		return highest;
	}

	/*
	 * Returns the stringified version of Properties object
	 */
	public String toString() 
	{
		// Variables
		String r = "";

		// Append
		r += "List of properties for " + this.getName() + ", TaxID: " + this.TaxID;

		// Loop
		for (int i = 0; i < this.Properties.length; i++) 
		{
			// Checks
			if (this.Properties[i] == null) 
			{ 
				continue; 
			}

			// Variables
			r += "\n" + this.Properties[i].toString();
		}

		// Append
		r += "\ntotal management Fee: " + (this.totalRent() * (this.ManagementFee * 0.01));

		// Return
		return r;
	}

	/*
	 * Add property (Property)
	 */
	public int addProperty(Property P) 
	{
		// Variables
		int index = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;

		// Checks
		if (newIndex >= this.MAX_PROPERTY) 
		{ 
			return -1; 
		}

		// Variables
		this.Properties[newIndex] = new Property(P);

		// Default
		currentPropertyIndex = newIndex;
		return newIndex;
	}

	/*
	 * Add property (Name, City, Rent, Owner)
	 */
	public int addProperty(String n, String c, double r, String o) 
	{
		// Variables
		int index = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;

		// Checks
		if (newIndex >= this.MAX_PROPERTY) 
		{ 
			return -1; 
		}

		// Variables
		this.Properties[newIndex] = new Property(n, c, r, o);

		// Default
		currentPropertyIndex = newIndex;
		return newIndex;
	}

	/*
	 * Add property (Name, City, Rent, Owner, X, Y, Width, Depth)
	 */
	public int addProperty(String n, String c, double r, String o, int x, int y, int w, int d) 
	{
		// Variables
		int index = currentPropertyIndex;
		int newIndex = currentPropertyIndex + 1;
		Plot tempPlot = new Plot(x, y, w, d);

		// Checks
		if (newIndex >= this.MAX_PROPERTY) 
		{ 
			return -1; 
		}
		if (this.ManagementPlot.encompasses(tempPlot) == false) 
		{ 
			return -3; 
		}
		if (index >= 0) 
		{
			for (int i = 0; i < this.Properties.length; i++) 
			{
				// Checks
				if (this.Properties[i] == null) 
				{ 
					continue; 
				}
				if (this.Properties[i].getPlot().overlaps(tempPlot) == true) 
				{ 
					return -4; 
				}
			}
		}

		// Variables
		this.Properties[newIndex] = new Property(n, c, r, o, x, y, w, d);

		// Default
		currentPropertyIndex = newIndex;
		return newIndex;
	}
}