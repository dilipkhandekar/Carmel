package com.carmel.ugt.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.carmel.ugt.common.OperationArgs;
import com.carmel.ugt.common.OperationId;

@Path("/UGT")
public class UgtRESTServer {
    
	@GET
    @Path("/op/{id}/{arg}")
    @Produces(MediaType.TEXT_XML)
    public String dispatch(@PathParam("id") String id, @PathParam("arg") int arg) {
		UgtServer.getOpDispatcher().Dispatch(OperationId.ID.valueOf(id), new OperationArgs(arg));
		return "<?xml version=\"1.0\"?><result>0</result>"; // TODO: Return something useful
    }
}
