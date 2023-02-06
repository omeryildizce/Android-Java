package com.omeryildizce.webservis2.restApi;

public class BaseManager {
    protected RestApi getRestApiClient() {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.urlBilgi);
        return restApiClient.getRestApi();
    }
}
