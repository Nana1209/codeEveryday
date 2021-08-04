package netty.simple;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        // 创建两个线程组
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup worderGroup = new NioEventLoopGroup();
        try{
            // 创建服务器端的启动对象，配置参数（使用链式编程配置）
            ServerBootstrap bootstrap=new ServerBootstrap();
            bootstrap.group(bossGroup,worderGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class) //使用NioSocketChannel作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG,128) //设置线程队列得到连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE,true) //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道初始化对象（匿名对象）
                        // 给pipeline设置处理器

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            System.out.println("client socketChannel hashcode=" + socketChannel.hashCode());
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    });// 给我们的workerGroup 的 EventLoop 对应的管道设置处理器
            System.out.println("-----Server is ready----");
//            绑定一个端口并且同步，生成一个ChannelFurture对象
            //启动服务器
            ChannelFuture cf=bootstrap.bind(6668).sync();
            //给cf注册监听器，监听我们关心的事件
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if(cf.isSuccess()){
                        System.out.println("listen port6668 success");
                    }else {
                        System.out.println("listen port6668 faile");
                    }
                }
            });
            //对关闭通道进行监听
            cf.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            worderGroup.shutdownGracefully();
        }

    }
}
