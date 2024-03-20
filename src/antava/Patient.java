package antava;

public class Patient extends User {
	public PatientDataRepository patientData;
	//TODO: implement patient ID from requirements, made from bday, first & last name
	
	public Patient(Account account) {
		this.account = account;
		this.patientData = new PatientDataRepository();
		this.messager = new MessageManager();
		this.messager.setOwnerUID(account.getUID());
	}
}