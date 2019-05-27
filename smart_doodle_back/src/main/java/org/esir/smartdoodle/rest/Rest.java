
package org.esir.smartdoodle.rest;

import org.esir.smartdoodle.entities.Guest;
import org.esir.smartdoodle.entities.Poll;
import org.esir.smartdoodle.entities.Slot;
import org.esir.smartdoodle.entities.UserAccount;
import org.esir.smartdoodle.jsonobject.Disponibility;
import org.esir.smartdoodle.pad.Pad;
import org.jboss.logging.annotations.Pos;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Path("/polls")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class Rest {

    private final String PAD_API_KEY = "473205ce80eba9fefc02de7401d64d71d4fda6db8fd1e066d71da3f4cc2ce723";
    private final String PAD_URL = "http://148.60.11.233:3500";
    @GET
    public List<Poll> list() {
        return Poll.listAll();
    }

    @GET
    @Path("g")
    public List<Guest> listg() {
        return Guest.listAll();
    }

    @POST
    @Transactional
    public Poll createPoll(Poll poll) {
        Pad pad = new Pad(PAD_URL, PAD_API_KEY);
        poll.pad_link = pad.getLink();
        poll.persist();

        return poll;
    }

    @POST
    @Transactional
    @Path("slots/{id}")
    public void addSlots(@PathParam("id") Long id, List<Slot> slots) {
        System.out.println("in");
        Poll poll = Poll.findById(id);
        for(Slot slot: slots) {
            poll.addSlot(slot);
            slot.persist();
            poll.persist();
        }
    }

    @POST
    @Transactional
    @Path("guests/{id}")
    public void addGuest(@PathParam("id") Long id, Guest guest) {
        Poll poll = Poll.findById(id);
        poll.addGuest(guest);
        guest.persist();
        poll.persist();

        Pad pad = new Pad(Pad.getIdFromLink(poll.pad_link), PAD_API_KEY);
        pad.addUser(guest.name);
    }

    @PATCH
    @Transactional
    @Path("disponibility")
    public void changeDisponibility(Disponibility disponibility) {
        Guest guest = Guest.findById(disponibility.guestId);
        Slot slot = Slot.findById(disponibility.slotId);
        System.out.println(disponibility.available);
        if(disponibility.available) {
            guest.addSlot(slot);
        } else {
            guest.removeSlot(slot);
        }
        slot.persist();
        guest.persist();
        System.out.println("" + guest.slots);
    }

//
//    @DELETE
//    @Path("/{id}")
//    public void delete(@PathParam("id") Long id) {
//        Poll.d
//    }

}
