package za.ac.cput.repository.student.Impl;

import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.student.StudentAddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Data storing with data structure
public class StudentAddressRepositoryImpl implements StudentAddressRepository
{
    private final List<StudentAddress> studentAddressList;
    private static StudentAddressRepositoryImpl STUDENTADDRESS_REPOSITORY;

    private StudentAddressRepositoryImpl()
    {
        this.studentAddressList = new ArrayList<>();
    }

    public static StudentAddressRepositoryImpl studentAddressRepository()
    {
        if (STUDENTADDRESS_REPOSITORY == null)
            STUDENTADDRESS_REPOSITORY = new StudentAddressRepositoryImpl();//instantiates
        return STUDENTADDRESS_REPOSITORY;//returns instance
    }

    //CRUD operations
    public StudentAddress save(StudentAddress studentAddress)
    {
        Optional<StudentAddress>read = read(studentAddress.getStudentId());
        if(read.isPresent())
        {
            delete(read.get());
        }
        this.studentAddressList.add(studentAddress);
        return studentAddress;

    }

    public Optional<StudentAddress> read(String studentId)
    {
        return this.studentAddressList.stream().filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .findFirst();
       // for(StudentAddress studentAddress : this.studentAddressList)
       // {
       //     if(studentAddress.getStudentId().equalsIgnoreCase(studentId))
       //         return studentAddress;
       // }
        // return null;
    }

    public void delete(StudentAddress studentAddress)
    {
        this.studentAddressList.remove(studentAddress);
    }

    public List<StudentAddress> findByStudentId(String studentId)
    {
        return this.studentAddressList.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .collect(Collectors.toList());
    }
}
