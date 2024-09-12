package br.com.cvc.core.dto.log;

import br.com.cvc.core.enums.LogFilterAttributeEnum;

import java.time.LocalDateTime;

public record LogSearchFilterDTO(LogFilterAttributeEnum attribute, String value, LocalDateTime beginDate, LocalDateTime finalDate, String accessToken, String uuid, String user) {
    public LogSearchFilterDTO withAccessToken(String newAccessToken) {
        return new LogSearchFilterDTO(this.attribute, this.value, this.beginDate, this.finalDate, newAccessToken, this.uuid, this.user);
    }

    public LogSearchFilterDTO withUuid(String newUuid) {
        return new LogSearchFilterDTO(this.attribute, this.value, this.beginDate, this.finalDate, this.accessToken, newUuid, this.user);
    }

    public LogSearchFilterDTO withUser(String newUser) {
        return new LogSearchFilterDTO(this.attribute, this.value, this.beginDate, this.finalDate, this.accessToken, this.uuid, newUser);
    }
}
