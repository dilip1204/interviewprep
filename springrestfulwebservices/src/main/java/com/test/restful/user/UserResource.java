package com.test.restful.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.restful.exception.UserNotFoundException;

@RestController
public class UserResource {

	@Autowired
	private UserService service;

	// return all user
	@GetMapping(path = "/users")
	public List<User> fetchAllUser() {
		return service.findALl();
	}

	@GetMapping("/user/{id}")
	public Resource<User> retriveBasedonId(@PathVariable int id) {
		User findOne = service.findOne(id);

		if (findOne == null) {

			throw new UserNotFoundException("id - " + id);
		}

		Resource<User> res = new Resource<User>(findOne);
		ControllerLinkBuilder linkTos = linkTo(methodOn(this.getClass()).fetchAllUser());
		res.add(linkTos.withRel("Fetching all users"));

		return res;
	}

	@DeleteMapping("/user/{id}")
	public void deleteBasedonId(@PathVariable int id) {
		User findOne = service.deleteById(id);
		if (findOne == null) {
			throw new UserNotFoundException("id - " + id);
		}
		// return findOne;
	}

	@PostMapping("/createUser")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User userDetail = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(userDetail.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
