package com.example.student_library_management_system.Model;

import com.example.student_library_management_system.Enum.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="transaction")
@Builder
public class Transaction {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="transaction_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column(name="transaction_id", nullable = false)
    private String transactionId = UUID.randomUUID().toString();

    @Column(name="fine", nullable = false)
    private double fine;

    @Column(name="transaction_date", nullable = false)
    @CreationTimestamp
    private Date transactionDate;

    @Column(name="is_issue_operation", nullable = false)
    private boolean isIssueOperation;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Book book;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Card card;
}
