package heu.iot.Util;

import heu.iot.Model.OrderClient;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static heu.iot.Util.Excel.dealCell;

/**
 * @Author: Sumail-Lee
 * @Version: V1.0.0
 * @Description:
 * @Since: 2018/1/24 10:20
 */
public class OrderExcel {

    /**
     * @param
     * @Author: Sumail-Lee
     * @Description:标题
     * @Date: 2018/1/23 16:21
     */
    public static ArrayList<String> getTitle() {

        ArrayList<String> title = new ArrayList<String>();
        title.add("订单编号");
        title.add("客户姓名");
        title.add("所属集团");
        title.add("用车时间");
        title.add("出发地");
        title.add("目的地");
        title.add("订单价格");
        return title;
    }

    public static ArrayList<ArrayList<String>> getData(List<OrderClient> orderClientList) {
        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        for (OrderClient each : orderClientList) {
            ArrayList<String> every = new ArrayList<String>();

            every.add(String.valueOf(each.getId()));
            every.add(each.getClName());
            every.add(each.getCoName());
            every.add(each.getOrTime());
            every.add(each.getOrStart());
            every.add(each.getOrEnd());
            every.add(String.valueOf(each.getOrPrice()));
            data.add(every);
        }
        return data;
    }

}
