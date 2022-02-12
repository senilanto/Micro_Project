package com.account_service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "account_details")
public class Account {


    private int accountId;

    @Id
    private  int customerId;
    private Date createdDate;
    private String accountBalance;

}
