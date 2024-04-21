package com.hackathon.prduction.services.impl;

import com.hackathon.prduction.domain.fine.FineResponseDTO;
import com.hackathon.prduction.services.FineService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class FineServiceImpl implements FineService {

    @Override
    public List<FineResponseDTO> getAll() {
        return createListFine();
    }

    private List<FineResponseDTO> createListFine() {
        List<FineResponseDTO> responseList = new ArrayList<>();

        FineResponseDTO fineResponseDTO = new FineResponseDTO();
        fineResponseDTO.setValue(520);
        fineResponseDTO.setName("Штраф за парковку в неположенном месте");
        responseList.add(fineResponseDTO);

        FineResponseDTO fineResponseDTOTwo = new FineResponseDTO();
        fineResponseDTOTwo.setValue(550);
        fineResponseDTOTwo.setName("Штраф за превышение скорости");
        responseList.add(fineResponseDTOTwo);

        FineResponseDTO fineResponseDTOThree = new FineResponseDTO();
        fineResponseDTOThree.setValue(1000);
        fineResponseDTOThree.setName("Штраф за выгул собаки без намордника");
        responseList.add(fineResponseDTOThree);

        FineResponseDTO fineResponseDTOFour = new FineResponseDTO();
        fineResponseDTOFour.setValue(5000);
        fineResponseDTOFour.setName("Штраф за программирование не на Жаве");
        responseList.add(fineResponseDTOFour);

        FineResponseDTO fineResponseDTOFive = new FineResponseDTO();
        fineResponseDTOFive.setValue(7000);
        fineResponseDTOFive.setName("Штраф за то, что вы слишком красивый");
        responseList.add(fineResponseDTOFive);

        FineResponseDTO fineResponseDTOSix = new FineResponseDTO();
        fineResponseDTOSix.setValue(300);
        fineResponseDTOSix.setName("Штраф за шум после 22:00");
        responseList.add(fineResponseDTOSix);

        FineResponseDTO fineResponseDTOSeven = new FineResponseDTO();
        fineResponseDTOSeven.setValue(520);
        fineResponseDTOSeven.setName("Просто оплатите штраф...");
        responseList.add(fineResponseDTOSeven);

        FineResponseDTO fineResponseDTOEight = new FineResponseDTO();
        fineResponseDTOEight.setValue(2200);
        fineResponseDTOEight.setName("Штрафик");
        responseList.add(fineResponseDTOEight);

        return responseList;
    }
}
