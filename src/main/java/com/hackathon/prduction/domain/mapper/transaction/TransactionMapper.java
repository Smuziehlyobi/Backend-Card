package com.hackathon.prduction.domain.mapper.transaction;

import com.hackathon.prduction.domain.dto.transaction.TransactionRequestDTO;
import com.hackathon.prduction.domain.entity.Transaction;
import com.hackathon.prduction.domain.mapper.EntityRequestMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends EntityRequestMapper<TransactionRequestDTO, Transaction> {
    @Override
    Transaction toEntity(TransactionRequestDTO dto);

    @Override
    TransactionRequestDTO toDto(Transaction entity);

    @Override
    List<Transaction> toEntity(List<TransactionRequestDTO> dtoList);

    @Override
    List<TransactionRequestDTO> toDto(List<Transaction> entityList);

}
