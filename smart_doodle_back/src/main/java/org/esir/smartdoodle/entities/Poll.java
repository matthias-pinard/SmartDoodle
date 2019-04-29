package org.esir.smartdoodle.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by 16002492 on 24/04/19.
 */
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Poll {

	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Basic(optional=false)
    private String title;

    @Basic(optional=false)
    private String summary;

    @ManyToMany
    private List<Participant> participants;

    @OneToMany(mappedBy = "poll")
    private List<Slot> slots;

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

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public void addSlot(Slot slot) {
        if(!this.slots.contains(slot)) {
            this.slots.add(slot);
        }
    }
}