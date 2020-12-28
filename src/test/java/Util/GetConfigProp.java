package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class GetConfigProp {
    Properties prop = new Properties();
       String url;
       public String payload;

    public GetConfigProp() throws IOException {
        InputStream inputFile = new FileInputStream("src/test/resources/application.properties");
        payload = new String(Files.readAllBytes(Paths.get("src/test/resources/payload/post.json")));
        prop.load(inputFile);

    }

    public String getUrl()
    {
        url = prop.getProperty("url");
        return url;

    }
}
