package jsmg.cargocliente.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExep extends RuntimeException {
    public  BadRequestExep (String message){
        super(message);
    }
}
