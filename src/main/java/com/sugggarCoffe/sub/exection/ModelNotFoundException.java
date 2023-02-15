package com.sugggarCoffe.sub.exection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends RuntimeException{
	@Serial
    private static final long serialVersionUID = -3772403188868998069L;

	public ModelNotFoundException(String mensaje) {
        super(mensaje);
    }

}
