  package antava;


public class Nurse extends User {
	public Patient currentPatient;
	
	public Nurse(Account account) {
		this.account = account;
		this.currentPatient = null;
	}
	
	public void setPatient(String inputtedPatientID) {
				
		for(User user : Main.userList.values()) {
			if(user instanceof Patient) {
				Patient patient = (Patient) user;
				if(patient.getPatientID().compareTo(inputtedPatientID) == 0) {
					this.currentPatient = patient;
				}
			}
		}
	}
	
	public Patient getPatient() {
		return this.currentPatient;
	}
}