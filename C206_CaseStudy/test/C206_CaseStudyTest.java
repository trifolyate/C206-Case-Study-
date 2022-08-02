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
		s1 = new student(1,"John",'A',"banana","ash");
		s2 = new student(2,"bob",'B',"minions","gru");
		s3 = new student(3,"snoopy",'C',"oo","gru");
		
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
	public void testViewParent() {
		assertNotNull("Test if there is valid parent arraylist to view from", parentList);
		
		String registeredParent= C206_CaseStudy.viewAllParent(parentList);
		String testOutput = "";
		assertEquals("Check that ViewAllParentlist", testOutput, registeredParent);
		
		assertEquals("Test if that parent arraylist size is 2?", 2, parentList.size());

	}
	
	@Test
	public void testDeleteParent() {
		// Item list is not null, so that can delete a parent
		assertNotNull("Test if there is valid Camcorder arraylist to add to", parentList);
		
		String registeredParent= C206_CaseStudy.viewAllParent(parentList);
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
	
	
	

	@After
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		parentList = null;
	}

	
	
	

}
