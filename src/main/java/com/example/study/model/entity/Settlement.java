package com.example.study.model.entity;

import com.example.study.model.network.response.SettlementApiResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
@Entity
public class Settlement {

    @Id
    private Long id;

    private BigDecimal price;

    public SettlementApiResponse toApiResponse() {

        return SettlementApiResponse.builder()
                .id(id)
                .price(price)
                .build();
    }
}
