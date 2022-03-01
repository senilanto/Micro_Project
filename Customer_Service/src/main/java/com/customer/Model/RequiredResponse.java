package com.customer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {

    private List<Account> account_model;
    private Customer customer_model;

}
