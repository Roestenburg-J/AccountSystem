package za.ac.nwu.ac.domain.persistence;


import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER")
public class Member implements Serializable {

    private static final long serialVersionUID = -223199133093568577L;

    private long memID;
    private String memName;
    private String memSurname;
    private LocalDate memDOB;
    private Set<Account> accounts;

    public Member(){

    }

    public Member(long memID, String memName, String memSurname, LocalDate memDOB) {
        this.memID = memID;
        this.memName = memName;
        this.memSurname = memSurname;
        this.memDOB = memDOB;
    }

    public Member(String memName, String memSurname, LocalDate memDob) {
        this.memName = memName;
        this.memSurname = memSurname;
        this.memDOB = memDob;
    }

    @Id
    @SequenceGenerator(name = "MEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEM_SEQ")
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

    @OneToMany(targetEntity = Account.class, fetch = FetchType.LAZY, mappedBy = "accMember", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<Account> getAccounts(){
        return accounts;
    }

    public void setAccounts(Set<Account> accounts){
        this.accounts = accounts;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return memID == member.memID && memName.equals(member.memName) && memSurname.equals(member.memSurname) && memDOB.equals(member.memDOB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memID, memName, memSurname, memDOB);
    }

}