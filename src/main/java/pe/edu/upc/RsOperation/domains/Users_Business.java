package pe.edu.upc.RsOperation.domains;

import java.util.Date;

public class Users_Business {

    private Integer user_business_id;
    private String business_description;
    private Integer state;
    private Date creation_date;
    private Date update_date;
    private Integer user_id_fk;
    private Integer business_id_fk;

    public Integer getUser_business_id() {
        return user_business_id;
    }

    public void setUser_business_id(Integer user_business_id) {
        this.user_business_id = user_business_id;
    }

    public Users_Business() {
    }

    public Users_Business(Integer user_business_id) {
        this.user_business_id = user_business_id;
    }

    public String getBusiness_description() {
        return business_description;
    }

    public void setBusiness_description(String business_description) {
        this.business_description = business_description;
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

    public Integer getUser_id_fk() {
        return user_id_fk;
    }

    public void setUser_id_fk(Integer user_id_fk) {
        this.user_id_fk = user_id_fk;
    }

    public Integer getBusiness_id_fk() {
        return business_id_fk;
    }

    public void setBusiness_id_fk(Integer business_id_fk) {
        this.business_id_fk = business_id_fk;
    }



    @Override
    public String toString() {
        return "Users_Business{" +
                "user_business_id=" + user_business_id +
                ", business_description='" + business_description + '\'' +
                ", state='" + state + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", update_date='" + update_date + '\'' +
                ", user_id_fk='" + user_id_fk + '\'' +
                ", business_id_fk=" + business_id_fk +
                '}';
    }
}
