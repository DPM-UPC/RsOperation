package pe.edu.upc.RsOperation.domains;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Economic_Activity {
    private Integer  economic_activity_Id;
    private String description;
    private Integer state;
    private Date creation_Date;
    private Date update_Date;

    @Override
    public String toString() {
        return "Economic_Activity{" +
                "economic_activity_Id=" + economic_activity_Id +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", creation_Date='" + creation_Date + '\'' +
                ", update_Date=" + update_Date +
                '}';
    }

}
