package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.student.StudentAddress;

public class AddressFactory
{
    public static Address build(String unitNumber, String complexName, String streetNumber, String streetName, int postalCode)
    {
        if(unitNumber.isEmpty() || unitNumber == null)//you have to provide studentId
            throw new IllegalArgumentException("student ID is required");
        if(complexName.isEmpty() || complexName == null)//you have to provide studentId
            throw new IllegalArgumentException("student ID is required");
        if(streetNumber.isEmpty() || streetNumber == null)//you have to provide studentId
            throw new IllegalArgumentException("student ID is required");
        if(streetName.isEmpty() || streetName == null)//you have to provide studentId
            throw new IllegalArgumentException("student ID is required");
        if(postalCode < 1000 || postalCode >9999 )//you have to provide studentId
            throw new IllegalArgumentException("Postal code required 4 digits number between 1000-9999");
        return new Address.Builder().unitNumber(unitNumber).complexName(complexName).streetNumber(streetNumber).streetName(streetName).postalCode(postalCode).build();

    }
}
