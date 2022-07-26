public class Teacher extends CCA{
	public String teacher_name;
	public String password;
	
	public Teacher(String cca_title, String cca_description, int cca_class_size, String cca_day_of_the_week, int time,
			String cca_venue, String teacher_name, String password) {
		super(cca_title, cca_description, cca_class_size, cca_day_of_the_week, time, cca_venue);
		this.teacher_name = teacher_name;
		this.password = password;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toStringCca() {
		String output = "";
		output += String.format("CCA Title: %s\nDescription: %s\nClass Size: %d\n"
				+ "Days of the Week: %s\nTime: %d\nVenue: %s\nInstructor-In-Charge: %s"
				,getCca_title(),getCca_description()
				,getCca_class_size(),getCca_day_of_the_week(),getTime(),getCca_venue(),getTeacher_name() );
		return output;
	}

}
