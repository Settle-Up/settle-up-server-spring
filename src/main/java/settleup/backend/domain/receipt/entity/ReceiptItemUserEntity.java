package settleup.backend.domain.receipt.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import settleup.backend.domain.user.entity.AbstractUserEntity;
import settleup.backend.global.Helper.Status;

import java.math.BigDecimal;

@Entity
@Table(name = "receipt_item_user")
@Getter
@Setter
public class ReceiptItemUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_item_id", nullable = false)
    private ReceiptItemEntity receiptItem;


    @Column(name = "purchased_quantity",nullable = true)
    private BigDecimal purchasedQuantity;

    @Column(name = "purchased_total_amount",nullable = true)
    private BigDecimal purchasedTotalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private AbstractUserEntity user;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private Status userType;
}

