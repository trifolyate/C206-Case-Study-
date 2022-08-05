
public class CCACategory {

	private String category_title;
	private int category_id;

	public CCACategory(String category_title, int category_id) {
		this.category_title = category_title;
		this.category_id = category_id;

	}

	public String getTitle() {
		return category_title;
	}

	public void setTitle(String category_title) {
		this.category_title = category_title;
	}

	public int getcat_ID() {
		return category_id;
	}

	public void setcat_ID(int category_id) {
		this.category_id = category_id;
	}
	// test

}
