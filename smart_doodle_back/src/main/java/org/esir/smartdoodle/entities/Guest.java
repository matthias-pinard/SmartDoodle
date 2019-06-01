package org.esir.smartdoodle.entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

/**
 * Created by 16002492 on 24/04/19.
 */

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Guest extends PanacheEntity{
	@Basic(optional=false)
    public String name;
	@Basic(optional=true)
    public String mail;
	@Basic(optional=true)
    public String information;
//	@Basic(optional=true)
//    public UserAccount user;
    @ManyToOne
    @JsonbTransient
    public Poll poll;

    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    @ManyToMany(mappedBy = "guests")
    public List<Slot> slots = new ArrayList<>();

    public Guest() {}
    public Guest(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
        slot.guests.add(this);
    }

    public void removeSlot(Slot slot) {
        if (slots.contains(slot)) {
            slots.remove(slot);
            slot.guests.remove(this);
        }
    }
}
