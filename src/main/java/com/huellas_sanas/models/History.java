package com.huellas_sanas.models;

public class History {

    private String id;
    private String pet_id;
    private String appointment_id;
    private String diagnosis;

    public History(String pet_id, String appointment_id, String diagnosis) {

        this.pet_id = pet_id;
        this.appointment_id = appointment_id;
        this.diagnosis = diagnosis;

    }

    public String getPet_id() {
        return pet_id;
    }

    public String getAppointment_id() {
        return appointment_id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
}
