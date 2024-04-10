package antava;


public class Visit {
	private String date;
    private String temperature;
    private String bloodPressure;
    private String weight;
    private String height;
    private String allergies;
    private String healthConcerns;
    private String HEENNT;
    private String gastro;
    private String cardio;
    private String resp;
    private String skin;
    private String muscle;
    private String neuro;
    private String psych;
    private String finalAssessment;
    private String summary;
    private String prescriptions;

    public Visit(String date, String temperature, String bloodPressure, 
    		String weight, String height, String allergies,  String healthConcerns, 
    		String HEENNT, String gastro, String cardio, String resp, String skin,
    		String muscle, String neuro, String psych, 
    		String finalAssessment, String summary,  String prescriptions) {
    	
        this.date = date;
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
        this.weight = weight;
        this.height = height;
        this.allergies = allergies;
        this.healthConcerns = healthConcerns;
        this.HEENNT = HEENNT;
        this.gastro = gastro;
        this.cardio = cardio;
        this.resp = resp;
        this.skin = skin;
        this.muscle = muscle;
        this.neuro = neuro;
        this.psych = psych;
        this.finalAssessment = finalAssessment;
        this.summary = summary;
        this.prescriptions = prescriptions;
    }
    
    public String getPatientVisit() {
    	String patientVisit = "Date Of Visit: " + this.date + "\n" + "Visit Summary: " + this.summary + "\n\n";
		return patientVisit;
    }
    
    public String getAllVisitInfo() {
    	 String visit =  	"Date Of Visit: " + this.date + "\n" +
		    	            "Temperature: " + this.temperature + "\n" +
		    	            "Blood Pressure: " + this.bloodPressure + "\n" +
		    	            "Weight: " + this.weight + "\n" +
		    	            "Height: " + this.height + "\n" +
		    	            "Allergies: " + this.allergies + "\n" +
		    	            "Health Concerns: " + this.healthConcerns + "\n" +
		    	            "HEENNT: " + this.HEENNT + "\n" +
		    	            "Gastrointestinal: " + this.gastro + "\n" +
		    	            "Cardiovascular: " + this.cardio + "\n" +
		    	            "Respiratory: " + this.resp + "\n" +
		    	            "Skin: " + this.skin + "\n" +
		    	            "Musculoskeletal: " + this.muscle + "\n" +
		    	            "Neurological: " + this.neuro + "\n" +
		    	            "Psychiatric: " + this.psych + "\n" +
		    	            "Final Assessment: " + this.finalAssessment + "\n" +
		    	            "Summary: " + this.summary + "\n" +
		    	            "Medication Prescribed: " + this.prescriptions + "\n\n";
    	 return visit;
    }
    
    // Getters and Setters
    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getBloodPressure() {
        return this.bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAllergies() {
        return this.allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getHealthConcerns() {
        return this.healthConcerns;
    }

    public void setHealthConcerns(String healthConcerns) {
        this.healthConcerns = healthConcerns;
    }

    public String getHEENNT() {
        return this.HEENNT;
    }

    public void setHEENNT(String HEENNT) {
        this.HEENNT = HEENNT;
    }

    public String getGastro() {
        return this.gastro;
    }

    public void setGastro(String gastro) {
        this.gastro = gastro;
    }

    public String getCardio() {
        return this.cardio;
    }

    public void setCardio(String cardio) {
        this.cardio = cardio;
    }

    public String getResp() {
        return this.resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getSkin() {
        return this.skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getMuscle() {
        return this.muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getNeuro() {
        return this.neuro;
    }

    public void setNeuro(String neuro) {
        this.neuro = neuro;
    }

    public String getPsych() {
        return this.psych;
    }

    public void setPsych(String psych) {
        this.psych = psych;
    }

    public String getFinalAssessment() {
        return this.finalAssessment;
    }

    public void setFinalAssessment(String finalAssessment) {
        this.finalAssessment = finalAssessment;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    
    public String getPrescriptions() {
        return this.prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }
	
}