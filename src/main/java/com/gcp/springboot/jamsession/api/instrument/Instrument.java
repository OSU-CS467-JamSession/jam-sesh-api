package com.gcp.springboot.jamsession.api.instrument;

import javax.persistence.*;

@Entity
@Table(name = "Instruments")
public class Instrument {
    // Class Definition
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "instrument_id")
    private long instrument_id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    public Instrument() {}

    // Getters and Setters
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

    // Constructors
    public Instrument(long instrument_id, String name, String type) {
        super();
        this.instrument_id = instrument_id;
        this.name = name;
        this.type = type;
    }
}
