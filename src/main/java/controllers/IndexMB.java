package controllers;

import javax.faces.bean.ManagedBean;

import controllers.primitive.AbstractMB;
import rest.EspClientImpl;

@ManagedBean
public class IndexMB extends AbstractMB<Object> {

	private EspClientImpl client;

	public float getHumidity() {
		resetMB();
		return client.getHumidity().getHumidity();
	}

	public float getTemperature() {
		resetMB();
		return client.getTemperature().getTemperature();
	}

	public void ligarDispositivo() {
		resetMB();
		client.ligarLed();
	}

	public void desligarDispositivo() {
		resetMB();
		client.desligarLed();	
	}

	@Override
	public void resetMB() {
		client = new EspClientImpl();
	}

	@Override
	public boolean validaObj() {
		return true;
	}

}
