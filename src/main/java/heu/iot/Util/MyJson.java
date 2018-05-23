package heu.iot.Util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import heu.iot.Model.OrderClient;
import heu.iot.Server.KeepAliveNode;
import heu.iot.Server.UserNode;


import java.util.ArrayList;

/**
 * @Author: Sumail-Lee
 * @Date: 10:01 2017/11/27
 */
public class MyJson {

    private static Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static OrderClient JsonToOrderClient(String json){
        return gson.fromJson(json,OrderClient.class);
    }

    public static ArrayList<ArrayList<Integer>> JsonToList(String json) {
        return gson.fromJson(json, new TypeToken<ArrayList<ArrayList<Integer>>>() {
        }.getType());
    }

    public static KeepAliveNode JsonToKeepAliveNode(String json){
        return gson.fromJson(json,KeepAliveNode.class);
    }

    public static UserNode JsonToUserNode(String json){
        return gson.fromJson(json,UserNode.class);
    }


    public static ArrayList<String> JsonToStringList(String json) {
        return gson.fromJson(json, new TypeToken<ArrayList<String>>() {
        }.getType());
    }



}
