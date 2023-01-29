package com.gcp.springboot.jamsession.api.instrument;

import javax.persistence.*;

@Entity // keyword that tells the Spring Boot that the following
        // class should be considered as a table class
public class Instrument {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long instrument_id;
    private String name;
    private String type;
    public Instrument() {
    }

    public long getId() {
        return instrument_id;
    }

    public void setId(long instrument_id) {
        this.instrument_id = instrument_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Instrument(long instrument_id, String name, String type) {
        super();
        this.instrument_id = instrument_id;
        this.name = name;
        this.type = type;
    }
}
