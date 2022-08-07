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
	private CCACategory ct1;
	private CCACategory ct2;
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

		s1 = new student("Ash Parent 1", "ash@gmail.com", 92341234, 1, "S123", "Ash Kid 1", 3, "3A",
				"MS THAMMY", "C123", "", "", "", true, true);
		s2 = new student("", "", 0, 0, "S456", "Ash Kid 2", 2, "2F", "Ms Ong", "AKHWUIDHadawidh", "", "", "",
		false, true);
		s3 = new student("Ash Parent 2", "ash@gmail.com", 91234567, 2, "S789", "Ash Kid 3", 3, "3D",
				"Ms Leih", "C789", "CCA1", "CCA2", "", true, true);
		p1 = new parent("Ash Parent 1", "ash@gmail.com", 92341234, 1);
     	p2 = new parent("Ash Parent 2", "ash@gmail.com", 81023823, 2);
//		
//
		cca1 = new CCA("Sports", 1, 1, "Soccer",
				"a game played on a field between two teams of 11 players each with the object to propel a round ball into the opponent's goal by kicking or by hitting it with any part of the body except the hands and arms.",
				2, "Monday", "3:00PM-4:00PM", "Field");
		cca2 = new CCA("Clubs & Societies", 2, 2, "Boy Scouts",
		" an organization for boys that encourages them to take part in activities outside and to become responsible and independent.",
		20, "Tuesday", "3:00PM-4:00PM", "Field");
		
		ct1 = new CCACategory("Sports", 1);
		ct2 = new CCACategory("Clubs & Societies", 2);
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
	
	@Test
	public void testViewAllParent() {
		assertNotNull("Test if there is valid parent arraylist to view from", parentList);
		C206_CaseStudy.addParent(parentList, p1);
		C206_CaseStudy.addParent(parentList, p2);
		String registeredParent = C206_CaseStudy.retrieveAllParent(parentList);
		String testOutput = String.format("%-10s %-10s %-10d %-10d\n\n","Ash Parent 1","ash@gmail.com",92341234, 1 );
		testOutput += String.format("%-10s %-10s %-10d %-10d\n\n","Ash Parent 2","ash@gmail.com",81023823,2);
		assertEquals("Check that ViewAllParentlist", testOutput, registeredParent);

		assertEquals("Test if that parent arraylist size is 2?", 2, parentList.size());

	}
	
	@Test
	public void testDeleteParent() {
		// Item list is not null, so that can delete a parent
		assertNotNull("Test if there is valid parent arraylist to delete from", parentList);
		C206_CaseStudy.addParent(parentList, p1);
		C206_CaseStudy.addParent(parentList, p2);
		String registeredParent = C206_CaseStudy.retrieveAllParent(parentList);
		String testOutput = String.format("%-10s %-10s %-10d %-10d\n\n","Ash Parent 1","ash@gmail.com",92341234,1);
		testOutput += String.format("%-10s %-10s %-10d %-10d\n\n","Ash Parent 2","ash@gmail.com",81023823,2);
		assertEquals("Check that ViewAllParentlist", testOutput, registeredParent);

		C206_CaseStudy.deleteParent(parentList, p2);
		assertEquals("Test if that parent arraylist size is 1?", 1, parentList.size());
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////CCA TEST CASES/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	// View Details
	@Test
	public void testViewAllCCA() {
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
		allCCA= C206_CaseStudy.viewAllCCA(CCAList);
		testOutput +=String.format("%-15s %-15s %-15s %-15s %-19s %-15s\n", "CCA ID", "CCA TITLE", "CLASS SIZE","DAY OF WEEK", "TIME", "VENUE");
	    testOutput += String.format("%-15d %-15s %-15s %-15s %-19s %-13s\n\n", 1, "Soccer",
				2, "Monday", "3:00PM-4:00PM", "Field");
		testOutput += String.format("%-15d %-15s %-15s %-15s %-19s %-13s\n\n", 2, "Boy Scouts",
				20, "Tuesday", "3:00PM-4:00PM", "Field");
	   
		
		assertEquals("Check that ViewAllCCA", allCCA, testOutput);

	}
	
	//Delete CCA
		@Test
		public void testDeleteCCA() {
	             assertNotNull("Test if there is valid CCA arraylist to add to", CCAList);
	             
	            C206_CaseStudy.addCCA(CCAList, cca1);
	     		C206_CaseStudy.addCCA(CCAList, cca2);
				String CCA= C206_CaseStudy.retrieveAllCCA(CCAList);
				String testOutput = String.format("%-15d %-15s %-15d %-15s %-19s %-13s\n\n", 1, "Soccer",2, "Monday", "3:00PM-4:00PM", "Field");
				testOutput += String.format("%-15d %-15s %-15d %-15s %-19s %-13s\n\n", 2, "Boy Scouts",20, "Tuesday", "3:00PM-4:00PM", "Field");
				assertEquals("Check that ViewAllCAAList", testOutput,CCA );
				
				C206_CaseStudy.deleteCCA(CCAList, cca2);
				assertEquals("Test if that student arraylist size is 1?", 1,CCAList.size());
		
		
			}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////STUDENT TEST CASES/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
		C206_CaseStudy.addStudent(studentList, s1);
		C206_CaseStudy.addStudent(studentList, s2);
		C206_CaseStudy.addStudent(studentList, s3);
		String students= C206_CaseStudy.retrieveAllStudent(studentList);
		String testOutput = String.format("%-10s %-14s %-10d %-10s %-10s %-10s\n", "S123", "Ash Kid 1", 3,"3A", "MS THAMMY","true");
		testOutput += String.format("\n%-10s %-14s %-10d %-10s %-10s %-10s\n", "S456", "Ash Kid 2", 2,"2F", "Ms Ong","false");
		testOutput += String.format("\n%-10s %-14s %-10d %-10s %-10s %-10s\n\n", "S789", "Ash Kid 3", 3,"3D", "Ms Leih","true");
		assertEquals("Check that ViewAllStudentList", testOutput, students);
		
		assertEquals("Test if that student arraylist size is 3?", 3, studentList.size());

	}
	@Test
	public void testDeleteStudent() {
		// Item list is not null, so that can delete a parent
		assertNotNull("Test if there is valid student arraylist to view from", studentList);
		
		C206_CaseStudy.addStudent(studentList, s1);
		C206_CaseStudy.addStudent(studentList, s2);
		C206_CaseStudy.addStudent(studentList, s3);
		String CCA= C206_CaseStudy.retrieveAllStudent(studentList);
		String testOutput = String.format("%-10s %-14s %-10d %-10s %-10s %-10s\n", "S123", "Ash Kid 1", 3,"3A", "MS THAMMY","true");
		testOutput += String.format("\n%-10s %-14s %-10d %-10s %-10s %-10s\n", "S456", "Ash Kid 2", 2,"2F", "Ms Ong","false");
		testOutput += String.format("\n%-10s %-14s %-10d %-10s %-10s %-10s\n\n", "S789", "Ash Kid 3", 3,"3D", "Ms Leih","true");
		assertEquals("Check that ViewAllCAAList", testOutput,CCA );
		
		C206_CaseStudy.deleteStudent(studentList, s2);
		assertEquals("Test if that student arraylist size is 2?", 2, studentList.size());
	}
	

	
