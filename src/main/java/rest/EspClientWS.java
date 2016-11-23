package rest;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import rest.dominio.Humidity;
import rest.dominio.Temperature;

public class EspClientWS {

	public Humidity getHumidity() {

		String uri = "http://192.168.43.48/humidity";
		
		String value = execute(uri);
		
		ObjectMapper objectMapper=  new ObjectMapper();
		Humidity humidity = null;
		try {
			humidity = objectMapper.readValue(value, Humidity.class);
			System.out.println(humidity.getHumidity());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return humidity;

	}

	public Temperature getTemperature() {

		
		String uri = "http://192.168.43.48/temperature";
		
		String value = execute(uri);
		
		ObjectMapper objectMapper=  new ObjectMapper();
		Temperature temperature = null;
		
		try {
			temperature = objectMapper.readValue(value, Temperature.class);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return temperature;
	}

	public void ligarLed() {
		String uri = "http://192.168.43.48/led?params=0";
		execute(uri);	

	}

	public void desligarLed() {		
		String uri = "http://192.168.43.48/led?params=1";		
		execute(uri);
		
	}
	
	private String execute(String uri) {
		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target(uri);
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		response.close();
		return value;
	}

}
