package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public interface EspClient {

	@GET
	@Path("basic")
	@Produces("text/plain")
	String getHumidity();
	
}
