/**
 * @author Tran Dang Duong
 * Student ID: s3979381
 * @version ${11.0.18}
 * @created 19-Apr-24 1:34 PM
 * @project PracticeDatabase
 * @since ${11.0.18}
 */

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.*;

import java.util.List;

@Entity

@Table(name = "it")
public class ITStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private int semester;

    public ITStudent(long id, String firstName, String lastName, int semester, List<String> listOfCourses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.semester = semester;

    }

    public ITStudent() {

    }


@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)

    public long getId() {
        return id;
    }



    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }




}
