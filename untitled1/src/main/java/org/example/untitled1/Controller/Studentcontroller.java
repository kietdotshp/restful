package org.example.untitled1.Controller;

import org.example.untitled1.Dto.StudentDTO;
import org.example.untitled1.Service.Studentservice;
import org.example.untitled1.entity.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;

@Path("/students")
public class Studentcontroller {
    Studentservice studentService = new Studentservice();

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudentList(){
        return studentService.getListStudent();
    }
    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByName(@PathParam("name") String name) {
        return studentService.getListStudentByName(name);
    }

    @GET
    @Path("/gender/{gender}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByGender(@PathParam("gender") String gender) {
        return studentService.getListStudentByGender(gender);
    }

    @GET
    @Path("/hometown/{hometown}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByHometown(@PathParam("hometown") String hometown) {
        return studentService.getListStudentByHometown(hometown);
    }

    @GET
    @Path("/classname/{className}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByClassName(@PathParam("className") String className) {
        return studentService.getListStudentByClassName(className);
    }

    @GET
    @Path("/major/{major}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByMajor(@PathParam("major") String major) {
        return studentService.getListStudentByMajor(major);
    }

    @GET
    @Path("/averagemark/{min}/{max}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getListStudentByAverageMark(@PathParam("min") double min, @PathParam("min") double max) {
        return studentService.getListStudentAverageMark(min, max);
    }


    @GET
    @Path("/birthday")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudentListBirthday(){
        return studentService.findAllStudentBirthday();
    }

//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Student getStudent(@PathParam("id") int id) {
//        return studentService.findID(id);
//    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewStudent(StudentDTO studento) {
        Student student=studentService.convertStudentDtoToStudent(studento);
        return studentService.insert(student) ? "Thêm mới thành công" : "Thêm mới thất bại";
    }
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String Updatestudent(StudentDTO studento) {
        Student student=studentService.convertStudentDtoToStudent(studento);
        return studentService.update(student) ? "Update thành công" : "Update thất bại";
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String DeleteStudent(@PathParam("id") int id){
        return studentService.delete(id) ? "Xóa thành công" : "Xóa thất bại";
    }




}

