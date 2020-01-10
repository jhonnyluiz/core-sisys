package com.jlcabral.sisys.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.service.Messages;

@RestController
@RequestMapping(path = "example")
public class ExampleResource {

	@Autowired
	private Messages messages;

	@PostMapping
	public String getMessage(@RequestBody String msg) {
		return messages.get(msg, "teste");
	}
}
