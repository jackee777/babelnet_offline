package babelnet;

import static java.lang.System.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import server.ContentType;
import server.EmptyRequestException;
import server.HttpHeader;
import server.HttpRequest;
import server.HttpResponse;
import server.Status;

public class HttpServer {

    private ExecutorService service = Executors.newCachedThreadPool();
    //private ExecutorService service = Executors.newFixedThreadPool(4);
    //private ExecutorService service = Executors.newSingleThreadScheduledExecutor();
    private static int PORT = 1000; //待ち受けポート番号

	public HttpServer(int PORT) {
    	this.PORT = PORT;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                this.serverProcess(server);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private void serverProcess(ServerSocket server) throws IOException {
        Socket socket = server.accept();

        this.service.execute(() -> {
            try (
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                ) {
            	HttpApi ha = new HttpApi();
                HttpRequest request = new HttpRequest(in);

                HttpHeader header = request.getHeader();

                String default_path = "/files/"+String.valueOf(PORT);
                String url_path = default_path+header.getPath();
                String target_function = url_path.split("\\?")[0];

                //System.out.println(header.getText());
                //System.out.println(url_path);
                //System.out.println(target_function);

                if (header.isGetMethod()) {
                    File file = new File(".", target_function);
                    if (file.exists() && file.isFile()) {
                    	boolean change_file = false;
                    	if(target_function.equals(default_path+"/getSynsetIds")) {
                    		BabelInfo bi = readHeaderPath(url_path);
                    		change_file = ha.getSynsetIds(file, bi.lemma, bi.searchLang, bi.pos, String.valueOf(PORT));
                    	}
                    	else if(target_function.equals(default_path+"/getSynset")) {
                    		//System.out.println("search");
                    		BabelInfo bi = readHeaderPath(url_path);
                    		change_file = ha.getSynset(file, bi.synsetid, bi.targetLang, String.valueOf(PORT));
                    	}
                    	else if(target_function.equals(default_path+"/getSenses")) {
                    		//System.out.println("search");
                    		BabelInfo bi = readHeaderPath(url_path);
                    		change_file = ha.getSenses(file, bi.lemma, bi.searchLang, String.valueOf(PORT));
                    	}
                    	else if(target_function.equals(default_path+"/getOutgoingEdges")) {
                    		//System.out.println("search");
                    		BabelInfo bi = readHeaderPath(url_path);
                    		change_file = ha.getOutgoingEdges(file, bi.synsetid, String.valueOf(PORT));
                    	}
                    	else if(target_function.equals(default_path+"/getWordnetId")) {
                    		//System.out.println("search");
                    		BabelInfo bi = readHeaderPath(url_path);
                    		change_file = ha.getWordnetId(file, bi.synsetid, String.valueOf(PORT));
                    	}
                    	if(change_file) {
                    		this.respondLocalFile(file, out);
                    	}
                    	else {
                    		this.respondOk(out);
                    	}
                    } else {
                        this.respondNotFoundError(out);
                    }
                } else {
                    this.respondOk(out);
                }
            } catch (EmptyRequestException e) {
                // ignore
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            } finally {
                try {
                    socket.close();
                    in.close();
                    out.close();
                    //service.shutdown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private BabelInfo readHeaderPath(String path) {
    	BabelInfo bi = new BabelInfo();
    	String[] data = path.split("\\?");
    	for(String info: data[1].split("&")) {
    		String[] path_info = info.split("=");
    		if(path_info[0].equals("lemma")) {
    			bi.lemma = path_info[1];
    		}
    		else if(path_info[0].equals("lang")) {
    			bi.lang = path_info[1];
    		}
    		else if(path_info[0].equals("searchLang")) {
    			bi.searchLang = path_info[1];
    		}
    		else if(path_info[0].equals("targetLang")) {
    			bi.targetLang = path_info[1];
    		}
    		else if(path_info[0].equals("id")) {
    			bi.synsetid = path_info[1];
    		}
    		else if(path_info[0].equals("pos")) {
    			bi.pos = path_info[1];
    		}
    		else if(path_info[0].equals("source")) {
    			bi.source = path_info[1];
    		}
    		else if(path_info[0].equals("key")) {
    			bi.key = path_info[1];
    		}
    	}

    	return bi;
    }

    private void respondNotFoundError(OutputStream out) throws IOException {
        HttpResponse response = new HttpResponse(Status.NOT_FOUND);
        response.addHeader("Content-Type", ContentType.TEXT_PLAIN);
        response.setBody("404 Not Found");
        response.writeTo(out);
        out.close();
    }

    private void respondLocalFile(File file, OutputStream out) throws IOException {
        HttpResponse response = new HttpResponse(Status.OK);
        response.setBody(file);
        response.writeTo(out);
        out.close();
    }

    private void respondOk(OutputStream out) throws IOException {
        HttpResponse response = new HttpResponse(Status.OK);
        response.writeTo(out);
        out.close();
    }

    public static void main(String[] args) throws Exception {
        out.println("start >>>");
        int port = Integer.valueOf(args[0]);
    	HttpServer server = new HttpServer(port);
        server.start();
        out.println("<<< end");
	}
}
