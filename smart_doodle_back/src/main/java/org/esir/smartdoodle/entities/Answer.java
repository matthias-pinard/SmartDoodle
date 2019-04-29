package entities;

/**
 * Created by 16002492 on 24/04/19.
 */

import javax.persistence.*;

public class Answer {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Poll poll;

    @ManyToOne
    private Participant participant;

    @OneToOne
    private Slot slot;

    public Answer() {
    }

    public Answer(Poll poll, Participant participant, Slot slot) {
        this.poll = poll;
        this.participant = participant;
        this.slot = slot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
