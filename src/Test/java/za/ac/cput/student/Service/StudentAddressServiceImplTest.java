package za.ac.cput.student.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.controller.student.StudentAddressControllerImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StudentAddressServiceImplTest
{

    @Autowired private StudentAddressControllerImpl controller;


    @BeforeEach
    void setUp()
    {
        assertNotNull(controller);
    }

    @Test
    void save()
    {

    }

    @Test
    void read()
    {

    }

    @Test
    void delete()
    {

    }

    @Test
    void findById()
    {

    }
}
