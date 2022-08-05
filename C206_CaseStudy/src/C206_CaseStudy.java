import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 3;
	private static final int OPTION_LOGIN = 1;
	private static final int OPTION_REGISTER = 2;

	
	//take note we have 5 different ID types:
	//S... = Student ID
	//T... = Teacher ID
	//C... = CCA ID 
	//U... = Super User ID (HOD / Principal)
	//F... = Family ID 
	
	public static void main(String[] args) {
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<parent> parentList = new ArrayList<parent>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		ArrayList<CCA> CCAList = new ArrayList<CCA>();
		ArrayList<CCACategory> categoryList = new ArrayList<CCACategory>();

		parentList.add(new parent("S123", "Ash", 'A', "5A", "Ms Tan","CCA1","CCA1","CCA1", "Ash Dad", "C123", "ash@gmail.com", 1234,"1"));
		parentList.add(new parent("S456", "Ash", 'A', "5A", "Ms Tan","CCA1","CCA1","CCA1", "Ash Dad", "C123", "ash@gmail.com", 1234,"1"));
		parentList.add(new parent("S789", "Ash", 'A', "5A", "Ms Tan","CCA1","CCA1","CCA1", "Ash Dad", "C123", "ash@gmail.com", 1234,"1"));
		parentList.add(new parent("S321", "Ash", 'A', "5A", "Ms Tan","CCA1","CCA1","CCA1", "Ash Dad", "C123", "ash@gmail.com", 1234,"1"));
		parentList.add(new parent("S654", "Ash", 'A', "5A", "Ms Tan","CCA1","CCA1","CCA1", "Ash Dad", "C123", "ash@gmail.com", 1234,"1"));

		int option = 0;

		while (option != OPTION_QUIT) {
			C206_CaseStudy.mainMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_LOGIN) {
				System.out.println("");
				int userOption = 0;
				C206_CaseStudy.LoginUsersMenu();
				userOption = Helper.readInt("Enter an option > ");
				if (userOption == 1) {
					int position = 0;
					System.out.println("\n");
					C206_CaseStudy.LoginMenu();
					position = C206_CaseStudy.checkParent(parentList);
					
					//options such as add student to CCA or drop them from CCA, also the view after logging in should show the current student details and the CCA details that he has joined.
					
				} else if (userOption == 2) {
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
//					parent p = inputParent();
//					C206_CaseStudy.addParent(parentList, p);
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
		System.out.println("");
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Log in");
		System.out.println("2. Register");
		Helper.line(80, "-");
		// test
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

	public static String retrieveAllParent(ArrayList<parent> parentList) {
		String output = "";
		return output;
	}

	public static int checkParent(ArrayList<parent> parentList) {
		int situation = 0;
		int position = 0;
		boolean loop = true;
		while (loop == true) {
			
			String username = "";
			String password = "";
			username = Helper.readString("Enter Student ID > ");
			password = Helper.readString("Enter CCA ID > ");
			
			for (int i = 0; i < parentList.size(); i++) {
				if (parentList.get(i).getStudentID().equals(username)) {
					if (parentList.get(i).getCCAid().equals(password)) {
						position = i;
						loop = false;
						break;
					} else {
						System.out.println("Incorrect password/student ID, please try again");
						System.out.print("\n");
						break;
					}
				}
			}
		}
		return position;
	}

	// ================================= Option 2 Add an user (CRUD - Create)
	// =================================
	public static void inputParent() {
		String childID = Helper.readString("Enter child's ID > ");
		String childName = Helper.readString("Enter child's name > ");
		char grade = Helper.readChar("Enter child's grade > ");
		String classroom = Helper.readString("Enter child's class > ");
		String teacher = Helper.readString("Enter child's teacher > ");
		String parentName = Helper.readString("Enter parent's name > ");
		String CCAID = Helper.readString("Enter CCA ID > ");
		String email = Helper.readString("Enter email > ");
		int contactNo = Helper.readInt("Enter contact number > ");


	}

	public static void addParent(ArrayList<parent> parentList, parent p) {

		parentList.add(p);

	}

	// ================================= Option 3 Delete an user (CRUD - Delete)
	// =================================

	public static String deleteParent(ArrayList<parent> parentList, parent p) {
		String output = "";
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
//test2
	// good job
	// why is this not working

}
