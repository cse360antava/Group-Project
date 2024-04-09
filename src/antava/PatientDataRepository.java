package antava;

import java.util.HashMap;
import java.util.ArrayList;

public class PatientDataRepository {
	private HashMap<String, Object> data;
	
	public PatientDataRepository() {
		data = new HashMap<String, Object>();
		
		//added the following to the HashMap:
			//Patient Information, Physical Exam Report, and Order Prescription fields
		
		data.put("firstName", "Enter first name here");
		data.put("middleName", "Enter middle name here"); 
		data.put("lastName", "Enter last name here");
		data.put("birthDay", 0);
		data.put("birthMonth", 0);
		data.put("birthYear", 0);
		data.put("phoneNumber", "0-000-000-0000");
		data.put("email", "Enter email here");
		data.put("insuranceCompany", "Enter insurance company here");
		data.put("insurancePhoneNumber", "Enter insurance phone number here");
		data.put("previousMedicalHistory", "Enter previous medical history here");
		data.put("visitHistory", new ArrayList<Visit>());
		data.put("pulseRate", 0);		
		data.put("bloodOxygen", 0);
		data.put("bloodGlucoseLevel", 0);
		data.put("allergies", "Enter allergies here");
		data.put("healthConcerns", "Enter any health concerns here");
		data.put("prescriptions", "Enter any prescriptions here");
		//unsure if I missed any fields, if so let me know or just add it -Chris
		
		//DoctorView: Patient Information
		data.put("patientName", "Enter patient name here");
		data.put("patientAge", 0);
		data.put("bodyTemperature", 0);
		data.put("weight", 0);
		data.put("height", 0);
		data.put("bloodPressure", 0);
		data.put("previousHealthConcerns", "Enter health concerns here");
		data.put("previousMedication", "Enter medication here");
		data.put("immunizationHistory", "Enter immunziations here");
		//DoctorView: Physical Exam Report
		data.put("HEENNT", "Enter HEENNT concerns here");
		data.put("cardiovascular", "Enter cardiovascular concerns here");
		data.put("respiratory", 0);
		data.put("gastrointestinal", "Enter gastro concerns here");
		data.put("musculoskeletal", "Enter muscu concerns here");
		data.put("neurological", "Enter neuro concerns here");
		data.put("skin", "Enter skin concerns here");
		data.put("psychiatric", "Enter psych concerns here");
		data.put("finalAssessment", "Enter final assessment here");
		data.put("summary", "Enter summary here");
		//DoctorView: Order Prescription 
		data.put("prescriptionName", "Enter prescription name here");
		data.put("dosage", "Enter dosage amount here");
		data.put("duration", "Enter duration time here");
		data.put("notes", "Enter notes here");
		
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