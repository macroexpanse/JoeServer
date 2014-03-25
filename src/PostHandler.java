import java.io.IOException;
import java.util.ArrayList;

public class PostHandler implements RequestHandler {
    private Request request;
    private Response response;
    private ArrayList methodNotAllowedUrls = createMethodNotAllowedUrls();

    public PostHandler(Request request) throws Exception {
        this.request = request;
        response = new Response(request);
    }

    public Response handle() throws IOException {
        if(methodNotAllowed()) {
            response.statusCode = "405";
        } else {
            response.statusCode = "200";
        }
        return response;
    }

    private boolean methodNotAllowed() {
        return methodNotAllowedUrls.contains(request.path);
    }

    private ArrayList createMethodNotAllowedUrls() {
        return new ArrayList<String>() {{
            add("/text-file.txt");
        }};
    }
}
