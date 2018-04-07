package com.techm.ms.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techm.ms.model.User;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This is the Interface definition for User Resource
 * 
 */
@RequestMapping("/user")
@Produces({ MediaType.APPLICATION_JSON })
public interface UserResource {

	/**
	 * Service definition which create the user account
	 * 
	 * @return Response - Returns the details of the response.
	 */
	@PostMapping(value = "/createUser")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Create Account Resource", notes = "Create the new user account in ResourceCollection representation format", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 201, message = "OK"),
			@ApiResponse(code = 409, message = "Unable to create. A Account with name already exist") })
	public Response createUser(@RequestBody User user);

	/**
	 * Service definition which returns the perticular user accounts
	 * 
	 * @return Response - Returns the details of the accounts being searched
	 */
	@GetMapping(value = "/getUser/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Get Account Resource", notes = "Returns all the accounts in ResourceCollection representation format", response = Response.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "Account with given id not found") })
	public Response getUserAccount(@PathVariable("id") final String id);
}