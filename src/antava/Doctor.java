package antava;


public class Doctor extends User {
	public PatientDataRepository currentPatient;
	
	public Doctor(Account account) {
		this.account = account;
		this.currentPatient = null;
	}
}