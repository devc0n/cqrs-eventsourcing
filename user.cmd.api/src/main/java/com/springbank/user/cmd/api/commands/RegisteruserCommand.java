package com.springbank.user.cmd.api.commands;

import com.springbank.user.core.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Validated
public class RegisteruserCommand {
    @TargetAggregateIdentifier // so axon knows which aggregate has to pick up the command
    private String id;

    @NotNull(message = "no user was provided")
    @Valid
    private User user;
}
