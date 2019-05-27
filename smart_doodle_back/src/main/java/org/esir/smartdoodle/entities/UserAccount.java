package org.esir.smartdoodle.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class UserAccount extends PanacheEntity {

    public String name;
    
    @Column(unique=true)
    public String mail;
    
    public UserAccount() {
    	
    }
    
    public UserAccount(String name, String mail) {
    	this.name = name;
        this.mail = mail;
    }    
}
