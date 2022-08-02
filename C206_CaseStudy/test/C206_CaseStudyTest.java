import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private parent p1;
	private parent p2;
	private parent p3;
	
	ArrayList<student> studentList = new ArrayList<student>();
	ArrayList<parent> parentList = new ArrayList<parent>();
	ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
//		p1 = new parent("CC0011", "Nikon HDSLR", 40);
//		p2 = new parent("CC0012", "Sony DSC-RX100M7", 20);
//		p3 = new parent("CC0013", "panasoni DSC-RX100M7", 30);
		
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<parent> parentList = new ArrayList<parent>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	}
	
	
	@Test
	public void testAddCamcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", parentList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addParent(parentList, p1);		
		assertEquals("Test if that Camcorder arraylist size is 1?", 1, parentList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Camcorder is added same as 1st item of the list?", p1, parentList.get(0));
		
		//Add another item. test The size of the list is 2?
//		C206_CaseStudy.addCamcorder(parentList, p2);
//		C206_CaseStudy.addCamcorder(parentList, p3);
//		assertEquals("Test that parent arraylist size is 3?", 3, parentList.size());
//		assertSame("Test that parent is added same as 3rd item of the list?", p3, parentList.get(2));
	}
	

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		p3 = null;
		parentList = null;
	}

	
	
	

}
