package br.com.cvc.core.dto.corpauth;

import br.com.cvc.core.dto.log.LogDTO;

public record OrcCorpAuthLoginResponseDTO(String accessToken, String refreshToken, String sub, String defaultContext, String scope, String iss, String tokenType, int expiresIn, LogDTO logDTO) {
    public OrcCorpAuthLoginResponseDTO withLog(LogDTO newLogDTO) {
        return new OrcCorpAuthLoginResponseDTO(this.accessToken,this.refreshToken,this.sub, this.defaultContext,this.scope,this.iss,this.tokenType, this.expiresIn, newLogDTO);
    }
}
