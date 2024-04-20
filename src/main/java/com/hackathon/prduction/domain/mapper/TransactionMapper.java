package com.hackathon.prduction.domain.mapper;

import com.hackathon.prduction.domain.dto.TransactionDTO;
import com.hackathon.prduction.domain.entity.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends EntityMapper<TransactionDTO, Transaction> {
    @Override
    Transaction toEntity(TransactionDTO dto);

    @Override
    TransactionDTO toDto(Transaction entity);

    @Override
    List<Transaction> toEntity(List<TransactionDTO> dtoList);

    @Override
    List<TransactionDTO> toDto(List<Transaction> entityList);

}
