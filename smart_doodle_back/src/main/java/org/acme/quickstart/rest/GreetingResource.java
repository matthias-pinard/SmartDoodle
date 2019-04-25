package org.acme.quickstart.rest;

import org.acme.quickstart.domain.Gift;
import org.acme.quickstart.domain.GiftService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/gift")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    GiftService giftService;

    @GET
    public List<Gift> list() {
        return giftService.list();
    }

    @POST
    public void create() {
        Gift gift = new Gift();
        gift.setName("test");
        giftService.set(gift);
    }
}