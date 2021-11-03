package org.example.untitled1.reponsitory;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.example.untitled1.Service.ConvertDateService;
import org.example.untitled1.Utils.HibernateUtils;
import org.example.untitled1.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//@Log4j
public class StudentDao {

    ConvertDateService convertDateService=new ConvertDateService();

//   Logger logger = Logger.getLogger(StudentDao.class);






    public List<Student> getAllStudent() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Student ").list();
        } catch (HibernateException e) {
            //           log.error (e);
        }
        return null;
    }

    public boolean insertStudent(Student student) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Student student = session.load(Student.class, id);
            session.delete(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }

    public boolean updateStudent(Student student) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.merge(student);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Student findById(int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Query<Student> query = session.createQuery("select s from Student s where s.id = :p_student_id");
            query.setParameter("p_student_id", id);
            return query.getSingleResult();
        } catch (HibernateException e) {
//            log.error(e);
        }
        return null;
    }
    public List<Student> getStudentByName(String name){
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from Student where lower(Fullname) like lower(to_char(concat(concat('%', :p_student_name), '%'))) ");
            query.setParameter("p_student_name", name);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentByGender(String gender){
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from Student where Gender = :p_student_gender");
            query.setParameter("p_student_gender", gender);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentByHometown(String homeTown){
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from Student where Hometown = :p_student_hometown");
            query.setParameter("p_student_hometown", homeTown);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentByClassName(String className){
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from Student where Classname = :p_student_className");
            query.setParameter("p_student_className", className);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentByMajor(String major){
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from Student where Major = :p_student_major");
            query.setParameter("p_student_major", major);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Student> getStudentByAverage(double min, double max){
        try (Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Query<Student> query = session.createQuery("from Student where Averagemark between :p_student_markMin and :p_student_markMax");
            query.setParameter("p_student_markMin", min);
            query.setParameter("p_student_markMax", max);
            List<Student> students = query.getResultList();
            session.getTransaction().commit();
            return students;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public List<Student>getAllBirthday(Date date){
        try {
//            String stringDate=convertDateService.ConvertDateToStringDayMonth(date);
            Session session = HibernateUtils.getSessionFactory().openSession();
            return session.createQuery("select t from Student t where TO_CHAR(Birthday,'DD-MM')=TO_CHAR(:DATE,'MM-DD')")
//                    .setParameter("StringDate",stringDate)
                    .setParameter("DATE",date)
                    .list();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }








}
