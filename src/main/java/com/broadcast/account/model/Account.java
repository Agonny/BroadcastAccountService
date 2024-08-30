package com.broadcast.account.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NamedEntityGraph(name = "accountWithAccountData", attributeNodes =
@NamedAttributeNode(value = "accountData", subgraph = "accountDataWithEducationPlaces"), subgraphs =
@NamedSubgraph(name = "accountDataWithEducationPlaces", attributeNodes = @NamedAttributeNode(value = "educationPlaces")))
public class Account {

    @Id
    private String id;

    private String username;

    private String email;

    @JoinColumn(name = "account_data_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AccountData accountData;

}