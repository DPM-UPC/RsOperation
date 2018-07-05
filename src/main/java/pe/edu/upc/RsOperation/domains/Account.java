package pe.edu.upc.RsOperation.domains;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private  Integer account_Id;
    private String description;
    private Integer main_Account;
    private Integer sign;
    private Integer state;
    private Date creation_Date;
    private Date update_Date;

    public Integer getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(Integer account_Id) {
        this.account_Id = account_Id;
    }


    @Override
    public String toString() {
        return "Account{" +
                "account_Id=" + account_Id +
                ", description='" + description + '\'' +
                ", main_Account='" + main_Account + '\'' +
                ", sign='" + sign + '\'' +
                ", state='" + state + '\'' +
                ", creation_Date='" + creation_Date + '\'' +
                ", update_Date=" + update_Date +
                '}';
    }

}
