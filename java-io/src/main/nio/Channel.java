package nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName Channel
 * @Description TODO
 * @Author yale
 * @Date 2018/12/21 10:50
 * @Version 1.0
 **/
public class Channel {
    public static void main(String[] args) {
        fileChannel();
    }

    private static void fileChannel(){
        try {
            RandomAccessFile aFile = new RandomAccessFile("D:/data/nio-data.txt", "rw");
            FileChannel inChannel = aFile.getChannel();
            //create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buf); //read into buffer.
            while (bytesRead != -1) {
                buf.flip();  //make buffer ready for read
                while(buf.hasRemaining()){
                    System.out.print((char) buf.get()); // read 1 byte at a time
                }
                buf.clear(); //make buffer ready for writing
                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
