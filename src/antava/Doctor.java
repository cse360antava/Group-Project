package antava;

import java.util.List;

public class Doctor extends User 
{
	private PatientDataRepository currentPatient;
	private MessageManager messages;
		
	
	public Doctor(Account account, PatientDataRepository currentPatient, MessageManager messages) 
	{
		this.account = account;
		this.currentPatient = null;
		this.messages = messages;
	}
	
	//Getter
	public PatientDataRepository getCurrentPatient()
	{
		return currentPatient;
	}
	
	//Setter
	public void setCurrentPatient(PatientDataRepository currentPatient)
	{
		this.currentPatient = currentPatient;
	}
}