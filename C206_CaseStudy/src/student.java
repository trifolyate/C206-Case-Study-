
public class student {
	private String studentID;
	private String name;
	private char grade;
	private String classroom;
	private String teacher;

	

	public student(String studentID, String name, char grade, String classroom, String teacher) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.grade = grade;
		this.classroom = classroom;
		this.teacher = teacher;
	}
	
	
	public String getStudentID() {
		return studentID;
	}


	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

}
