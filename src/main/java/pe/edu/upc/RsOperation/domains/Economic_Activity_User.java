package pe.edu.upc.RsOperation.domains;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Economic_Activity_User {
    private Integer economic_activity_user_Id;
    private String business_description;
    private Integer state;
    private Date creation_Date;
    private Date update_Date;
    private Integer economic_activity_id_Fk;
    private Integer user_id_Fk;

    public Integer getEconomic_activity_user_Id() {
        return economic_activity_user_Id;
    }

    public void setEconomic_activity_user_Id(Integer economic_activity_user_Id) {
        this.economic_activity_user_Id = economic_activity_user_Id;
    }

    @Override
    public String toString() {
        return "Economic_Activity_User{" +
                "economic_activity_user_Id=" + economic_activity_user_Id +
                ", business_description='" + business_description + '\'' +
                ", state='" + state + '\'' +
                ", creation_Date='" + creation_Date + '\'' +
                ", update_Date='" + update_Date + '\'' +
                ", economic_activity_id_Fk='" + economic_activity_id_Fk + '\'' +
                ", user_id_Fk=" + user_id_Fk +
                '}';
    }

}
