package com.fdm.carparksimulation;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CarparkControllerTest {
	iCarparkModel carparkModel = mock(CarparkModel.class);
	iCarparkView carparkView = mock(CarparkView.class);

	@Test
	public void that_controller_can_be_constructed_from_model_and_view() {

		CarparkController carparkController = new CarparkController(carparkModel, carparkView);

		carparkController.handle();

		int maxSpace = 15;
		when(carparkView.nextInt()).thenReturn(maxSpace);
		assertEquals(carparkModel.getTotalSpace(), maxSpace);
	}

}
