package pe.edu.upc.RsOperation.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class UsersBusiness {

    @JsonProperty(value = "user_business_id")
    private Integer userBusinessId;
    private Integer state;
    @JsonProperty(value = "creation_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota")
    private Date creationDate;
    @JsonProperty(value = "update_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "America/Bogota")
    private Date updateDate;
    @JsonProperty(value = "user_id_fk")
    private Integer userIdFk;
    @JsonProperty(value = "business_id_fk")
    private Integer businessIdFk;

    public Integer getUserBusinessId() {
        return userBusinessId;
    }

    public void setUserBusinessId(Integer userBusinessId) {
        this.userBusinessId = userBusinessId;
    }

    public UsersBusiness() {
    }

    public UsersBusiness(Integer userBusinessId) {
        this.userBusinessId = userBusinessId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(Integer userIdFk) {
        this.userIdFk = userIdFk;
    }

    public Integer getBusinessIdFk() {
        return businessIdFk;
    }

    public void setBusinessIdFk(Integer businessIdFk) {
        this.businessIdFk = businessIdFk;
    }



    @Override
    public String toString() {
        return "UsersBusiness{" +
                "userBusinessId=" + userBusinessId +
                ", state='" + state + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", userIdFk='" + userIdFk + '\'' +
                ", businessIdFk=" + businessIdFk +
                '}';
    }
}
