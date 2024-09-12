package br.com.cvc.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleItemDTO {

    private Long id;
    private Long ruleId;
    private ParameterTypeDTO parameterType;
    private String value1;
    private String value2;
    private String value3;
    private String value4;
    private String value5;
    private String user;
    private LocalDateTime updatedAt;
}