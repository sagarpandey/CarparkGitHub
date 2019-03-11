package com.fdm.carparksimulation;

public class CarParkApp {

	public static void main(String[] args) {

		CarparkModel carparkModel = new CarparkModel();
		CarparkView carparkView = new CarparkView();
		CarparkController carparkController = new CarparkController(carparkModel, carparkView);

		carparkController.handle();

	}

}
