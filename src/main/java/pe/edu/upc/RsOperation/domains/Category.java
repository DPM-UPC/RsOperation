package pe.edu.upc.RsOperation.domains;
import java.util.Date;
public class Category {
    private Integer category_id;
    private String description;
    private Integer state;
    private Date creation_date;
    private Date update_date;
    private Integer account_id_fk;

    public Category() {
    }

    public Category(Integer category_id) {
        this.category_id = category_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getAccount_id_fk() {
        return account_id_fk;
    }

    public void setAccount_id_fk(Integer account_id_fk) {
        this.account_id_fk = account_id_fk;
    }



    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", update_date='" + update_date + '\'' +
                ", account_id_fk=" + account_id_fk +
                '}';
    }
}


