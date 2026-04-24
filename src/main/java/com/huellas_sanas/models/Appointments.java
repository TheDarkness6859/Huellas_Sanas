package com.huellas_sanas.models;

import java.time.*;

public class Appointments {

    private String id;
    private LocalDate app_date;
    private LocalTime app_time;
    private String status;
    private String pet_id;
    private String veterinarian_id;

    public Appointments(LocalDate app_date, LocalTime app_time, String status, String pet_id, String veterinarian_id) {

        this.app_date = app_date;
        this.app_time = app_time;
        this.status = status;
        this.pet_id = pet_id;
        this.veterinarian_id = veterinarian_id;

    }

    public LocalDate getApp_date() {
        return app_date;
    }

    public LocalTime getApp_time() {
        return app_time;
    }

    public String getStatus() {
        return status;
    }

    public String getPet_id() {
        return pet_id;
    }

    public String getVeterinarian_id() {
        return veterinarian_id;
    }
}
