import java.util.ArrayList;

public class sruthi {
	private static final int OPTION_QUIT = 4;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;

	public static void itemTypeMenu() {
		C206_CaseStudy.setHeader("users");
		System.out.println("1. Parent");
		System.out.println("2. Student");
		System.out.println("3. Teacher");
		System.out.println("4. CCA");
		System.out.println("5. CCA Categories");
	}

	public static void main(String[] args) {
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<parent> parentList = new ArrayList<parent>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		ArrayList<CCA> CCAList = new ArrayList<CCA>();
		ArrayList<CCACategory> categoryList = new ArrayList<CCACategory>();
		
		int option = 0;

		while (option != OPTION_QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				// View all items
				//C206_CaseStudy.viewAllStudent(studentList);
				C206_CaseStudy.viewAllParent(parentList);
				C206_CaseStudy.viewAllCCA(CCAList);
			
				//C206_CaseStudy.viewAllTeacher(teacherList);
				
			}
			
			else if (option == OPTION_ADD) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");			
				C206_CaseStudy.itemTypeMenu();
				
				int userType = Helper.readInt("Enter option to select user type > ");

				if (userType == 1) {
					// Add a student
					//student student = inputStudent();
					//C206_CaseStudy.addStudent(studentList, student);
					//System.out.println("Student added");

				} else if (userType == 2) {
					// Add a parent
					parent p = inputParent();
					C206_CaseStudy.addParent(parentList, p);
					System.out.println("Parent added");
					
				} else if (userType == 3) {
					// Add a teacher
					//teacher teacher = inputTeacher();
					//C206_CaseStudy.addTeacher(teacherList, teacher);
					//System.out.println("teacher added");
				} else {
					System.out.println("Invalid type");
					}
				}
			
				else if (option == OPTION_DELETE) {
					C206_CaseStudy.setHeader("DELETE");			
					C206_CaseStudy.itemTypeMenu();
					
					int userType = Helper.readInt("Enter option to select user type > ");

					if (userType == 1) {
						// Delete a student			
						//System.out.println("Student deleted");

					} else if (userType == 2) {
						// Delete a parent	
						parent p = inputParent();
						C206_CaseStudy.deleteParent(parentList, p);
						System.out.println("Parent deleted");
						
					} else if (userType == 3) {
						// Delete a teacher						
						//System.out.println("teacher deleted");
					} else {
						System.out.println("Invalid type");
						}
				
				} 
			
				else if (option == OPTION_QUIT) {
					System.out.println("Bye!");
				}
				else {
					System.out.println("Invalid option");
				}

			}
		
		
	}

	

	public static void menu() {
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. View user");
		System.out.println("2. Add user");
		System.out.println("3. Delete user");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//================================= Option 1 View users (CRUD- Read) =================================
		public static String retrieveAllParent(ArrayList<parent> parentList) {
			String output = "";

			for (int i = 0; i < parentList.size(); i++) {
				
				output += String.format("%-84s\n", parentList.get(i).toString());

			}
			return output;
		}
		public static String viewAllParent(ArrayList<parent> parentList) {
			C206_CaseStudy.setHeader("PARENT LIST");
			String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "CHILD ID", "CHILD NAME",
					"CHILD GRADE", "CHILD CLASS","CHILD TEACHER", "NAME", "CCA ID", "EMAIL", "CONTACT NO");
			 output += retrieveAllParent(parentList);	
			System.out.println(output);
			return output;
		}
		
		// for VIEW ALL CCA
		public static String retrieveAllCCA(ArrayList<CCA>CCAList) {
			String output="";
			for (int i =0;i<CCAList.size();i++) {
				output += String.format("%-84s\n", CCAList.get(i).toString());
			}
			return output;
		}
		public static String viewAllCCA(ArrayList<CCA> CCAList) {
			C206_CaseStudy.setHeader("CCA LIST");
			String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n", "CCA TITLE", "DESCRIPTION",
					"CLASS SIZE", "DAY OF WEEK","TIME","NAME","VENUE");
			output +=retrieveAllCCA(CCAList);
			System.out.println(output);
			return output;
			
			
		}
		//does this work?
		//check CCA size
		
		public static int checkCCA(ArrayList<CCA> CCAList) {
			int position = 0;
			boolean i = true;
			while (i ==true) {
				String cca_Title=" ";
				String cca_class_size= " ";
				cca_Title = Helper.readString("Enter CCA title >: ");
				cca_class_size = Helper.readString("Enter CCA class size >: ");
				
				for (int c =0;c < CCAList.size();c++) {
					if(CCAList.get(c).getCca_title().equals(cca_Title)) {
						if(CCAList.get(c).getCca_class_size()>=50);
						position = c;
						i= false;
						break;
					}else {
						System.out.println("Incorrect CCA class size,please try again");
						break;
					}
				}
				
			}
			return position;
			
		}
		
	
		//================================= Option 2 Add an user (CRUD - Create) =================================
