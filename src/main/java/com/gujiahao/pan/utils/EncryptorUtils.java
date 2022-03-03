package com.gujiahao.pan.utils;

import com.gujiahao.pan.model.User;
import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptorUtils {

    private BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

    private static String ENCRYPT_PRIVATE_KEY = "3VzT(vJ8U3e<JIq=m07:zS]p>^>.Rx";

    public EncryptorUtils(){
        final String privateKey = ENCRYPT_PRIVATE_KEY;
//        System.out.println(privateKey);
        this.textEncryptor.setPassword(privateKey);
    }


    /**
     *
     * @param s 需要加密的密码
     * @return
     */
    public String encrypt(String s) {
        return textEncryptor.encrypt(s);
    }

    /**
     * 用户验证
     * @param user  请求登录用户
     * @param data  数据库保存的用户
     * @return
     */
    public boolean verify(User user, User data) {
        final String userPassword = user.getUserPassword();
        final String dataPassword = data.getUserPassword();
        final String decrypt = textEncryptor.decrypt(dataPassword);
        return decrypt.equals(userPassword);
    }

}
