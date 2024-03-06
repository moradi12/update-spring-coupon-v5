package com.coupon.project.database.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity()
@Table(name = "customers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 20, name = "first_name")
    private String firstName;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(nullable = false, length = 20, name = "last_name")
    private String lastName;

    @NotNull
    @Size(min = 5, max = 50)
    @Column(nullable = false, length = 50, name = "email")
    private String email;

    @NotNull
    @Size(min = 6, max = 20)
    @Column(nullable = false, length = 20, name = "password")
    private String password;

    private List<Coupon> coupons;
}