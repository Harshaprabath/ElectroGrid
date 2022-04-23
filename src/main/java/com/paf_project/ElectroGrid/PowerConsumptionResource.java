package com.paf_project.ElectroGrid;

import com.paf_project.ElectroGrid.Business.PowerconsumptioneService;
import com.paf_project.ElectroGrid.Model.PowerConsumption;
import java.util.ArrayList;
import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;




@Path("powerconsumptione")
public class PowerConsumptionResource {
	
	PowerconsumptioneService powerconsumptioneService = new PowerconsumptioneService();

	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<PowerConsumption> getAll() {
		 
		 return powerconsumptioneService.getAll();
     }
	 
	
	
}
