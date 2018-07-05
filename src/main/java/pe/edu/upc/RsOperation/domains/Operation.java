package pe.edu.upc.RsOperation.domains;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Operation {
    private Integer operation_Id;
    private Date operation_Date;
    private String concept;
    private Double amount;
    private Integer state;
    private Date creation_Date;
    private Date update_Date;
    private Integer user_business_Id;
    private Integer account_Id;
    private Integer category_Id;
    private Integer tag_Id;
    private Integer user_Id;

    public Operation() {
    }

    public Integer getTag_Id() {
        return tag_Id;
    }

    public void setTag_Id(Integer tag_Id) {
        this.tag_Id = tag_Id;
    }

    public Operation(Integer operation_Id) {
        this.operation_Id = operation_Id;
    }

    public Integer getOperation_Id() {
        return operation_Id;
    }

    public void setOperation_Id(Integer operation_Id) {
        this.operation_Id = operation_Id;
    }

    public Date getOperation_Date() {
        return operation_Date;
    }

    public void setOperation_Date(Date operation_Date) {
        this.operation_Date = operation_Date;
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

    public Date getCreation_Date() {
        return creation_Date;
    }

    public void setCreation_Date(Date creation_Date) {
        this.creation_Date = creation_Date;
    }

    public Date getUpdate_Date() {
        return update_Date;
    }

    public void setUpdate_Date(Date update_Date) {
        this.update_Date = update_Date;
    }

    public Integer getUser_business_Id() {
        return user_business_Id;
    }

    public void setUser_business_Id(Integer user_business_Id) {
        this.user_business_Id = user_business_Id;
    }

    public Integer getAccount_Id() {
        return account_Id;
    }

    public void setAccount_Id(Integer account_Id) {
        this.account_Id = account_Id;
    }

    public Integer getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(Integer category_Id) {
        this.category_Id = category_Id;
    }

    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "operation_Id=" + operation_Id +
                ", operation_Date='" + operation_Date + '\'' +
                ", concept='" + concept + '\'' +
                ", amount='" + amount + '\'' +
                ", state=" + state + '\'' +
                ", creation_Date=" + creation_Date + '\'' +
                ", update_Date=" + update_Date + '\'' +
                ", user_business_Id=" + user_business_Id + '\'' +
                ", account_Id=" + account_Id + '\'' +
                ", category_Id=" + category_Id + '\'' +
                ", tag_Id=" + tag_Id + '\'' +
                ", user_Id='" + user_Id+
                '}';
    }



}
