package com.jlcabral.core.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcabral.core.constant.PathResource;
import com.jlcabral.core.service.BusinessMessages;
import com.jlcabral.core.util.ObjUtil;

@RestController
@RequestMapping(path = PathResource.MESSAGES)
public class MessageResource {
	
	@Autowired
	private BusinessMessages messages;

	@GetMapping(path = {"/{codeMsg}/{param}", "/{codeMsg}"})
	public ResponseEntity<String> getMessage(@PathVariable Integer codeMsg, @PathVariable(required = false) String param) {
		String msg = "msg.".concat(String.format("%03d", codeMsg));
		String strMsg = messages.get(msg, ObjUtil.isNotEmpty(param) ? param.split(",") : null);
		return ResponseEntity.ok(strMsg);
	}
}
