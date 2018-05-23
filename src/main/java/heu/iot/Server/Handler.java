package heu.iot.Server;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
/**
 * @Description :
 * @Author : reaper
 * @CreateDate : 2018/4/4 9:25
 * @Version : 1.0
 */
public class Handler extends SimpleChannelUpstreamHandler {
    /* （非 Javadoc）
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#messageReceived(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.MessageEvent)
     * 服务器收到信息
     */
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
            throws Exception {
        System.out.println("recive message,message content:" + e.getMessage());
        new DealJson(e.getMessage().toString(), ctx.getChannel()).checkJson();
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        super.channelConnected(ctx, e);
        System.out.println(ctx.getChannel().getRemoteAddress()+"连接成功!");
//		ServerStart.addClientConn();
    }


    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
            throws Exception {
        super.channelClosed(ctx, e);
        System.out.println(ctx.getChannel().getRemoteAddress()+"连接关闭");
//		ServerStart.removeClientConn();
    }


    /* （非 Javadoc）
     * @see org.jboss.netty.channel.SimpleChannelUpstreamHandler#exceptionCaught(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ExceptionEvent)
     *服务器连接异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e)
            throws Exception {
        System.out.println(ctx.getChannel().getRemoteAddress()+"连接异常关闭");
        Channel ch = e.getChannel();
        ch.close();
    }

//	private boolean changeChannelMap(Channel channel) {
//		if(!ServerWindow.chanalMap.isEmpty()){
//			Set<Entry<String, Channel>> entrySet = ServerWindow.chanalMap.entrySet();
//			for(Entry<String,Channel>entry :entrySet) {
//				String key = entry.getKey();
//				Channel c = entry.getValue();
//				if(channel.getRemoteAddress().equals(c.getRemoteAddress())){
//					if(!channel.isConnected()){
//						ServerWindow.chanalMap.remove(key);
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}

}
