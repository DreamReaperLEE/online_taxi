package heu.iot.Server;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.DefaultChannelPipeline;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;


/**
 * @Description :
 * @Author : reaper
 * @CreateDate : 2018/4/4 9:25
 * @Version : 1.0
 */
public class NioServer {
    private int port;
    private ServerBootstrap bootstrap;

    public NioServer(int port) {
        super();
        this.port = port;
    }

    public boolean startServer() {
        boolean startFlag = false;
        bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(),
                Executors.newCachedThreadPool()));

        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipleline = new DefaultChannelPipeline();
                pipleline.addLast("encode", new StringEncoder());
                pipleline.addLast("decode", new StringDecoder());
                pipleline.addLast("handler", new Handler());
                return pipleline;
            }

        });

        try {
            bootstrap.bind(new InetSocketAddress(port));
            System.out.println("服务器已启动");
            startFlag = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("服务器启动失败!");
        }
        return startFlag;
    }

}
