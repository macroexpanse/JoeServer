import java.io.IOException;
import java.util.ArrayList;

public class PostHandler implements RequestHandler {
    private Request request;
    private ResponseBuilder builder;
    private ArrayList methodNotAllowedUrls = createMethodNotAllowedUrls();

    public PostHandler(Request request) throws Exception {
        this.request = request;
        builder = new ResponseBuilder(request);
    }

    public Response handle() throws Exception {
        if(methodNotAllowed()) {
            builder.buildMethodNotAllowedResponse();
        } else {
            builder.buildOKResponse();
        }
        return builder.buildFullResponse();
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
