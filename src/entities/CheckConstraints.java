package entities;

import exceptions.EntityException;

/**
 *
 * @author Hemrik Balázs
 */
public class CheckConstraints {

    private CheckConstraints(){}
    
    static void checkTextLength(int max, String data, String fieldName) {
        int length = data.length();
        if (length > max) {
            throw new EntityException(
                    fieldName + "length has to be max: " + max);
        }
    }
    
    static void checkNumberLowerBound(int lowerBound, int number, String fieldName) {
        if (number < lowerBound){
            throw new EntityException(
            fieldName + "value has to be equal or greater than: " + lowerBound);
        }
    }
    
    static void checkIDFormat(String id, String fieldName){
        String regex = "^[A-Z]{2}\\d{8}$";
        if (!id.matches(regex)){
            throw new EntityException(
            fieldName + "has to be 2 upper case letters followed by 8 digits");
        }
    }
}
