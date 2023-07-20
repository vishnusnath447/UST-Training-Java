package com.stackroute.commonjavaclasses;

public class WrapperClassConvert {

    //write logic to determine and convert given primitive type to its wrapper class and return result
    public Object convertToWrapper(Object input) {
        if(input instanceof Integer){
            Integer obj = (Integer) input;
            return obj;
        } else if (input instanceof Character) {
            Character obj = (Character) input;
            return obj;
        } else if(input instanceof Double){
            Double obj = (Double) input;
            return obj;
        } else if (input instanceof Short) {
            Short obj = (Short) input;
            return obj;
        }else if (input instanceof Long) {
            Long obj = (Long) input;
            return obj;
        }else if (input instanceof Boolean) {
            Boolean obj = (Boolean) input;
            return obj;
        }else if (input instanceof Float) {
            Float obj = (Float) input;
            return obj;
        }else if (input instanceof Byte) {
            Byte obj = (Byte) input;
            return obj;
        }
        else {
            return "Give proper primitive type as input";
        }
    }
}

