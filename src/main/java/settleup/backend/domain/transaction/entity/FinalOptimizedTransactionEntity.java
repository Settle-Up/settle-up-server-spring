package settleup.backend.domain.transaction.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import settleup.backend.domain.group.entity.GroupEntity;
import settleup.backend.domain.receipt.entity.ReceiptEntity;
import settleup.backend.domain.user.entity.UserEntity;
import settleup.backend.global.common.Status;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "final_optimized_transaction")
public class FinalOptimizedTransactionEntity implements TransactionalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_uuid", nullable = false, unique = true)
    private String transactionUUID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    private GroupEntity group;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_user")
    private UserEntity senderUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_user")
    private UserEntity recipientUser;

    @Column(name = "transaction_amount", nullable = false)
    private double transactionAmount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status isUsed;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_sender_status", nullable = false)
    private Status isSenderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_recipient_status", nullable = false)
    private Status isRecipientStatus;

    @Column(name = "clear_status_timestamp")
    @Setter
    private LocalDateTime clearStatusTimestamp;


    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public UserEntity getSenderUser() {
        return this.senderUser;
    }

    @Override
    public UserEntity getRecipientUser() {
        return this.recipientUser;
    }

    @Override
    public double getTransactionAmount() {
        return this.transactionAmount;
    }

    @Override
    public String getTransactionUUID() {
        return this.transactionUUID;
    }

    @Override
    public Status getIsSenderStatus() {
        return this.isSenderStatus;
    }

    @Override
    public Status getIsRecipientStatus() {
        return this.isRecipientStatus;
    }

    @Override
    public LocalDateTime getClearStatusTimeStamp() {
        return this.clearStatusTimestamp;
    }
}

