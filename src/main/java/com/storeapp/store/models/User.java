package com.storeapp.store.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="USERTABLE")
@Getter
@Setter
public class User {

    @JsonIgnore
    @ManyToMany(mappedBy = "userList")
    private List<Role> roles;

    @Id
    @Min(value = 1)
    @SequenceGenerator(name="user_seq", initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name="userId")
    private long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String shippingAddressId;
    private String billingAddressId;
    private String phoneNumber;
}
