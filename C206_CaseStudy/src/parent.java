
public class parent extends student {
	private String parentName;
	private String CCAid;
	private String email;
	private int contactNo;
	private String FamilyID; // in case have two child, same family ID means belongs to the parent, so when
								// logging in, can choose which student will the parent use

	public parent(String studentID, String name, char grade, String classroom, String teacher, String cCA1, String cCA2,
			String cCA3, String parentName, String cCAid, String email, int contactNo, String familyID) {
		super(studentID, name, grade, classroom, teacher, cCA1, cCA2, cCA3);
		this.parentName = parentName;
		CCAid = cCAid;
		this.email = email;
		this.contactNo = contactNo;
		FamilyID = familyID;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getCCAid() {
		return CCAid;
	}

	public void setCCAid(String cCAid) {
		CCAid = cCAid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getFamilyID() {
		return FamilyID;
	}

	public void setFamilyID(String familyID) {
		FamilyID = familyID;
	}

	public String toString() {
		return String.format("%-10s %-30s %-10s %-10s", getName(), getCCAid(), getEmail(), getContactNo());
	}

}
