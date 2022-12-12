package jsmg.cargocliente.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoContentExep extends RuntimeException{
    public  NoContentExep(String message){
        super(message);
    }
}
