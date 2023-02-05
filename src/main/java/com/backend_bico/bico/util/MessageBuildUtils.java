package com.backend_bico.bico.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MessageBuildUtils {

    public static String buildMessage(String constante, Object... variavel) {
        return String.format(constante, variavel);
    }

}
