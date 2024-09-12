package br.com.cvc.core.dto.log;

import java.time.LocalDateTime;

public record LogDTO(String uuid, LocalDateTime datetime, String user, String service, String type, RequestDTO request, ResponseDTO response, String infoFromDatabase) {}
