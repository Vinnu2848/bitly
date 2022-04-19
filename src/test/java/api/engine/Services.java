package api.engine;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utilities.ConfigReader;


import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Services {

    private static Services services;
    Map<String, String> headersMap = new HashMap<>();

    RequestSpecification request;

    private static Properties properties;
    private static File file;
    @Step
    public static Services getInstance() {
        if (services == null) {
            services = new Services();
        }
        return services;
    }

    public RequestSpecification setRequestDetails(String serviceName) {
        setHeaderMap(serviceName);
        String url=getProperty(serviceName);
        RestAssured.baseURI =getProperty(serviceName);
        request = SerenityRest.given().headers(headersMap);
        return request;
    }
//    public RequestSpecification setRequestDetailswithoutcontentType(String serviceName) {
//       // setLogisticCatalogueHeadersfordelete();
//        RestAssured.baseURI = ConfigReader.getInstance().getProperty(serviceName);
//        request = SerenityRest.given().headers(headersMap);
//        return request;
//    }

    public Response postService(String moduleName, String serviceName, Object object) {
        Response response = services.setRequestDetails(moduleName).
                when().body(object).post(serviceName);
        if (response.getStatusCode() >= 400) {
            response.getBody().asString();
        }

        return response;
    }



    @Step
    public Response getService(String moduleName, String serviceName, Map<String, String> queryParam) {

        Response response = services.setRequestDetails(moduleName).
                when().queryParams(queryParam).get(serviceName);
        if (response.getStatusCode() >= 400) {
            response.getBody().asString();
        }

        return response;
    }

    public Response getService(String moduleName, String serviceName) {
        Response response = services.setRequestDetails(moduleName).
                when().get(serviceName);

        if (200 < response.getStatusCode() ) {
            response.getBody().asString();
            System.out.println("Status code"+response.getStatusCode());
        }

        return response;
    }

//    public Response getService(String moduleName, String serviceName, String attribute) {
//        Response response = services.setRequestDetails(moduleName).
//                when().get(serviceName + attribute);
//        if (200 < response.getStatusCode() && response.getStatusCode() < 510) {
//            response.getBody().asString();
//        } else {
//            response = services.setRequestDetails(moduleName).
//                    when().get(serviceName + attribute);
//        }
//
//        return response;
//    }



    public void setHeaderMap(String serviceName) {
       // headersMap.clear();
        switch (serviceName) {

            case "bitly":
                setMasterDataHeaders();
                break;
            case "bitlinks":
                setBitlinks();
                break;
            default:
                String s = "Client & Secret not set for this module";
        }
    }

    public void setMasterDataHeaders() {
        headersMap.put("Content-type", "application/json");
        headersMap.put("Authorization", "Bearer " + getProperty("accessToken"));
    }
    public void setBitlinks() {
        headersMap.put("Content-type", "application/json");
        headersMap.put("Authorization", "Bearer " + getProperty("accessTokenbitlink"));
    }

    public String getProperty(String propertyName)
    {

        file = new File("./src/test/resources/configurations/authorisation.properties");
        properties = new Properties();
        String expectedValue=null;
        System.out.println("Startedthemethod");
        try {
            FileInputStream fis = new FileInputStream(file);
            properties = new Properties();
            properties.load(fis);
            expectedValue = properties.getProperty(propertyName);
            System.out.println(expectedValue);
        }catch (Exception e){
            e.printStackTrace();
        }
        return expectedValue;
    }




}

