package com.zara.main.domain.exceptions.specificExceptions;
import com.zara.main.domain.exceptions.GenericException;
import lombok.*;
import org.springframework.lang.NonNull;

@EqualsAndHashCode(callSuper = true)
@Value
public class BadRequestException extends GenericException {

    public BadRequestException(@NonNull String textDescription) {
        super(textDescription);
    }

}
