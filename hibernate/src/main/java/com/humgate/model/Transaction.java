package com.humgate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Getter @Setter @NoArgsConstructor
public class Transaction implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;

    private BigDecimal amount;

    private Account source;

    private Account target;

    private Instant timestamp;

    public Transaction(BigDecimal amount, Account source, Account target, Instant timestamp) {
        this.amount = amount;
        this.source = source;
        this.target = target;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", source=" + source +
                ", target=" + target +
                ", timestamp=" + timestamp +
                '}';
    }
}
