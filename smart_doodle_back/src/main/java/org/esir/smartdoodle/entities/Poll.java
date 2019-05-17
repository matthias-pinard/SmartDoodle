package org.esir.smartdoodle.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16002492 on 24/04/19.
 */
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Poll extends PanacheEntity{

    @Basic(optional=false)
    public String title;

    @Basic(optional=false)
    public String summary;

    @Basic()
    @OneToMany(mappedBy = "poll")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    public List<Guest> guests = new ArrayList<>();

    @OneToMany(mappedBy = "poll")
    //@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    public List<Slot> slots = new ArrayList<>();
    
    @Basic(optional=true)
    public String pad_link;
    
    @Basic(optional=true)
    public String slack_link;
    //Constructors
    public Poll() {
    }

    public Poll(String title, String summary) {
        this.title = title;
        this.summary = summary;
    }

    //Methods
    public void addSlot(Slot slot) {
        if(!this.slots.contains(slot)) {
            this.slots.add(slot);
            slot.poll = this;
        }
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
        guest.poll = this;
    }
    //Queries
}