package com.fdm.carparksimulation;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CarparkModelTest {

	private CarparkModel carparkModel;

	@Before
	public void setUp() {
		carparkModel = new CarparkModel();
	}

	@Test
	public void when_user_inputs_total_spaces_of_10_totalSpace_should_be_stored_10() {
		carparkModel.setTotalSpace(10);
		assertEquals(10, carparkModel.getTotalSpace());
	}

	@Test
	public void when_user_inputs_1_as_a_car_number_shoukd_return_1() {
		carparkModel.setCarNumber(1);
		assertEquals(1, carparkModel.getCarNumber());
	}

	@Test
	public void when_user_inputs_2_as_a_number_of_trucks_should_return2_as_a_number_of_trucks() {
		carparkModel.setTruckNumber(2);
		assertEquals(2, carparkModel.getTruckNumber());
	}

	@Test
	public void when_a_car_is_exited_it_should_return_number_of_car_exited_as_1() {
		carparkModel.setCarExit(1);
		assertEquals(1, carparkModel.getCarExit());
	}

	@Test
	public void when_a_truck_is_exited_it_should_return_number_of_trucks_exited_as_1() {
		carparkModel.setCarExit(1);
		assertEquals(1, carparkModel.getCarExit());
	}

	@Test
	public void when_a_car_is_added_the_total_space_should_be_deducted_by_1() {
		carparkModel.setTotalSpace(10);
		carparkModel.setUsedSpace(1);
		assertEquals(9, (carparkModel.getTotalSpace() - carparkModel.getUsedSpace()));
	}

	@Test
	public void when_a_truck_is_added_the_total_space_should_be_deducted_by_2() {
		carparkModel.setTotalSpace(10);
		carparkModel.setTotalTruckNumber(1);
		carparkModel.setUsedSpace(2);
		assertEquals(8, (carparkModel.getTotalSpace() - carparkModel.getUsedSpace()));
	}

	@Test
	public void when_a_car_is_exited_the_total_spaces_shoukd_be_added_by_1() {
		carparkModel.setTotalSpace(10);
		carparkModel.setUsedSpace(2);
		assertEquals(8, carparkModel.getTotalSpace() - carparkModel.getUsedSpace());

	}

	@Test
	public void when_3_cars_are_entered_and_1_is_exited_total_number_of_cars_should_be_2() {
		carparkModel.setCarNumber(3);
		carparkModel.setCarExit(1);
		assertEquals(2, carparkModel.getCarNumber() - carparkModel.getCarExit());

	}

	@Test
	public void when_5_trucks_are_entered_and_2_are_exited_total_number_of_trucks_should_be_3() {
		carparkModel.setTruckNumber(5);
		carparkModel.setTruckExit(2);
		assertEquals(3, carparkModel.getTruckNumber() - carparkModel.getTruckExit());

	}
	
	@Test
	public void for_each_car_exited_the_total_amount_for_one_hour_is_dollar_2() {
		carparkModel.setTotalCarNumber(1);
		carparkModel.setTotalAmount(2*carparkModel.getTotalCarNumber());
		assertEquals(2,carparkModel.getTotalAmount());
		
	}
	
	@Test
	public void for_each_trucks_exited_the_amount_for_one_hour_is_dollar_3() {
		carparkModel.setTotalTruckNumber(1);
		carparkModel.setTotalAmount(3*carparkModel.getTotalTruckNumber());
		assertEquals(3,carparkModel.getTotalAmount());
	}

}
