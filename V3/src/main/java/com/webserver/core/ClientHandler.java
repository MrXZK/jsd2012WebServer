package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 负责与指定客户端进行HTTP交互
 * HTTP协议要求与客户端的交互规则采取一问一答的方式。因此，处理客户端交互以
 * 3步形式完成：
 * 1：解析请求(一问)
 * 2：处理请求
 * 3：反馈请求(一答)
 */
public class ClientHandler implements Runnable{
    private Socket socket;
    public ClientHandler(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try{
            //1解析请求
            InputStream in = socket.getInputStream();  //
            //测试读取客户端发送过来的请求内容
            int d;                                           //   高八位   低八位
            char cur = ' '; //本次读取到的字符
            char pre = ' '; //上次读取到的字符
            StringBuilder builder = new StringBuilder(); //保存读取到的所有的字符
            while((d=in.read())!=-1){  //读取的字节会放到低八位上去 00000000_01010100
                char c=(char)d;//本次读取到的字符
                //如果上次读取到的是回车符，本次是换行符则停止读取
                if(pre==13 && cur== 10){
                    break;    //退出循环
                }
                builder.append(c);//将本次读取到的字符传给builder
                pre = cur;    //读取完后将本次读取到的字符赋给上次读取的
            }
            String line =builder.toString().trim();
            System.out.print("请求行："+line);
            String method;//请求方式
            String uri;   //抽象路径
            String protocol;//协议版本

            //http://localhost:8088/index.html
            //将请求行 按照格式用空格拆分为三部分，并分别赋值给上述变量
            String[] data =line.split(" ");
            method=data[0];
            uri=data[1];
            protocol=data[2];
            System.out.println("method:"+method);  //method；GET
            System.out.println("uri:"+uri);      //uri:/index.html
            System.out.println("protocol:"+protocol); //protocol:HTTP/1.1


            //2处理请求

            //3反馈请求

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //处理完毕后与客户端断开连接  一问一答后要断开
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
