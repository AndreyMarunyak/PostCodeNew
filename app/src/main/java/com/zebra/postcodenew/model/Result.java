package com.zebra.postcodenew.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("postcode")
    @Expose
    public String postcode;
    @SerializedName("quality")
    @Expose
    public int quality;
    @SerializedName("eastings")
    @Expose
    public int eastings;
    @SerializedName("northings")
    @Expose
    public int northings;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("nhs_ha")
    @Expose
    public String nhsHa;
    @SerializedName("longitude")
    @Expose
    public float longitude;
    @SerializedName("latitude")
    @Expose
    public float latitude;
    @SerializedName("european_electoral_region")
    @Expose
    public String europeanElectoralRegion;
    @SerializedName("primary_care_trust")
    @Expose
    public String primaryCareTrust;
    @SerializedName("region")
    @Expose
    public String region;
    @SerializedName("lsoa")
    @Expose
    public String lsoa;
    @SerializedName("msoa")
    @Expose
    public String msoa;
    @SerializedName("incode")
    @Expose
    public String incode;
    @SerializedName("outcode")
    @Expose
    public String outcode;
    @SerializedName("distance")
    @Expose
    public float distance;
    @SerializedName("parliamentary_constituency")
    @Expose
    public String parliamentaryConstituency;
    @SerializedName("admin_district")
    @Expose
    public String adminDistrict;
    @SerializedName("parish")
    @Expose
    public String parish;
    @SerializedName("admin_county")
    @Expose
    public Object adminCounty;
    @SerializedName("admin_ward")
    @Expose
    public String adminWard;
    @SerializedName("ccg")
    @Expose
    public String ccg;
    @SerializedName("nuts")
    @Expose
    public String nuts;
}