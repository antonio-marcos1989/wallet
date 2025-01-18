package com.br.wallet.controller;

import com.br.wallet.dto.request.WalletRequestDTO;
import com.br.wallet.dto.response.WalletResponseDTO;
import com.br.wallet.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping
    public ResponseEntity<List<WalletResponseDTO>> getAllWallets(){
        List<WalletResponseDTO> wallets = walletService.getAllWallets();
        return ResponseEntity.ok(wallets);
    }
    @GetMapping("/{id}")
    public ResponseEntity<WalletResponseDTO> getWalletById(@PathVariable Long id){
        WalletResponseDTO walletResponseDTO = walletService.getWalletById(id);
        return ResponseEntity.ok(walletResponseDTO);
    }

    @Operation(
            summary = "Create a new wallet",
            description = "Creates a wallet ..."
    )
    @PostMapping
    public ResponseEntity<WalletResponseDTO> createWallet(@RequestBody WalletRequestDTO walletRequestDTO){
        WalletResponseDTO walletResponseDTO = walletService.createWallet(walletRequestDTO);
        return ResponseEntity.ok(walletResponseDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<WalletResponseDTO> updateWallet(@PathVariable Long id, @RequestBody WalletRequestDTO walletRequestDTO){
        WalletResponseDTO walletResponseDTO = walletService.updateWallet(id, walletRequestDTO);
        return ResponseEntity.ok(walletResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWallet(@PathVariable Long id){
        walletService.deleteWallet(id);
        return ResponseEntity.ok("Wallet with ID: " + id + "has been delected.");
    }

}