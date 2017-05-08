package com.shopping.list.api;

import com.shopping.list.dto.Card;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/shopping")
public interface ShoppingRecourse {

    /**
     * POST  /cards : user card list synchronization.
     *
     * @param currentDeviceList current shopping list on user device
     * @return merged shopping list from server
     */
    @POST
    @Path("/cards")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    List<Card> syncCustomerCards(List<Card> currentDeviceList);

    @POST
    @Path("card/create")
    void create(Card list);

    @POST
    @Path("card/remove")
    void remove(String cardId);
}
