package com.example.study.controller.api;

import com.example.study.model.network.response.SettlementApiResponse;
import com.example.study.service.SettlementApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * settlement 테이블 create sql
 * create table settlement (id bigint not null, price decimal(19,2), primary key (id)) engine=InnoDB
 *
 * data insert
 * insert into settlement(id, price) values(1, 124000)
 *
 *
 */

@RequiredArgsConstructor
@RequestMapping("/settlement")
@RestController
public class SettlementApiController {

    private final SettlementApiLogicService settlementApiLogicService;

    @GetMapping("{id}")
    public ResponseEntity<SettlementApiResponse> getSettlement(@PathVariable(name = "id") Long userId) {

        return ResponseEntity.ok(settlementApiLogicService.getSettlement(userId));
    }

}
