package com.shopping.list.api;

import com.shopping.list.dto.CardDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@Path("/shopping")
public interface ShoppingRecourse {

    /**
     * POST  /cards : user card list synchronization.
     *
     * @param currentDeviceList current shopping list on user device
     *
     * @return merged shopping list from server, return WebApplicationException in case error of shopping list merge
     */
    @POST
    @Path("/cards")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Set<CardDto> syncCustomerCards(List<CardDto> currentDeviceList);

    @POST
    @Path("card/create")
    void create(CardDto list);

    @POST
    @Path("card/remove")
    void remove(String cardId);
}
