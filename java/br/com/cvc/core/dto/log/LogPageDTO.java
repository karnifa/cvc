package br.com.cvc.core.dto.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record LogPageDTO (

        List<LogDTO> content,
        PageableDTO pageable,
        boolean last,
        long totalElements,
        int totalPages,
        boolean first,
        int numberOfElements,
        int size,
        int number,
        SortDTO sort,
        boolean empty,
        LogDTO log) {
    public LogPageDTO initContentIfNull() {
        return new LogPageDTO(Objects.requireNonNullElseGet(this.content, ArrayList::new), pageable, last, totalElements, totalPages, first, numberOfElements, size, number, sort, empty, this.log);
    }

    public LogPageDTO withLogDTO(LogDTO newLogDTO) {
        return new LogPageDTO(content, pageable, last, totalElements, totalPages, first, numberOfElements, size, number, sort, empty, newLogDTO);
    }
}