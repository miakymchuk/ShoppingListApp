package com.shopping.list.api;

import com.shopping.list.dto.CardDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/share/card")
public interface ShareCardRecourse {

    @GET
    @Path("/link/{userId}/{cardId}")
    String getShareCardLink(@PathParam("userId") String userId, @PathParam("cardId") String cardId);

    @GET
    @Path("/{userId}/accept/{cardId}")
    CardDto accept(@PathParam("userId")String userId, @PathParam("cardId") String cardId);
}
