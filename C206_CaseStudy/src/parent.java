public class parent {

	private String parentName;
	private String email;
	private int contactNo;
	private int familyId;

	

	public parent(String parentName, String email, int contactNo, int familyId) {
		this.parentName = parentName;
		this.email = email;
		this.contactNo = contactNo;
		this.familyId = familyId;
	}


	public int getFamilyId() {
		return familyId;
	}


	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}


	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
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


	@Override
	public String toString() {
		String output = String.format("%-10s %-10s %-10d %-10d\n",this.parentName,this.email,this.contactNo,this.familyId);
		return output;
	}
	
	
}
