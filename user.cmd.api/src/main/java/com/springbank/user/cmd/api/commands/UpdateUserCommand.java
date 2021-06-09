package com.springbank.user.cmd.api.commands;

import com.springbank.user.core.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UpdateUserCommand {
    @TargetAggregateIdentifier // so axon knows which aggregate has to pick up the command
    private String id;

    @Valid
    @NotNull(message = "No user details were provided")
    private User user;
}
