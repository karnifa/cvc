package br.com.cvc.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LogFilterAttributeEnum {
    UUID,
    USER,
    SERVICE,
    TYPE,
    REQUEST_METHOD,
    REQUEST_URL,
    RESPONSE_STATUS_CODE
}