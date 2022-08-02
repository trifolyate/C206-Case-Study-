public class CCA extends CCACategory {
	public String cca_title;
	public String cca_description;
	public int cca_class_size;
	public String cca_day_of_the_week;
	public int time;
	public String cca_venue;

	public CCA(String category_title, int category_id, String cca_title, String cca_description, int cca_class_size,
			String cca_day_of_the_week, int time, String cca_venue) {
		super(category_title, category_id);
		this.cca_title = cca_title;
		this.cca_description = cca_description;
		this.cca_class_size = cca_class_size;
		this.cca_day_of_the_week = cca_day_of_the_week;
		this.time = time;
		this.cca_venue = cca_venue;
	}

	public String getCca_title() {
		return cca_title;
	}

	public void setCca_title(String cca_title) {
		this.cca_title = cca_title;
	}

	public String getCca_description() {
		return cca_description;
	}

	public void setCca_description(String cca_description) {
		this.cca_description = cca_description;
	}

	public int getCca_class_size() {
		return cca_class_size;
	}

	public void setCca_class_size(int cca_class_size) {
		this.cca_class_size = cca_class_size;
	}

	public String getCca_day_of_the_week() {
		return cca_day_of_the_week;
	}

	public void setCca_day_of_the_week(String cca_day_of_the_week) {
		this.cca_day_of_the_week = cca_day_of_the_week;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getCca_venue() {
		return cca_venue;
	}

	public void setCca_venue(String cca_venue) {
		this.cca_venue = cca_venue;
	}

	
	
}
