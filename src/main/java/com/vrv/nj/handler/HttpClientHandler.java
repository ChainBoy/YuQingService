package com.vrv.nj.handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientHandler
{
    // media type
    public static final List<ContentType> CONTENT_TYPES = Arrays.asList(ContentType.TEXT_HTML,
        ContentType.TEXT_XML,
        ContentType.APPLICATION_XML,
        ContentType.APPLICATION_SVG_XML,
        ContentType.APPLICATION_XHTML_XML,
        ContentType.APPLICATION_ATOM_XML,
        ContentType.APPLICATION_JSON);
    
    protected static final Logger LOGGER = LoggerFactory.getLogger(HttpClientHandler.class);
    
    // convert mill seconds to second unit
    protected static final int MS_TO_S_UNIT = 1000;
    
    // Normal http response code
    protected static final int NORMAL_RESPONSE_CODE = 200;
    
    // https prefix
    protected static final String HTTPS = "https";
    
    protected static HttpsTrustManager httpsTrustManager = new HttpsTrustManager();
    
    protected String url;
    
    protected int maxConnectionSeconds = 0;
    
    protected String contentType;
    
    protected HttpEntity httpEntity;
    
    protected Map<String, String> requestParams = new HashMap<String, String>();
    
    protected Map<String, String> headers = new HashMap<String, String>();
    
    private static final String DEFAULT_ENCODING = "utf8";
    
    public HttpClientHandler(String url)
    {
        this.url = url;
    }
    
    public HttpClientHandler maxConnectionSeconds(int maxConnectionSeconds)
    {
        this.maxConnectionSeconds = maxConnectionSeconds;
        return this;
    }
    
    public HttpClientHandler addRequestParam(String key, String value)
    {
        this.requestParams.put(key, value);
        return this;
    }
    
    @SuppressWarnings("unchecked")
    public <T extends HttpClientHandler> T addHeader(String key, String value)
    {
        this.headers.put(key, value);
        return (T)this;
    }
    
    @SuppressWarnings("unchecked")
    public <T extends HttpClientHandler> T httpEntity(HttpEntity httpEnity)
    {
        this.httpEntity = httpEnity;
        return (T)this;
    }
    
    public HttpClientHandler contentType(String contentType)
    {
        this.contentType = contentType;
        return this;
    }
    
    public String handleAsString()
    {
        
        try
        {
            final CloseableHttpResponse response = sendRequest();
            if (isNormal(response))
            {
                return responseAsString(response);
            }
            else
            {
                LOGGER.warn("Failed: Send request to [{}] response: {}", url, response.getStatusLine());
            }
        }
        catch (Exception e)
        {
            LOGGER.debug("Send request to url[" + url + "] failed", e);
        }
        
        return null;
    }
    
    /*
     * Convert response as string
     */
    protected String responseAsString(CloseableHttpResponse response)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try
        {
            response.getEntity().writeTo(baos);
            return new String(baos.toByteArray(), DEFAULT_ENCODING);
        }
        catch (IOException e)
        {
            throw new IllegalStateException(e);
        }
    }
    
    protected boolean isNormal(CloseableHttpResponse response)
    {
        return response.getStatusLine().getStatusCode() == NORMAL_RESPONSE_CODE;
    }
    
    protected CloseableHttpResponse sendRequest()
        throws Exception
    {
        HttpUriRequest request = retrieveHttpRequest();
        setContentType(request);
        setHeaders(request);
        
        CloseableHttpClient client = retrieveHttpClient();
        return client.execute(request);
    }
    
    protected CloseableHttpClient retrieveHttpClient()
    {
        final RequestConfig requestConfig = requestConfig();
        if (isHttps())
        {
            // Support SSL
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(createSSLContext());
            return HttpClients.custom().setDefaultRequestConfig(requestConfig).setSSLSocketFactory(sslConnectionSocketFactory).build();
        }
        else
        {
            return HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        }
    }
    
    private SSLContext createSSLContext()
    {
        try
        {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new HttpsTrustManager[] {httpsTrustManager}, null);
            return sslContext;
        }
        catch (Exception e)
        {
            throw new IllegalStateException("Create SSLContext error", e);
        }
    }
    
    protected boolean isHttps()
    {
        return url.toLowerCase().startsWith(HTTPS);
    }
    
    private RequestConfig requestConfig()
    {
        final int maxConnMillSeconds = this.maxConnectionSeconds * MS_TO_S_UNIT;
        return RequestConfig.custom().setSocketTimeout(maxConnMillSeconds).setConnectTimeout(maxConnMillSeconds).build();
    }
    
    protected void setHeaders(HttpUriRequest request)
    {
        for (String key : headers.keySet())
        {
            request.addHeader(key, headers.get(key));
        }
    }
    
    private void setContentType(HttpUriRequest request)
    {
        if (StringUtils.isNotEmpty(this.contentType))
        {
            request.setHeader(HttpHeaders.CONTENT_TYPE, contentType);
            LOGGER.debug("Set HttpUriRequest[{}] contentType: {}", request, contentType);
        }
    }
    
    private HttpUriRequest retrieveHttpRequest()
    {
        final RequestBuilder builder = createRequestBuilder();
        addRequestParams(builder);
        setHttpEntity(builder);
        return builder.setUri(url).build();
    }
    
    protected void setHttpEntity(RequestBuilder builder)
    {
        if (this.httpEntity != null)
        {
            builder.setEntity(this.httpEntity);
        }
    }
    
    protected void addRequestParams(RequestBuilder builder)
    {
        final Set<String> keySet = requestParams.keySet();
        for (String key : keySet)
        {
            final String value = requestParams.get(key);
            if (StringUtils.isNotEmpty(value))
            {
                builder.addParameter(key, value);
            }
            else
            {
                LOGGER.error("Ignore add request param[{}={}], because key is empty or null", key, value);
            }
        }
    }
    
    protected RequestBuilder createRequestBuilder()
    {
        return RequestBuilder.get();
    }
    
    /**
     * Default X509TrustManager implement
     */
    private static class HttpsTrustManager implements X509TrustManager
    {
        
        @Override
        public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
            throws CertificateException
        {
            // ignore
            
        }
        
        @Override
        public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
            throws CertificateException
        {
            // ignore
            
        }
        
        @Override
        public X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }
        
    }
}
