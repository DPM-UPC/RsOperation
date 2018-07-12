package pe.edu.upc.RsOperation.domains;

import java.util.Date;

public class Tag {
    private Integer tag_id;
    private String description;
    private Integer state;
    private Date creation_date;
    private Date update_date;
    private Integer category_id_fk;

    public Tag() {
    }

    public Tag(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
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

    public Integer getCategory_id_fk() {
        return category_id_fk;
    }

    public void setCategory_id_fk(Integer category_id_fk) {
        this.category_id_fk = category_id_fk;
    }
    @Override
    public String toString() {
        return "Category{" +
                "tag_id=" + tag_id +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", update_date='" + update_date + '\'' +
                ", category_id_fk=" + category_id_fk +
                '}';
    }
}
