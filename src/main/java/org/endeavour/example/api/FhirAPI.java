package org.endeavour.example.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

@Path("/fhir")
public class FhirAPI {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{type}/{id}")
	public Response read(@PathParam("type") String type,
			@PathParam("id") String id,
			@QueryParam("_format") String format) {
		
		Map<String, String> response = new HashMap<String, String>();
		response.put("type", type);
		response.put("id", id);
		response.put("action", "GET");

		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
		df.setTimeZone(tz);
		String nowAsISO = df.format(new Date());

		return Response.ok().entity("{ \"type\": \"" + type +
				"\", \"id\": \"" + id +
				"\", \"timestamp\": \"" + nowAsISO + "\"}").build();
	}
}