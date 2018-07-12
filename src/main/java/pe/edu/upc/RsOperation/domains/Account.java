package pe.edu.upc.RsOperation.domains;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private  Integer account_id;
    private String description;
    private Integer main_account;
    private Integer sign;
    private Integer state;
    private Date creation_date;
    private Date update_date;

    public Account(Integer account_id) {
        this.account_id = account_id;
    }

    public Account() {
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMain_account() {
        return main_account;
    }

    public void setMain_account(Integer main_account) {
        this.main_account = main_account;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }



    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", description='" + description + '\'' +
                ", main_account='" + main_account + '\'' +
                ", sign='" + sign + '\'' +
                ", state='" + state + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", update_date=" + update_date +
                '}';
    }


}
