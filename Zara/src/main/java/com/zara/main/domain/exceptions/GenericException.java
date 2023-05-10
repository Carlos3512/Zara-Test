package com.zara.main.domain.exceptions;

import lombok.*;

@Data
@AllArgsConstructor
public class GenericException extends Exception {
    @NonNull
    private final String textDescription;



}
