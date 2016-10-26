package com.vrv.nj.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import com.vrv.nj.common.Constants;
import com.vrv.nj.domain.ip.Data;
import com.vrv.nj.domain.ip.TaoBaoResp;

/**
 * <一句话功能简述>
 * 
 * @author 赵炎
 * @version [V1.00, 2016年8月29日]
 * @category ip转换工具类
 */
public class IPUtil
{
    /**
     * 请求的url
     */
    private static final String IP_URL = PropertiesUtil.getString("ip", "url");
    
    private static final String LOCALHOST = "127.0.0.1";
    
    public static String getIPByRequest(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip) || ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
        {
            ip = "127.0.0.1";
        }
        return ip;
    }
    
    /**
     * <p>
     * 根据ip获取登录具体地址
     * </p>
     * 
     * <pre>
     * 例如：中国南京市建邺区电信
     * </pre>
     * 
     * @param ip 远程ip
     * @return <code>String</code>
     */
    public static String getLocalAddress(String ip)
    {
        if(LOCALHOST.equals(ip))
        {
            return Constants.LOCAL_LOGIN;
        }
        StringBuffer address = new StringBuffer();
        String content = "ip=" + ip;
        String returnStr = getResult(content);
        if (StringUtil.isNotBlank(returnStr))
        {
            JSONObject jsonObject = JSONObject.fromObject(returnStr);
            int code = jsonObject.getInt("code");
            if (code == 0)
            {
                TaoBaoResp resp = (TaoBaoResp)JSONObject.toBean(jsonObject, TaoBaoResp.class);
                Data data = resp.getData();
                // 国家
                String country = data.getCountry();
                address.append(country);
                // 省份
                String region = data.getRegion();
                address.append(region);
                // 城市
                String city = data.getCity();
                address.append(city);
                // 区县
                String county = data.getCounty();
                address.append(county);
                // 运营商
                String isp = data.getIsp();
                address.append(isp);
                return address.toString();
            }
            else
            {
                return Constants.UNKOWN;
            }
        }
        return Constants.UNKOWN;
    }
    
    /**
     * @param urlStr
     *            请求的地址
     * @param content
     *            请求的参数 格式为：name=xxx&pwd=xxx
     * @param encoding
     *            服务器端请求编码。如GBK,UTF-8等
     * @return <code>String</code>
     */
    private static String getResult(String content)
    {
        URL url = null;
        HttpURLConnection connection = null;
        int failCnt = 0;
        while(failCnt < 3)
        {
            try
            {
                url = new URL(IP_URL);
                connection = (HttpURLConnection)url.openConnection();// 新建连接实例
                connection.setConnectTimeout(3000);// 设置连接超时时间，单位毫秒
                connection.setReadTimeout(10000);// 设置读取数据超时时间，单位毫秒
                connection.setDoOutput(true);// 是否打开输出流 true|false
                connection.setDoInput(true);// 是否打开输入流true|false
                connection.setRequestMethod("POST");// 提交方法POST|GET
                connection.setUseCaches(false);// 是否缓存true|false
                connection.connect();// 打开连接端口
                DataOutputStream out = new DataOutputStream(connection.getOutputStream());// 打开输出流往对端服务器写数据
                out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
                out.flush();// 刷新
                out.close();// 关闭输出流
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf8"));// 往对端写完数据对端服务器返回数据,以BufferedReader流来读取
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null)
                {
                    buffer.append(line);
                }
                reader.close();
                return buffer.toString();
            }
            catch (IOException e)
            {
                failCnt++;
                System.out.println("failCnt>>>" + failCnt);
                e.printStackTrace();
            }
            finally
            {
                if (connection != null)
                {
                    connection.disconnect();// 关闭连接
                }
            }
        }
        
        return null;
    }
}
