package br.com.cvc.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupItemDTO {

    private Long id;
    private Long groupId;
    private String value1;
    private String value2;
    private String value3;
    private String value4;
    private String value5;
    private String user;
    private LocalDateTime updatedAt;
}