package br.com.cvc.core.util;

import java.util.UUID;

public class GenerateUuidUtils {
    public static String execute() {
        return UUID.randomUUID().toString();
    }
}
