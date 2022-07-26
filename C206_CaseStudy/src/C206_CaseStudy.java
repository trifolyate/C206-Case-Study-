import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 4;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;

	public static void itemTypeMenu() {
		C206_CaseStudy.setHeader("users");
		System.out.println("1. Parent");
		System.out.println("2. Student");
		System.out.println("3. Teacher");
	}

	public static void main(String[] args) {
		ArrayList<student> studentList = new ArrayList<student>();
		ArrayList<parent> parentList = new ArrayList<parent>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		
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
				
				int itemType = Helper.readInt("Enter option to select user type > ");

				if (itemType == 1) {
					// Add a student
					//student student = inputStudent();
					//C206_CaseStudy.addStudent(studentList, student);
					//System.out.println("Student added");

				} else if (itemType == 2) {
					// Add a parent
					//parent parent = inputParent();
					//C206_CaseStudy.addParent(parentList, parent);
					//System.out.println("Parent added");
					
				} else if (itemType == 3) {
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
					
					int itemType = Helper.readInt("Enter option to select user type > ");

					if (itemType == 1) {
						// Delete a student			
						//System.out.println("Student deleted");

					} else if (itemType == 2) {
						// Delete a parent					
						//System.out.println("Parent deleted");
						
					} else if (itemType == 3) {
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
	
	//================================= Option 1 View items (CRUD- Read) =================================
		public static String retrieveAllParent(ArrayList<parent> parentList) {
			String output = "";

			for (int i = 0; i < parentList.size(); i++) {
				
				output += String.format("%-84s\n", parentList.get(i).toString());

			}
			return output;
		}
		public static void viewAllParent(ArrayList<parent> parentList) {
			C206_CaseStudy.setHeader("PARENT LIST");
			String output = String.format("%-10s %-30s %-10s %-10s %-20s %-10s %-10s %-10s\n", "CHILD ID", "CHILD NAME",
					"CHILD GRADE", "CHILD CLASS","CHILD TEACHER", "NAME", "CCA ID", "EMAIL", "CONTACT NO");
			 output += retrieveAllParent(parentList);	
			System.out.println(output);
		}
		//does this work?



}
