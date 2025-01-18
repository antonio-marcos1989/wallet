package com.br.wallet.dto.response;

import java.math.BigDecimal;

public class WalletResponseDTO {
    private Long id;
    private String userId;
    private BigDecimal balance;

    public WalletResponseDTO(Long id, String userId, BigDecimal balance) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
