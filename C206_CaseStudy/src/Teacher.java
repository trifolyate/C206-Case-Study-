public class Teacher extends CCA {
	private String staffId;
	private String teacher_name;
	private String password;

	public Teacher(String category_title, int category_id, int cca_id, String cca_title, String cca_description,
			int cca_class_size, String cca_day_of_the_week, String time, String cca_venue, String staffId,
			String teacher_name, String password) {
		super(category_title, category_id, cca_id, cca_title, cca_description, cca_class_size, cca_day_of_the_week,
				time, cca_venue);
		this.staffId = staffId;
		this.teacher_name = teacher_name;
		this.password = password;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
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
//	public String toStringTeacherDetaisl()
//	{
//		String output = "";
//		output += String.format("Welcome,", null)
//		return output;
//	}
	public String toStringCca() {
		String output = "";
		output += 
				String.format(
				"CCA Title: %s\nDescription: %s\nClass Size: %d\n"
						+ "Days of the Week: %s\nTime: %d\nVenue: %s\n",
				getCca_title(), getCca_description(), getCca_class_size(), getCca_day_of_the_week(), getTime(),
				getCca_venue());
		return output;
	}
	
}
