package api.engine;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Authorisation {
    String autotoken ;

    private static Properties properties;
    private static Authorisation authorisation;

    public Authorisation() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/test/resources/configurations/authorisation.properties"));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("authorisation.properties file not found");
        }
    }

    public static Authorisation getInstance( ) {
        if(authorisation == null) {
            authorisation = new Authorisation();
        }
        return authorisation;
    }


    public String getAuthBearerToken(String moduleName) {
        try {
             autotoken= RestAssured.given()
                     .config(RestAssured.config()
                             .encoderConfig(EncoderConfig.encoderConfig().
                                     encodeContentTypeAs("x-www-form-urlencoded",
                                             ContentType.URLENC))).contentType("x-www-form-urlencoded")
                      .auth().basic("d187f27fcd0ea61fa8d3ddaac4475c69c85eee09","ee7590d58c3aa64a8428b71432517ac6134e3536")
                    .formParam("username","dasaraju")
                    .formParam("password", "Dasaraju33@")
                    .formParam("grant_type", "password")
                     .header("Host", "api-ssl.bitly.com")
                     .header("Content-Type", "application/x-www-form-urlencoded")
                     //    .headers(setAuthHeaders())
                    .post("https://api-ssl.bitly.com/oauth/access_token")
                    .then()
                    .extract().response().jsonPath().getString("access_token");
            System.out.println("Token "+autotoken);
        }catch (Exception e){
            System.out.println(" "+ e.getMessage());

        }
        return autotoken;
    }

    public Map<String, String> setAuthHeaders() {
        Map<String, String> authHeaderMap = new HashMap<>();
        authHeaderMap.put("Content-Type", "application/x-www-form-urlencoded");
        authHeaderMap.put("Host", properties.getProperty("Host"));

        for(Map.Entry entry : authHeaderMap.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        return authHeaderMap;
    }


}

