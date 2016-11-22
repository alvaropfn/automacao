package rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestClient {
	
	public Client getClient(){
		
		  Client client = ClientBuilder.newBuilder().build();
          WebTarget target = client.target("http://foo.com/resource");
          Response response = target.request().get();
          String value = response.readEntity(String.class);
          response.close();
		
		return null;
	}

}
