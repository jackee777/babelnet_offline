package babelnet;

import static java.lang.System.*;

public class MainServer {
	public static void main(String[] args) throws Exception {
        out.println("start >>>");
        int port = Integer.valueOf(args[0]);
    	HttpServer server = new HttpServer(port);
        server.start();
        HttpServer server2 = new HttpServer(port+1);
        server2.start();
        out.println("<<< end");
//        List<HttpServer> servers = new ArrayList<HttpServer>();
//        for(int port = start; port < end; port++) {
//        	HttpServer server = new HttpServer(port);
//            servers.add(server);
//        }
//        out.println(servers);
//        for(HttpServer server: servers){
//        	//out.println(server.PORT);
//        	server.start();
//        }
        out.println("<<< end");
	}
}
