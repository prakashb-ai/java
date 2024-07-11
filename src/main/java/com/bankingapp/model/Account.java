package com.bankingapp.model;

import jakarta.persistence.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;

    private Double balance;

    @ManyToOne
    private Applicant applicant;

    @OneToMany(mappedBy = "senderAccount", cascade = CascadeType.ALL)
    private List<Transaction> sentTransactions;

    @OneToMany(mappedBy = "recipientAccount", cascade = CascadeType.ALL)
    private List<Transaction> receivedTransactions;

    // Getters and setters
}
