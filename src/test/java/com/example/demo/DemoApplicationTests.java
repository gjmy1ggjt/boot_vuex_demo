package com.example.demo;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.junit.jupiter.api.Test;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

import static com.example.demo.utils.bianlichannel.Consts.*;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
    private RedisTemplate<String, Object> redisTemplate;

	@Test
	void contextLoads() throws SchedulerException {

//		String url = "https://sapi.bianli24.com/superpeanut/device/push/batch";
//		String params =  "y1MV+TVksQGjCTh3VBrjbT7ooOO96yra4LNpqAvcFsDm/Vhy8PkVTGsELlNNUMjR0atvCDMCr9opX35bH7Cm4y6ve/balr0Bx/GKo2O7w1ClFjCknK3ALrIdM3fPCdBW+XFLsQfLDVCasP9AMQSqqkWjHdus2Uhhm/FE/USfxazOwddTB7FliMTJ3Ie9IzON1J4a36IaQ6q6KcqOkH+a2STXfde0K/tsxYryCwzVzZk=";
//
//		String result2 = HttpRequest.post(url)
//				.body(params)
//				.execute().body();
		boolean bhd1 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 1 + POINT + 1);
        boolean bhd2 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 2 + POINT + 1);
        boolean bhd3 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 3 + POINT + 1);
        boolean bhd4 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 4 + POINT + 1);
        boolean bhd5 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 5 + POINT + 1);
        boolean bhd6 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 6 + POINT + 1);
        boolean bhd7 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 7 + POINT + 1);
        boolean bhd9 = redisTemplate.hasKey(DEVICE_PUSH_STATUS + DEVICE_CODE + POINT + 9 + POINT + 1);


//		Map<String, Object> paramMap = new HashMap<>();
//		paramMap.put("params", params);


//		MainScheduler mainScheduler = new MainScheduler();
//		mainScheduler.schedulerJob();
	}
/*

	public Response intercept(@NonNull Chain chain) throws IOException {
		Request request = chain.request();
		RequestBody oldBody = request.body();

		Map<String, Object> paramsMap = new HashMap<>();
		if (oldBody instanceof FormBody) {
			//FormBody参数直接通过key-value形式直接存入
			for (int i = 0; i < ((FormBody) oldBody).size(); i++) {
//                paramsMap.put(((FormBody) oldBody).encodedName(i), ((FormBody) oldBody).encodedValue(i));
				paramsMap.put(((FormBody) oldBody).name(i), ((FormBody) oldBody).value(i));

			}
		}
		paramsMap.put("version", String.valueOf(AppUtil.getVersionCode()));
		paramsMap.put("platform", "1");
		paramsMap.put("channel", "");
		paramsMap.put("imei", AppUtil.getIMEI());
		if (!TextUtils.isEmpty(DataManager.getInstance().getLoginInfo().getToken())) {
			paramsMap.put("token", DataManager.getInstance().getLoginInfo().getToken());
		}
		paramsMap.put("role", DataManager.getInstance().getLoginInfo().getRole());


		//TODO:非FromBOdy参数可能需要处理

		JSONObject jsonObject = new JSONObject(paramsMap);
		String s = jsonObject.toString();

		//加密处理
		String encryptData = ContentSecurity.encrypt(s);
		if (BuildConfig.DEBUG) {
			KLog.i("afa-加密后的请求参数：", s);
			KLog.i("afa-请求接口地址：", request.url());
		}
		//根据请求方式来分别处理，处理完毕分别装入RequestBody
		Request.Builder builder = request.newBuilder();

		Request newRequest;
		if ("GET".equals(request.method())) {
			newRequest = builder.get().url(request.url() + "?params=" + encryptData).build();
		} else {
			FormBody body = new FormBody.Builder().add("params", encryptData).build();
			newRequest = builder
					.addHeader("Accept", "application/json;charset:utf-8")
					.addHeader("Content-Type", "application/json;charset:utf-8")
					.addHeader("k", GateSecurity.encrypt(String.valueOf(System.currentTimeMillis())))
					.post(body).build();
		}
		return chain.proceed(newRequest);
	}

*/


}
