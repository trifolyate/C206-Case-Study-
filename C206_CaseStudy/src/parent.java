
public class parent extends student{
	private String parentName;
	private String CCAid;
	private String email;
	private int contactNo;
	
	public parent(int ID, String name, char grade, String classroom, String teacher, String parentName, String CCAid, String email, int contactNo) {
		super(ID, name, grade, classroom, teacher);
		this.parentName = parentName;
		this.CCAid = CCAid;
		this.email = email;
		this.contactNo = contactNo;
	}

	public String toString() {
		return String.format("%-10s %-30s %-10s %-10s", getName(), getCCAid(), getEmail(), getContact());
	}
	
	public String getName() {
		return parentName;
	}
	
	public void setName(String parentName) {
		this.parentName = parentName;
	}
	
	public String getCCAid() {
		return CCAid;
	}
	
	public void setPassword(String CCAid) {
		this.CCAid = CCAid;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getContact() {
		return contactNo;
	}
	
	public void setContact(int contactNo) {
		this.contactNo = contactNo;
	}
}
