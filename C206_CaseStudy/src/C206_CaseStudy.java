import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 3;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;

	public static void itemTypeMenu() {
		C206_CaseStudy.setHeader("users");
		System.out.println("1. Parent");
		System.out.println("2. Student");
		System.out.println("3. Teacher");
	}

	public static void main(String[] args) {
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<parent> parentList = new ArrayList<parent>();
		//ArrayList<teacher> teacherList = new ArrayList<teacher>();
		
		int option = 0;

		while (option != OPTION_QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				// View all items
				//C206_CaseStudy.viewAllStudent(studentList);
				//C206_CaseStudy.viewAllChromebook(parentList);
			}
			else if (option == OPTION_ADD) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");			
				C206_CaseStudy.itemTypeMenu();
				
				int itemType = Helper.readInt("Enter option to select user type > ");

				if (itemType == 1) {
					// Add a student
					//student student = inputStudent();
					//C206_CaseStudy.addStudent(studentList, student);
					System.out.println("Camcorder added");

				} else if (itemType == 2) {
					// Add a parent
					//parent parent = inputParent();
					//C206_CaseStudy.addChromebook(parentList, parent);
					System.out.println("Chromebook added");

				} else {
					System.out.println("Invalid type");
			}} else if (option == OPTION_QUIT) {
					System.out.println("Bye!");
				} else {
					System.out.println("Invalid option");
				}

			}
		
	}

	public static void menu() {
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. View user");
		System.out.println("2. Add user");
		System.out.println("3. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

}
