package api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

import static org.apache.http.HttpHeaders.DATE;

public class ApiUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static int getIntResponseValue(Response response, String key) {
        return objectMapper.readTree(response.getBody().asString()).at("/" + key).asInt();
    }

    @SneakyThrows
    public static String getResponseValue(Response response, String key) {
        return objectMapper.readTree(response.getBody().asString()).at("/" + key).asText();
    }



    @SneakyThrows
    public static String getAllureResponse(String endpoint, Response resp, Object body) {

        String request_date = resp.getHeader(DATE);
        String responseStatus = String.valueOf(resp.getStatusCode());
        String requestBody = body != null ? objectMapper.writeValueAsString(body) : "";


        return "\n\nRequest date: " + request_date +
                "\n\nEndpoint: " + endpoint +
                "\n\nRequest body: " + requestBody +
                "\n\nResponse status code: " + responseStatus +
                "\n\nResponse: " + resp.getBody().asString();
    }

    private static final List<Integer> successStatusCodes = new ArrayList<>() {{
        add(200);
        add(201);
        add(202);
    }};

    public static boolean isSuccess(int actualResponseCode) {
        return successStatusCodes.contains(actualResponseCode);
    }

    public static Response checkHttpExceptions(Response response) {
        if (!isSuccess(response.statusCode())) {
            throw new HttpsException("Actual status_code = "
                    + response.statusCode() + "\nError message:\n" + response.getBody().asString());
        }
        return response;
    }

    private static final List<Integer> serverErrorStatusCodes = new ArrayList<>() {{
        add(500);
        add(504);
    }};

    public static boolean isServerError(int actualResponseCode) {
        return serverErrorStatusCodes.contains(actualResponseCode);
    }

    public static Response checkServerError(Response response) {
        if (isServerError(response.statusCode())) {
            throw new HttpsException("Actual status_code = "
                    + response.statusCode() + "\nError message:\n" + response.getBody().asString());
        }
        return response;
    }
}
