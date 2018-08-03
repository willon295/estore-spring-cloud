package com.briup.estore;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import org.junit.Before;
import org.junit.Test;

/**
 * Created By willon
 *
 * @author willon
 * @version 1.0
 * 联系方式： willon295@163.com
 * @since 18-7-31
 */
public class TestTime {
    private String GATEWAY;
    private String APP_ID;
    private String PRIVATE_KEY;
    private String CHARSET;
    private String FORMAT;
    private String ALIPUBLIC_KEY;
    private String SIGN_TYPE;
    private AlipayClient alipayClient;

    @Before
    public void init() {
        GATEWAY = "https://openapi.alipaydev.com/gateway.do";
        APP_ID = "2016091900545865";
        PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCs6KD8b2oUKygi7cM+t1GVxwsJ+6RQdm4X51yM/17oAdZuvu1XJsvUkLIs7RBSpkimAu3vJAmnTqwP48uR79pQbyOmLbjTKPpn0ev7Gk9exj6rUjPZT2cZDpOgqFqiMayE1dA+XDGAUFU0DgWR4ZVd4mkpdOdj8tTrvElJDRWLkLosDuAGIbpFRXO4ucVPElQhAeedyxXQIUFX32vNUoFnT/neqTx9gtSbaz+StwBQ4U0djMOvkLaj3uABymQIz+zb7qs5Q6Qzy22y7ebhe18RCjjtCKIb065qM1C0mlJywqWhuTmnJ1/THnbSSUwrJvPPNV+VJfi7GRErgmRvly9xAgMBAAECggEAbyc0plKxLLn5mUqjYuPR7KkB7a75GEipyXAPzQw1ZIwZ3yOZy5bDHajPAZZ8EcWXmjDz5/GQyx8F+UkFCpHYFDD+B8wIrqX/I1KNkuR89X4Xt2amsiIbMr5uJK9VZELulo4kypHVuJjrzQTei8MqlCoCVIY0YcovGkP2EKH6obach75RC98xzi07li43LhpOd/hB4LHPUZNoQSEdvZHSJFl5d2oDoh1QaTJWEXGVlZ7LKHUf8mC8OHbZdTHO7qX5apPakssiagvZNTWCzH4XmhF0ZoObTHjvCXBWU0cDFsMeD8sXbVUApEYQ5Z8EGni0plYKhooMwBKRJIpUOPSo4QKBgQD0g1vrYQAqxsRdVhxPHNm+myLzJDRR5Sf6AZaQqWT20VFD+8pncTO3Rc4aG9iYRCNT6xTafQ0rhIuPfyFC0ddAbAzbvRpAlc2CqG72HBnrNQypwhRw8vlyweylwtkEiSiQQ84pmFhJNs0wt+o96+dbfW2hLSigmq0Vw/d8jMF/3QKBgQC1CB4/mk0qvRXNrZ+tarXs2gmHAiPuzx1vOC+PhWWBBUTVZ8Pe7XWWXJXGJpnrOG3n2O/CjeMV6bNVr+89I6SQMMCdMUoodkZUU7NIZ7/nbpu50xOVgVki3PyfLsdUdtpzwKpURO9nJuqixT21uo7+to9J21Q0fmRRgDEaiyV+pQKBgBgOlIykDpAm3ksQndhqzkGiod2qQjuMgFJotZemEvj1vzkhHNjwmlX92DlZZAYXLiKjjnmwtAsED3ce2vboDnWYK+uyv1J7aqzgRYqRWTt7DLPnFHvIbCKOUeo9MXzwwbzv7ujIxGbvrWCNt84/15N408B34PdsQHtTvJXUg3VBAoGAVrxVAdRENL3zvF/7qXL/R0QQXIdCACFr0OXyo6keQPrtR/I3fo/3Ttt9Rzsnc/PNdNATz/t7Wfxm2B87WOfC6PLy1l3PUiOY/r47n+1VnOT558aiE3et5W5L+1jGWEm50Mv2z/lXWuzibqpiLrf72z5M2O4lIiGMnx/0ZutUQ6ECgYBG703DlzZy04bZuHET3x4aeQzK7/IYMFdsnSMgibzfBYsHBMxZC6VrnjoaHp1gke1aFAlGTeV8WjeDo5DbSQ1md04rrurmPnc1NRiSYrbo7q5EESlNMsaT01sry8RipbdM39OBEZK/Wq+MezZ7wTY1tISj4F2+mS2r5Abr0GglbA==";
        CHARSET = "utf-8";
        FORMAT = "json";
        ALIPUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAveQxS6Uv9LSrzEngUIbTYSSEpQVEzFonYkJGx3uSbcDNZ+ieMLC641GUFDAZTYzzX5aZv6YuRdrO/+rH20vKmfwVjFF43Ics99Awj4PdPHLX0uX1ypva1L2H2LndD7FAfP6TD4nMWuFZsOvSett9meYMMuy9y32X5WVR5n47ZMCVl9SiylpiDKlzrfGO98+0JlDGIkn9jxzvj0rP0FHImSAWRArdWK0qUhe9HA/lPZHe41bYOuB2FGWnoh7FUd0QquIcDSRLlHDunmaM80Fokdn1OFZTYqVAarwSd1+HtoOPeiDGXDqTdOoBnFLgxDTbZ2040qNvXDIkOeR3tPDxPQIDAQAB";
        SIGN_TYPE = "RSA2";
        alipayClient=new DefaultAlipayClient(GATEWAY,APP_ID,PRIVATE_KEY,FORMAT,CHARSET,ALIPUBLIC_KEY,SIGN_TYPE);

    }

    @Test
    public void testQuery() throws AlipayApiException {
        AlipayTradeQueryRequest queryRequest = new AlipayTradeQueryRequest();

        queryRequest.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101001\"," +
                "    \"trade_no\":\"2014112611001004680073956707\"}");
        AlipayTradeQueryResponse response = alipayClient.execute(queryRequest);
        System.out.println(response.getBody());
        System.out.println("---------------");
        System.out.println(response.getTradeStatus());
    }
}