//		public static parent inputParent() {
//			int childID = Helper.readInt("Enter child's ID > ");
//			String childName = Helper.readString("Enter child's name > ");
//			char grade = Helper.readChar("Enter child's grade > ");
//			String classroom = Helper.readString("Enter child's class > ");
//			String teacher = Helper.readString("Enter child's teacher > ");
//			String parentName = Helper.readString("Enter parent's name > ");
//			String CCAID = Helper.readString("Enter CCA ID > ");
//			String email = Helper.readString("Enter email > ");
//			int contactNo = Helper.readInt("Enter contact number > ");
//
//			//parent p = new parent(childID, childName, grade, classroom, teacher, parentName, CCAID, email, contactNo);
//			//return p;
//			
//		}
		public static void addParent(ArrayList<parent> parentList, parent p) {
			
			parentList.add(p);
			
		}
		
		// FOR ADD CCA DETIALS
		
		public static CCA inputCCA() {
			String category_title = Helper.readString("Enter category Title> ");
			int category_id = Helper.readInt("Enter category ID> ");
			String ccaTitle = Helper.readString("Enter CCA title > ");
			String ccaDescription = Helper.readString("Enter CCA description > ");
			int ccaClassSize = Helper.readInt("Enter CCA class size > ");
			String ccaDay = Helper.readString("Enter CCA day of week> ");
			int ccaTime = Helper.readInt("Enter CCA time > ");
			String ccaVenue = Helper.readString("Enter CCA venue > ");
			
			CCA cca = new CCA (category_title,category_id ,ccaTitle, ccaDescription, ccaClassSize, ccaDay, ccaTime, ccaVenue);
			return cca;
			
		}
		public static void addCCA(ArrayList<CCA>CCAList,CCA cca) {
			CCAList.add(cca);
		}
		
		
		//================================= Option 3 Delete an user (CRUD - Delete) =================================
		
		public static void deleteParent(ArrayList<parent> parentList, parent p) {

			parentList.remove(p);
			
		}
		public static void deleteCCA(ArrayList<CCA>CCAList,CCA cca) {
			CCAList.remove(cca);
		}
		
		//test cases
		
}
// test cases for the cca add view and delete.
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//public class C206_CaseStudyTest {
//	private parent p1;
//	private parent p2;
//	private student s1;
//	private student s2;
//
//	private student s3;
//
//	
//
//	private CCA cca1;
//	private CCA cca2;
//	
//	private ArrayList<CCA> CCAList;
//	private ArrayList<parent>parentList;
//	
//	//ArrayList<student> studentList = new ArrayList<student>();
//	//ArrayList<parent> parentList = new ArrayList<parent>();
//	//ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
//	//ArrayList<CCA> CCAList = new ArrayList<CCA>();
//	
//   
//
////	ArrayList<student> studentList = new ArrayList<student>();
////	ArrayList<parent> parentList = new ArrayList<parent>();
////	ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
////	ArrayList<CCA>CCAList = new ArrayList<CCA>();
////	ArrayList<CCACategory> categoryList = new ArrayList<CCACategory>();
//
//	public C206_CaseStudyTest() {
//		super();
//		
//		
//	}
//
//	@Before
//	public void setUp() throws Exception {
////		p1 = new parent("CC0011", "Nikon HDSLR", 40);
////		p2 = new parent("CC0012", "Sony DSC-RX100M7", 20);
//		
//		s1 = new student(1001, "John", 'B', "B101", "Mr Tan");
//		s2 = new student(1002, "Max", 'C', "B102", "Mr Lim");
//		p1 = new parent(1001, "John", 'B', "B101", "Mr Tan", "Mrs Lim", "B2345E", "limsy@gmail.com", 92345678);
//     	p2 = new parent(1002, "Max", 'C', "B102", "Mr Lim", "Mr lee", "A1234D", "leejh@gmail.com", 81234567);
//		
//
//		cca1 = new CCA("MUSIC","All songs",20,"monday",9,"Hall1");
//		cca2 = new CCA("dance","All dance",25,"tuesday",10,"Hall");
//		
//		
//		//ArrayList<student> studentList = new ArrayList<student>();
//		//ArrayList<parent> parentList = new ArrayList<parent>();
//		//ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
//		//ArrayList<CCA> CCAList = new ArrayList<CCA>();
//		CCAList = new ArrayList<CCA>();
//		parentList=new ArrayList<parent>();
//
//		s1 = new student("1001", "John", 'B', "B101", "Mr Tan");
//		s2 = new student("1002", "Max", 'C', "B102", "Mr Lim");
//		p1 = new parent("1001", "John", 'B', "B101", "Mr Tan", "Mrs Lim", "B2345E", "limsy@gmail.com", 92345678);
//		p2 = new parent("1002", "Max", 'C', "B102", "Mr Lim", "Mr lee", "A1234D", "leejh@gmail.com", 81234567);
//
//
//		ArrayList<student> studentList = new ArrayList<student>();
//		ArrayList<parent> parentList = new ArrayList<parent>();
//		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
//		ArrayList<CCA> CCAList = new ArrayList<CCA>();
//		ArrayList<CCACategory> categoryList = new ArrayList<CCACategory>();
//
//
//	}
//
//	
//
//	// ADD CCA details
//	@Test
//	public void testAddCCA() {
//		// CCA list is not null, so that can add a new CCA
//				assertNotNull("Test if there is valid CCA arraylist to add to", CCAList);
//				
//				//Given an empty list, after adding 1 CCA, the size of the list is 1
//				C206_CaseStudy.addCCA(CCAList, cca1);		
//				assertEquals("Test if that CCA arraylist size is 1?", 1, CCAList.size());
//				
//				//The CCA just added is as same as the first item of the list
//				assertSame("Test that CCA is added same as 1st item of the list?", cca1, CCAList.get(0));
//				
//				//Add another CCA. test The size of the list is 2?
//				C206_CaseStudy.addCCA(CCAList, cca2);
//				assertEquals("Test that CCA arraylist size is 2?", 2, CCAList.size());
//		
//	}
//
//
//
//
//	//VIEWCCA
//	@Test
//	public void testRetrieveAllCCA() {
//		// Test if CCA list is not null but empty, so that can add a new item
//		assertNotNull("Test if there is valid CCA arraylist to add to", CCAList);
//					
//		//test if the list of CCA retrieved  is empty
//		String allCCA= C206_CaseStudy.retrieveAllCCA(CCAList);
//		String testOutput = "";
//		assertEquals("Check that ViewAllCCAlist", testOutput, allCCA);
//							
//		//Given an empty list, after adding 2 items, test if the size of the list is 2
//		C206_CaseStudy.addCCA(CCAList, cca1);
//		C206_CaseStudy.addCCA(CCAList, cca2);
//		assertEquals("Test if that Chromebook arraylist size is 2?", 2, CCAList.size());
//					
//		//test if the expected output string same as the list of CCA retrieved from the SourceCentre
//		allCCA= C206_CaseStudy.retrieveAllCCA(CCAList);
//
//	    testOutput = String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n","Music", "All songs", "20", "Monday", "9","Hall1");
//		testOutput += String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n","Dance", "All dance", "25", "Tuesday", "10","hall12");
//	   
//		
//		assertEquals("Check that ViewAllCCA", testOutput, allCCA);
//					
//			
//		}
//
//	@Test
//	public void testDeleteParent() {
//		// Item list is not null, so that can delete a parent
//		assertNotNull("Test if there is valid parent arraylist to delete from", parentList);
//
//		String registeredParent = C206_CaseStudy.viewAllParent(parentList);
//		String testOutput = "";
//		assertEquals("Check that ViewAllParentlist", testOutput, registeredParent);
//
//		C206_CaseStudy.deleteParent(parentList, p2);
//		assertEquals("Test if that parent arraylist size is 1?", 1, parentList.size());
//	}
//
//	
//	
//	@Test
//	public void testDeleteStudent() {
//		// Item list is not null, so that can delete a parent
//		assertNotNull("Test if there is valid Student arraylist to add to", studentList);
//		
//		String Students= C206_CaseStudy.viewAllStudent(studentList);
//		String testOutput = "";
//		assertEquals("Check that ViewAllStudentlist", testOutput, Students);
//		
//		C206_CaseStudy.deleteStudent(studentList, s2);
//		assertEquals("Test if that student arraylist size is 1?", 1, studentList.size());
//	}
//	
//
//
//	//Delete CCA
//	@Test
//	public void testDeleteCCA() {
//             assertNotNull("Test if there is valid CCA arraylist to add to", CCAList);
//		
//		String CCA= C206_CaseStudy.viewAllCCA(CCAList);
//		String testOutput = "";
//		assertEquals("Check that ViewAllCAAList", testOutput,CCA );
//		
//		C206_CaseStudy.deleteCCA(CCAList, cca2);
//		assertEquals("Test if that student arraylist size is 1?", 1,CCAList.size());
//
//
//	}
//	
//
//
//
//	@After
//	public void tearDown() throws Exception {
//		p1 = null;
//		p2 = null;
//		s1 = null;
//		s2 = null;
//		parentList = null;
//
//
//		
//		cca1= null;
//		cca2=null;
//		CCAList = null;
//
//
//		studentList = null;
//		teacherList = null;
//		CCAList = null;
//		categoryList = null;
//>>>>>>> branch 'master' of https://github.com/trifolyate/C206-Case-Study-.git
//	}
//
//}
