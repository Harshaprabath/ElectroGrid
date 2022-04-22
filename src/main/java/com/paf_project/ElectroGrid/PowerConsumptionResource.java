package com.paf_project.ElectroGrid;

import com.paf_project.ElectroGrid.Model.PowerConsumption;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;




@Path("powerconsumptione")
public class PowerConsumptionResource {

	 @GET
	 //@Produces(MediaType.APPLICATION_XML)
	 @Produces(MediaType.APPLICATION_JSON)
	 public PowerConsumption getIt() {
		 
		 System.out.println("test");
		 PowerConsumption pc = new PowerConsumption();
		 pc.setId("1");
		 pc.setCustomer_ID("2");
		 pc.setValue(2);
		 pc.setDate(null);
		 
		 return pc;
     }
	
	
}
