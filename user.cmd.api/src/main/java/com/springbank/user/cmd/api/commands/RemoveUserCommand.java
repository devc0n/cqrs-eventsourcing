package com.springbank.user.cmd.api.commands;

import com.springbank.user.core.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveUserCommand {
    @TargetAggregateIdentifier // so axon knows which aggregate has to pick up the command
    private String id;
}
