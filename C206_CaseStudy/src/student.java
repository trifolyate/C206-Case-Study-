
public class student extends parent { // for P3 and below
	private String studentID;
	private String name;
	private int grade;
	private String classroom;
	private String teacher;
	private String CCAID;
	private String CCA1;
	private String CCA2;
	private String CCA3;
	private boolean registered;
	private boolean lowerPrimary;

	//test

	public student(String parentName, String email, int contactNo, int familyId, String studentID, String name,
			int grade, String classroom, String teacher, String cCAID, String cCA1, String cCA2, String cCA3,
			boolean registered, boolean lowerPrimary) {
		super(parentName, email, contactNo, familyId);
		this.studentID = studentID;
		this.name = name;
		this.grade = grade;
		this.classroom = classroom;
		this.teacher = teacher;
		CCAID = cCAID;
		CCA1 = cCA1;
		CCA2 = cCA2;
		CCA3 = cCA3;
		this.registered = registered;
		this.lowerPrimary = lowerPrimary;
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

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
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

	public String getCCAID() {
		return CCAID;
	}

	public void setCCAID(String cCAID) {
		CCAID = cCAID;
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
	
	public boolean isRegistered() {
		return registered;
	}
	
	public String getStringRegistered() {
		String output = "";
		if(this.registered == true)
		{
			output = "true";
		} else
		{
			output = "false";
		}
		return output;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	
	public boolean isLowerPrimary() {
		return lowerPrimary;
	}
	
	public String getStringLowerPrimary() {
		String output = "";
		if(this.lowerPrimary == true)
		{
			output = "true";
		} else
		{
			output = "false";
		}
		return output;
	}
	
	public void setLowerPrimary(boolean lowerPrimary) {
		this.lowerPrimary = lowerPrimary;
	}

	public String toMainStudentString() {
		return "\nStudent ID: " + studentID + "\n Student Name: " + name + "\n Grade: " + grade + "\n Classroom: "
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
		} else {
			System.out.print(String.format(" %s has not registered for any CCA.", name));
		}
		return result;
	}

	public String toStudentCCASpecialString() {
		String result = "";
		if (!this.CCA1.isEmpty()) {
			System.out.print(String.format(" (1) CCA 1: %s", getCCA1()));
			if (!this.CCA2.isEmpty()) {
				System.out.print(String.format("\n (2) CCA 2: %s", getCCA2()));
				if (!this.CCA3.isEmpty()) {
					System.out.print(String.format("\n (3) CCA 3: %s", getCCA3()));

				}
			}
		} else {
			System.out.print(String.format(" %s has not registered for any CCA.", name));
		}
		return result;
	}

	@Override
	public String toString() {
		String output = String.format("%-10s %-14s %-10d %-10s %-10s %-10s\n", this.studentID, this.name, this.grade,this.classroom, this.teacher,this.getStringRegistered());
		return output;
	}
	
	
}
