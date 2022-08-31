package com.humgate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "accounts")
public class Account implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", nullable = false)
    private long number;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "source")
//    @BatchSize(size = 10)
      @LazyCollection(LazyCollectionOption.EXTRA)
//    @Fetch(FetchMode.SELECT)
    private List<Transaction> transactionsWithSource;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "target")
//    private List<Transaction> transactionsWithTarget;

    public Account(long number, String description) {
        this.number = number;
        this.description = description;
    }
}