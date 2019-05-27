package org.esir.smartdoodle.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by 16002492 on 24/04/19.
 */
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class Poll extends PanacheEntityBase {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id", updatable = false, nullable = false)
	public UUID id;
	
    @Basic(optional=false)
    public String title;

    @Basic(optional=false)
    public String summary;

    @Basic(optional=true)
    public String place;
    
    @Basic()
    @OneToMany(mappedBy = "poll")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    public List<Guest> guests = new ArrayList<>();

    @OneToMany(mappedBy = "poll")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    public List<Slot> slots = new ArrayList<>();
    
    @Basic(optional=true)
    public String pad_link;

    @Basic(optional=true)
    public String slack_link;
    
    //	CONSTRUCTORS
    public Poll() {
    }

    public Poll(String title, String summary) {
        this.title = title;
        this.summary = summary;
    }
    
    //	METHODS
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