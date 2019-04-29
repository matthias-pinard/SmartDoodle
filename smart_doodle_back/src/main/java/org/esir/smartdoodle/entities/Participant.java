package org.esir.smartdoodle.entities;

import java.util.UUID;

/**
 * Created by 16002492 on 24/04/19.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Participant {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    
    private UUID id;

    private String firstName;
    
    private String secondName;

    private String mail;
    
    
    
    public Participant(){

    }

    public Participant(String firstName, String secondName, String mail) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.mail = mail;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
