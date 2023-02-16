package com.example.task1.validation;

import com.example.task1.dto.CarRequestDto;
import com.example.task1.exception.GenericValidationException;
import com.example.task1.model.CarType;
import org.springframework.stereotype.Component;

@Component
public class CarValidation {
    public void validate(CarRequestDto carRequestDto){

        if(!checkCarType(carRequestDto.getCarType())){
            throw new GenericValidationException("Cartype isn't correct.");
        }
        if(carRequestDto.getYear() == null){
            throw new GenericValidationException("Year must not be null.");
        }
        if(carRequestDto.getRegistrationMark().isBlank()){
            throw new GenericValidationException("Registration mark must not be null.");
        }
        validateRegistration(carRequestDto.getRegistrationMark());
        if(carRequestDto.getColor().isBlank()){
            throw new GenericValidationException("Color must not be blank");
        }
    }
    private boolean checkCarType(String carType){
        for (CarType c : CarType.values()) {
            if (c.name().equals(carType)) {
                return true;
            }
        }
        return false;
    }

    public void validateRegistration(String registrationMark){
        if(!Character.isLetter(registrationMark.charAt(0)) || !Character.isLetter(registrationMark.charAt(1)) ){
            throw new GenericValidationException("Registration mark starts with 2 letters.");
        }
        if(!Character.isWhitespace(registrationMark.charAt(2)) ||
                !Character.isWhitespace(registrationMark.charAt(registrationMark.length()-3))){
            throw new GenericValidationException("Whitespace required.");
        }
        if(!Character.isLetter(registrationMark.charAt(registrationMark.length()-2)) ||
                !Character.isLetter(registrationMark.charAt(registrationMark.length()-1))){
            throw new GenericValidationException("Registration mark ends with 2 letters.");
        }
        if(registrationMark.length()<9 || registrationMark.length()>11){
            throw new GenericValidationException("Registration mark has from 9 to 11 characters.");
        }
        for(int i=3; i<registrationMark.length()-3;i++){
            if(!Character.isDigit(registrationMark.charAt(i))){
                throw new GenericValidationException("Only numbers allowed between letters and whitespaces.");
            }
        }

    }
}
