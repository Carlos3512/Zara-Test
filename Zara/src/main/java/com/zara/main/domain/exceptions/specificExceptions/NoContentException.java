package com.zara.main.domain.exceptions.specificExceptions;


import com.zara.main.domain.exceptions.GenericException;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.lang.NonNull;


@EqualsAndHashCode(callSuper = true)
@Value
public class NoContentException extends GenericException {
    public NoContentException(@NonNull String textDescription) {
        super(textDescription);
    }
}
