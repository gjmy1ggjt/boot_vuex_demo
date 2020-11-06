package com.example.demo.utils.bianlichannel;

import com.example.demo.utils.EncryptUtil;

public class LockChannelUrl {

    public static void main(String[] args) {

        String urlLine = "https://promote-h5.bianli24.com//#/facility";
        String urlTest = "https://promote-h5-test.bianli24.com//#/facility";
//        Long supplierId = 12327L;
//        Long memberId = 542137498572166554L;
        Long supplierId = 4684L;
        Long memberId = 542137498572168565L;

//        Long supplierId = 6624L;
//        Long memberId = 542137498572166498L;
//        Long memberId = 1000_000L;

//        System.out.println(EncryptUtil.encryptHex(supplierId.toString()));
//        System.out.println(EncryptUtil.encryptHex(memberId.toString()));

        StringBuilder sb = new StringBuilder();

        String supplierIdEncrypt = EncryptUtil.encryptHex(supplierId.toString());

        String memberIdEncrypt = EncryptUtil.encryptHex(memberId.toString());

        sb.append("?supplierId=").append(supplierIdEncrypt)

                .append("&memberId=").append(memberIdEncrypt).append("&1");

        System.out.println(new StringBuffer().append(urlLine).append(sb));
        System.out.println(new StringBuffer().append(urlTest).append(sb));

//        String dddd = EncryptUtil.decryptStr(sb.toString());

//        System.out.println(dddd);

//        System.out.println(EncryptUtil.encryptHex("4099"));
//        System.out.println(EncryptUtil.encryptHex("1000000"));
//
//
//        System.out.println(EncryptUtil.decryptStr("95f30cf5d1e9d2f3526a335b238b1082"));
//        System.out.println(EncryptUtil.decryptStr("b870237085c09ca3cfca56dc594e8e0f89274c52f761d47fbf79481b8d8e9c92"));


    }
}
