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

		int totalSpaces = carparkView.nextInt();

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

				case "EXIT CAR":
					if (carparkModel.getCarNumber() > 0) {
						exitCar(carparkModel, carparkView);
					} else {
						carparkView.println("There is no car to exit");

					}
					break;

				case "EXIT TRUCK":

					if (carparkModel.getTruckNumber() > 0) {
						exitTruck(carparkModel, carparkView);
					} else {
						carparkView.println("There is no truck to exit");

					}
					break;

				case "REPORT":
					generateReport(carparkModel);

				case "QUIT":
					run = false;

					break;
				default:
					carparkView.println("Wrong Command");
					break;

				}
			}

		}

	}

	private void exitTruck(CarparkModel carParkSimulation, CarparkView carparkView) {
		carParkSimulation.setTruckNumber(carParkSimulation.getTruckNumber() - 1);
		carParkSimulation.setUsedSpace(carParkSimulation.getUsedSpace() - 1);
		carParkSimulation.setTruckExit(carParkSimulation.getTruckExit() + 1);
		carparkView.println("Total Number of hours parked?");
		int timeInHours = carparkView.nextInt();
		carParkSimulation.setTotalAmount(carParkSimulation.getTotalAmount() + (timeInHours * 3));
	}

	private void exitCar(CarparkModel carParkSimulation, CarparkView carparkView) {
		carParkSimulation.setCarNumber(carParkSimulation.getCarNumber() - 1);
		carParkSimulation.setUsedSpace(carParkSimulation.getUsedSpace() - 1);
		carParkSimulation.setCarExit(carParkSimulation.getCarExit() + 1);
		carparkView.println("Total Number of hours parked?");
		int timeInHours = carparkView.nextInt();
		carParkSimulation.setTotalAmount(carParkSimulation.getTotalAmount() + (timeInHours * 2));
	}

	private void enterCar(CarparkModel carParkSimulation) {
		carParkSimulation.setCarNumber(carParkSimulation.getCarNumber() + 1);
		carParkSimulation.setUsedSpace(carParkSimulation.getUsedSpace() + 1);
		carParkSimulation.setTotalCarNumber(carParkSimulation.getTotalCarNumber() + 1);
	}

	private void enterTruck(CarparkModel carParkSimulation) {
		carParkSimulation.setTruckNumber(carParkSimulation.getTruckNumber() + 1);
		carParkSimulation.setUsedSpace(carParkSimulation.getUsedSpace() + 2);
		carParkSimulation.setTotalTruckNumber(carParkSimulation.getTotalTruckNumber() + 1);
	}

	private void generateReport(CarparkModel carParkSimulation) {
		carparkView.println("Report: \n" + "Cars Entered: " + carParkSimulation.getTotalCarNumber()
				+ "\n Trucks Entered: " + carParkSimulation.getTotalTruckNumber() + "\n Cars Exited: "
				+ carParkSimulation.getCarExit() + "\n Trucks Exited: " + carParkSimulation.getTruckExit()
				+ "\n Parking Cars: " + carParkSimulation.getCarNumber() + "\n Parking Trucks: "
				+ carParkSimulation.getTruckNumber() + "\n Spaces Available: "
				+ (carParkSimulation.getTotalSpace() - carParkSimulation.getUsedSpace()) + "\n Fees Paid: $"
				+ carParkSimulation.getTotalAmount());
	}

}
