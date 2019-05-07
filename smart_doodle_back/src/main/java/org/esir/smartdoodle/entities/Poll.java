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


@Entity
public class Poll extends PanacheEntity{

    @Basic(optional=false)
    public String title;

    @Basic(optional=false)
    public String summary;

    @OneToMany(mappedBy = "poll")
    //@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    public List<Participant> participants;

    @OneToMany(mappedBy = "poll")
    //@Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    public List<Slot> slots;
    
    @Basic(optional=true)
    public String pad_link;
    
    @Basic(optional=true)
    public String slack_link;
    //Constructors
    public Poll() {
        this.participants = new ArrayList<Participant>();
        this.slots = new ArrayList<Slot>();
    }

    public Poll(String title, String summary) {
        this.title = title;
        this.summary = summary;
        this.participants = new ArrayList<Participant>();
        this.slots = new ArrayList<Slot>();
    }

    //Methods
    public void addSlot(Slot slot) {
        if(!this.slots.contains(slot)) {
            this.slots.add(slot);
        }
    }
    //Queries
}