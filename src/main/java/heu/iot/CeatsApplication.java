package heu.iot;

import heu.iot.Model.OrderClient;
import heu.iot.Server.NioServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@MapperScan(basePackages = "heu.iot.Dao")
@SpringBootApplication
public class CeatsApplication {

	public static NioServer server;

	// chanalMap 存放	  <用户名：Channel> 键值对, 用户标注多用户
	public static ConcurrentHashMap<Integer, org.jboss.netty.channel.Channel> chanalMap = new ConcurrentHashMap<Integer, org.jboss.netty.channel.Channel>();
	// 司机信息存放
	public static HashMap<Integer,OrderClient> driverMap = new HashMap<Integer,OrderClient>();

	public static void main(String[] args) {
//		OrderClient orderClient=new OrderClient();
//		orderClient.setClName("李守政");
//		orderClient.setOrEgps("45.779407");
//		orderClient.setOrSgps("126.69488");
//		orderClient.setOrTime("ent");
//		orderClient.setOrState(1);
//		driverMap.put(2013201309,orderClient);
		SpringApplication.run(CeatsApplication.class, args);
		server = new NioServer(8085);
		server.startServer();
	}
}
