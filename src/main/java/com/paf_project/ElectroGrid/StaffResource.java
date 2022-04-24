package com.paf_project.ElectroGrid;


import java.util.Arrays;
import java.util.List;

import com.paf_project.ElectroGrid.Business.StaffService;
import com.paf_project.ElectroGrid.Model.Staff;
import com.paf_project.ElectroGrid.Model.UnitValue;

import jakarta.validation.constraints.Past;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("staff")
public class StaffResource {
	  
	
	StaffService Sservice = new StaffService();
	
	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public List <Staff> getStaff()
		{		  		  
		  
		  System.out.println("staff called ");		 
		  return Sservice.getStaffs();     																																																									  
	    }
	
	@GET
	@Path("getStaff/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Staff getStaff(@PathParam("id") int id)
	{		  		  
	  		 
	  return Sservice.getStaff(id);     																																																									  
    }
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("AddStaff")
	public String addStaff(Staff staff)
	{		
		// System.out.println(staff);
		 Sservice.addStaff(staff);
		// return staff;
		 return "Success";
	}

	 @PUT
	 @Path ("updateStaff/{id}")
	 @Consumes (MediaType.APPLICATION_JSON)
	 public String updateStaff( Staff staff) {
			
		 return Sservice.updateStaff(staff);
		
	 }
	 
	 @DELETE
	 @Path("delete/{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public String getStaffById(@PathParam("id")int id) {
		
		return Sservice.deleteStaff(id);
	}
	
	
}
