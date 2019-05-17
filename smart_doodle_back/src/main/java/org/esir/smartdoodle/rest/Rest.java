
package org.esir.smartdoodle.rest;

import org.esir.smartdoodle.entities.Guest;
import org.esir.smartdoodle.entities.Poll;
import org.esir.smartdoodle.entities.Slot;
import org.esir.smartdoodle.entities.UserAccount;
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
    public void createPoll(Poll poll) {
        poll.persist();
    }

    @POST
    @Transactional
    @Path("slots/{id}")
    public void addSlot(@PathParam("id") Long id, Slot slot) {
        Poll poll = Poll.findById(id);
        poll.addSlot(slot);
        slot.persist();
        poll.persist();
    }

    @POST
    @Transactional
    @Path("guests/{id}")
    public void addGuest(@PathParam("id") Long id, Guest guest) {
        Poll poll = Poll.findById(id);
        poll.addGuest(guest);
        guest.persist();
        poll.persist();
    }
}
