package org.endeavour.example.api;

import org.endeavour.example.model.User;
import org.endeavour.example.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/admin")
public class AdminAPI {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users")
	public Response list() {
		return Response.ok().entity(UserService.getInstance().list()).build();
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users/{index}")
	public Response get(@PathParam("index") int index) {
		return Response.ok().entity(UserService.getInstance().get(index - 1)).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users/{index}")
	public Response put(@PathParam("index") int index, User user) {
		return Response.ok().entity(UserService.getInstance().set(index - 1, user)).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users/{index}")
	public Response delete(@PathParam("index") int index) {
		UserService.getInstance().delete(index - 1);
		return Response.ok().entity("{ \"status\" : \"ok\" }").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users")
	public Response insert(User user) {
		UserService.getInstance().add(user);
		return Response.ok().entity(user).build();
	}
}