//ADD CCA CATEGORY
@Test
public void testAddCCACategory() {
//CCA category list is not null, so that can add a new CCA category
assertNotNull("Test if there is valid CCA arraylist to add to", categoryList);
//Given an empty list, after adding 1 CCA Category, the size of the list is 1
C206_CaseStudy.addCCACategory(categoryList, ct1);		
assertEquals("Test if that CCA Category arraylist size is 1?", 1, categoryList.size());

//The CCA category just added is as same as the first item of the list
assertSame("Test that CCA category is added same as 1st item of the list?", ct1, categoryList.get(0));

//Add another CCA. test The size of the list is 2?
C206_CaseStudy.addCCACategory(categoryList, ct2);
assertEquals("Test that CCA category arraylist size is 2?", 2, categoryList.size());

}




//VIEW CCA CATEGORY
@Test
public void testRetrieveAllCCACategory() {
//Test if CCA category list is not null but empty, so that can add a new item
assertNotNull("Test if there is valid CCA category arraylist to add to", categoryList);

//test if the list of CCA category retrieved  is empty
C206_CaseStudy.addCCACategory(categoryList, ct1);
C206_CaseStudy.addCCACategory(categoryList, ct2);
String allCCACAT= C206_CaseStudy.retrieveAllCCACategory(categoryList);
String testOutput = String.format("%-10s %-10s\n\n",1,"Sports");
testOutput += String.format("%-10s %-10s\n\n",2, "Clubs & Societies");
assertEquals("Check that ViewAllcategorylist", testOutput, allCCACAT);

//Given an empty list, after adding 2 items, test if the size of the list is 2
assertEquals("Test if that Chromebook arraylist size is 2?", 2, categoryList.size());

//test if the expected output string same as the list of CCA retrieved from the SourceCentre
String allCCACategory = C206_CaseStudy.retrieveAllCCACategory(categoryList);



assertEquals("Check that ViewAllCCACategory", testOutput, allCCACategory);


}



//Delete CCA Category
@Test
public void testDeleteCCACategory() {
assertNotNull("Test if there is valid CCA category arraylist to add to", categoryList);
C206_CaseStudy.addCCACategory(categoryList, ct1);
C206_CaseStudy.addCCACategory(categoryList, ct2);
String CCA = C206_CaseStudy.retrieveAllCCACategory(categoryList);

String testOutput = String.format("%-10s %-10s\n\n", 1,"Sports");
testOutput += String.format("%-10s %-10s\n\n", 2,"Clubs & Societies");
assertEquals("Check that ViewAllCCACategory", CCA,testOutput );

C206_CaseStudy.deleteCCACategory(categoryList, ct2);
assertEquals("Test if that CCA category arraylist size is 1?", 1,categoryList.size());
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