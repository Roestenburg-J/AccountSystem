package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "MEMBER")
public class Member implements Serializable {

    @Id
    @Column(name = "MEM_ID")
    private long memID;

    @Column(name = "MEM_NAME")
    private String memName;

    @Column(name = "MEM_SURNAME")
    private String memSurname;

    @Column(name = "MEM_DOB")
    private LocalDate memDOB;
}