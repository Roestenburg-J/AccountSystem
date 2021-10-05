package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.ApiModel;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "Member", description = "A DTO that represents Members for the account system")

public class MemberDto implements Serializable {

    private static final long serialVersionUID = -3675411777951570019L;

    private String memName;
    private String memSurname;
    private LocalDate memDob;

    public MemberDto(){

    }

    public MemberDto(String memName, String memSurname, LocalDate memDob) {
        this.memName = memName;
        this.memSurname = memSurname;
        this.memDob = memDob;
    }

    public MemberDto(Member member){
        this.setMemName(member.getMemName());
        this.setMemSurname(member.getMemSurname());
        this.setMemDob(member.getMemDOB());
    }

    @ApiModelProperty(position = 1,
            value = "Member Name",
            name = "Name",
            notes = "The name of a Member",
            dataType = "java.lang.String",
            example = "John",
            allowEmptyValue = false,
            required = true)
    public String getMemName() {
        return memName;
    }

    @ApiModelProperty(position = 2,
            value = "Member Surname",
            name = "Surname",
            notes = "The surname of a Member",
            dataType = "java.time.String",
            example = "Stone",
            allowEmptyValue = false,
            required = true)
    public String getMemSurname() {
        return memSurname;
    }

    @ApiModelProperty(position = 3,
            value = "Member DOB",
            name = "Date of Birth",
            notes = "The date of birth of a Member",
            dataType = "java.lang.String",
            example = "2000-01-01",
            allowEmptyValue = false,
            required = true)
    public LocalDate getMemDob() {
        return memDob;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public void setMemSurname(String memSurname) {
        this.memSurname = memSurname;
    }

    public void setMemDob(LocalDate memDob) {
        this.memDob = memDob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberDto)) return false;
        MemberDto memberDto = (MemberDto) o;
        return memName.equals(memberDto.memName) && memSurname.equals(memberDto.memSurname) && memDob.equals(memberDto.memDob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memName, memSurname, memDob);
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "memName='" + memName + '\'' +
                ", memSurname='" + memSurname + '\'' +
                ", memDob=" + memDob +
                '}';
    }

    @JsonIgnore
    public Member getMember(){
        return new Member(getMemName(), getMemSurname(), getMemDob());
    }

}
