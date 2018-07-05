package pe.edu.upc.RsOperation.domains;
import java.util.Date;
public class Category {
    private Integer category_Id;
    private String description;
    private Integer state;
    private Date creation_Date;
    private Date update_Date;
    private Integer account_Id;

    public Integer getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(Integer category_Id) {
        this.category_Id = category_Id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_Id=" + category_Id +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", creation_Date='" + creation_Date + '\'' +
                ", update_Date='" + update_Date + '\'' +
                ", account_Id=" + account_Id +
                '}';
    }
}


