import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertSame;
//
//import org.junit.Test;
//
//public class katie {
//	//================================= Option 1 Add student (CRUD- Create) =================================
//    public static student inputStudent() {
//      int StudentID = Helper.readInt("Enter Student ID:");
//      String studentName = Helper.readString("Enter Student's Name:");
//      char StudentGrade = Helper.readChar("Enter Student's Grade:");
//      String classroom = Helper.readString("Enter Student's Classroom:");
//      String teacher = Helper.readString("Enter Student's teacher: ");
//      
//      student s = new student(StudentID,studentName,StudentGrade,classroom,teacher);
//      return s;
//    }
//    public static void addStudent(ArrayList<student>studentList,student s) {
//      studentList.add(s);
//    }
//    public static void deleteStudent(ArrayList<student>studentList,student s) {
//      studentList.remove(s);
//    }
//    //================================= Option 2 View Students (CRUD - Read) =================================
//    public static String retrieveAllStudent(ArrayList<student> studentList) {
//      String output = "";
//
//      for (int i = 0; i < studentList.size(); i++) {
//        
//        output += String.format("%-84s\n", studentList.get(i).toString());
//
//      }
//      return output;
//    }
//    public static String viewAllStudent(ArrayList<student> studentList) {
//      C206_CaseStudy.setHeader("STUDENT LIST");
//      String output = String.format("%-10d %-10s %-10s %-10s %-10s\n", "Student ID", "Student Name",
//          "GRADE", "CLASSROOM","TEACHER");
//       output += retrieveAllStudent(studentList);  
//      System.out.println(output);
//      return output;
//    }
//	if (userType == 1) {
//        // Add a student
//        //student student = inputStudent();
//        student student = inputStudent();
//        //C206_CaseStudy.addStudent(studentList, student);
//        C206_CaseStudy.addStudent(studentList, student);
//        //System.out.println("Student added");
//        System.out.println("Student added");
//	if (userType == 1) {
//        // Delete a student      
//        //System.out.println("Student deleted");
//        student student = inputStudent();
//        C206_CaseStudy.deleteStudent(studentList, student);
//        System.out.println("Student deleted");
	
	//test cases
//		@Test
//	public void testAddStudent() {
//		// Item list is not null, so that can add a new item
//		assertNotNull("Test if there is valid Camcorder arraylist to add to", studentList);
//		
//		//Given an empty list, after adding 1 item, the size of the list is 1
//		C206_CaseStudy.addStudent(studentList, s1);		
//		assertEquals("Test if that Student arraylist size is 1?", 1, studentList.size());
//		
//		//The item just added is as same as the first item of the list
//		assertSame("Test that Student is added same as 1st item of the list?", s1, studentList.get(0));
//		
//		//Add another item. test The size of the list is 2?
//		C206_CaseStudy.addStudent(studentList, s2);
//		C206_CaseStudy.addStudent(studentList, s3);
//		assertEquals("Test that Student arraylist size is 3?", 3, studentList.size());
//		assertSame("Test that Student is added same as 3rd item of the list?", s3, studentList.get(2));
//		
//	}
//	@Test
//	public void testViewStudent() {
//		assertNotNull("Test if there is valid student arraylist to view from", studentList);
//		C206_CaseStudy.addStudent(studentList, s1);
//		C206_CaseStudy.addStudent(studentList, s2);
//		C206_CaseStudy.addStudent(studentList, s3);
//		String students= C206_CaseStudy.retrieveAllStudent(studentList);
//		String testOutput = String.format("%-10s %-14s %-10d %-10s %-10s %-10s\n", "S123", "Ash Kid 1", 3,"3A", "MS THAMMY","true");
//		testOutput += String.format("\n%-10s %-14s %-10d %-10s %-10s %-10s\n", "S456", "Ash Kid 2", 2,"2F", "Ms Ong","false");
//		testOutput += String.format("\n%-10s %-14s %-10d %-10s %-10s %-10s\n\n", "S789", "Ash Kid 3", 3,"3D", "Ms Leih","true");
//		assertEquals("Check that ViewAllStudentList", testOutput, students);
//		
//		assertEquals("Test if that student arraylist size is 3?", 3, studentList.size());
//
//	}
//	@Test
//	public void testDeleteStudent() {
//		// Item list is not null, so that can delete a parent
//		assertNotNull("Test if there is valid student arraylist to view from", studentList);
//		
//		C206_CaseStudy.addStudent(studentList, s1);
//		C206_CaseStudy.addStudent(studentList, s2);
//		C206_CaseStudy.addStudent(studentList, s3);
//		String CCA= C206_CaseStudy.retrieveAllStudent(studentList);
//		String testOutput = String.format("%-10s %-14s %-10d %-10s %-10s %-10s\n", "S123", "Ash Kid 1", 3,"3A", "MS THAMMY","true");
//		testOutput += String.format("\n%-10s %-14s %-10d %-10s %-10s %-10s\n", "S456", "Ash Kid 2", 2,"2F", "Ms Ong","false");
//		testOutput += String.format("\n%-10s %-14s %-10d %-10s %-10s %-10s\n\n", "S789", "Ash Kid 3", 3,"3D", "Ms Leih","true");
//		assertEquals("Check that ViewAllCAAList", testOutput,CCA );
//		
//		C206_CaseStudy.deleteStudent(studentList, s2);
//		assertEquals("Test if that student arraylist size is 2?", 2, studentList.size());
//	}
//	

