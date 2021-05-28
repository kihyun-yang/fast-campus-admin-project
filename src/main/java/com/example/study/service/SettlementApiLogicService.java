package com.example.study.service;

import com.example.study.model.entity.Settlement;
import com.example.study.model.network.response.SettlementApiResponse;
import com.example.study.repository.SettlementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SettlementApiLogicService {

    private final SettlementRepository settlementRepository;

    public SettlementApiResponse getSettlement(Long userId) {

        return settlementRepository.findById(userId)
                .map(Settlement::toApiResponse)
                .orElseThrow(() -> new RuntimeException("데이터가 없습니다"));
    }

}
