package com.omeryildizce.paremetreliservisyazma.restApi;

public class BaseManager {
    protected RestApi getRestApiClient(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url);
        return restApiClient.getRestApi();
    }
}