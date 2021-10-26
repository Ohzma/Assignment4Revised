import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1, p2, p3, p4, p5, p6;
	ManagementCompany co = new ManagementCompany(); 
	@Before
	public void setUp() throws Exception {
		
		//student create a management company
		
		//student add three properties, with plots, to mgmt co
		p1 = new Property ("BeanHouse", "Bean", 1200, "Frijole",2,2,2,2);
		p2 = new Property ("BeanCasa", "Frijole", 1300, "B", 2,2,3,2);
		p3 = new Property ("RiceHouse", "Rice", 900, "Maria",1,1,2,1);
		co.addProperty(p1);
		co.addProperty(p2);
		co.addProperty(p3);
		
	}

	@After
	public void tearDown() {
		p1=p2=p3=null;
		co=null;  
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(co.addProperty("woah", "meanie", 5000, "gimemoni"), 3,0 );
		//student should add property with 8 args
		assertEquals(co.addProperty("shalom", "gutentag", 400, "god no", 2, 3, 1, 9), 4,0);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		assertEquals(co.addProperty("sumimasen", "hehe", 100, "eat my shorts", 2, 3, 1, 9), -1, 0);
	}
 
	@Test
	public void testMaxRentProp() {
		assertEquals(co.maxRentProp(),4500.0,0);
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(co.totalRent(),5000.0,0);
	}

 }