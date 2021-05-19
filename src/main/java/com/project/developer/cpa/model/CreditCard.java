package com.project.developer.cpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private Long creditCardNumber;
    @NonNull
    private String userName;
    @NonNull
    private Long limit;
    @NonNull
    private Long balance;

}
