package za.ac.cput.student.service;
/*
 * name: Taariq Khan
 * student number: 219231141
 *
 *
 *
 *
 * */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.student.StudentAddressFactory;
import za.ac.cput.service.student.Impl.StudentAddressServiceImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentAddressServiceImplTest
{

    @Autowired private StudentAddressServiceImpl studentAddressServiceImpl;


    Address address = AddressFactory.build("45","Parklands","23","Jordan",1237);
    StudentAddress studentAddress = StudentAddressFactory.build("1234",address);


    @Test
    @Order(1)
    void save()
    {
        StudentAddress studaddr = studentAddressServiceImpl.save(studentAddress);
        assertNotNull(studaddr);
    }

    @Test
    @Order(2)
    void read()
    {
        Optional<StudentAddress> studaddr = studentAddressServiceImpl.read("1234");
        assertAll
                (
                        () -> assertTrue(studaddr.isPresent()),
                        () -> assertNotNull(studaddr)
                );
        System.out.println(studaddr);
    }

    @Test
    @Order(3)
    void delete()
    {
        studentAddressServiceImpl.delete(studentAddress);
        List<StudentAddress > studaddr = studentAddressServiceImpl.findByStudentId(studentAddress.getStudentId());
        assertEquals(0,studaddr.size());
        assertNotNull(studaddr);
    }

    @Test
    @Order(4)
    void findById()
    {
        List<StudentAddress > studaddr = studentAddressServiceImpl.findByStudentId(studentAddress.getStudentId());
        assertEquals(0,studaddr.size());
        assertNotNull(studaddr);
    }
}
