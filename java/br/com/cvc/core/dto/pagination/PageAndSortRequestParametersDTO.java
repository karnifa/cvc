package br.com.cvc.core.dto.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageAndSortRequestParametersDTO {
    
    private Integer offset;
    private Integer limit;
    private String sort;
    private String sortBy;
}