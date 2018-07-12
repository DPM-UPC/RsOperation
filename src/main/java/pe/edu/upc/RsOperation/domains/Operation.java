package pe.edu.upc.RsOperation.domains;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Operation {
    private Integer operation_id;
    private Date operation_date;
    private String concept;
    private Double amount;
    private Integer state;
    private Date creation_date;
    private Date update_date;
    private Integer user_business_id_fk;
    private Integer account_id_fk;
    private Integer category_id_fk;
    private Integer tag_id_fk;
    private Users_Business users_business;

    private Account account;
    private Category category;
    private Tag tag;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Users_Business getUsers_business() {
        return users_business;
    }

    public void setUsers_business(Users_Business users_business) {
        this.users_business = users_business;
    }

    public Integer getTag_id_fk() {
        return tag_id_fk;
    }

    public void setTag_id_fk(Integer tag_id_fk) {
        this.tag_id_fk = tag_id_fk;
    }

    public Operation() {
    }

    public Operation(Integer operation_id) {
        this.operation_id = operation_id;
    }

    public Integer getOperation_id() {
        return operation_id;
    }

    public void setOperation_id(Integer operation_id) {
        this.operation_id = operation_id;
    }

    public Date getOperation_date() {
        return operation_date;
    }

    public void setOperation_date(Date operation_date) {
        this.operation_date = operation_date;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public Integer getUser_business_id_fk() {
        return user_business_id_fk;
    }

    public void setUser_business_id_fk(Integer user_business_id_fk) {
        this.user_business_id_fk = user_business_id_fk;
    }

    public Integer getAccount_id_fk() {
        return account_id_fk;
    }

    public void setAccount_id_fk(Integer account_id_fk) {
        this.account_id_fk = account_id_fk;
    }

    public Integer getCategory_id_fk() {
        return category_id_fk;
    }

    public void setCategory_id_fk(Integer category_id_fk) {
        this.category_id_fk = category_id_fk;
    }



    @Override
    public String toString() {
        return "Operation{" +
                "operation_id=" + operation_id +
                ", operation_date='" + operation_date + '\'' +
                ", concept='" + concept + '\'' +
                ", amount='" + amount + '\'' +
                ", state=" + state + '\'' +
                ", creation_date=" + creation_date + '\'' +
                ", update_date=" + update_date + '\'' +
                ", user_business_id_fk=" + user_business_id_fk + '\'' +
                ", account_id_fk=" + account_id_fk + '\'' +
                ", category_id_fk=" + category_id_fk + '\'' +
                ", tag_id_fk=" + tag_id_fk + '\'' +
                ", users_business=" + users_business +
                '}';
    }



}
