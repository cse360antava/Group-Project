package antava;

import java.util.HashMap;
import java.util.ArrayList;

public class PatientDataRepository {
	private HashMap<String, Object> data;
	
	public PatientDataRepository() {
		data = new HashMap<String, Object>();
		
		data.put("patientID", "");
		data.put("firstName", "");
		data.put("lastName", "");
		data.put("birthDay", "");
		data.put("birthMonth", "");
		data.put("birthYear", "");
		data.put("age", "");
		data.put("phoneNumber", "");
		data.put("email", "");
		data.put("insuranceCompany", "");
		data.put("pharmacy", "");
		data.put("previousHealthIssues", "");
		data.put("immunizationHistory", "");
		data.put("currentPrescriptions", "");
		data.put("bodyTemperature", "");
		data.put("bloodPressure", "");
		data.put("weight", "");
		data.put("height", "");
		data.put("allergies", "");
		data.put("healthConcerns", "");
		data.put("HEENNT", "");
		data.put("gastro", "");
		data.put("cardio", "");
		data.put("resp", "");
		data.put("skin", "");
		data.put("muscle", "");
		data.put("neuro", "");
		data.put("psych", "");
		data.put("finalAssessment", "");
		data.put("summary", "");
		data.put("prescriptions", "");
		data.put("visitDate", "");
		data.put("visitHistory", new ArrayList<Visit>());
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