public class parent {

	private String parentName;
	private String CCAid;
	private String email;
	private int contactNo;

	public parent(String parentName, String cCAid, String email, int contactNo) {
		this.parentName = parentName;
		CCAid = cCAid;
		this.email = email;
		this.contactNo = contactNo;
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

}
