package antava;

import java.util.HashMap;
import java.util.ArrayList;

public class PatientDataRepository {
	private HashMap<String, Object> data;
	
	public PatientDataRepository() {
		data = new HashMap<String, Object>();
		
		data.put("firstName", "Enter first name here");
		data.put("lastName", "Enter last name here");
		data.put("birthDay", "Enter birth day");
		data.put("birthMonth", "Enter birth month");
		data.put("birthYear", "Enter birth year");
		data.put("age", "Enter age");
		data.put("phoneNumber", "0-000-000-0000");
		data.put("email", "Enter email here");
		data.put("insuranceCompany", "Enter insurance company here");
		data.put("insurancePhoneNumber", "Enter insurance phone number here");
		data.put("previousHealthIssues", "Enter previous health issues here");
		data.put("immunizationHistory", "Enter immunization history here");
		data.put("currentPrescriptions", "Enter current prescriptions here");
		data.put("visitHistory", new ArrayList<Visit>());
		data.put("bodyTemperature", "Enter body temperature");
		data.put("bloodPressure", "Enter blood pressure");
		data.put("weight", "Enter weight");
		data.put("height", "Emter height");
		data.put("allergies", "Enter allergies here");
		data.put("healthConcerns", "Enter any health concerns here");
		data.put("physicalExamSummaryList", new ArrayList<String>());
		data.put("prescriptions", "Enter any prescriptions here");
	}
	
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
	
	public HashMap<String, Object> getDataRepo() {
		return this.data;
	}
}