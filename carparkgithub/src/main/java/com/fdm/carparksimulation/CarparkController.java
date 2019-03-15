package com.fdm.carparksimulation;

import java.util.Scanner;

public class CarparkController {

	private final iCarparkModel carparkModel;
	private final iCarparkView carparkView;

	public CarparkController(iCarparkModel carparkModel, iCarparkView carparkView) {
		this.carparkModel = carparkModel;
		this.carparkView = carparkView;
	}

	public void handle() {

		carparkView.println("How many spaces does the carpark have?");

		String totalSpacesString = carparkView.nextLine();
		int totalSpaces = Integer.parseInt(totalSpacesString);

		carparkModel.setTotalSpace(totalSpaces);

		if (carparkModel.getTotalSpace() == 0) {
			carparkView.println("The Carpark has no space available");
		}

		else {
			boolean run = true;

			String userInput;
			while (run) {
				carparkView.println("User: ");

				userInput = carparkView.nextLine();

				switch (userInput.toUpperCase()) {

				case "ENTER CAR":
					if (carparkModel.getUsedSpace() <= carparkModel.getTotalSpace() - 1) {

						enterCar(carparkModel);

					} else {
						carparkView.println("The car park is full");
					}
					break;

				case "ENTER TRUCK":
					if (carparkModel.getUsedSpace() <= carparkModel.getTotalSpace() - 2) {

						enterTruck(carparkModel);

					} else {
						carparkView.println("The car park is full");
					}
					break;


				case "REPORT":
					generateReport(carparkModel);
					break;

				case "QUIT":
					run = false;

					break;
				default:
					if (userInput.toUpperCase().matches("EXIT CAR [0-9]+")) {
						String[] data = userInput.split(" ");
						if (carparkModel.getCarNumber() > 0) {
							exitCar(carparkModel, carparkView, Integer.parseInt(data[2]));
						} else {
							carparkView.println("The car park is full");
						}

					} else if (userInput.toUpperCase().matches("EXIT TRUCK [0-9]+")) {
						String[] data = userInput.split(" ");
						if (carparkModel.getTruckNumber() > 0) {
							exitTruck(carparkModel, carparkView, Integer.parseInt(data[2]));
						} else {
							carparkView.println("There is no truck to exit");

						}

						break;

					}
				}

			}
		}
	}

	private void exitTruck(iCarparkModel carParkSimulation, iCarparkView carparkView, int numberOfHours) {
		carParkSimulation.setTruckNumber(carParkSimulation.getTruckNumber() - 1);
		carParkSimulation.setUsedSpace(carParkSimulation.getUsedSpace() - 2);
		carParkSimulation.setTruckExit(carParkSimulation.getTruckExit() + 1);
		carParkSimulation.setTotalAmount(carParkSimulation.getTotalAmount() + (numberOfHours * 3));
	}

	private void exitCar(iCarparkModel carParkSimulation, iCarparkView carparkView, int numberOfHours) {
		carParkSimulation.setCarNumber(carParkSimulation.getCarNumber() - 1);
		carParkSimulation.setUsedSpace(carParkSimulation.getUsedSpace() - 1);
		carParkSimulation.setCarExit(carParkSimulation.getCarExit() + 1);
		carParkSimulation.setTotalAmount(carParkSimulation.getTotalAmount() + (numberOfHours * 2));
	}

	private void enterCar(iCarparkModel carParkSimulation) {
		carParkSimulation.setCarNumber(carParkSimulation.getCarNumber() + 1);
		carParkSimulation.setUsedSpace(carParkSimulation.getUsedSpace() + 1);
		carParkSimulation.setTotalCarNumber(carParkSimulation.getTotalCarNumber() + 1);
	}

	private void enterTruck(iCarparkModel carparkModel2) {
		carparkModel2.setTruckNumber(carparkModel2.getTruckNumber() + 1);
		carparkModel2.setUsedSpace(carparkModel2.getUsedSpace() + 2);
		carparkModel2.setTotalTruckNumber(carparkModel2.getTotalTruckNumber() + 1);
	}

	private void generateReport(iCarparkModel carParkSimulation) {
		carparkView.println("Report: \n" + "Cars Entered: " + carParkSimulation.getTotalCarNumber()
				+ "\n Trucks Entered: " + carParkSimulation.getTotalTruckNumber() + "\n Cars Exited: "
				+ carParkSimulation.getCarExit() + "\n Trucks Exited: " + carParkSimulation.getTruckExit()
				+ "\n Parking Cars: " + carParkSimulation.getCarNumber() + "\n Parking Trucks: "
				+ carParkSimulation.getTruckNumber() + "\n Spaces Available: "
				+ (carParkSimulation.getTotalSpace() - carParkSimulation.getUsedSpace()) + "\n Fees Paid: $"
				+ carParkSimulation.getTotalAmount());
	}

}
