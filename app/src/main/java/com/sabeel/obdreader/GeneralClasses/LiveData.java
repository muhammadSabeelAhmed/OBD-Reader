package com.sabeel.obdreader.GeneralClasses;

import javax.xml.transform.sax.SAXResult;

public class LiveData {
    private String email;
    private String type;
    private String model;
    private String engine;
    private String year;
    private String time;
    private String lat;
    private String lon;
    private String alt;
    private String v_id;
    private String baro_pressure;
    private String eng_cool_temp;
    private String fuel_leve;
    private String eng_load;
    private String amb_air_temp;
    private String eng_rpm;
    private String intake_manifold_pressure;
    private String maf;
    private String term_fuel_trim_bank1;
    private String fuel_eco;
    private String long_term_fuel_trim_bank2;
    private String fuel_type;
    private String air_intake_temp;
    private String fuel_pressure;
    private String speed;
    private String short_term_fuel_trim_bank2;
    private String short_term_fuel_trim_bank1;
    private String engine_runtime;
    private String throttle_pos;
    private String dtc_number;
    private String trouble_codes;
    private String timing_advance;
    private String equiv_ratio;

    public LiveData(String email, String type, String model, String engine, String year, String time, String lat, String lon, String alt, String v_id, String baro_pressure, String eng_cool_temp, String fuel_leve, String eng_load, String amb_air_temp, String eng_rpm, String intake_manifold_pressure, String maf, String term_fuel_trim_bank1, String fuel_eco, String long_term_fuel_trim_bank2, String fuel_type, String air_intake_temp, String fuel_pressure, String speed, String short_term_fuel_trim_bank2, String short_term_fuel_trim_bank1, String engine_runtime, String throttle_pos, String dtc_number, String trouble_codes, String timing_advance, String equiv_ratio) {
        this.email = email;
        this.type = type;
        this.model = model;
        this.engine = engine;
        this.year = year;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.v_id = v_id;
        this.baro_pressure = baro_pressure;
        this.eng_cool_temp = eng_cool_temp;
        this.fuel_leve = fuel_leve;
        this.eng_load = eng_load;
        this.amb_air_temp = amb_air_temp;
        this.eng_rpm = eng_rpm;
        this.intake_manifold_pressure = intake_manifold_pressure;
        this.maf = maf;
        this.term_fuel_trim_bank1 = term_fuel_trim_bank1;
        this.fuel_eco = fuel_eco;
        this.long_term_fuel_trim_bank2 = long_term_fuel_trim_bank2;
        this.fuel_type = fuel_type;
        this.air_intake_temp = air_intake_temp;
        this.fuel_pressure = fuel_pressure;
        this.speed = speed;
        this.short_term_fuel_trim_bank2 = short_term_fuel_trim_bank2;
        this.short_term_fuel_trim_bank1 = short_term_fuel_trim_bank1;
        this.engine_runtime = engine_runtime;
        this.throttle_pos = throttle_pos;
        this.dtc_number = dtc_number;
        this.trouble_codes = trouble_codes;
        this.timing_advance = timing_advance;
        this.equiv_ratio = equiv_ratio;
    }

