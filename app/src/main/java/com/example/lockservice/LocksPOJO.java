
package com.example.lockservice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Классический POJO класс со всеми гетерами и сетерами
public class LocksPOJO {
    @SerializedName("l_id")
    @Expose
    private Integer lId;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("last_echo")
    @Expose
    private String lastEcho;

    public Integer getLId() {
        return lId;
    }

    public void setLId(Integer lId) {
        this.lId = lId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastEcho() {
        return lastEcho;
    }

    public void setLastEcho(String lastEcho) {
        this.lastEcho = lastEcho;
    }

}
