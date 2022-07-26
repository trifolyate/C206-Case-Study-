
public class student {
	private int ID;
	private String name;
	private char grade;
	private String classroom;
	private String teacher;
	public student(int ID, String name, char grade, String classroom, String teacher) {
		this.ID = ID;
		this.name = name;
		this.grade = grade;
		this.classroom = classroom;
		this.teacher = teacher;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
