package antava;


public class Patient extends User {
	public PatientDataRepository patientData;
	private String patientID;
	
	public Patient(Account account) {
		this.account = account;
		this.patientData = new PatientDataRepository();
		this.patientID = "";
	}
	
	 public void createPatientID() {
        String firstName = ((String) patientData.getDataRepo().get("firstName")).toUpperCase();
        String lastName = ((String) patientData.getDataRepo().get("lastName")).toUpperCase();
        String birthDay = (String) patientData.getDataRepo().get("birthDay");
        String birthMonth = (String) patientData.getDataRepo().get("birthMonth");
        String birthYear = (String) patientData.getDataRepo().get("birthYear");
        this.patientID = firstName.substring(0, 1) + firstName.substring(firstName.length() - 1) 
        + birthMonth + lastName.substring(0, 1) + lastName.substring(lastName.length() - 1) + birthDay + birthYear;
	 } 	 
	 
	 public String getPatientID() {
		 return this.patientID;
	 }
	 
	 public void setPatientID(String inputtedPatientID) {
		 this.patientID = inputtedPatientID;
	 }

	    
}