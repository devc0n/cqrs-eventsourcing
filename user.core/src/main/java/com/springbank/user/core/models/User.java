package com.springbank.user.core.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
@Document(collection = "users") // Same as @Entity for mysql, but for mongo
public class User {
    @Id
    private String id;

    @NotEmpty(message = "firstname is mandatory")
    private String firstname;

    @NotEmpty(message = "lastname is mandatory")
    private String lastname;

    @Email(message = "please provide a valid email address")
    private String emailAddress;

    @NotNull(message = "please provide account credentials")
    @Valid
    private Account account;
}
