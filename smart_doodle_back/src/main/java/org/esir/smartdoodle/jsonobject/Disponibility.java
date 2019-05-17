package org.esir.smartdoodle.jsonobject;

public class Disponibility {
    public Long guestId;
    public Long slotId;
    public boolean availble;

    public Disponibility(Long guest, Long slot, boolean available) {
        this.guestId = guest;
        this.slotId = slot;
        this.availble = available;
    }
}
