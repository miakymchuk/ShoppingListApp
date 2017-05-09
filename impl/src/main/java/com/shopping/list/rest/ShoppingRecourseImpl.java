package com.shopping.list.rest;


import com.shopping.list.api.ShoppingRecourse;
import com.shopping.list.dto.CardDto;
import com.shopping.list.exception.MergeCardException;
import com.shopping.list.service.ShoppingListSyncService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@Path("/shopping")
public class ShoppingRecourseImpl implements ShoppingRecourse {

    @Autowired
    private ShoppingListSyncService shoppingListSyncService;
    @POST
    @Path("/cards")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Set<CardDto> syncCustomerCards(List<CardDto> currentDeviceList)  {
        try {
            return shoppingListSyncService.getRelevantList(currentDeviceList);
        } catch (MergeCardException e) {
            throw new WebApplicationException("Application error");
        }
    }

    @POST
    @Path("card/create")
    @Override
    public void create(CardDto list) {
        //TODO
    }

    @POST
    @Path("card/remove")
    @Override
    public void remove(String cardId) {
        //TODO
    }
}
