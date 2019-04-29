package org.esir.smartdoodle.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.esir.smartdoodle.domain.PollService;
import org.esir.smartdoodle.entities.Poll;

@Path("/gift")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    PollService pollService;

    @GET
    public List<Poll> list() {
        return pollService.list();
    }

    @POST
    public void create() {
        Poll poll = new Poll();
        poll.setTitle("test");
        pollService.set(poll);
    }
}