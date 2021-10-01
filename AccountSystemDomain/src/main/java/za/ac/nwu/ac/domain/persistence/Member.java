package za.ac.nwu.ac.domain.persistence;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "MEMBER")
public class Member implements Serializable {

    private static final long serialVersionUID = -223199133093568577L;

    private long memID;
    private String memName;
    private String memSurname;
    private LocalDate memDOB;

    public Member(long memID, String memName, String memSurname, LocalDate memDOB) {
        this.memID = memID;
        this.memName = memName;
        this.memSurname = memSurname;
        this.memDOB = memDOB;
    }

    @Id
    @SequenceGenerator(name = "GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GENERIC_SEQ")
    @Column(name = "MEM_ID")
    public long getMemID() {
        return memID;
    }

    public void setMemID(long memID) {
        this.memID = memID;
    }

    @Column(name = "MEM_NAME")
    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    @Column(name = "MEM_SURNAME")
    public String getMemSurname() {
        return memSurname;
    }

    public void setMemSurname(String memSurname) {
        this.memSurname = memSurname;
    }

    @Column(name = "MEM_DOB")
    public LocalDate getMemDOB() {
        return memDOB;
    }

    public void setMemDOB(LocalDate memDOB) {
        this.memDOB = memDOB;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memID=" + memID +
                ", memName='" + memName + '\'' +
                ", memSurname='" + memSurname + '\'' +
                ", memDOB=" + memDOB +
                '}';
    }
}