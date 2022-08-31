package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "transactions")
@Getter @Setter @NoArgsConstructor
public class Transaction implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @JoinColumn(name = "source", nullable = false)
    @ManyToOne(fetch=FetchType.LAZY)
    private Account source;

    @JoinColumn(name = "target", nullable = false)
    @ManyToOne(fetch=FetchType.LAZY)
    private Account target;

    @Column(name = "timestamp", nullable = false)
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
