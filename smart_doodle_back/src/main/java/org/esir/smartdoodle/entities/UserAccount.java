package org.esir.smartdoodle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class UserAccount extends PanacheEntity {

    public String firstName;
    
    public String secondName;
    @Column(unique=true)
    public String mail;
    
    public UserAccount() {
    	
    }
    
    public UserAccount(String firstName, String secondName, String mail) {
    	this.firstName = firstName;
        this.secondName = secondName;
        this.mail = mail;
    }    
}
