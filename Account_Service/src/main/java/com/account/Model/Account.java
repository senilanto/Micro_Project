package com.account.Model;

import com.account.Enum.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "account_details")
public class Account {
    @NotNull(message = "Id should not be null")
    private  int customerid;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Acccount id cannot be empty")
    private  int account_id;

    @NotNull
    private Date createdDate;

@NotNull(message = "Date should not be null")
    private LocalDateTime createdCurrentDate =LocalDateTime.now();

@NotNull(message = "Enter account balanace")
    private float accountBalance;

@NotNull(message = "Enter active or not")
private Boolean isActive;

@NotNull(message = "Account Type cannot be null")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;


}
