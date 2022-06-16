package za.ac.cput.student.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.student.StudentAddressFactory;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.student.Impl.StudentAddressRepositoryImpl;
import za.ac.cput.repository.student.StudentAddressRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentAddressRepositoryImplTest
{
    private StudentAddress studentAddress;
    private StudentAddressRepository repository;
    private Address address;

    @BeforeEach void setUp()
    {
        this.address = AddressFactory.build("45","Parklands","23","Jordan",1237);
        this.studentAddress = StudentAddressFactory.build("2134", address);
        this.repository = StudentAddressRepositoryImpl.studentAddressRepository();
    }
    @AfterEach void tearDown()
    {
        this.repository.delete(this.studentAddress);
    }

    @Test
    void save()
    {
        StudentAddress saved = this.repository.save(this.studentAddress);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.studentAddress, saved);
    }

    @Test
    void read()
    {
        StudentAddress saved = this.repository.save(this.studentAddress);
        Optional<StudentAddress> read = this.repository.read(saved.getStudentId());
        System.out.println(read);
        assertTrue(read.isPresent());
        assertSame(saved, read.get());
    }

    @Test
    void delete()
    {
        StudentAddress saved = this.repository.save(this.studentAddress);
        List<StudentAddress> studentAddressList = this.repository.findByStudentId(saved.getStudentId());
        assertEquals(1,studentAddressList.size());
        //System.out.println(saved);
        this.repository.delete(saved);
        studentAddressList = this.repository.findByStudentId(saved.getStudentId());
        assertEquals(0,studentAddressList.size());

    }

    @Test
    void findByStudentId()
    {
        this.repository.save(this.studentAddress);
        List<StudentAddress> studentAddressList = this.repository.findByStudentId(studentAddress.getStudentId());
        System.out.println(studentAddressList);
        assertEquals(1,studentAddressList.size());
    }
}