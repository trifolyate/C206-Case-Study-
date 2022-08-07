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
	private student s3;

	private CCA cca1;
	private CCA cca2;
	
	//ArrayList<student> studentList = new ArrayList<student>();
	//ArrayList<parent> parentList = new ArrayList<parent>();
	//ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	//ArrayList<CCA> CCAList = new ArrayList<CCA>();

	ArrayList<student> studentList = new ArrayList<student>();
	ArrayList<parent> parentList = new ArrayList<parent>();
	ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	ArrayList<CCA> CCAList = new ArrayList<CCA>();
	ArrayList<CCACategory> categoryList = new ArrayList<CCACategory>();

	public C206_CaseStudyTest() {
		super();
	
		
	}

	@Before
	public void setUp() throws Exception {

		s1 = new student(1,"John",'A',"banana","ash");
		s2 = new student(2,"bob",'B',"minions","gru");
		s3 = new student(3,"snoopy",'C',"oo","gru");
		s1 = new student(1001, "John", 'B', "B101", "Mr Tan");
		s2 = new student(1002, "Max", 'C', "B102", "Mr Lim");
		p1 = new parent(1001, "John", 'B', "B101", "Mr Tan", "Mrs Lim", "B2345E", "limsy@gmail.com", 92345678);
     	p2 = new parent(1002, "Max", 'C', "B102", "Mr Lim", "Mr lee", "A1234D", "leejh@gmail.com", 81234567);
		

		cca1 = new CCA("MUSIC","All songs",20,"monday",9,"Hall1");
		cca2 = new CCA("dance","All dance",25,"tuesday",10,"Hall");
		
		
		//ArrayList<student> studentList = new ArrayList<student>();
		//ArrayList<parent> parentList = new ArrayList<parent>();
		//ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		//ArrayList<CCA> CCAList = new ArrayList<CCA>();
		CCAList = new ArrayList<CCA>();
		parentList=new ArrayList<parent>();

		s1 = new student("1001", "John", 'B', "B101", "Mr Tan");
		s2 = new student("1002", "Max", 'C', "B102", "Mr Lim");
		p1 = new parent("1001", "John", 'B', "B101", "Mr Tan", "Mrs Lim", "B2345E", "limsy@gmail.com", 92345678);
		p2 = new parent("1002", "Max", 'C', "B102", "Mr Lim", "Mr lee", "A1234D", "leejh@gmail.com", 81234567);


		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<parent> parentList = new ArrayList<parent>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		ArrayList<CCA> CCAList = new ArrayList<CCA>();
		ArrayList<CCACategory> categoryList = new ArrayList<CCACategory>();

	}

	@Test
	public void testAddParent() {
		// Item list is not null, so that can add a new parent
		assertNotNull("Test if there is valid parent arraylist to add to", parentList);

		// Given an empty list, after adding 1 parent, the size of the list is 1
		C206_CaseStudy.addParent(parentList, p1);
		assertEquals("Test if that parent arraylist size is 1?", 1, parentList.size());

		// The parent just added is as same as the first item of the list
		assertSame("Test that parent is added same as 1st item of the list?", p1, parentList.get(0));

		// Add another parent. test The size of the list is 2?
		C206_CaseStudy.addParent(parentList, p2);
		assertEquals("Test that parent arraylist size is 2?", 2, parentList.size());
	}

	// ADD CCA details
	@Test
	public void testAddCCA() {
		// CCA list is not null, so that can add a new CCA
				assertNotNull("Test if there is valid CCA arraylist to add to", CCAList);
				
				//Given an empty list, after adding 1 CCA, the size of the list is 1
				C206_CaseStudy.addCCA(CCAList, cca1);		
				assertEquals("Test if that CCA arraylist size is 1?", 1, CCAList.size());
				
				//The CCA just added is as same as the first item of the list
				assertSame("Test that CCA is added same as 1st item of the list?", cca1, CCAList.get(0));
				
				//Add another CCA. test The size of the list is 2?
				C206_CaseStudy.addCCA(CCAList, cca2);
				assertEquals("Test that CCA arraylist size is 2?", 2, CCAList.size());
		
	}

	@Test
	public void testViewAllParent() {
		assertNotNull("Test if there is valid parent arraylist to view from", parentList);

		String registeredParent = C206_CaseStudy.viewAllParent(parentList);
		String testOutput = "";
		assertEquals("Check that ViewAllParentlist", testOutput, registeredParent);

		assertEquals("Test if that parent arraylist size is 2?", 2, parentList.size());

	}

	//VIEWCCA
	@Test
	public void testRetrieveAllCCA() {
		// Test if CCA list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid CCA arraylist to add to", CCAList);
					
		//test if the list of CCA retrieved  is empty
		String allCCA= C206_CaseStudy.retrieveAllCCA(CCAList);
		String testOutput = "";
		assertEquals("Check that ViewAllCCAlist", testOutput, allCCA);
							
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addCCA(CCAList, cca1);
		C206_CaseStudy.addCCA(CCAList, cca2);
		assertEquals("Test if that Chromebook arraylist size is 2?", 2, CCAList.size());
					
		//test if the expected output string same as the list of CCA retrieved from the SourceCentre
		allCCA= C206_CaseStudy.retrieveAllCCA(CCAList);

	    testOutput = String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n","Music", "All songs", "20", "Monday", "9","Hall1");
		testOutput += String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n","Dance", "All dance", "25", "Tuesday", "10","hall12");
	   
		
		assertEquals("Check that ViewAllCCA", testOutput, allCCA);
					
			
		}

	@Test
	public void testDeleteParent() {
		// Item list is not null, so that can delete a parent
		assertNotNull("Test if there is valid parent arraylist to delete from", parentList);

		String registeredParent = C206_CaseStudy.viewAllParent(parentList);
		String testOutput = "";
		assertEquals("Check that ViewAllParentlist", testOutput, registeredParent);

		C206_CaseStudy.deleteParent(parentList, p2);
		assertEquals("Test if that parent arraylist size is 1?", 1, parentList.size());
	}

	@Test
	public void testAddStudent() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Camcorder arraylist to add to", studentList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addStudent(studentList, s1);		
		assertEquals("Test if that Student arraylist size is 1?", 1, studentList.size());
		
		//The item just added is as same as the first item of the list
		assertSame("Test that Student is added same as 1st item of the list?", s1, studentList.get(0));
		
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addStudent(studentList, s2);
		C206_CaseStudy.addStudent(studentList, s3);
		assertEquals("Test that Student arraylist size is 3?", 3, studentList.size());
		assertSame("Test that Student is added same as 3rd item of the list?", s3, studentList.get(2));
		
	}
	@Test
	public void testViewStudent() {
		assertNotNull("Test if there is valid student arraylist to view from", studentList);
		
		String Students= C206_CaseStudy.viewAllStudent(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllStudentList", testOutput, Students);
		
		assertEquals("Test if that student arraylist size is 2?", 2, studentList.size());

	}
	@Test
	public void testDeleteStudent() {
		// Item list is not null, so that can delete a parent
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);
		
		String Students= C206_CaseStudy.viewAllStudent(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllStudentlist", testOutput, Students);
		
		C206_CaseStudy.deleteStudent(studentList, s2);
		assertEquals("Test if that student arraylist size is 1?", 1, studentList.size());
	}
	

	//Delete CCA
	@Test
	public void testDeleteCCA() {


	}

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		s1 = null;
		s2 = null;
		parentList = null;
		
		cca1= null;
		cca2=null;
		CCAList = null;

		studentList = null;
		teacherList = null;
		CCAList = null;
		categoryList = null;

	}

}
