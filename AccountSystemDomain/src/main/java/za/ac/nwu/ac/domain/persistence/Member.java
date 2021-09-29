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

    public Member(long memID, String memName, String memSurname, LocalDate memDOB) {
        this.memID = memID;
        this.memName = memName;
        this.memSurname = memSurname;
        this.memDOB = memDOB;
    }

    public long getMemID() {
        return memID;
    }

    public void setMemID(long memID) {
        this.memID = memID;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemSurname() {
        return memSurname;
    }

    public void setMemSurname(String memSurname) {
        this.memSurname = memSurname;
    }

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