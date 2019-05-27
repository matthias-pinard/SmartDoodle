package org.esir.smartdoodle.entities;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class UserAccount extends PanacheEntity {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;
	
	@Basic(optional = true)
    public String name;
    
    @Column(unique=true)
    @Basic(optional = false)
    public String mail;
    
    public UserAccount() {
    	
    }
    
    public UserAccount(String name, String mail) {
    	this.name = name;
        this.mail = mail;
    }    
}
