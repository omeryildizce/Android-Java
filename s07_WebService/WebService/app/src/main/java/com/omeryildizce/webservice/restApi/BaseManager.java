package com.omeryildizce.webservice.restApi;

public class BaseManager {
    protected RestApi getRestApiClient(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.bilgiUrl);
        return restApiClient.getRestApi();
    }
}
