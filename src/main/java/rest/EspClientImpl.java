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

public class EspClientImpl {

	public Humidity getHumidity() {

		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target("http://192.168.43.48/humidity");
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		response.close();	
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

		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target("http://192.168.43.48/temperature");
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		response.close();
		ObjectMapper objectMapper=  new ObjectMapper();
		Temperature temperature = null;
		try {
			temperature = objectMapper.readValue(value, Temperature.class);
			System.out.println(temperature.getTemperature());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return temperature;
	}

	public void ligarLed() {

		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target("http://192.168.43.48/led?params=0");
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		response.close();

	}

	public void desligarLed() {

		Client client = ClientBuilder.newBuilder().build();
		WebTarget target = client.target("http://192.168.43.48/led?params=1");
		Response response = target.request().get();
		String value = response.readEntity(String.class);
		response.close();
	}

}
