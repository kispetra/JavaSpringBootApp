package com.example.task1.validation;

import com.example.task1.exception.GenericValidationException;
import com.example.task1.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientValidation {
    public void validate(Client client){
        if(client.getFirstName().equals("")){
                throw new GenericValidationException("First name must not be blank.");
        }
        if(client.getLastName().isBlank()){
                throw new GenericValidationException("Last name must not be blank.");
        }
        validateOib(client.getOib());
    }
    public void validateOib(String oib){

        if(oib.isBlank()){
            throw new GenericValidationException("OIB must not be blank.");
        }
        if (oib.length() != 11) {
            throw new GenericValidationException("OIB must contain 11 numbers.");
        }
        for(int i=0; i<oib.length();i++){
            if(!Character.isDigit(oib.charAt(i))){
                throw new GenericValidationException("OIB contains only numbers.");
            }
        }
    }
}

