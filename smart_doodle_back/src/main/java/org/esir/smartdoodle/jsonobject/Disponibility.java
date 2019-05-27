package org.esir.smartdoodle.jsonobject;

public class Disponibility {
    public Long guestId;
    public Long slotId;
    public Boolean available;

    public  Disponibility(){}
    public Disponibility(Long guest, Long slot, Boolean available) {
        this.guestId = guest;
        this.slotId = slot;
        this.available = available;
    }
}
