package api.dao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "TB_city".
 */
public class City {

    /** Not-null value. */
    private String city;
    /** Not-null value. */
    private String cnty;
    /** Not-null value. */
    private String id;
    /** Not-null value. */
    private String lat;
    /** Not-null value. */
    private String lon;
    private String prov;

    public City() {
    }

    public City(String city, String cnty, String id, String lat, String lon, String prov) {
        this.city = city;
        this.cnty = cnty;
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.prov = prov;
    }

    /** Not-null value. */
    public String getCity() {
        return city;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCity(String city) {
        this.city = city;
    }

    /** Not-null value. */
    public String getCnty() {
        return cnty;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    /** Not-null value. */
    public String getId() {
        return id;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setId(String id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getLat() {
        return lat;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /** Not-null value. */
    public String getLon() {
        return lon;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

}