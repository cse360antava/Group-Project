package antava;

import java.util.HashMap;
import java.util.ArrayList;

public class PatientDataRepository {
	private HashMap<String, Object> data;
	
	public PatientDataRepository() {
		data = new HashMap<String, Object>();
		
		data.put("firstName", "Enter first name here");
		data.put("middleName", "Enter middle name here");
		data.put("lastName", "Enter last name here");
		data.put("birthDay", 0);
		data.put("birthMonth", 0);
		data.put("birthYear", 0);
		data.put("Age", 0);
		data.put("phoneNumber", "0-000-000-0000");
		data.put("email", "Enter email here");
		data.put("insuranceCompany", "Enter insurance company here");
		data.put("insurancePhoneNumber", "Enter insurance phone number here");
		data.put("previousHealthIssues", "Enter previous health issues here");
		data.put("immunizationHistory", "Enter immunization history here");
		data.put("currentPrescriptions", "Enter current prescriptions here");
		data.put("visitHistory", new ArrayList<Visit>());
		data.put("bodyTemperature", 0);
		data.put("bloodPressure", 0);
		data.put("weight", 0);
		data.put("height", 0);
		data.put("allergies", "Enter allergies here");
		data.put("healthConcerns", "Enter any health concerns here");
		data.put("physicalExamSummaryList", new ArrayList<String>());
		data.put("prescriptions", "Enter any prescriptions here");
		//unsure if I missed any fields, if so let me know or just add it -Chris
	}
	/*
	 * Decided pretty arbitrarily to add boolean return type to these functions
	 * so if you want to remove them for any reason go ahead -Chris
	 * */
	public boolean addPatientData(String key, Object value) {
		try {
			data.put(key, value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean editPatientData(String key, Object value) {
		try {
			data.replace(key, value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean removePatientData(String key) {
		try {
			data.remove(key);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}