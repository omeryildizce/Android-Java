package com.omeryildizce.mailaktivasyon.restApi;

public class BaseManager {
    protected RestApi getRestApiClient(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url);
        return restApiClient.getRestApi();
    }
}