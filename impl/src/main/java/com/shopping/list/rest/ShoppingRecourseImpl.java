package com.shopping.list.rest;


import com.shopping.list.api.ShoppingRecourse;
import com.shopping.list.dto.Card;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/shopping")
public class ShoppingRecourseImpl implements ShoppingRecourse {
    @POST
    @Path("/cards")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public List<Card> syncCustomerCards(List<Card> currentDeviceList) {
        return null;
    }

    @POST
    @Path("card/create")
    @Override
    public void create(Card list) {
        //TODO
    }

    @POST
    @Path("card/remove")
    @Override
    public void remove(String cardId) {
        //TODO
    }
}
