/**
 * Last Name: Zar
 * First Name: Ilan
 */
//the exception should be used if rented period is defined wrongly
public class RentPeriodException extends Exception {
    public RentPeriodException() {}
    public RentPeriodException(String message) {
        super(message);
    }
}

