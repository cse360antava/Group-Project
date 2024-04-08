package avanta;

public class Visit {
	private int month;
	private int day;
	private int year;
	private String doctor;
	private String purpose;
	private String notes;
	public Visit(int month, int day, int year, String doctor, String purpose, String notes) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.doctor = doctor;
		this.purpose = purpose;
		this.notes = notes;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public int getYear() {
		return year;
	}
	public String getDoctor() {
		return doctor;
	}
	public String getPurpose() {
		return purpose;
	}
	public String getNotes() {
		return notes;
	}
}