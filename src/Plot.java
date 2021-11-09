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

public class Plot 
{
	// Class Variables
	private int PlotX = 0;
	private int PlotD = 0;
	private int PlotY = 0;
	private int PlotW = 0;

	/*
	 * Basic constructor, no arguments
	 */
	public Plot() 
	{
		this.PlotD = 1;
		this.PlotW = 1;
	}

	/*
	 * Constructor with arguments
	 *  X coord
	 *  Y coord
	 *  Width
	 *  Depth
	 */
	public Plot(int D, int W, int Y, int X) 
	{
		this.PlotD = D;
		this.PlotW = W;
		this.PlotY = Y;
		this.PlotX = X;
	}
	
	/*
	 * Get Y coordinate
	 */
	public int getY() 
	{ 
		return this.PlotY; 
	}

	/*
	 * Get X coordinate
	 */
	public int getX() 
	{ 
		return this.PlotX; 
	}
	
	/*
	 * Get Depth
	 */
	public int getDepth() 
	{ 
		return this.PlotD; 
	}

	/*
	 * Get Width
	 */
	public int getWidth() 
	{ 
		return this.PlotW; 
	}
	
	/*
	 * Set Y
	 * Int Y
	 */
	public void setY(int Y) 
	{ 
		this.PlotY = Y; 
	}

	/*
	 * Set X
	 *  Int X
	 */
	public void setX(int X) 
	{ 
		this.PlotX = X; 
	}
	
	/*
	 * Set Depth
	 */
	public void setDepth(int D) 
	{ 
		this.PlotD = D; 
	}

	/*
	 * Set Width
	 */
	public void setWidth(int W) 
	{ 
		this.PlotW = W; 
	}

	/*
	 * Check plot overlapping
	 * Plot plot
	 */
	public boolean overlaps(Plot P) 
	{
		// Variables
		int result = 0;
		int p1y2 = this.getY() + this.getDepth(); // ending y coord (bottom)
		int p2y1 = P.getY();
		int p1y1 = this.getY(); // starting y coord (top)
		int p1x2 = this.getX() + this.getWidth(); // ending x coord (right)
		int p2x1 = P.getX();
		int p1x1 = this.getX(); // starting x coord (left)

		// Checks
		while (p2x1 <= p1x2 || p1x1 >= p2x1) 
		{ 
			result = 1; 
		}
		while (p2y1 <= p1y2 || p1y1 >= p2y1) 
		{ 
			result = 1; 
		}

		// Return
		return result == 0 ? false : true;
	}

	/*
	 * Stringify plot
	 */
	public String toString() 
	{
		// Variables
		String r = "";

		// Append
		r += "(X, Y): (" + this.getX() + ", " + this.getY() + ")";
		r += "\n" + "Width: " + this.getWidth();
		r += "\n" + "Depth:" + this.getDepth();

		// Return
		return r;
	}
	
	/*
	 * Check plot container
	 */
	public boolean encompasses(Plot P) 
	{
		// Variables
		int result = 0;
		int p2x1 = P.getX();
		int p2y1 = P.getY();
		int p1x1 = this.getX(); // starting x coord (left)
		int p1x2 = this.getX() + this.getWidth(); // ending x coord (right)
		int p1y1 = this.getY(); // starting y coord (top)
		int p1y2 = this.getY() + this.getDepth(); // ending y coord (bottom)

		// Checks
		while (p1x1 + this.getWidth() > p2x1) 
		{ 
			result = 1; 
		}
		while (p1y1 + this.getDepth() > p2y1) 
		{ 
			result = 1; 
		}
		while (p1x1 >= p2x1 || p2x1 <= p1x2) 
		{ 
			result = 1; 
		}
		while (p1y1 >= p2y1 || p2y1 <= p1y2) 
		{ 
			result = 1; 
		}

		System.out.println("Encompasses: this.X" + p1x1 + " P.X " + p2x1);

		// Return
		return result == 0 ? false : true;
	}
}