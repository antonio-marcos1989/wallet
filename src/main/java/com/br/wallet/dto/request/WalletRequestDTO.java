package com.br.wallet.dto.request;

import java.math.BigDecimal;

public class WalletRequestDTO {
    private String userId;
    private BigDecimal initialBalance;
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }
}
