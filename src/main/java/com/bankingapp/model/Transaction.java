package com.bankingapp.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private LocalDateTime timestamp;

    private String remarks;

    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private Account senderAccount;

    @ManyToOne
    @JoinColumn(name = "recipient_account_id")
    private Account recipientAccount;

    // Getters and setters
}
