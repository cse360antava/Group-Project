package antava;

import java.util.List;

public class Doctor extends User 
{
	private PatientDataRepository currentPatient;
	private Account account;
	private MessageManager messager;
		
	
	public Doctor(Account account, PatientDataRepository currentPatient, MessageManager messages) 
	{
		this.account = account;
		this.currentPatient = null;
		this.messager = messages;
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