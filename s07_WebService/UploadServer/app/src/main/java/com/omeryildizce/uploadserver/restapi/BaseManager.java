package com.omeryildizce.uploadserver.restapi;

public class BaseManager {
    protected RestApi getRestApi(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url);
        return restApiClient.getRestApi();
    }
}
