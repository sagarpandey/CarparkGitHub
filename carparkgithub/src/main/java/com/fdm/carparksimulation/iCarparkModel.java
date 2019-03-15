package com.fdm.carparksimulation;

public interface iCarparkModel {

	public int getCarNumber();

	public void setCarNumber(int carNumber);

	public int getTruckNumber();

	public void setTruckNumber(int truckNumber);

	public int getTotalSpace();

	public void setTotalSpace(int totalSpace);

	 public int getCarExit() ;
	
	 public void setCarExit(int carExit);
	
	 public int getTruckExit() ;
	
	 public void setTruckExit(int truckExit);
	 
	 public int getUsedSpace() ;
	
	 public void setUsedSpace(int usedSpace);
	
	 public int getTotalAmount() ;
	
	 public void setTotalAmount(int totalAmount) ;
	
	 public int getTotalCarNumber();
	
	 public void setTotalCarNumber(int totalCarNumber);
	
	
	 public void setTotalTruckNumber(int totalTruckNumber);

	public int getTotalTruckNumber();

}
