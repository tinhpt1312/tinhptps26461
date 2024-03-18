package UI;

import java.util.Date;

public class Staff {
	private String fullname;
	private Date birthday;
	private boolean gender;
	private String country;
	private boolean married;
	private String[] hobbies;
	private String notes;
	
	
	
	public Staff(String fullname, Date birthday, boolean gender, String country, boolean married, String[] hobbies,
			String notes) {
		super();
		this.fullname = fullname;
		this.birthday = birthday;
		this.gender = gender;
		this.country = country;
		this.married = married;
		this.hobbies = hobbies;
		this.notes = notes;
	}
	
	public Staff() {
		super();
	}
	
	
	public String getFullname() {
		return fullname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public boolean isGender() {
		return gender;
	}
	public String getCountry() {
		return country;
	}
	public boolean isMarried() {
		return married;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public String getNotes() {
		return notes;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
