package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TYPE")
public class AccountType implements Serializable {

    private static final long serialVersionUID = 7323243789334252048L;

    private long typeID;
    private String type;

    public AccountType(long typeID, String type) {
        this.typeID = typeID;
        this.type = type;
    }

    @Id
    @Column(name = "ACC_TYPE_ID")
    public long getTypeID() {
        return typeID;
    }

    @Column(name = "ACC_TYPE")
    public String getType() {
        return type;
    }

    public void setTypeID(long typeID) {
        this.typeID = typeID;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "typeID=" + typeID +
                ", type='" + type + '\'' +
                '}';
    }
}
