package com.springbank.user.cmd.api.controllers;

import com.springbank.user.cmd.api.commands.RemoveUserCommand;
import com.springbank.user.cmd.api.commands.UpdateUserCommand;
import com.springbank.user.cmd.api.dto.BaseResponse;
import com.springbank.user.cmd.api.dto.RegisterUserResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/removeUser")
public class RemoveUserController {
    private final CommandGateway commandGateway;

    @Autowired
    public RemoveUserController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<BaseResponse> updateUser(@PathVariable String id) {
        try {
            var command = new RemoveUserCommand(id);
            commandGateway.send(command);
            return new ResponseEntity<>(new BaseResponse("User successfully removed"), HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Error while processing removal of user request for id - " + id;
            System.out.println(e);

            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
