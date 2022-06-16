package za.ac.cput.service.student;

import za.ac.cput.domain.student.StudentAddress;
import za.ac.cput.service.Interface.IService;

import java.util.List;

public interface StudentAddressService extends IService<StudentAddress, String>
{
    List<StudentAddress> findByStudentId(String studentId);
}
