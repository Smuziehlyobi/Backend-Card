package com.hackathon.prduction.domain.mapper.transaction;

import com.hackathon.prduction.domain.dto.transaction.TransactionRequestDTO;
import com.hackathon.prduction.domain.dto.transaction.TransactionResponseDTO;
import com.hackathon.prduction.domain.entity.Transaction;
import com.hackathon.prduction.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionResponseMapper extends EntityRequestMapper<TransactionResponseDTO, Transaction> {
    @Override
    Transaction toEntity(TransactionResponseDTO dto);

    @Override
    TransactionResponseDTO toDto(Transaction entity);

    @Override
    List<Transaction> toEntity(List<TransactionResponseDTO> dtoList);

    @Override
    List<TransactionResponseDTO> toDto(List<Transaction> entityList);
}
