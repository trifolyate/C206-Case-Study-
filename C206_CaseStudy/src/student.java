
public class student extends parent {
	private String studentID;
	private String name;
	private char grade;
	private String classroom;
	private String teacher;
	private String CCA1;
	private String CCA2;
	private String CCA3;
	// in case have two child, same family ID means belongs to the parent, so when
	// logging in, can choose which student will the parent use

	public student(String parentName, String cCAid, String email, int contactNo, String studentID, String name,
			char grade, String classroom, String teacher, String CCA1, String CCA2, String CCA3) {
		super(parentName, cCAid, email, contactNo);
		this.studentID = studentID;
		this.name = name;
		this.grade = grade;
		this.classroom = classroom;
		this.teacher = teacher;
		this.CCA1 = CCA1;
		this.CCA2 = CCA2;
		this.CCA3 = CCA3;
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

	public String getCCA1() {
		return CCA1;
	}

	public void setCCA1(String cCA1) {
		CCA1 = cCA1;
	}

	public String getCCA2() {
		return CCA2;
	}

	public void setCCA2(String cCA2) {
		CCA2 = cCA2;
	}

	public String getCCA3() {
		return CCA3;
	}

	public void setCCA3(String cCA3) {
		CCA3 = cCA3;
	}

	public String toMainStudentString() {
		return "\nStudent ID: " + studentID + "\n Student Name: " + name + "\n Grade(Latest): " + grade + "\n Classroom: "
				+ classroom + "\n Teacher:" + teacher + "\n";
	}

	public String toStudentCCAString() {
		String result = "";
		if (!this.CCA1.isEmpty()) {
			System.out.print(String.format(" CCA 1: %s", getCCA1()));
			if (!this.CCA2.isEmpty()) {
				System.out.print(String.format("\n CCA 2: %s", getCCA2()));
				if (!this.CCA3.isEmpty()) {
					System.out.print(String.format("\n CCA 3: %s", getCCA3()));

				}
			}
		}else {
			System.out.print(String.format(" %s has not registered for any CCA.", name));
		}
		return result;
	}
}
