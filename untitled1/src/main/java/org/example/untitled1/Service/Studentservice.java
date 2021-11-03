package org.example.untitled1.Service;

import org.example.untitled1.Dto.StudentDTO;
import org.example.untitled1.entity.Student;
import org.example.untitled1.reponsitory.StudentDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

public class Studentservice {
    StudentDao studentDao = new StudentDao();

    ConvertDateService convertDateService=new ConvertDateService();
    public Student convertStudentDtoToStudent(StudentDTO studentDTO){
        Student result=new Student();
        if(studentDTO.getBirthday()!=null)
            result.setBirthday(convertDateService.ConvertStringToDate(studentDTO.getBirthday()));//dạng dd/MM/yyyy
        if(studentDTO.getAverageMark()!=null)
            result.setAveragemark(studentDTO.getAverageMark());
        if(studentDTO.getClassName()!=null)
            result.setClassname(studentDTO.getClassName());
        if(studentDTO.getGender()!=null)
            result.setGender(studentDTO.getGender());
        if(studentDTO.getFullName()!=null)
            result.setFullname(studentDTO.getFullName());
        if(studentDTO.getHometown()!=null)
            result.setHometown(studentDTO.getHometown());
        if(studentDTO.getMajor()!=null)
            result.setMajor(studentDTO.getMajor());
        return result;
    }

    public List<Student> getListStudent(){

            return studentDao.getAllStudent();
    }


    public Student findID(int id) {

        return studentDao.findById(id);
    }

    public boolean insert(Student student) {
        List<Student> students = studentDao.getAllStudent();
        students.sort((o1, o2) -> o1.getId() < o2.getId() ? 1 : -1);
        int id = students.get(0).getId() + 1;

        student.setId(id);
        if (student.getFullname() == null) {
            return false;
        }
        if (student.getBirthday() == null){
            return false;
        }
        if (student.getClassname() == null || student.getClassname().length() > 50 || student.getClassname().length() < 1){
            return false;
        }
        if (student.getMajor() == null){
            return false;
        }
        if (student.getHometown() == null){
            return false;
        }
        if (student.getGender() == null){
            return false;
        }
        if (student.getAveragemark() > 10 || student.getAveragemark() < 0){
            return false;
        }
        return studentDao.insertStudent(student);
    }
    public boolean update(Student student) {
//        if(student.getId() <= 0){
//            return false;
//        }
        if (student.getFullname() == null){
            return false;
        }
        if (student.getBirthday() == null){
            return false;
       }
        if (student.getClassname() == null || student.getClassname().length() > 50 || student.getClassname().length() < 1){
            return false;
        }
        if (student.getMajor() == null){
            return false;
        }
        if (student.getHometown() == null){
            return false;
        }
        if (student.getGender() == null){
            return false;
        }
        if (student.getAveragemark() > 10 || student.getAveragemark() < 0){
            return false;
        }
        return studentDao.updateStudent(student);
    }
    public List<Student>findAllStudentBirthday(){
        //lấy thời gian hiện tại
        Date dateNow=new Date();
        return studentDao.getAllBirthday(dateNow);
    }
    public List<Student> getListStudentByName(String name){
        return studentDao.getStudentByName(name);
    }

    public List<Student> getListStudentByGender(String gender){
        return studentDao.getStudentByGender(gender);
    }

    public List<Student> getListStudentByHometown(String hometown){
        return studentDao.getStudentByHometown(hometown);
    }

    public List<Student> getListStudentByClassName(String className){
        return studentDao.getStudentByClassName(className);
    }

    public List<Student> getListStudentByMajor(String major){
        return studentDao.getStudentByMajor(major);
    }

    public List<Student> getListStudentAverageMark(double min, double max){
        return studentDao.getStudentByAverage(min, max);
    }

    public boolean delete(int id) {
        return studentDao.deleteStudent(id);
    }

}
