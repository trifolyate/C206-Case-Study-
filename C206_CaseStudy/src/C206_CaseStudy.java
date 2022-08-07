import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 3;
	private static final int OPTION_LOGIN = 1;
	private static final int OPTION_REGISTER = 2;

	// take note we have 5 different ID types:
	// S... = Student ID
	// T... = Teacher ID
	// C... = CCA REGISTRATION ID
	// U... = Super User ID (HOD / Principal)
	// F... = Family ID

	public static void main(String[] args) {
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<parent> parentList = new ArrayList<parent>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		ArrayList<CCA> CCAList = new ArrayList<CCA>();
		ArrayList<CCACategory> categoryList = new ArrayList<CCACategory>();
		ArrayList<superUser> superUserList = new ArrayList<superUser>();

		studentList.add(new student("Ash Parent 1", "ash@gmail.com", 92341234, 1, "S123", "Ash Kid 1", 3, "3A",
				"MS THAMMY", "C123", "", "", "", true, true));
		studentList.add(new student("", "", 0, 0, "S456", "Ash Kid 2", 2, "2F", "Ms Ong", "AKHWUIDHadawidh", "", "", "",
				false, true));
		studentList.add(new student("Ash Parent 2", "ash@gmail.com", 91234567, 2, "S789", "Ash Kid 3", 3, "3D",
				"Ms Leih", "C789", "CCA1", "CCA2", "", true, true));
		studentList.add(new student("", "", 0, 0, "S987", "Ash Kid 4", 6, "6B", "Mr K", "AKHWUIDHadawidh", "", "", "",
				false, false));
		studentList.add(new student("Ash Parent 1", "ash@gmail.com", 92341234, 1, "S654", "Ash Kid 5", 2, "2B",
				"Mr Tan", "C123", "Soccer", "", "", true, true));

		parentList.add(new parent("Ash Parent 1", "ash@gmail.com", 92341234, 1));
		parentList.add(new parent("Ash Parent 2", "ash@gmail.com", 81023823, 2));
		parentList.add(new parent("Ash Parent 3", "ash@gmail.com", 91203981, 3));
		parentList.add(new parent("Ash Parent 4", "ash@gmail.com", 81237290, 4));

		CCAList.add(new CCA("Sports", 1, 1, "Soccer",
				"a game played on a field between two teams of 11 players each with the object to propel a round ball into the opponent's goal by kicking or by hitting it with any part of the body except the hands and arms.",
				2, "Monday", "3:00PM-4:00PM", "Field"));
		CCAList.add(new CCA("Clubs & Societies", 2, 2, "Boy Scouts",
				" an organization for boys that encourages them to take part in activities outside and to become responsible and independent.",
				20, "Tuesday", "3:00PM-4:00PM", "Field"));
		CCAList.add(new CCA("Sports", 1, 3, "Soccer2",
				"a game played on a field between two teams of 11 players each with the object to propel a round ball into the opponent's goal by kicking or by hitting it with any part of the body except the hands and arms.",
				2, "Monday", "Lunch Break", "Field"));

		teacherList.add(new Teacher("Sports", 1, 1, "Soccer",
				"a game played on a field between two teams of 11 players each with the object to propel a round ball into the opponent's goal by kicking or by hitting it with any part of the body except the hands and arms.",
				2, "Wednesday", "Lunch Break", "Field", "T123", "Mr. Ash", "apple"));
		teacherList.add(new Teacher("Sports", 1, 1, "Soccer",
				"a game played on a field between two teams of 11 players each with the object to propel a round ball into the opponent's goal by kicking or by hitting it with any part of the body except the hands and arms.",
				2, "Wedesday", "3:00PM- 4:00PM", "Field", "T321", "Mr. Ash1", "apple1"));

		categoryList.add(new CCACategory("Sports", 1));
		categoryList.add(new CCACategory("Clubs & Societies", 2));

		superUserList.add(new superUser("U1", "password", "Ash Principal", "Principal"));
		int option = 0;
		while (option != OPTION_QUIT) {
			C206_CaseStudy.mainMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_LOGIN) {
				System.out.println("");
				int userOption = 0;
				C206_CaseStudy.LoginUsersMenu();
				userOption = Helper.readInt("Enter an option > ");
				if (userOption == 1) { // parents
					int studentPositionInList = 0;
					System.out.println("\n");
					C206_CaseStudy.LoginMenu();
					studentPositionInList = C206_CaseStudy.findStudentPositioninList(studentList);
					if (studentPositionInList != -1) {
						boolean loop = true;
						while (loop == true) {
							System.out.print("\n");
							C206_CaseStudy.setHeader("Student CCA Page");
							int focusStudentposition = -1;
							focusStudentposition = chooseCorrectStudent(studentList, studentPositionInList);
							String studentOption = "";
							studentOption = studentChoices(studentList, focusStudentposition);// studentChoices
							if (studentOption.equals("1")) // add student CCA //using SRUTHI CODES
							{
								C206_CaseStudy.setHeader("Student Add CCA Page");

								addCCALoginStudent(CCAList, focusStudentposition, studentList, teacherList);
							} else if (studentOption.equals("2")) { // remove cca
								C206_CaseStudy.setHeader("Student Remove CCA Page");
								removeCCALoginStudent(studentList, focusStudentposition);
							} else if (studentOption.equals("3")) {
								loop = false;
								// make this empty to bring user to Main Menu
							}
						}
					}
				} else if (userOption == 2) { // teachers
					System.out.print("\n");
					C206_CaseStudy.LoginMenu();
					int teacherPositionInList = 0;
					teacherPositionInList = findTeacherPositionInList(teacherList);
					if (teacherPositionInList != -1) {
						System.out.print("\n");
						C206_CaseStudy.setHeader("Teacher CCA Page");
						boolean loop = true;
						while (loop == true) {
							int teacherOption = teacherChoices(CCAList, teacherList, teacherPositionInList);
							if (teacherOption == 1) // view students inside CCA
							{
								System.out.print("\n");
								Helper.line(80, "-");
								System.out.print(
										studentsInsideCCA(studentList, CCAList, teacherList, teacherPositionInList));
								Helper.line(80, "-");
							} else if (teacherOption == 2) // View CCA Details
							{
								System.out.print("\n");
								Helper.line(80, "-");
								System.out.print(teacherList.get(teacherPositionInList).toStringCCASpecial());
								System.out.print("\n");
								Helper.line(80, "-");
							} else if (teacherOption == 3) // Edit CCA Details
							{
								System.out.print("\n");
								Helper.line(80, "-");
								editCCADetails(CCAList, teacherList, studentList, teacherPositionInList);
								Helper.line(80, "-");
							} else {
								loop = false;
							}
						}
					}

				} else if (userOption == 3) { // super User
					System.out.print("\n");
					C206_CaseStudy.LoginMenu();
					int superUserInList = 0;
					superUserInList = findSuperUserPositionInList(superUserList);
					if (superUserInList != -1) {
						System.out.print("\n");
						C206_CaseStudy.setHeader("Super User Page");
						boolean loop = true;
						while (loop == true) {
//							System.out.print("\n (1) Add/View/Delete Student \n");
//							System.out.print(" (2) Add/View/Delete CCA \n");
//							System.out.print(" (3) Add/View/Delete CCA Category \n");
//							System.out.print(" (4) Add/View/Delete Parent \n");
//							System.out.print(" (5) Exit\n\n");
							int superUserOption = superUserChoices(superUserList, superUserInList);
							if (superUserOption == 1) // (1) Add/View/Delete Student
							{
								boolean loop2 = true;
								while (loop2 == true) {
									viewAllStudent(studentList);

									int su_ccaoption = SUCCAOptions();
									if (su_ccaoption == 1) // add
									{
										student addedStudent = inputStudent();
										addStudent(studentList, addedStudent);
									} else if (su_ccaoption == 2) // delete
									{
										int focusstudent = SUchoosecorrectStudentDELETE(studentList);
										deleteStudent(studentList, focusstudent);
									} else {
										loop2 = false;
									}
								}

							} else if (superUserOption == 2) // (2) Add/View/Delete CCA
							{
								boolean loop3 = true;
								while (loop3 == true) {
									viewAllCCA(CCAList);

									int su_studentoption = SUstudentOptions(studentList);
									if (su_studentoption == 1) // add
									{
										CCA addedCCA = inputCCA(CCAList, categoryList);
										addCCA(CCAList, addedCCA);
									} else if (su_studentoption == 2) // delete
									{
										int focusCCA = SUchoosecorrectCCADELETE(CCAList);
										deleteCCA(CCAList, focusCCA);
									} else {
										loop3 = false;
									}
								}
							} else if (superUserOption == 3) // (3) Add/View/Delete CCA Category
							{
								boolean loop4 = true;
								while (loop4 == true) {
									viewAllCCACategory(categoryList);
									int su_ccacatoption = SUCCACATOptions();
									if (su_ccacatoption == 1) // add
									{
										CCACategory addedCCACategory = inputCCACategory(categoryList);
										addCCACategory(categoryList, addedCCACategory);
									} else if (su_ccacatoption == 2) // delete
									{
										int focusCCACAt = SUchoosecorrectCCACATDELETE(categoryList);
										deleteCCACategory(categoryList, focusCCACAt);
									} else {
										loop4 = false;
									}
								}
							} else if (superUserOption == 4) // (4) Add/View/Delete Parent
							{
								boolean loop5 = true;
								while (loop5 == true) {
									viewAllParent(parentList);
									int su_parentoption = SUPARENTOptions();
									if (su_parentoption == 1) // add
									{
										parent addedParent = inputParent(parentList);
										addParent(parentList, addedParent);
									} else if (su_parentoption == 2) // delete
									{
										int focusParent = SUchoosecorrectPARENTDELETE(parentList);
										deleteParent(parentList, focusParent);
									} else {
										loop5 = false;
									}
								}
							} else {
								loop = false;
							}
						}
					}

				} else if (userOption == 4) { // empty means it will go back to Main Page
				}
			}

			else if (option == OPTION_REGISTER) {
				System.out.print("\n");
				C206_CaseStudy.setHeader("Register");
				char registerOptions = 'z';
				boolean continueAsking = true;
				while (continueAsking == true) {
					registerOptions = Helper.readChar(
							"\nAre you a parent of a student that is P3 and below? \n(Y for Yes, N for No, E for exit): ");
					if (registerOptions == 'Y' || registerOptions == 'y') {
						RegisterStudentP3andBelow(studentList, parentList);
					} else if (registerOptions == 'N' || registerOptions == 'n') {
						RegisterStudentP3andAbove(studentList);
					} else if (registerOptions == 'E' || registerOptions == 'e') {
						break;
					} else {
						System.out.print("Incorrect option, please try again (Y or N)\n");
					}
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
		System.out.print("\n");
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Log in");
		System.out.println("2. Register");
		System.out.print("3. Exit\n");
		Helper.line(80, "-");
		// test
	}

	public static void LoginUsersMenu() {
		Helper.line(80, "-");
		System.out.println("CHOOSE USER TYPE");
		Helper.line(80, "-");
		System.out.println("1.Parent / Students");
		System.out.println("2.Teachers");
		System.out.println("3.Others");
		System.out.print("4.Exit\n");
		Helper.line(80, "-");
	}

	public static void LoginMenu() {
		Helper.line(80, "-");
		System.out.println("LOG IN ");
		Helper.line(80, "-");
	}

//	public static void itemTypeMenu() {
//		C206_CaseStudy.setHeader("");
//		System.out.println("1. Parent");
//		System.out.println("2. Student");
//		System.out.println("3. Teacher");
//		System.out.println("4. CCA");
//		System.out.println("5. CCA Categories");
//	}

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

	public static void addCCALoginStudent(ArrayList<CCA> list, int StudentListPosition, ArrayList<student> studentlist,
			ArrayList<Teacher> teacherList) {
		viewAllCCA(list);
		int CCAposition = -1;
		int ccaChoice = Helper.readInt("Enter CCA ID : ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCca_id() == ccaChoice) {
				CCAposition = i;
				System.out.print(list.get(i).toStringCCASpecial());
				System.out.print("\n");
			}
		}
		char finalChoice = Helper.readChar("Register for this CCA?(Y or N): ");
		if (finalChoice == 'Y' || finalChoice == 'y') {
			if (studentlist.get(StudentListPosition).getCCA1().isEmpty()) {
				studentlist.get(StudentListPosition).setCCA1(list.get(CCAposition).getCca_title());
				int size = list.get(CCAposition).getCca_class_size();
				list.get(CCAposition).setCca_class_size(size + 1);
				for (int i = 1; i < teacherList.size(); i++) {
					if (list.get(CCAposition).getCca_id() == teacherList.get(i).getCca_id()) {
						teacherList.get(i).setCca_class_size(size);
					}
				}
			} else if (studentlist.get(StudentListPosition).getCCA2().isEmpty()) {
				studentlist.get(StudentListPosition).setCCA2(list.get(CCAposition).getCca_title());
				int size = list.get(CCAposition).getCca_class_size();
				list.get(CCAposition).setCca_class_size(size + 1);
				for (int i = 1; i < teacherList.size(); i++) {
					if (list.get(CCAposition).getCca_id() == teacherList.get(i).getCca_id()) {
						teacherList.get(i).setCca_class_size(size);
					}
				}
			} else if (studentlist.get(StudentListPosition).getCCA3().isEmpty()) {
				studentlist.get(StudentListPosition).setCCA3(list.get(CCAposition).getCca_title());
				int size = list.get(CCAposition).getCca_class_size();
				list.get(CCAposition).setCca_class_size(size + 1);
				for (int i = 1; i < teacherList.size(); i++) {
					if (list.get(CCAposition).getCca_id() == teacherList.get(i).getCca_id()) {
						teacherList.get(i).setCca_class_size(size);
					}
				}
			}
		}

	}

	public static void removeCCALoginStudent(ArrayList<student> list, int position) {
		System.out.print("\n");
		System.out.print(String.format("%s\n", list.get(position).toStudentCCASpecialString()));
		System.out.print("\n");
		int choice = -1;
		boolean loop = true;
		while (loop == true) {
			if (!list.get(position).getCCA1().isEmpty() && !list.get(position).getCCA2().isEmpty()
					&& !list.get(position).getCCA3().isEmpty()) {
				choice = Helper.readInt("Choose a CCA to drop of from (1 to 3): ");
				if (choice == 1) {
					list.get(position).setCCA1(list.get(position).getCCA2());
					list.get(position).setCCA2(list.get(position).getCCA3());
					list.get(position).setCCA3("");
					loop = false;
				} else if (choice == 2) {
					list.get(position).setCCA2(list.get(position).getCCA3());
					list.get(position).setCCA3("");
					loop = false;
				} else if (choice == 3) {
					list.get(position).setCCA3("");
					loop = false;
				} else {
					System.out.print("Please Try again\n");
				}
			} else if (!list.get(position).getCCA1().isEmpty() && !list.get(position).getCCA2().isEmpty()) {
				choice = Helper.readInt("Choose A CCA to drop of from (1 to 2): ");
				if (choice == 1) {
					list.get(position).setCCA1(list.get(position).getCCA1());
					list.get(position).setCCA2("");
					loop = false;
				} else if (choice == 2) {
					list.get(position).setCCA2("");
					loop = false;
				} else {
					System.out.print("Please Try again\n");
				}
			} else {
				choice = Helper.readInt("Choose A CCA to drop of from (1): ");
				if (choice == 1) {
					list.get(position).setCCA1("");
					loop = false;
				} else {
					System.out.print("Please Try again\n");
				}
			}
		}
	}

	public static String studentChoices(ArrayList<student> list, int position) {
		String result = "";
		System.out.print("\n");
		boolean loop = true;
		while (loop == true) {
			System.out.print(String.format("You have chosen: %s\n\n", list.get(position).getName()));
			if (!list.get(position).getCCA3().isEmpty()) {
				System.out.print("(2) Remove Student From CCA\n");
				System.out.print("(3) EXIT\n");
				result = Helper.readString("Please select your option (2 or 3): ");
				if (result.equals("2") || result.equals("3")) {
					loop = false;
					return result;
				} else {
					System.out.print("Incorrect option, please try again\n\n");
				}

			} else if (list.get(position).getCCA1().isEmpty()) {
				System.out.print("(1) Add Student into CCA (Maximum 3)\n");
				System.out.print("(3) EXIT\n");
				result = Helper.readString("Please select your option (1 or 3): ");
				if (result.equals("1") || result.equals("3")) {
					loop = false;
					return result;
				} else {
					System.out.print("Incorrect option, please try again\n\n");
				}
			} else {
				System.out.print("(1) Add Student into CCA (Maximum 3)\n");
				System.out.print("(2) Remove Student From CCA\n");
				System.out.print("(3) EXIT\n");
				result = Helper.readString("Please select your option (1,2 or 3): ");
				if (result.equals("1") || result.equals("2") || result.equals("3")) {
					loop = false;
				} else {
					System.out.print("Incorrect option, please try again\n\n");
				}
			}
		}
		return result;
	}

	public static int chooseCorrectStudent(ArrayList<student> list, int studentPositionInList) {
		int position = 9999;
		boolean loop = true;
		boolean noFamilydata = true;
		List<String> studentIDOptions = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getFamilyId() == (list.get(studentPositionInList).getFamilyId())
					&& list.get(studentPositionInList).getFamilyId() != 0) { // prints
				// the
				// students
				// details,
				// based on
				// the
				// students
				// CCAID
				// since
				// student
				// having
				// the same
				// Family ID
				// would
				// mean that
				// they are
				// related except 0 since they have not registered, log in without parents
				noFamilydata = false;
				String studentID = list.get(i).getStudentID();
				studentIDOptions.add(studentID);
				String message = String.format(" %s", list.get(i).toMainStudentString());
				System.out.print(message);
				list.get(i).toStudentCCAString();
				System.out.print("\n\n");
			}
		}
		if (noFamilydata == true) {
			String studentID = list.get(studentPositionInList).getStudentID();
			studentIDOptions.add(studentID);
			String message = String.format(" %s", list.get(studentPositionInList).toMainStudentString());
			System.out.print(message);
			list.get(studentPositionInList).toStudentCCAString();
			System.out.print("\n\n");
		}
		while (loop == true) {

			String focusStudent = Helper.readString("Enter the Student ID you wish to focus on:");
			for (int i = 0; i < studentIDOptions.size(); i++) {
				if (studentIDOptions.get(i).equals(focusStudent)) {
					for (int v = 0; v < list.size(); v++) {
						if ((studentIDOptions.get(i).equals(list.get(v).getStudentID()))) {
							position = v;
							loop = false;
						}
					}
				}

			}
			if (position == 9999) {
				System.out.print("Please try again\n\n");
			}

		}
		return position;
	}

	public static int findStudentPositioninList(ArrayList<student> list) {
		int position = -1;
		boolean loop = true;
		while (loop == true) {

			String username = "";
			String password = "";
			String input = "";
			username = Helper.readString("Enter Student ID(enter 'exit' to go back to main menu) > ");
			if (username.equalsIgnoreCase("exit")) {
				loop = false;
				return position;
			}
			password = Helper.readString("Enter CCA ID > ");

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getStudentID().equals(username)) {
					if (list.get(i).getCCAID().equals(password)) {
						if (list.get(i).getGrade() > 3) {
							position = i;
							loop = false;
						} else {
							boolean parentCheck = false;
							while (parentCheck == false) {
								String parentEmail = "";
								parentEmail = Helper.readString(
										"(FOR P3 STUDENTS AND BELOW)\nPlease enter this student account's registered parent email\n(enter 'exit' to go back): ");
								if (list.get(i).getEmail().equals(parentEmail)) {
									position = i;
									parentCheck = false;
									loop = false;
									break;
								} else if (parentEmail.equals("exit")) {

									break;
								} else {
									System.out.print("Incorrect Parent Email, Please Try Again\n\n");
								}
							}
						}
					}
				}
			}
			if (position == -1) {
				input += "Incorrect Student ID / CCA ID, Please Try Again";
				System.out.print(input);
				System.out.print("\n");
				System.out.print("\n");
			}

		}
		return position;
	}

	public static int findTeacherPositionInList(ArrayList<Teacher> teacherList) {
		int teacherPosition = -1;
		boolean loop = true;
		while (loop == true) {

			String username = "";
			String password = "";
			String input = "";
			boolean foundUsername = false;
			username = Helper.readString("Enter Staff ID(enter 'exit' to go back to main menu) > ");
			if (username.equalsIgnoreCase("exit")) {
				loop = false;
				return teacherPosition;
			}
			password = Helper.readString("Enter Password > ");

			for (int i = 0; i < teacherList.size(); i++) {
				if (teacherList.get(i).getStaffId().equals(username)) {
					foundUsername = true;
					if (teacherList.get(i).getPassword().equals(password)) {
						teacherPosition = i;
						loop = false;
					}
				}
			}
			if (foundUsername == false) {
				input += "Incorrect Staff ID / Password, Please Try Again";
				System.out.print(input);
				System.out.print("\n");
				System.out.print("\n");
			} else if (foundUsername == true && teacherPosition == -1) {
				input += "Incorrect Password, Please Try Again";
				System.out.print(input);
				System.out.print("\n");
				System.out.print("\n");
			}

		}
		return teacherPosition;
	}

	public static int teacherChoices(ArrayList<CCA> ccalist, ArrayList<Teacher> teacherlist, int teacherPosition) {
		int choice = -1;
		boolean loop = true;
		System.out.print("\n");
		System.out.print(String.format("WELCOME, %s", teacherlist.get(teacherPosition).getTeacher_name()));
		System.out.print("\n");
		while (loop == true) {
			System.out.print(
					String.format("\n (1) View Students inside %s\n", teacherlist.get(teacherPosition).getCca_title()));
			System.out.print(String.format(" (2) View %s Details\n", teacherlist.get(teacherPosition).getCca_title()));
			System.out.print(String.format(" (3) Edit %s Details\n", teacherlist.get(teacherPosition).getCca_title()));
			System.out.print(" (4) Exit\n\n");
			int teacherchoice = Helper.readInt("Select an option (1,2,3 or 4): ");
			if (teacherchoice == 1 || teacherchoice == 2 || teacherchoice == 3 || teacherchoice == 4) {
				choice = teacherchoice;
				loop = false;
//				break;
			} else {
				String input = "Incorrect Option, Please Try Again";
				System.out.print(input);
				System.out.print("\n");
				System.out.print("\n");
			}
		}
		return choice;
	}

	public static String studentsInsideCCA(ArrayList<student> slist, ArrayList<CCA> clist, ArrayList<Teacher> tlist,
			int tposition) {
		String output = "";
		output += String.format("CCA NAME: %s\n\n", tlist.get(tposition).getCca_title());
		int number = 0;
		for (int i = 0; i < slist.size(); i++) {
			if (tlist.get(tposition).getCca_title().equals(slist.get(i).getCCA1())
					|| tlist.get(tposition).getCca_title().equals(slist.get(i).getCCA2())
					|| tlist.get(tposition).getCca_title().equals(slist.get(i).getCCA3())) {
				number += 1;
				output += String.format("(%d) %-15s %-10s\n", number, slist.get(i).getName(),
						slist.get(i).getClassroom());
			}
		}

		return output;
	}

	public static void editCCADetails(ArrayList<CCA> ccalist, ArrayList<Teacher> teacherlist,
			ArrayList<student> studentlist, int teacherPosition) {
		boolean loop = true;
		while (loop == true) {
			String information = String.format("%s", teacherlist.get(teacherPosition).toStringCCASpecialwithOptions());
			information += " (5) Exit\n\n";
			System.out.print(information);
			int updateChoice = Helper.readInt("Choose an option to change the details(1-5): ");
			if (updateChoice == 1) {
				System.out.print(String.format("\nCCA TITLE: %s\n", teacherlist.get(teacherPosition).getCca_title()));
				String updatedTitle = Helper.readString("Enter New Title: ");
				boolean loop1 = true;
				while (loop1 == true) {
					char confirm = Helper.readChar("\nConfirm (Y or N)? : ");
					if (confirm == 'Y' || confirm == 'y') {
						for (int i = 0; i < studentlist.size(); i++) {
							if (studentlist.get(i).getCCA1().equals(teacherlist.get(teacherPosition).getCca_title())) {
								studentlist.get(i).setCCA1(updatedTitle);
							} else if (studentlist.get(i).getCCA2()
									.equals(teacherlist.get(teacherPosition).getCca_title())) {
								studentlist.get(i).setCCA2(updatedTitle);
							} else if (studentlist.get(i).getCCA3()
									.equals(teacherlist.get(teacherPosition).getCca_title())) {
								studentlist.get(i).setCCA3(updatedTitle);
							}
						}
						teacherlist.get(teacherPosition).setCca_title(updatedTitle);
						loop1 = false;
					} else if (confirm == 'N' || confirm == 'n') {
						loop1 = false;
					} else {
						System.out.print("Incorrect Input, Please Try again\n\n");
					}
				}
			} else if (updateChoice == 2) {
				System.out.print(
						String.format("\nCCA DESCIPTION: %s\n", teacherlist.get(teacherPosition).getCca_description()));
				String updatedDescription = Helper.readString("Enter New Description: ");
				boolean loop1 = true;
				while (loop1 == true) {
					char confirm = Helper.readChar("\nConfirm (Y or N)? : ");
					if (confirm == 'Y' || confirm == 'y') {
						teacherlist.get(teacherPosition).setCca_description(updatedDescription);
						;
						loop1 = false;
					} else if (confirm == 'N' || confirm == 'n') {
						loop1 = false;
					} else {
						System.out.print("Incorrect Input, Please Try again\n\n");
					}
				}

			} else if (updateChoice == 3) {
				System.out.print(String.format("\nCCA DAY OF THE WEEK: %s\nCCA TIME: %s\n",
						teacherlist.get(teacherPosition).getCca_day_of_the_week(),
						teacherlist.get(teacherPosition).getTime()));
				String updatedDay = "";
				String updatedTime = "";
				boolean complete1 = false;
				while (complete1 == false) {
					int updatedDayInteger = Helper.readInt(
							"\nEnter New Day of the Week \n( 1 - Monday , 2 - Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday ): ");
					if (updatedDayInteger == 1) {
						updatedDay = "Monday";
						complete1 = true;
					} else if (updatedDayInteger == 2) {
						updatedDay = "Tuesday";
						complete1 = true;
					} else if (updatedDayInteger == 3) {
						updatedDay = "Wednesday";
						complete1 = true;
					} else if (updatedDayInteger == 4) {
						updatedDay = "Thursday";
						complete1 = true;
					} else if (updatedDayInteger == 5) {
						updatedDay = "Friday";
						complete1 = true;
					} else {
						System.out.print("Please try again\n\n");
					}

				}
				boolean complete2 = false;
				while (complete2 == false) {
					int updatedDayInteger = Helper
							.readInt("\nEnter New Time ( 1 - Lunch Break , 2 - 3:00PM-4:00PM ): ");
					if (updatedDayInteger == 1) {
						updatedTime = "Lunch Break";
						complete2 = true;
					} else if (updatedDayInteger == 2) {
						updatedTime = "3:00PM-4:00PM";
						complete2 = true;
					} else {
						System.out.print("Please try again\n\n");
					}

				}
				boolean available = true;
				for (int i = 0; i < ccalist.size(); i++) {
					if (ccalist.get(i).getCca_day_of_the_week().equals(updatedDay)) {
						if (ccalist.get(i).getTime().equals(updatedTime)) {
							available = false;
						}
					}
				}
				if (available == true) {
					boolean loop1 = true;
					while (loop1 == true) {
						char confirm = Helper.readChar("\nConfirm (Y or N)? : ");
						if (confirm == 'Y' || confirm == 'y') {
							teacherlist.get(teacherPosition).setCca_day_of_the_week(updatedDay);
							teacherlist.get(teacherPosition).setTime(updatedTime);
							loop1 = false;
						} else if (confirm == 'N' || confirm == 'n') {
							loop1 = false;
						} else {
							System.out.print("Incorrect Input, Please Try again\n\n");
						}
					}
				} else {
					System.out.print("Date / Time clashes with other CCA, Please try again\n\n");
				}

			} else if (updateChoice == 4) {
				System.out.print(String.format("\nCCA VENUE: %s\n", teacherlist.get(teacherPosition).getCca_venue()));
				String updatedVenue = Helper.readString("Enter New Venue: ");
				boolean loop1 = true;
				while (loop1 == true) {
					char confirm = Helper.readChar("\nConfirm (Y or N)? : ");
					if (confirm == 'Y' || confirm == 'y') {
						teacherlist.get(teacherPosition).setCca_venue(updatedVenue);
						;
						loop1 = false;
					} else if (confirm == 'N' || confirm == 'n') {
						loop1 = false;
					} else {
						System.out.print("Incorrect Input, Please Try again\n\n");
					}
				}
			} else if (updateChoice == 5) {
				loop = false;
			} else {
				System.out.print("Incorrect Option, Please Try Again\n\n");
			}
		}
	}

	public static void RegisterStudentP3andBelow(ArrayList<student> studentlist, ArrayList<parent> parentlist) { // Using

		String parentName = "";// Katie
		boolean nameCorrect = false;
		while (nameCorrect == false) {
			parentName = Helper.readString("Enter your name (parent): ");
			String input = parentName.trim();
			Pattern p = Pattern.compile("[a-zA-Z ]+"); // copied from internet
			Matcher m = p.matcher(input);
			boolean matchFound = m.matches();
			if (matchFound) {
				nameCorrect = true;
			} else {
				System.out.print("Incorrect Name Format, Please Try Again (only letters)\n\n");
			}
		}
		int contactNo = 0;
		boolean contactNoCorrect = false;
		while (contactNoCorrect == false) {
			String contactNoString = Helper.readString("Enter your Contact Number (parent): ");
			if (contactNoString.matches("[8-9].*") && contactNoString.length() == 8) {
				contactNo = Integer.parseInt(contactNoString);
				contactNoCorrect = true;
			}
			if (contactNoCorrect == false) {
				System.out.print(
						"Incorrect Number Format, Please Try Again \n(must start with 8 or 9, and only have 8 numbers)\n\n");
			}
		}
		String email = "";
		boolean emailCorrect = false;
		while (emailCorrect == false) {
			email = Helper.readString("Enter your email(parent): ");
			Pattern p = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}"); // copied from internet
			Matcher m = p.matcher(email);
			boolean matchFound = m.matches();
			if (matchFound) {
				emailCorrect = true;
			} else {
				System.out.print("Incorrect Email Format, Please Try Again (must have an @)\n\n");
			}
		}
		int studentRegisteredPosition = -1;
		boolean repeatAddingStudent = true;
		while (repeatAddingStudent == true) {
			boolean studentFound = false;
			while (studentFound == false) {
				String StudentID = Helper.readString("Enter Student ID (enter -1 to exit): ");
				for (int i = 0; i < studentlist.size(); i++) {
					if (studentlist.get(i).getStudentID().equals(StudentID)) {
						studentRegisteredPosition = i;
						studentFound = true;
					}
				}
				if (StudentID.equals("-1")) {
					repeatAddingStudent = false;
					break;
				} else if (studentFound != true) {
					System.out.print("Incorrect Student ID, Please Try Again (make sure 'S' is capital)\n\n");
				}

			}
			char repeatRegistration = 'z';
			if (studentRegisteredPosition != -1) {
				if (studentlist.get(studentRegisteredPosition).isRegistered() == true) {
					System.out.print(
							"It seems like the student has already registered with a parent account\n(one student, one parent)\nPlease log in using this student's ID and the CCA Registration ID that \nwe have send you to your email\n\n");
					break;
				} else {
					studentlist.get(studentRegisteredPosition).setRegistered(true);
					boolean loopCCAID = true;
					while (loopCCAID == true) {
						int min = 100;
						int max = 999;
						int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
						String CCAID = "C123";
						boolean uniqueCCAID = false;
						for (int i = 0; i < studentlist.size(); i++) {
							if (studentlist.get(i).getCCAID().equals(CCAID)) {
								random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
								CCAID = String.format("C%d", random_int);
								uniqueCCAID = true;
								continue;
							} else {
								uniqueCCAID = false;
							}
						}
						if (uniqueCCAID == true) {
							studentlist.get(studentRegisteredPosition).setCCAID(CCAID);
							loopCCAID = false;
						}

					}
					System.out.print("\n");
					C206_CaseStudy.setHeader("EMAIL SENT!!");
					System.out.print(String.format("Student ID: %s\nCCA REGISTRATION ID: %s\n",
							studentlist.get(studentRegisteredPosition).getStudentID(),
							studentlist.get(studentRegisteredPosition).getCCAID()));
					Helper.line(80, "-");
					int familyid = parentlist.size() + 1;
					boolean newParent = true;
					for (int i = 0; i < parentlist.size(); i++) {
						if (parentlist.get(i).getContactNo() == contactNo) {
							newParent = false;
//							String parentName, String email, int contactNo, int familyId
							String currentparentName = parentlist.get(i).getParentName();
							String currentemail = parentlist.get(i).getEmail();
							int currentContactNo = parentlist.get(i).getContactNo();
							int currentfamilyId = parentlist.get(i).getFamilyId();
							studentlist.get(studentRegisteredPosition).setParentName(currentparentName);
							studentlist.get(studentRegisteredPosition).setContactNo(currentContactNo);
							studentlist.get(studentRegisteredPosition).setEmail(currentemail);
							studentlist.get(studentRegisteredPosition).setFamilyId(currentfamilyId);
						}
					}
					if (newParent == true) {
						inputParentForRegistration(parentlist, parentName, email, contactNo, familyid);
						studentlist.get(studentRegisteredPosition).setParentName(parentName);
						studentlist.get(studentRegisteredPosition).setContactNo(contactNo);
						studentlist.get(studentRegisteredPosition).setEmail(email);
						studentlist.get(studentRegisteredPosition).setFamilyId(familyid);
					}
					boolean repeatRegistrationloop = true;
					while (repeatRegistrationloop == true) {
						repeatRegistration = Helper.readChar("\nWould you like to register more students? (Y or N): ");
						if (repeatRegistration == 'Y' || repeatRegistration == 'y') {
							repeatRegistrationloop = false;
							studentRegisteredPosition = -1;
						} else if (repeatRegistration == 'N' || repeatRegistration == 'n') {
							System.out.print("");
							repeatAddingStudent = false;
							repeatRegistrationloop = false;
						} else {
							System.out.print("Incorrect Input Please Try again\n\n");
						}
					}
				}
			}
		}
	}

	public static void RegisterStudentP3andAbove(ArrayList<student> studentlist) {
		int studentRegisteredPosition = -1;
		boolean studentFound = false;
		while (studentFound == false) {
			String StudentID = Helper.readString("Enter Student ID (enter -1 to exit): ");
			for (int i = 0; i < studentlist.size(); i++) {
				if (studentlist.get(i).getStudentID().equals(StudentID)) {
					studentRegisteredPosition = i;
					studentFound = true;
				}
			}
			if (StudentID.equals("-1")) {
				break;
			} else if (studentFound != true) {
				System.out.print("Incorrect Student ID, Please Try Again (make sure 'S' is capital)\n\n");
			}

		}
		if (studentRegisteredPosition != -1) {
			if (studentlist.get(studentRegisteredPosition).isRegistered() == true) {
				System.out.print(
						"It seems like the student has already registered\n(one student, one account)\nPlease log in using this student's ID and the CCA Registration ID that \nwe have send you to your email\n\n");
			} else {
				studentlist.get(studentRegisteredPosition).setRegistered(true);
				boolean loopCCAID = true;
				while (loopCCAID == true) {
					int min = 100;
					int max = 999;
					int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
//					String CCAID = String.format("C%d", random_int);
					String CCAID = "C123";
					boolean sameCCAID = true;
					for (int i = 0; i < studentlist.size(); i++) {
						System.out.print(i);
						if (studentlist.get(i).getCCAID().equals(CCAID)) {
							random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
							CCAID = String.format("C%d", random_int);
						} else {
							sameCCAID = false;
						}
					}
					if (sameCCAID == false) {
						studentlist.get(studentRegisteredPosition).setCCAID(CCAID);
						loopCCAID = false;
					}

				}
				System.out.print("\n");
				C206_CaseStudy.setHeader("EMAIL SENT!!");
				System.out.print(String.format("Student ID: %s\nCCA REGISTRATION ID: %s\n",
						studentlist.get(studentRegisteredPosition).getStudentID(),
						studentlist.get(studentRegisteredPosition).getCCAID()));
				Helper.line(80, "-");
			}
		}
	}

	public static int findSuperUserPositionInList(ArrayList<superUser> superuserlist) {
		int position = -1;
		boolean loop = true;
		while (loop == true) {

			String username = "";
			String password = "";
			String input = "";
			boolean foundUsername = false;
			username = Helper.readString("Enter ID(enter 'exit' to go back to main menu) > ");
			if (username.equalsIgnoreCase("exit")) {
				loop = false;
				return position;
			}
			password = Helper.readString("Enter Password > ");

			for (int i = 0; i < superuserlist.size(); i++) {
				if (superuserlist.get(i).getUsername().equals(username)) {
					foundUsername = true;
					if (superuserlist.get(i).getPassword().equals(password)) {
						position = i;
						loop = false;
					}
				}
			}
			if (foundUsername == false) {
				input += "Incorrect Staff ID / Password, Please Try Again";
				System.out.print(input);
				System.out.print("\n");
				System.out.print("\n");
			} else if (foundUsername == true && position == -1) {
				input += "Incorrect Password, Please Try Again";
				System.out.print(input);
				System.out.print("\n");
				System.out.print("\n");
			}

		}
		return position;
	}

	public static int superUserChoices(ArrayList<superUser> superlist, int position) {
		int option = -1;
		boolean loop = true;
		System.out.print("\n");
		System.out.print(String.format("WELCOME, %s", superlist.get(position).getName()));
		System.out.print("\n");
		while (loop == true) {
			System.out.print("\n (1) Add/View/Delete Student \n");
			System.out.print(" (2) Add/View/Delete CCA \n");
			System.out.print(" (3) Add/View/Delete CCA Category \n");
			System.out.print(" (4) Add/View/Delete Parent \n");
			System.out.print(" (5) Exit\n\n");
			int superuserchoice = Helper.readInt("Select an option (1,2,3,4, or 5): ");
			if (superuserchoice >= 1 && superuserchoice <= 5) {
				option = superuserchoice;
				loop = false;
//				break;
			} else {
				String input = "Incorrect Option, Please Try Again";
				System.out.print(input);
				System.out.print("\n");
				System.out.print("\n");
			}
		}
		return option;
	}

	public static void inputParentForRegistration(ArrayList<parent> parentlist, String parentName, String email, // ash
																													// codes
			int contactNo, int familyid) {
		parent p = new parent(parentName, email, contactNo, familyid);
		addParent(parentlist, p);
	}

	public static String retrieveAllStudent(ArrayList<student> studentList) { // katie codes
		String output = "";

		for (int i = 0; i < studentList.size(); i++) {

			output += String.format("%-84s\n", studentList.get(i).toString());

		}
		return output;
	}

	public static String viewAllStudent(ArrayList<student> studentList) { // katie codes
		System.out.print("\n");
		C206_CaseStudy.setHeader("STUDENT LIST");
		String output = String.format("%-10s %-14s %-10s %-10s %-10s %-10s\n", "Student ID", "Student Name", "GRADE",
				"CLASSROOM", "TEACHER", "REGISTERED?");
		output += retrieveAllStudent(studentList);
		System.out.println(output);
		return output;
	}

	public static int SUchoosecorrectStudentDELETE(ArrayList<student> studentlist) { // katie codes
		int position = -1;
		boolean loop = true;
		while (loop == true) {
			String focusStudent = Helper.readString("Enter the Student ID you wish to delete:");
			for (int i = 0; i < studentlist.size(); i++) {
				if (studentlist.get(i).getStudentID().equals(focusStudent)) {
					position = i;
					loop = false;
				}
			}
			if (position == -1) {
				System.out.print("Please try again\n\n");
			}
		}
		return position;
	}

	public static int SUstudentOptions(ArrayList<student> studentlist) { // ash codes
		int result = -1;
		System.out.print("\n");
		boolean loop = true;
		while (loop == true) {
			System.out.print("(1) Add Student\n");
			System.out.print("(2) Remove Student\n");
			System.out.print("(3) EXIT\n");
			result = Helper.readInt("Please select your option (1,2 or 3): ");
			if (result >= 1 && result <= 3) {
				loop = false;
				return result;
			} else {
				System.out.print("Incorrect option, please try again\n\n");
			}
		}
		return result;
	}

	public static student inputStudent() { // katie codes ash enhancements
		String StudentID = Helper.readString("Enter Student ID: \n");
		String studentName = Helper.readString("Enter Student's Name: \n");
		int StudentGrade = Helper.readInt("Enter Student's Grade: \n");
		String classroom = Helper.readString("Enter Student's Classroom: \n");
		String teacher = Helper.readString("Enter Student's teacher: \n");
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 10;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String fakeCCAID = sb.toString();
		boolean lowerPrimary = true;
		if (StudentGrade > 3) {
			lowerPrimary = false;
		}
		student s = new student("", "", 0, 0, StudentID, studentName, StudentGrade, classroom, teacher, fakeCCAID, "",
				"", "", false, lowerPrimary);
		return s;
	}

	public static void addStudent(ArrayList<student> studentList, student s) { // katie codes
		studentList.add(s);
	}

	public static void deleteStudent(ArrayList<student> studentList, int position) { // katie codes ash enhancement
		studentList.remove(position);
	}
	
	public static void deleteStudent(ArrayList<student> parentlist, student s) { // katie
		parentlist.remove(s);
	}

	public static String retrieveAllCCA(ArrayList<CCA> CCAList) { // sruthi codes ash enhancements
		String output = "";
		for (int i = 0; i < CCAList.size(); i++) {
			output += String.format("%-84s\n", CCAList.get(i).toString());
		}
		return output;
	}

	public static String viewAllCCA(ArrayList<CCA> CCAList) { // sruthi codes ash enhancements
		C206_CaseStudy.setHeader("CCA LIST");
		System.out.print("\n");
		String output = String.format("%-15s %-15s %-15s %-15s %-19s %-15s\n", "CCA ID", "CCA TITLE", "CLASS SIZE",
				"DAY OF WEEK", "TIME", "VENUE");
		output += retrieveAllCCA(CCAList);
		System.out.println(output);
		System.out.print("\n");
		return output;

	}

	public static int SUCCAOptions() {
		int result = -1;
		System.out.print("\n");
		boolean loop = true;
		while (loop == true) {
			System.out.print("(1) Add CCA\n");
			System.out.print("(2) Remove CCA\n");
			System.out.print("(3) EXIT\n");
			result = Helper.readInt("Please select your option (1,2 or 3): ");
			if (result >= 1 && result <= 3) {
				loop = false;
				return result;
			} else {
				System.out.print("Incorrect option, please try again\n\n");
			}
		}
		return result;
	}

	public static CCA inputCCA(ArrayList<CCA> ccalist, ArrayList<CCACategory> ccacatlist) { // sruthi codes ash
																							// enhancements
		viewAllCCACategory(ccacatlist);
		String category_title = "";
		int category_id = 0;
		boolean categoryCorrect = false;
		while (categoryCorrect == false) {
			category_id = Helper.readInt("Enter Category ID > ");
			for (int i = 0; i < ccacatlist.size(); i++) {
				if (ccacatlist.get(i).getcat_ID() == category_id) {
					category_title = ccacatlist.get(i).getTitle();
					categoryCorrect = true;
				}
			}
			if (categoryCorrect == false) {
				System.out.print("Incorrect ID, Please try again\n\n");
			}
		}
		int cca_id = ccalist.size() + 1;
		String ccaTitle = Helper.readString("Enter CCA title > ");
		String ccaDescription = Helper.readString("Enter CCA description > ");
		int ccaClassSize = 0;
		String cca_day_of_the_week = "";
		String time = "";
		boolean complete1 = false;
		while (complete1 == false) {
			int updatedDayInteger = Helper.readInt(
					"\nEnter New Day of the Week \n( 1 - Monday , 2 - Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday ): ");
			if (updatedDayInteger == 1) {
				cca_day_of_the_week = "Monday";
				complete1 = true;
			} else if (updatedDayInteger == 2) {
				cca_day_of_the_week = "Tuesday";
				complete1 = true;
			} else if (updatedDayInteger == 3) {
				cca_day_of_the_week = "Wednesday";
				complete1 = true;
			} else if (updatedDayInteger == 4) {
				cca_day_of_the_week = "Thursday";
				complete1 = true;
			} else if (updatedDayInteger == 5) {
				cca_day_of_the_week = "Friday";
				complete1 = true;
			} else {
				System.out.print("Please try again\n\n");
			}

		}
		boolean complete2 = false;
		while (complete2 == false) {
			int updatedDayInteger = Helper.readInt("\nEnter New Time ( 1 - Lunch Break , 2 - 3:00PM-4:00PM ): ");
			if (updatedDayInteger == 1) {
				time = "Lunch Break";
				complete2 = true;
			} else if (updatedDayInteger == 2) {
				time = "3:00PM-4:00PM";
				complete2 = true;
			} else {
				System.out.print("Please try again\n\n");
			}

		}
		String ccaVenue = Helper.readString("Enter CCA venue > ");
		CCA cca = new CCA(category_title, category_id, cca_id, ccaTitle, ccaDescription, 0, cca_day_of_the_week, time,
				ccaVenue);
		return cca;
	}

	public static void addCCA(ArrayList<CCA> CCAList, CCA cca) {
		CCAList.add(cca);
	}

	public static int SUchoosecorrectCCADELETE(ArrayList<CCA> ccalist) { // sruthi codes ash enhancement
		int position = -1;
		boolean loop = true;
		while (loop == true) {
			int focusCCA = Helper.readInt("Enter the CCA ID you wish to delete:");
			for (int i = 0; i < ccalist.size(); i++) {
				if (ccalist.get(i).getCca_id() == focusCCA) {
					position = i;
					loop = false;
				}
			}
			if (position == -1) {
				System.out.print("Please try again\n\n");
			}
		}
		return position;
	}

	public static void deleteCCA(ArrayList<CCA> CCAList, int position) { // sruthi codes ash enhancements
		CCAList.remove(position);
	}

	public static String retrieveAllCCACategory(ArrayList<CCACategory> categorylist) { // matthew Codes
		String output = "";
		for (int i = 0; i < categorylist.size(); i++) {
			output += String.format("%s\n", categorylist.get(i).toString());
		}
		return output;
	}

	public static String viewAllCCACategory(ArrayList<CCACategory> categorylist) { // matthew Codes
		C206_CaseStudy.setHeader("CCA Categories");
		String output = String.format("%-10s %-10s\n", "CCA ID", "CCA CATEGORY");
		output += retrieveAllCCACategory(categorylist);
		System.out.println(output);
		return output;
	}

	public static int SUCCACATOptions() { // ash codes
		int result = -1;
		System.out.print("\n");
		boolean loop = true;
		while (loop == true) {
			System.out.print("(1) Add CCA Category\n");
			System.out.print("(2) Remove CCA Category\n");
			System.out.print("(3) EXIT\n");
			result = Helper.readInt("Please select your option (1,2 or 3): ");
			if (result >= 1 && result <= 3) {
				loop = false;
				return result;
			} else {
				System.out.print("Incorrect option, please try again\n\n");
			}
		}
		return result;
	}

	public static CCACategory inputCCACategory(ArrayList<CCACategory> ccacatlist) { // matthew codes ash enhancements
		String category_title = Helper.readString("Enter CCA Category Title: \n");
		int category_id = ccacatlist.size() + 1;
		CCACategory ct = new CCACategory(category_title, category_id);
		return ct;
	}

	public static void addCCACategory(ArrayList<CCACategory> categorylist, CCACategory ccaCat) { // matthew codes
		categorylist.add(ccaCat);
	}

	public static int SUchoosecorrectCCACATDELETE(ArrayList<CCACategory> ccacatlist) { // matthew codes ash enhancement
		int position = -1;
		boolean loop = true;
		while (loop == true) {
			int focusCATEGORY = Helper.readInt("Enter the CATEGORY ID you wish to delete:");
			for (int i = 0; i < ccacatlist.size(); i++) {
				if (ccacatlist.get(i).getcat_ID() == focusCATEGORY) {
					position = i;
					loop = false;
				}
			}
			if (position == -1) {
				System.out.print("Please try again\n\n");
			}
		}
		return position;
	}

	public static void deleteCCACategory(ArrayList<CCACategory> categorylist, int position) { // matthew codes
		categorylist.remove(position);
	}

	public static String retrieveAllParent(ArrayList<parent> parentList) {
		String output = "";
		for (int i = 0; i < parentList.size(); i++) {
			output += String.format("%-84s\n", parentList.get(i).toString());
		}
		return output;
	}

	public static String viewAllParent(ArrayList<parent> parentList) {
		C206_CaseStudy.setHeader("PARENT LIST");
		String output = String.format("%-12s %-11s %-11s %-10s\n", "PARENT NAME", "PARENT EMAIL", "CONTACT NO",
				"FAMILY ID");
		output += retrieveAllParent(parentList);
		System.out.println(output);
		return output;
	}

	public static int SUPARENTOptions() { // ash codes
		int result = -1;
		System.out.print("\n");
		boolean loop = true;
		while (loop == true) {
			System.out.print("(1) Add Parent\n");
			System.out.print("(2) Remove Parent\n");
			System.out.print("(3) EXIT\n");
			result = Helper.readInt("Please select your option (1,2 or 3): ");
			if (result >= 1 && result <= 3) {
				loop = false;
				return result;
			} else {
				System.out.print("Incorrect option, please try again\n\n");
			}
		}
		return result;
	}

	public static parent inputParent(ArrayList<parent> parentlist) { // zhuo hong codes
		String parentName = Helper.readString("Enter Parent Name: ");
		String email = Helper.readString("Enter Parent Email: ");
		int contactNo = Helper.readInt("Enter Contact No: ");
		int familyID = parentlist.size();
		
		parent p = new parent(parentName, email, contactNo, familyID);
		return p;
	}

	public static void addParent(ArrayList<parent> parentList, parent p) {
		parentList.add(p);
	}

	public static int SUchoosecorrectPARENTDELETE(ArrayList<parent> parentlist) { // matthew codes ash enhancement
		int position = -1;
		boolean loop = true;
		while (loop == true) {
			int focusFAMILYID = Helper.readInt("Enter the PARENT FAMILY ID you wish to delete:");
			for (int i = 0; i < parentlist.size(); i++) {
				if (parentlist.get(i).getFamilyId() == focusFAMILYID) {
					position = i;
					loop = false;
				}
			}
			if (position == -1) {
				System.out.print("Please try again\n\n");
			}
		}
		return position;
	}

	public static void deleteParent(ArrayList<parent> parentlist, int position) { // matthew codes
		parentlist.remove(position);
	}
	public static void deleteParent(ArrayList<parent> parentlist, parent p) { // matthew codes
		parentlist.remove(p);
	}

}
