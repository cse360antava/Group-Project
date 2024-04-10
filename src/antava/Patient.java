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
        this.patientID = birthYear + firstName + birthMonth + lastName + birthDay;
	 } 	 
	 
	 public String getPatientID() {
		 return this.patientID;
	 }
	 
	 public void setPatientID(String inputtedPatientID) {
		 this.patientID = inputtedPatientID;
	 }
	 
	 public String getID() {
		 return getPatientID();
	 }

	    
}