
package org.esir.smartdoodle.rest;

import org.esir.smartdoodle.entities.Guest;
import org.esir.smartdoodle.entities.Poll;
import org.esir.smartdoodle.entities.Slot;
import org.esir.smartdoodle.entities.UserAccount;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Path("/poll")
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
    public void create() {
        Poll poll = new Poll("Test", "test poll");
        Guest guest = new Guest("m", "m", "gmail");
        poll.addGuest(guest);
        guest.persist();
        poll.persist();
    }

    @PATCH
    @Path("{id}")
    @Transactional
    public void addGuest(@PathParam("id") Long id) {
        Poll poll = Poll.findById(id);
        poll.persist();
    }
}
