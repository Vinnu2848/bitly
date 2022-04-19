package stepDefinitions;

import api.engine.Endpoints;
import api.engine.Services;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.apache.commons.lang3.RandomStringUtils;
import request.CreateBitlink;
import response.Getbitly;
import response.getBitlinks.Getbitlinks;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BitlyCom {
    //private static final String URL = "http://dummy.restapiexample.com/api/v1/employee/1";
    private static final String URL="https://api-ssl.bitly.com/v4/groups/Bm47";
    public Response response;
    static Getbitly getbitly;
    static Getbitlinks getbitlinks;
    static response.CreateBitlLinks.CreateBitlink createBitResp;
    static String random;


    @Then("the API should return status {int}")
    public void theAPIShouldReturnStatus(int status) {
        SerenityRest.restAssuredThat(response -> response.statusCode(status));
        if(status<=200 || status<=201) {
            Serenity.recordReportData().withTitle("Verify Success Message").andContents("Successfully Verified status return "+status );
        }else if(status<=403)
        {
            SerenityRest.restAssuredThat(response -> response.body("message", equalTo("FORBIDDEN")));
            Serenity.recordReportData().withTitle("Verify Error Message").andContents("Successfully Verified " +response.body().jsonPath().get("message"));
        }
    }

    @And("Response should contains employee name {string}")
    public void responseShouldContainsEmployeeNameTigerNixon(String expectedEmployeeName) {
        SerenityRest.restAssuredThat(response -> response.body("data.employee_name", equalTo(expectedEmployeeName)));

    }
    @Given("I send a request to endpoint of Get Bitly")
    public void iSendARequestToEndpointOfGetBitly() {

        getbitly=Services.getInstance().getService("bitly",Endpoints.bitly()).as(Getbitly.class);
        System.out.println("guid"+getbitly.getGuid());


    }

    @And("Verify the get bitly Response data")
    public void verifyTheGetBitlyResponseData() {
        assertThat(getbitly.getGuid(),equalTo(Endpoints.bitly().split("/")[2]));
        assertThat(getbitly.getOrganizationGuid(),is(not(emptyString())));
        assertThat(getbitly.getName(),equalTo("dasaraju"));
        assertThat(getbitly.getBsds().size(),equalTo(0));
        assertThat(getbitly.getRole(),equalTo("org-admin"));
        assertThat(getbitly.getReferences().getOrganization(),containsStringIgnoringCase(Services.getInstance().getProperty("bitlylink")));
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        //created timestamp is constant while getbitly link
        assertThat(getbitly.getCreated(),containsStringIgnoringCase("2022-04-07T12:59:17+0000"));
        Serenity.recordReportData().withTitle("Verify Success Message").andContents("Successfully Verified " + getbitly.getGuid());

        //assertThat(getbitly.getGuid(),is(not(emptyOrNullString())));
    }

    @Given("I send a request to endpoint of Get Bitly invalid Guid")
    public void iSendARequestToEndpointOfGetBitlyInvalidGuid() {
        response = SerenityRest.given().contentType("application/json").header("Content-Type", "application/json")
        .header("Authorization","Bearer "+Services.getInstance().getProperty("accessToken") )
                .when().get(URL);

    }

    @And("Verify the get bitly error Response")
    public void verifyTheGetBitlyErrorResponse() {
        SerenityRest.restAssuredThat(response -> response.body("message", equalTo("FORBIDDEN")));
    }

    @Given("I send a request to endpoint of Get Bitlinks")
    public void iSendARequestToEndpointOfGetBitlinks() throws UnsupportedEncodingException {
        String str=decodeValue("2021-08-04T15%3A04%3A05-0700");
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("unit_reference",str);
        queryMap.put("unit","day" );
        queryMap.put("units","5");
        queryMap.put("size","10");
         getbitlinks=Services.getInstance().getService("bitlinks",Endpoints.getBitLinks(),queryMap).as(Getbitlinks.class);
       List lst=  Arrays.asList("bit.ly/3lsZJXB","bitly.is/2WUMwwH");
         for(int i=0;i<=getbitlinks.getSortedLinks().size()-1;i++)
            {
                if(getbitlinks.getSortedLinks().get(i).getId().equals(lst.get(i))) {
                    Serenity.recordReportData().withTitle("Verify Success Message").andContents("Successfully Verified " + getbitlinks.getSortedLinks().get(i).getId());
                }
        }

    }

    private String decodeValue(String value) throws UnsupportedEncodingException {
        return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
    }

    @And("Verify the get bitlinks with group Response")
    public void verifyTheGetBitlinksWithGroupResponse() {

        List lst=  Arrays.asList("bit.ly/3lsZJXB","bitly.is/2WUMwwH");
        for(int i=0;i<=getbitlinks.getSortedLinks().size()-1;i++)
        {
            if(getbitlinks.getSortedLinks().get(i).getId().equals(lst.get(i))) {
                Serenity.recordReportData().withTitle("Verify Success Message").andContents("Successfully Verified " + getbitlinks.getSortedLinks().get(i).getId());
            }
        }
    }

    @Given("Verify the create bitlinks")
    public void verifyTheCreateBitlinks() {
         random= randomString().toLowerCase(Locale.ROOT);
        CreateBitlink createBitlink=new CreateBitlink("https://dev"+ random
        +".bitly.com","bit.ly","Bm47cDR5f3Z","Bitly API Documentation",Arrays.asList("bitly","api"));
        createBitResp=Services.getInstance().postService("bitly",Endpoints.bitlink(),createBitlink).as(response.CreateBitlLinks.CreateBitlink.class);

        SerenityRest.restAssuredThat(response -> response.body("title", equalTo("Bitly API Documentation")));
    }
    private static String randomString()
    {
        String ramdomStr= RandomStringUtils.random(3, true, false);
        return ramdomStr;
    }
    @Then("Validate the response data")
    public void validateTheResponseData() {
        assertThat(createBitResp.getCreatedAt(),is(not(emptyOrNullString())));
        assertThat(createBitResp.getId(),is(not(emptyOrNullString())));
        assertThat(createBitResp.getArchived().toString(),equalTo("false"));
        assertThat(createBitResp.getCustomBitlinks().size(),equalTo(0));
        assertThat(createBitResp.getDeeplinks().size(),equalTo(0));
        assertThat(createBitResp.getLink(),containsString("https://bitly.is/"));
        assertThat(createBitResp.getLongUrl(),equalTo("https://dev"+ random
                +".bitly.com/"));
        assertThat(createBitResp.getReferences().getGroup(),equalTo("https://api-ssl.bitly.com/v4/groups/Bm47cDR5f3Z"));
        assertThat(createBitResp.getTags().size(),greaterThanOrEqualTo(2));
        assertThat(createBitResp.getTitle(),equalTo("Bitly API Documentation"));
        Serenity.recordReportData().withTitle("Verify Success Message").andContents("Successfully Created the bitlink " +createBitResp.getLongUrl());
    }
}
