package com.br.wallet.service;

import com.br.wallet.dto.request.WalletRequestDTO;
import com.br.wallet.dto.response.WalletResponseDTO;
import com.br.wallet.entity.Wallet;
import com.br.wallet.exception.WalletNotFoundException;
import com.br.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public List<WalletResponseDTO> getAllWallets(){
        List<Wallet> wallets = walletRepository.findAll();
        return wallets.stream()
                .map(wallet -> new WalletResponseDTO(wallet.getId(), wallet.getUserId(), wallet.getBalance()))
                .collect(Collectors.toList());
    }

    public WalletResponseDTO getWalletById(Long id){
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found with ID: " + id));
        return new WalletResponseDTO(wallet.getId(), wallet.getUserId(), wallet.getBalance());
    }

    public WalletResponseDTO createWallet(WalletRequestDTO walletRequestDTO){
        Wallet wallet = new Wallet(walletRequestDTO.getUserId(), walletRequestDTO.getInitialBalance());
        Wallet savedWallet = walletRepository.save(wallet);
        return new WalletResponseDTO(savedWallet.getId(), savedWallet.getUserId(), savedWallet.getBalance());
    }

    public WalletResponseDTO updateWallet(Long id, WalletRequestDTO walletRequestDTO){
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found with ID: " + id));

        wallet.setUserId(walletRequestDTO.getUserId());
        wallet.setBalance(walletRequestDTO.getInitialBalance());

        Wallet updatedWallet = walletRepository.save(wallet);
        return new WalletResponseDTO(updatedWallet.getId(), updatedWallet.getUserId(), updatedWallet.getBalance());

    }

    public void deleteWallet(Long id){
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found with ID: " + id));

        walletRepository.delete(wallet);
    }





}
