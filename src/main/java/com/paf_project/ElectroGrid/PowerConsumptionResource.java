package com.paf_project.ElectroGrid;

import com.paf_project.ElectroGrid.Business.PowerconsumptioneService;
import com.paf_project.ElectroGrid.Model.PowerConsumption;
import com.paf_project.ElectroGrid.Model.UnitValue;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;




@Path("powerconsumption")
public class PowerConsumptionResource {
	
	PowerconsumptioneService powerconsumptioneService = new PowerconsumptioneService();

	 @GET
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<PowerConsumption> getAll() {
		 
		 return powerconsumptioneService.getAll();
     }
	 
	 @GET
	 @Path("unit-value")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<UnitValue> getAllUnitValue() {
		 
		 return powerconsumptioneService.getAllUnitValue();
     }
	 
	 @PUT
	 @Path ("update-unit-value")
	 @Consumes (MediaType.APPLICATION_JSON)
	 public String updateUnitValue( UnitValue UnitValue) {
			
		 return powerconsumptioneService.updateUnitValue(UnitValue);
		
	 }
	 
	 @POST
	 @Path ("add-powerDetails")
	 @Consumes (MediaType.APPLICATION_JSON)
	 public String addPowerDetails(PowerConsumption powerConsumption ) {
		 	
		 return powerconsumptioneService.addPowerDetails(powerConsumption);
		
	 }
	 
	 @DELETE
	 @Path("delete/{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public String getUserById(@PathParam("id")int id) {
		 
		return powerconsumptioneService.deletePowerDetails(id);
	}
	 
	 @GET
	 @Path("test/{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<PowerConsumption> getAllUserPowerConsumption(@PathParam("id")int id) {
		 
		 return powerconsumptioneService.getAllUserPowerConsumption(id);
     }
	
}