    public LiveData(String time, String lat, String lon, String alt, String v_id, String baro_pressure, String eng_cool_temp, String fuel_leve, String eng_load, String amb_air_temp, String eng_rpm, String intake_manifold_pressure, String maf, String term_fuel_trim_bank1, String fuel_eco, String long_term_fuel_trim_bank2, String fuel_type, String air_intake_temp, String fuel_pressure, String speed, String short_term_fuel_trim_bank2, String short_term_fuel_trim_bank1, String engine_runtime, String throttle_pos, String dtc_number, String trouble_codes, String timing_advance, String equiv_ratio) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
        this.v_id = v_id;
        this.baro_pressure = baro_pressure;
        this.eng_cool_temp = eng_cool_temp;
        this.fuel_leve = fuel_leve;
        this.eng_load = eng_load;
        this.amb_air_temp = amb_air_temp;
        this.eng_rpm = eng_rpm;
        this.intake_manifold_pressure = intake_manifold_pressure;
        this.maf = maf;
        this.term_fuel_trim_bank1 = term_fuel_trim_bank1;
        this.fuel_eco = fuel_eco;
        this.long_term_fuel_trim_bank2 = long_term_fuel_trim_bank2;
        this.fuel_type = fuel_type;
        this.air_intake_temp = air_intake_temp;
        this.fuel_pressure = fuel_pressure;
        this.speed = speed;
        this.short_term_fuel_trim_bank2 = short_term_fuel_trim_bank2;
        this.short_term_fuel_trim_bank1 = short_term_fuel_trim_bank1;
        this.engine_runtime = engine_runtime;
        this.throttle_pos = throttle_pos;
        this.dtc_number = dtc_number;
        this.trouble_codes = trouble_codes;
        this.timing_advance = timing_advance;
        this.equiv_ratio = equiv_ratio;
    }

    public LiveData(String baro_pressure, String eng_cool_temp, String fuel_leve, String eng_load, String amb_air_temp, String eng_rpm, String intake_manifold_pressure, String maf, String term_fuel_trim_bank1, String fuel_eco, String long_term_fuel_trim_bank2, String fuel_type, String air_intake_temp, String fuel_pressure, String speed, String short_term_fuel_trim_bank2, String short_term_fuel_trim_bank1, String engine_runtime, String throttle_pos, String dtc_number, String trouble_codes, String timing_advance, String equiv_ratio) {
        this.baro_pressure = baro_pressure;
        this.eng_cool_temp = eng_cool_temp;
        this.fuel_leve = fuel_leve;
        this.eng_load = eng_load;
        this.amb_air_temp = amb_air_temp;
        this.eng_rpm = eng_rpm;
        this.intake_manifold_pressure = intake_manifold_pressure;
        this.maf = maf;
        this.term_fuel_trim_bank1 = term_fuel_trim_bank1;
        this.fuel_eco = fuel_eco;
        this.long_term_fuel_trim_bank2 = long_term_fuel_trim_bank2;
        this.fuel_type = fuel_type;
        this.air_intake_temp = air_intake_temp;
        this.fuel_pressure = fuel_pressure;
        this.speed = speed;
        this.short_term_fuel_trim_bank2 = short_term_fuel_trim_bank2;
        this.short_term_fuel_trim_bank1 = short_term_fuel_trim_bank1;
        this.engine_runtime = engine_runtime;
        this.throttle_pos = throttle_pos;
        this.dtc_number = dtc_number;
        this.trouble_codes = trouble_codes;
        this.timing_advance = timing_advance;
        this.equiv_ratio = equiv_ratio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getV_id() {
        return v_id;
    }

    public void setV_id(String v_id) {
        this.v_id = v_id;
    }

    public String getBaro_pressure() {
        return baro_pressure;
    }

    public void setBaro_pressure(String baro_pressure) {
        this.baro_pressure = baro_pressure;
    }

    public String getEng_cool_temp() {
        return eng_cool_temp;
    }

    public void setEng_cool_temp(String eng_cool_temp) {
        this.eng_cool_temp = eng_cool_temp;
    }

    public String getFuel_leve() {
        return fuel_leve;
    }

    public void setFuel_leve(String fuel_leve) {
        this.fuel_leve = fuel_leve;
    }

    public String getEng_load() {
        return eng_load;
    }

    public void setEng_load(String eng_load) {
        this.eng_load = eng_load;
    }

    public String getAmb_air_temp() {
        return amb_air_temp;
    }

    public void setAmb_air_temp(String amb_air_temp) {
        this.amb_air_temp = amb_air_temp;
    }

    public String getEng_rpm() {
        return eng_rpm;
    }

    public void setEng_rpm(String eng_rpm) {
        this.eng_rpm = eng_rpm;
    }

    public String getIntake_manifold_pressure() {
        return intake_manifold_pressure;
    }

    public void setIntake_manifold_pressure(String intake_manifold_pressure) {
        this.intake_manifold_pressure = intake_manifold_pressure;
    }

    public String getMaf() {
        return maf;
    }

    public void setMaf(String maf) {
        this.maf = maf;
    }

    public String getTerm_fuel_trim_bank1() {
        return term_fuel_trim_bank1;
    }

    public void setTerm_fuel_trim_bank1(String term_fuel_trim_bank1) {
        this.term_fuel_trim_bank1 = term_fuel_trim_bank1;
    }

    public String getFuel_eco() {
        return fuel_eco;
    }

    public void setFuel_eco(String fuel_eco) {
        this.fuel_eco = fuel_eco;
    }

    public String getLong_term_fuel_trim_bank2() {
        return long_term_fuel_trim_bank2;
    }

    public void setLong_term_fuel_trim_bank2(String long_term_fuel_trim_bank2) {
        this.long_term_fuel_trim_bank2 = long_term_fuel_trim_bank2;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getAir_intake_temp() {
        return air_intake_temp;
    }

    public void setAir_intake_temp(String air_intake_temp) {
        this.air_intake_temp = air_intake_temp;
    }

    public String getFuel_pressure() {
        return fuel_pressure;
    }

    public void setFuel_pressure(String fuel_pressure) {
        this.fuel_pressure = fuel_pressure;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getShort_term_fuel_trim_bank2() {
        return short_term_fuel_trim_bank2;
    }

    public void setShort_term_fuel_trim_bank2(String short_term_fuel_trim_bank2) {
        this.short_term_fuel_trim_bank2 = short_term_fuel_trim_bank2;
    }

    public String getShort_term_fuel_trim_bank1() {
        return short_term_fuel_trim_bank1;
    }

    public void setShort_term_fuel_trim_bank1(String short_term_fuel_trim_bank1) {
        this.short_term_fuel_trim_bank1 = short_term_fuel_trim_bank1;
    }

    public String getEngine_runtime() {
        return engine_runtime;
    }

    public void setEngine_runtime(String engine_runtime) {
        this.engine_runtime = engine_runtime;
    }

    public String getThrottle_pos() {
        return throttle_pos;
    }

    public void setThrottle_pos(String throttle_pos) {
        this.throttle_pos = throttle_pos;
    }

    public String getDtc_number() {
        return dtc_number;
    }

    public void setDtc_number(String dtc_number) {
        this.dtc_number = dtc_number;
    }

    public String getTrouble_codes() {
        return trouble_codes;
    }

    public void setTrouble_codes(String trouble_codes) {
        this.trouble_codes = trouble_codes;
    }

    public String getTiming_advance() {
        return timing_advance;
    }

    public void setTiming_advance(String timing_advance) {
        this.timing_advance = timing_advance;
    }

    public String getEquiv_ratio() {
        return equiv_ratio;
    }

    public void setEquiv_ratio(String equiv_ratio) {
        this.equiv_ratio = equiv_ratio;
    }
}
