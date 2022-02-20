package com.customer.Entity;

import com.customer.Enum.CustomerType;
import com.customer.Model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "customer_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

@Id
@Min(0)
@Max(100)
private int customer_id;

@NotEmpty(message = " Name should not be empty")
private String customerFirstName;


private String customerMiddleName;

private String customerLastName;

@NotEmpty(message = "Address should not be empty")
    private String address;

@NotNull(message = "Date cannot be null")
    private LocalDateTime currentDate=LocalDateTime.now();

@NotNull(message ="Currently active or not")
    private Boolean isActive;

@NotNull(message = "It cannot be empty")
private Date createdDate;

    @NotNull(message = "Phone number  cannot be null")
    @Size(min=10,max = 10)
    private String phonenumber;


    @NotNull(message = "Email cannot be null")
    private String email;

    private Account accountModel;
    @NotNull(message = "Customer type cannot be empty")
    private CustomerType customerType;

}
