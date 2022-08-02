import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private parent p1;
	private parent p2;
	private student s1;
	private student s2;
	
	ArrayList<student> studentList = new ArrayList<student>();
	ArrayList<parent> parentList = new ArrayList<parent>();
	ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		s1 = new student(1001, "John", 'B', "B101", "Mr Tan");
		s2 = new student(1002, "Max", 'C', "B102", "Mr Lim");
		p1 = new parent(1001, "John", 'B', "B101", "Mr Tan", "Mrs Lim", "B2345E", "limsy@gmail.com", 92345678);
     	p2 = new parent(1002, "Max", 'C', "B102", "Mr Lim", "Mr lee", "A1234D", "leejh@gmail.com", 81234567);
		
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<parent> parentList = new ArrayList<parent>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	}
	
	
	@Test
	public void testAddParent() {
		// Item list is not null, so that can add a new parent
		assertNotNull("Test if there is valid parent arraylist to add to", parentList);
		
		//Given an empty list, after adding 1 parent, the size of the list is 1
		C206_CaseStudy.addParent(parentList, p1);		
		assertEquals("Test if that parent arraylist size is 1?", 1, parentList.size());
		
		//The parent just added is as same as the first item of the list
		assertSame("Test that parent is added same as 1st item of the list?", p1, parentList.get(0));
		
		//Add another parent. test The size of the list is 2?
		C206_CaseStudy.addParent(parentList, p2);
		assertEquals("Test that parent arraylist size is 2?", 2, parentList.size());
	}
	
	@Test
	public void testViewAllParent() {
		assertNotNull("Test if there is valid parent arraylist to view from", parentList);
		
		String registeredParent= C206_CaseStudy.viewAllParent(parentList);
		String testOutput = "";
		assertEquals("Check that ViewAllParentlist", testOutput, registeredParent);
		
		assertEquals("Test if that parent arraylist size is 2?", 2, parentList.size());

	}
	
	@Test
	public void testDeleteParent() {
		// Item list is not null, so that can delete a parent
		assertNotNull("Test if there is valid parent arraylist to delete from", parentList);
		
		String registeredParent= C206_CaseStudy.viewAllParent(parentList);
		String testOutput = "";
		assertEquals("Check that ViewAllParentlist", testOutput, registeredParent);
		
		C206_CaseStudy.deleteParent(parentList, p2);
		assertEquals("Test if that parent arraylist size is 1?", 1, parentList.size());
	}
	

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		s1 = null;
		s2 = null;
		parentList = null;
		studentList = null;
		teacherList = null;
	}

	
	
	

}
