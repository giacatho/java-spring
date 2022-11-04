package sg.nus.iss.validator.workshop.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sg.nus.iss.validator.workshop.model.Customer;

@Component
public class CustomerValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return Customer.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    Customer customer = (Customer) target;
    
    String gender = customer.getGender();
    if (!gender.isBlank()) {
      if (!gender.equalsIgnoreCase("Male") &&
          !gender.equalsIgnoreCase("Female") &&
          !gender.equalsIgnoreCase("Other") ) {
        errors.rejectValue("gender", "error.gender", "Gender must be either Male, Female, or Other");
      }
    }
    
    String ccNumber = customer.getCreditCardNumber();
    String ccExpiration = customer.getCreditCardExpiration();
    String ccCVV = customer.getCreditCardCVV();
    
    if ( !ccNumber.isBlank() ||
          !ccExpiration.isBlank() ||
          !ccCVV.isBlank()  ) {
      System.out.println("ccNumber " + ccNumber);
      System.out.println("expiration " + ccExpiration);
      System.out.println("ccCVV " + ccCVV);
     if (ccNumber.isBlank()) {
       errors.rejectValue("creditCardNumber", "error.creditCardNumber", "Number is required");
     }
     if (ccExpiration.isBlank()) {
       errors.rejectValue("creditCardExpiration", "error.creditCardExpiration", "Expiration is required");
     }
     if (ccCVV.isBlank()) {
       errors.rejectValue("creditCardCVV", "error.creditCardCVV", "CVV is required");
     }
   }
    
    
//    if ( (ccNumber != null  && !ccNumber.isBlank()) ||
//         (ccExpiration != null && !ccExpiration.isBlank()) ||
//         (ccCVV != null && !ccCVV.isBlank())  ) {
//      
//      if (ccNumber == null || ccNumber.isBlank()) {
//        errors.rejectValue("creditCardNumber", "error.creditCardNumber", "Number is required");
//      }
//      if (ccExpiration == null || ccExpiration.isBlank()) {
//        errors.rejectValue("creditCardExpiration", "error.creditCardExpiration", "Expiration is required");
//      }
//      if (ccCVV == null || ccCVV.isBlank()) {
//        errors.rejectValue("getCreditCardCVV", "error.getCreditCardCVV", "Credit card number is required");
//      }
//    }
    
    //String expiration = customer.getCreditCardExpiration();
    
    
  }
}
