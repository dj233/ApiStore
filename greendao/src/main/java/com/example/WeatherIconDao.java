package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class WeatherIconDao {

    public static void main(String[] args) throws Exception{

        Schema schema = new Schema(1, "api.dao");
        schema.setDefaultJavaPackageDao("api.dao");

        addNodes(schema);

        new DaoGenerator().generateAll(schema,"E:\\dev\\as_code\\ApiStore\\Weather\\src\\main\\java-gen");
    }

    private static void addNodes(Schema schema){
        addWeatherIconNode(schema);
        addCityNode(schema);
    }

    private static void addWeatherIconNode(Schema schema){
        Entity weatherIcon = schema.addEntity("WeatherIcon");
        weatherIcon.setTableName("TB_weather_icon");
        weatherIcon.addStringProperty("code").notNull();
        weatherIcon.addStringProperty("txt").notNull();
        weatherIcon.addStringProperty("txt_en").notNull();
        weatherIcon.addStringProperty("icon").notNull();
    }

    private static void addCityNode(Schema schema){
        Entity city = schema.addEntity("City");
        city.setTableName("TB_city");
        city.addStringProperty("city").notNull();
        city.addStringProperty("cnty").notNull();
        city.addStringProperty("id").notNull();
        city.addStringProperty("lat").notNull();
        city.addStringProperty("lon").notNull();
        city.addStringProperty("prov");
//        city.addStringProperty("search");
    }
}
