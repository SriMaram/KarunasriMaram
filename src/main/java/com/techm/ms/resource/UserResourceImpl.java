package com.techm.ms.resource;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.techm.ms.model.Account;
import com.techm.ms.model.User;
import com.techm.ms.service.AccountService;

@RestController
public class UserResourceImpl implements UserResource {
	public static final Logger logger = LoggerFactory.getLogger(UserResourceImpl.class);

	@Autowired
	AccountService accountService; 

	@Override
	public Response createUser(User user) {
		try {
			System.out.println(user.getId()+user.getName());
			Account account = accountService.findByName(user.getName());
			if (account != null) {
				return Response.status(Status.CONFLICT).build();
			} else {
				accountService.saveAccount(new Account(user.getId(), user.getName()));
				return Response.status(Status.OK).build();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Response getUserAccount(String id) {
		System.out.println(id);
		try {
			Account account = accountService.findById(Long.valueOf(id).longValue());
			if (account != null) {
				return Response.status(Status.OK).build();
			} else {
				return Response.status(Status.NOT_FOUND).build();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
}
