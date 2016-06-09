package org.endeavour.example.api;

import org.endeavour.example.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/admin")
public class AdminAPI {

	private List<User> users;

	public AdminAPI() {
		users = new ArrayList<User>();
		users.add(new User("alice@example.com", "Alice"));
		users.add(new User("bob@example.com", "Bob the Builder"));
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users")
	public Response list() {
		return Response.ok().entity(users).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users")
	public Response insert(User user) {
		users.add(user);
		return Response.ok().entity(user).build();
	}

}