package com.omeryildizce.webservis4.restApi;

public class BaseManager {
    protected RestApi getRestApi(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url);
        return restApiClient.getRestApi();

    }
}
