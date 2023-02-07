package com.omeryildizce.dbjson.restApi;

public class BaseManager {
    protected RestApi getRestApi(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url);
        return restApiClient.getRestApi();
    }
}
