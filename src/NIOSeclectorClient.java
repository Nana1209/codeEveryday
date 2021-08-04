import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NIOSeclectorClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel=SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress=new InetSocketAddress("127.0.0.1",9000);
        //连接服务器
        if(!socketChannel.connect(inetSocketAddress)){
            while (!socketChannel.finishConnect()){
                System.out.println("连接需要时间，客户端不阻塞，可以做其他工作");
            }

        }
        String str="hello NANA";
        ByteBuffer buffer=ByteBuffer.wrap(str.getBytes());
        //发送数据给服务器，将buffer数据写入channel
        socketChannel.write(buffer);
        System.in.read();
    }

}
