package za.ac.cput.repository.student;

import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.repository.Interface.IRepository;

import java.util.List;

public interface StudentAddressRepository extends IRepository<StudentAddress, String>
{
    List<StudentAddress> findByStudentId(String studentId);
}
