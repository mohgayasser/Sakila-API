package gov.iti.jets.service.util.customAnnotations;

import java.lang.reflect.Field;

public class ValidFieldsValidator {
    public static String validate(Object obj) {
      StringBuilder valid = new StringBuilder("");

        // Check if the object is annotated with @ValidFields
        if (!obj.getClass().isAnnotationPresent(EmptyAnnotation.class)) {
            return "";
        }

        // Get all the fields of the object
        Field[] fields = obj.getClass().getDeclaredFields();

        // Check each field for null or empty value
        for(int i=0;i< fields.length;i++){

            try {
                fields[i].setAccessible(true);

                Object value = fields[i].get(obj);
                System.out.println("object "+value);
                System.out.println("field "+fields[i].getName());
                if (value == null || value.toString().isEmpty() || value.equals(0)) {
                    if(i==0){
                        valid.append("you need to enter value for "+fields[i].getName()+", at the first position \n");
                    }
                   else {
                        valid.append("you need to enter value for "+fields[i].getName()+", After field "+fields[i-1].getName()+"\n");
                    }

                }
            } catch (IllegalAccessException e) {
                // Handle exception
            }
        }

        return valid.toString();
    }
}