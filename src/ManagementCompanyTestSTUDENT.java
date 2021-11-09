import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1, p2, p3;
	ManagementCompany co = new ManagementCompany("BeanLand","123454321",8); 
	@Before
	public void setUp() throws Exception {
		
		//student create a management company
		
		//student add three properties, with plots, to mgmt co
		p1 = new Property ("BeanHouse", "Bean", 2500, "Frijole",2,1,2,2);
		p2 = new Property ("BeanCasa", "Bean", 2800, "Habichuela", 4,1,2,2);
		p3 = new Property ("BeanMasion", "Bean", 3000, "LordBean",6,1,2,2);
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
	public void testMaxRentProp() {
		assertEquals(co.maxRentProp(),3000.0,0);
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(co.totalRent(),8300.0,0);
	}

 }