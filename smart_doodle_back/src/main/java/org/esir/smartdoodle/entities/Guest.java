package org.esir.smartdoodle.entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;

/**
 * Created by 16002492 on 24/04/19.
 */

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Guest extends PanacheEntity{
	@Basic(optional=false)
	public String firstName;
	@Basic(optional=false)
    public String secondName;
	@Basic(optional=false)
    public String mail;
    
    @ManyToOne
    @JsonbTransient
    public Poll poll;

    public Guest() {}
    public Guest(String firstName, String secondName, String mail) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.mail = mail;
    }

}
