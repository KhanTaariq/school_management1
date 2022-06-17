package za.ac.cput.domain.student;

import za.ac.cput.domain.Address;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class StudentAddress
{
    @NotNull @Id  private String studentId;
    @NotNull private Address address; //Address is a class

    protected StudentAddress()
    {

    }

    private StudentAddress(Builder builder)
    {
        this.studentId = builder.studentId;
        this.address = builder.address;
    }
    public String getStudentId()
    {
        return studentId;
    }
    public Address getAddress()
    {
        return address;
    }


    /*public static class StudentAddressId //immutable class
    {
        private String studentId;
        private Address address;

        public StudentAddressId(String studentId, Address address)
        {
            this.studentId = studentId;
            this.address = address;
        }

        public String getStudentId()
        {
            return studentId;
        }

        public Address getAddress()
        {
            return address;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentAddressId that = (StudentAddressId) o;
            return studentId.equals(that.studentId) && address.equals(that.address);
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(studentId, address);
        }
    }*/

    @Override
    public String toString()
    {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }

    public static class Builder
    {
        private String studentId;
        private Address address;

        public Builder setStudentId(String studentId)
        {
            this.studentId = studentId;
            return this;
        }
        public Builder setAddress(Address address)
        {
            this.address = address;
            return this;
        }
        public Builder copy(StudentAddress studentAddress)
        {
            this.studentId = studentAddress.studentId;
            this.address = studentAddress.address;
            return this;
        }

        public StudentAddress build()
        {
            return new StudentAddress(this);
        }
    }
}

