package org.esir.smartdoodle.rest;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.esir.smartdoodle.entities.Guest;
import org.esir.smartdoodle.entities.Poll;
import org.esir.smartdoodle.entities.Slot;
import org.esir.smartdoodle.jsonobject.Disponibility;
import org.esir.smartdoodle.pad.Pad;
@Path("/polls")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class Rest {

    private final String PAD_API_KEY = "473205ce80eba9fefc02de7401d64d71d4fda6db8fd1e066d71da3f4cc2ce723";
    private final String PAD_URL = "http://148.60.11.233:3500";
    //private final String PAD_API_KEY = System.getenv("PAD_API_KEY"); 
    //private final String PAD_URL = "http://" + System.getenv("PAD_URL");
    
    private final String INVALID_ID = "Invalid id provided";
    @GET
    public List<Poll> list() {
        return Poll.listAll();
    }
    
	@GET
	@Path("{id}")
	public Poll getPollbyID(@PathParam("id") UUID id) {
		Poll poll = Poll.findById(id);
	   	return poll;
	}
    
    @POST
    @Transactional
    public Poll createPoll(Poll poll) {
        Pad pad = new Pad(PAD_URL, PAD_API_KEY);
        poll.pad_link = pad.getLink();
        poll.persist();
        pad.setHeader(poll.title);
        return poll;
    }

    @POST
    @Transactional
    @Path("{id}/slots")
    public void addSlots(@PathParam("id") UUID id, List<Slot> slots) {
        Poll poll = Poll.findById(id);
        if (poll == null)
			throw new WebApplicationException(INVALID_ID,Response.Status.NOT_FOUND);
        for(Slot slot: slots) {
            poll.addSlot(slot);
            slot.persist();
            poll.persist();
        }
    }

    @POST
    @Transactional
    @Path("{id}/guests")
    public void addGuest(@PathParam("id") UUID id, Guest guest) {
        Poll poll = Poll.findById(id);
        if (poll == null)
			throw new WebApplicationException(INVALID_ID, Response.Status.NOT_FOUND);
        poll.addGuest(guest);
        guest.persist();
        poll.persist();

        Pad pad = new Pad(PAD_URL, PAD_API_KEY, Pad.getIdFromLink(poll.pad_link));
        pad.addUser(guest.name);
    }

    @PATCH
    @Transactional
    @Path("{id}")
    public void updatePoll(@PathParam("id") UUID id, Poll newPoll) {
    	Poll prevPoll = Poll.findById(id);
    	if (prevPoll == null)
			throw new WebApplicationException(INVALID_ID, Response.Status.NOT_FOUND);
    	prevPoll.title = newPoll.title;
    	prevPoll.summary = newPoll.summary;
    	prevPoll.place = newPoll.place;
    	prevPoll.persist();
    }
    
    @PATCH
    @Transactional
    @Path("{id}/disponibility/")
    public void changeDisponibility(Disponibility disponibility) {
        Guest guest = Guest.findById(disponibility.guestId);
        if (guest == null)
			throw new WebApplicationException(INVALID_ID, Response.Status.NOT_FOUND);
        Slot slot = Slot.findById(disponibility.slotId);
        if (slot == null)
			throw new WebApplicationException(INVALID_ID, Response.Status.NOT_FOUND);
        if(disponibility.available) {
            guest.addSlot(slot);
        } else {
            guest.removeSlot(slot);
        }
        slot.persist();
        guest.persist();
    }

   @DELETE
   @Transactional
   @Path("/{id}")
   public void delete(@PathParam("id") UUID id){
	   Poll poll = Poll.findById(id);
	   if (poll == null)
			throw new WebApplicationException(INVALID_ID, Response.Status.NOT_FOUND);
	   if(poll.isPersistent()) {
		   poll.delete();
	   }
   }

}
