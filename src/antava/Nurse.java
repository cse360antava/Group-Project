package antava;


public class Nurse extends User {
	public PatientDataRepository currentPatient;
	
	public Nurse(Account account) {
		this.account = account;
		this.currentPatient = null;
	}
}