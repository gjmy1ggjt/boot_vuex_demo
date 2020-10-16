package com.example.demo.utils.wxcode;

import java.util.HashMap;
import java.util.Map;

import static com.example.demo.utils.bianlichannel.Consts.PUSH_BATCH_URL;
import static com.example.demo.utils.bianlichannel.SaticScheduleTask.requestGet;

public class WXcodeTest {

    public static void main(String[] args) {

        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";

        String wxCode = "0013310000bisK12j4400P2UDn23310k";

        Map<String,String> requestUrlParam = new HashMap<String, String>(  );
        requestUrlParam.put( "appid","wx4bb223a490ec0b7d" );//小程序appId
        requestUrlParam.put( "secret","56afc27c01ac50a684861fa288b4e68c" );
        requestUrlParam.put( "js_code",wxCode );//小程序端返回的code
        requestUrlParam.put( "grant_type","authorization_code" );//默认参数

        String s = requestGet(requestUrl, requestUrlParam);
        System.out.println(s);

    }
}
