import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 4;
	private static final int OPTION_LOGIN = 1;
	private static final int OPTION_REGISTER = 2;

	public static void main(String[] args) {
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<parent> parentList = new ArrayList<parent>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		ArrayList<CCA> CCAList = new ArrayList<CCA>();
		ArrayList<CCACategory> categoryList = new ArrayList<CCACategory>();

		int option = 0;

		while (option != OPTION_QUIT) {
			C206_CaseStudy.mainMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_LOGIN) {
				System.out.println("");
				int userOption = 0;
				C206_CaseStudy.LoginUsersMenu();
				userOption = Helper.readInt("Enter an option > ");
				System.out.println("");
				if(userOption == 1 )
				{
					
					System.out.println("");
					C206_CaseStudy.LoginMenu();
					C206_CaseStudy.checkParent(parentList);
					//method to check if username and password exist inside parentList
					
				} else if (userOption == 2)
				{
					System.out.println("");
					C206_CaseStudy.LoginMenu();
					String username = "";
					String password = "";
					username = Helper.readString("Enter Username > ");
					password = Helper.readString("Enter password > ");
				}
			}

			else if (option == OPTION_REGISTER) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");
				C206_CaseStudy.itemTypeMenu();

				int userType = Helper.readInt("Enter option to select user type > ");

				if (userType == 1) {
					// Add a student
					// student student = inputStudent();
					// C206_CaseStudy.addStudent(studentList, student);
					// System.out.println("Student added");

				} else if (userType == 2) {
					// Add a parent
					parent p = inputParent();
					C206_CaseStudy.addParent(parentList, p);
					System.out.println("Parent added");

				} else if (userType == 3) {
					// Add a teacher
					// teacher teacher = inputTeacher();
					// C206_CaseStudy.addTeacher(teacherList, teacher);
					// System.out.println("teacher added");
				} else {
					System.out.println("Invalid type");
				}
			}

			else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void mainMenu() {
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Log in");
		System.out.println("2. Register");
		Helper.line(80, "-");
		//test
	}

	public static void LoginUsersMenu() {
		Helper.line(80, "-"); 
		System.out.println("CHOOSE USER TYPE"); 
		Helper.line(80, "-");
		System.out.println("1.Parent");
		System.out.println("2.Teachers");
		System.out.println("3.Others");
		Helper.line(80, "-");
	}
	
	public static void LoginMenu() {
		Helper.line(80, "-"); 
		System.out.println("LOG IN "); 
		Helper.line(80, "-");
	}

	public static void itemTypeMenu() {
		C206_CaseStudy.setHeader("users");
		System.out.println("1. Parent");
		System.out.println("2. Student");
		System.out.println("3. Teacher");
		System.out.println("4. CCA");
		System.out.println("5. CCA Categories");
	}

<<<<<<< HEAD
=======
	public static void main(String[] args) {
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<parent> parentList = new ArrayList<parent>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		ArrayList<CCA> CCAList = new ArrayList<CCA>();
		ArrayList<CCACategory> categoryList = new ArrayList<CCACategory>();
		
		studentList.add(new student(1001, "John", 'B', "B101", "Mr Tan"));
		studentList.add(new student(1002, "Max", 'C', "B102", "Mr Lim"));
		parentList.add(new parent(1001, "John", 'B', "B101", "Mr Tan", "Mrs Lim", "B2345E", "limsy@gmail.com", 92345678));
		parentList.add(new parent(1002, "Max", 'C', "B102", "Mr Lim", "Mr lee", "A1234D", "leejh@gmail.com", 81234567));
		
		int option = 0;

		while (option != OPTION_QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				// View all items
				//C206_CaseStudy.viewAllStudent(studentList);
				C206_CaseStudy.viewAllParent(parentList);
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

>>>>>>> branch 'master' of https://github.com/trifolyate/C206-Case-Study-.git
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// ================================= Option 1 View users (CRUD- Read)
	// =================================
	
	public static int checkParent(ArrayList<parent> parentList)
	{
		int situation = 0;
		String username = "";
		String password = "";
		username = Helper.readString("Enter Student ID > ");
		password = Helper.readString("Enter CCA ID > ");
		for(int i = 0;i < parentList.size();i++)
		{
			if (parentList.get(i).getStudentID().equals(username))
			{
				if(parentList.get(i).getCCAid().equals(password)) {
					situation = 1;
				}else {
					System.out.println("Incorrect password, please try again");
				}
				
<<<<<<< HEAD
			} else
			{
				System.out.println("Incorrect Student ID, please try again");
=======
				output += String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "CHILD ID", "CHILD NAME",
						"CHILD GRADE", "CHILD CLASS","CHILD TEACHER", "NAME", "CCA ID", "EMAIL", "CONTACT NO", parentList.get(i).toString());

>>>>>>> branch 'master' of https://github.com/trifolyate/C206-Case-Study-.git
			}
		}
		return situation;
		
		
<<<<<<< HEAD
	}
	public static String retrieveAllParent(ArrayList<parent> parentList) {
		String output = "";
=======
		
		
		//================================= Option 3 Delete an user (CRUD - Delete) =================================
		
		public static void deleteParent(ArrayList<parent> parentList, parent p) {
>>>>>>> branch 'master' of https://github.com/trifolyate/C206-Case-Study-.git

		for (int i = 0; i < parentList.size(); i++) {

			output += String.format("%-84s\n", parentList.get(i).toString());

		}
		return output;
	}

	public static String viewAllParent(ArrayList<parent> parentList) {
		C206_CaseStudy.setHeader("PARENT LIST");
		String output = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "CHILD ID", "CHILD NAME",
				"CHILD GRADE", "CHILD CLASS", "CHILD TEACHER", "NAME", "CCA ID", "EMAIL", "CONTACT NO");
		output += retrieveAllParent(parentList);
		System.out.println(output);
		return output;
	}
	// does this work?

	// ================================= Option 2 Add an user (CRUD - Create)
	// =================================
	public static parent inputParent() {
		String childID = Helper.readString("Enter child's ID > ");
		String childName = Helper.readString("Enter child's name > ");
		char grade = Helper.readChar("Enter child's grade > ");
		String classroom = Helper.readString("Enter child's class > ");
		String teacher = Helper.readString("Enter child's teacher > ");
		String parentName = Helper.readString("Enter parent's name > ");
		String CCAID = Helper.readString("Enter CCA ID > ");
		String email = Helper.readString("Enter email > ");
		int contactNo = Helper.readInt("Enter contact number > ");

		parent p = new parent(childID, childName, grade, classroom, teacher, parentName, CCAID, email, contactNo);
		return p;

	}

	public static void addParent(ArrayList<parent> parentList, parent p) {

		parentList.add(p);

	}

	// ================================= Option 3 Delete an user (CRUD - Delete)
	// =================================

	public static void deleteParent(ArrayList<parent> parentList, parent p) {

		parentList.remove(p);

	}

}
