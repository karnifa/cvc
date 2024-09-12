package br.com.cvc.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RuleDTO {
    private Long id;
    private String name;
    private String user;
    private List<RuleItemDTO> ruleItems;
    private LocalDateTime updatedAt;
}
