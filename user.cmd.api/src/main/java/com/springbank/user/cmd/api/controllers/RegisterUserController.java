package com.springbank.user.cmd.api.controllers;

import com.springbank.user.cmd.api.commands.RegisteruserCommand;
import com.springbank.user.cmd.api.dto.RegisterUserResponse;
import com.springbank.user.core.models.User;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/registerUser")
public class RegisterUserController {
    private final CommandGateway commandGateway;

    @Autowired
    public RegisterUserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public ResponseEntity<RegisterUserResponse> registerUser(@Valid @RequestBody RegisteruserCommand command) {
        command.setId(UUID.randomUUID().toString());
        try {
            commandGateway.send(command);
            return new ResponseEntity<>(new RegisterUserResponse("User successfully registered"), HttpStatus.CREATED);
        } catch (Exception e) {
            var safeErrorMessage = "Error while processing register user request for id - " + command.getId();
            System.out.println(e);

            return new ResponseEntity<>(new RegisterUserResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
