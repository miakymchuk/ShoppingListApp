package com.shopping.list.api;

import com.shopping.list.dto.Card;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/shopping")
public interface ShoppingRecourse {
    @GET
    @Path("/cards")
    List<Card> getCustomerCards();

    @POST
    @Path("card/create")
    void create(Card list);

    @POST
    @Path("card/remove")
    void remove(String cardId);
}
