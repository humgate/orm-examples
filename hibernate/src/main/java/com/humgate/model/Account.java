package com.humgate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.Set;

@Setter @Getter @NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 2L;

    private Long id;

    private long number;

    private String description;

    private Set<Transaction> transactionsWithSource;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "target")
//    private List<Transaction> transactionsWithTarget;

    public Account(long number, String description) {
        this.number = number;
        this.description = description;
    }
}