package com.vrv.nj.handler;

import org.apache.http.client.methods.RequestBuilder;

public class HttpClientPostHandler extends HttpClientHandler
{
    
    public HttpClientPostHandler(String url)
    {
        super(url);
    }
    
    protected RequestBuilder createRequestBuilder()
    {
        return RequestBuilder.post();
    }

}
