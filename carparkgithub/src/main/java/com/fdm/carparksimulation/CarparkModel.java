package com.fdm.carparksimulation;

public class CarparkModel implements iCarparkModel {

	private int totalSpace = 0;
	private int carNumber = 0;
	private int truckNumber = 0;
	private int carExit = 0;
	private int truckExit = 0;
	private int usedSpace = 0;
	private int totalAmount = 0;
	private int totalCarNumber = 0;
	private int totalTruckNumber = 0;

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public int getTruckNumber() {
		return truckNumber;
	}

	public void setTruckNumber(int truckNumber) {
		this.truckNumber = truckNumber;
	}

	public int getTotalSpace() {
		return totalSpace;
	}

	public void setTotalSpace(int totalSpace) {
		this.totalSpace = totalSpace;
	}

	public int getCarExit() {
		return carExit;
	}

	public void setCarExit(int carExit) {
		this.carExit = carExit;
	}

	public int getTruckExit() {
		return truckExit;
	}

	public void setTruckExit(int truckExit) {
		this.truckExit = truckExit;
	}

	public int getUsedSpace() {
		return usedSpace;
	}

	public void setUsedSpace(int usedSpace) {
		this.usedSpace = usedSpace;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalCarNumber() {
		return totalCarNumber;
	}

	public void setTotalCarNumber(int totalCarNumber) {
		this.totalCarNumber = totalCarNumber;
	}

	public int getTotalTruckNumber() {
		return totalTruckNumber;
	}

	public void setTotalTruckNumber(int totalTruckNumber) {
		this.totalTruckNumber = totalTruckNumber;
	}
	
}
