package ru.mipt;

import org.springframework.web.client.RestTemplate;

public class Test {

    private static final String id = "id";
    private static final String baseUrl = "http://localhost:8081";
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        testResponse();
        testRequest();
        System.out.println("All right");
    }

    private static void testResponse() {
        int statusCode = 200;
        Response res = new Response(id, statusCode);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(baseUrl + "/putResponse", res);

        Response response = restTemplate.getForObject(baseUrl + "/getResponse", Response.class);
        if (!id.equals(response.getId()) || statusCode != response.getStatusCode()) {
            throw new RuntimeException("invalid response");
        }
    }

    private static void testRequest() {
        Request req = new Request(id);

        restTemplate.put(baseUrl + "/putRequest", req);

        Request request = restTemplate.getForObject(baseUrl + "/getRequest", Request.class);
        if (!id.equals(request.getId())) {
            throw new RuntimeException("invalid response");
        }
    }
}
