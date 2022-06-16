package za.ac.cput.service.student.Impl;

import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.student.Impl.StudentAddressRepositoryImpl;
import za.ac.cput.repository.student.StudentAddressRepository;
import za.ac.cput.service.student.StudentAddressService;

import java.util.List;
import java.util.Optional;

public class StudentAddressServiceImpl implements StudentAddressService
{
    private final StudentAddressRepository repository;
    private static StudentAddressService SERVICE;

    private StudentAddressServiceImpl()
    {
        this.repository = StudentAddressRepositoryImpl.studentAddressRepository();
    }

    public static StudentAddressService getService()
    {
        if (SERVICE == null)
            SERVICE = new StudentAddressServiceImpl();//instantiates
        return SERVICE;//returns instance
    }
    @Override
    public StudentAddress save(StudentAddress studentAddress)
    {
        return this.repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(String s)
    {
        return this.repository.read(s);
    }

    @Override
    public void delete(StudentAddress studentAddress)
    {
        this.repository.delete(studentAddress);
    }

    @Override
    public List<StudentAddress> findByStudentId(String studentId)
    {
        return this.repository.findByStudentId(studentId);
    }
}
