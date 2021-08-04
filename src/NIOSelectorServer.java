import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOSelectorServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket=ServerSocketChannel.open();
        //绑定端口到socket并启动
        serverSocket.socket().bind(new InetSocketAddress(9000));
        serverSocket.configureBlocking(false);
        Selector selector=Selector.open();
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务启动成功");
        while(true){
            //阻塞等待需要处理的事件发生
            selector.select();
//            获取selector中注册的全部事件(已发生的）
            Set<SelectionKey> selectionKeys=selector.selectedKeys();
            Iterator<SelectionKey> iterator =selectionKeys.iterator();
            //遍历selectionKey对事件进行处理
            while(iterator.hasNext()){
                SelectionKey key=iterator.next();
                //dispatch
                // 如果是连接事件，进行连接获取和事件注册
                if(key.isAcceptable()){
                    ServerSocketChannel server= (ServerSocketChannel) key.channel();
//                    接受客户端连接
                    SocketChannel socketChannel=server.accept();
                    socketChannel.configureBlocking(false);
                    //将当前socketchannel注册读事件到选择器上,同时关联一个buffer
                    socketChannel.register(selector,SelectionKey.OP_READ,ByteBuffer.allocate(1024));
                    System.out.println("客户端连接成功,生成一个socketChannel："+socketChannel.hashCode());

                }else  if(key.isReadable()){// 如果是读事件，进行读取和打印
//                    通过key反向获取到channel
                    SocketChannel socketChannel= (SocketChannel) key.channel();
                    ByteBuffer byteBuffer= (ByteBuffer) key.attachment();
                    int len=socketChannel.read(byteBuffer);
                    if(len>0){
                        System.out.println("接受到消息：" + new String(byteBuffer.array()));
                    }else if(len==-1){//客户端断开连接，关闭Socket
                        System.out.println("客户端断开连接");
                        socketChannel.close();
                    }
                }
                //手动从事件集合中删除本次处理的key，防止下次select重复处理
                iterator.remove();
            }
        }
    }
}
