package com.zebra.postcodenew.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostcodeResponse {

    @SerializedName("status")
    @Expose
    public int status;
    @SerializedName("result")
    @Expose
    public List<Result> result = null;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("PostcodeResponse{" +
                "status=" + status);
        if (result != null && !result.isEmpty()) {
            for (Result res : result) {
                str.append(", result=").append(res.postcode);
            }
        }


        str.append('}');

        return str.toString();
    }
}