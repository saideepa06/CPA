package com.project.developer.cpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private Long creditCardNumber;
    @NonNull
    private String userName;
    @NonNull
    private Long cardLimit;
    @NonNull
    private Long balance;

}
