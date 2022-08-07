import java.util.ArrayList;

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

		studentList.add(new student("Ash Parent 1", "ash@gmail.com", 1234, 1, "S123", "Ash Kid 1", 3, "3A", "MS THAMMY",
				"C123", "Soccer", "", ""));
		studentList.add(new student("Ash Parent 2", "ash@gmail.com", 1234, 2, "S456", "Ash Kid 2", 4, "4F", "Teacher",
				"C456", "Soccer", "CCA2", "CCA3"));
		studentList.add(new student("Ash 3", "ash@gmail.com", 1234, 2, "S789", "Ash Kid 3", 3, "3D", "Teacher", "C789",
				"CCA1", "CCA2", ""));
		studentList.add(new student("Ash 4", "ash@gmail.com", 1234, 3, "S987", "Ash Kid 4", 6, "6B", "Teacher", "C987",
				"CCA1", "CCA2", "CCA3"));
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
				} else if (userOption == 2) {
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
								System.out.print(teacherOption);
							}
						}
					}

				} else if (userOption == 3) {

				} else if (userOption == 4) { // empty means it will go back to Main Page
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
		System.out.print("\n");
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
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getFamilyId() == (list.get(studentPositionInList).getFamilyId())) { // prints
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
				// CCAID
				// would
				// mean that
				// they are
				// related
				String message = String.format(" %s", list.get(i).toMainStudentString());
				System.out.print(message);
				list.get(i).toStudentCCAString();
				System.out.print("\n\n");
			}
		}
		while (loop == true) {

			String focusStudent = Helper.readString("Enter the Student ID you wish to focus on:");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getStudentID().equals(focusStudent)
						&& list.get(studentPositionInList).getFamilyId() == list.get(i).getFamilyId()) {
					position = i;
					loop = false;
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

	public static String retrieveCCADetails(ArrayList<CCA> CCAList, int ccaID) {
		String output = "";
		for (int i = 0; i < CCAList.size(); i++) {
			if (CCAList.get(i).getCca_id() == ccaID)
				output += String.format("Test");
		}
		return output;
	}

	public static String retrieveAllCCA(ArrayList<CCA> CCAList) {
		String output = "";
		for (int i = 0; i < CCAList.size(); i++) {
			output += String.format("%-84s\n", CCAList.get(i).toString());
		}
		return output;
	}

	public static String viewAllCCA(ArrayList<CCA> CCAList) {
		C206_CaseStudy.setHeader("CCA LIST");
		System.out.print("\n");
		String output = String.format("%-15s %-15s %-15s %-15s %-19s %-15s\n", "CCA ID", "CCA TITLE", "CLASS SIZE",
				"DAY OF WEEK", "TIME", "VENUE");
		output += retrieveAllCCA(CCAList);
		System.out.println(output);
		System.out.print("\n");
		return output;

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
				input += "Incorrect Staff ID, Please Try Again";
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
			int teacherchoice = Helper.readInt("Select an option (1,2, or 3): ");
			if (teacherchoice == 1 || teacherchoice == 2 || teacherchoice == 3) {
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
						for(int i = 0;i < studentlist.size();i++)
						{
							if(studentlist.get(i).getCCA1().equals(teacherlist.get(teacherPosition).getCca_title())) {
								studentlist.get(i).setCCA1(updatedTitle);
							} else if(studentlist.get(i).getCCA2().equals(teacherlist.get(teacherPosition).getCca_title())) {
								studentlist.get(i).setCCA2(updatedTitle);
							} else if(studentlist.get(i).getCCA3().equals(teacherlist.get(teacherPosition).getCca_title())) {
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
				System.out.print(
						String.format("\nCCA VENUE: %s\n", teacherlist.get(teacherPosition).getCca_venue()));
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
