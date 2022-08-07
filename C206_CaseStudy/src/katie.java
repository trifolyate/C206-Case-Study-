import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class katie {
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
//	@Test
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
//		@Test
//	public void testViewStudent() {
//		// Test if Item list is not null but empty, so that can add a new item
//		assertNotNull("Test if there is valid Student ArrayList to add to", studentList);
//		
//		//test if the list of students retrieved from the SourceCentre is empty
//		String allStudent= C206_CaseStudy.retrieveAllStudent(studentList);
//		String testOutput = "";
//		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);
//				
//		//Given an empty list, after adding 2 items, test if the size of the list is 2
//		C206_CaseStudy.addStudent(studentList, s1);
//		C206_CaseStudy.addStudent(studentList, s2);
//		assertEquals("Test if that Student arraylist size is 2?", 2, studentList.size());
//		
//		//test if the expected output string same as the list of students retrieved from the SourceCentre
//		
//		allStudent = C206_CaseStudy.retrieveAllStudent(studentList);
//		String testOutput1 = "";
//		assertEquals("Check that ViewAllCamcorderlist", testOutput1, allStudent);
//		
//	}
//	@Test
//	public void testDeleteStudent() {
//		// Item list is not null, so that can delete a parent
//		assertNotNull("Test if there is valid Student arraylist to add to", studentList);
//		
//		String Students= C206_CaseStudy.viewAllStudent(studentList);
//		String testOutput = "";
//		assertEquals("Check that ViewAllStudentlist", testOutput, Students);
//		
//		C206_CaseStudy.deleteStudent(studentList, s1);
//		assertEquals("Test if that student arraylist size is 1?", 1, studentList.size());
//	}
	
//	s1 = new student(1,"John",'A',"banana","ash");
//	s2 = new student(2,"bob",'B',"minions","gru");
//	s3 = new student(3,"snoopy",'C',"oo","gru");
}
