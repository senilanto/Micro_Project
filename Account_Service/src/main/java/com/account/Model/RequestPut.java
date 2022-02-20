package com.account.Model;

import com.account.Enum.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPut {

    private int unquie_id;
    private int cash;
    private AccountType accountType;
}
