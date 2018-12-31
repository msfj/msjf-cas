package com.msjf.finance.cas.modules.util;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * 密码加密、解密
 * Created by lzp on 2018/12/27.
 */
public class ADEncrypUtil {
    private static final Logger logger = LoggerFactory.getLogger(ADEncrypUtil.class);
    /**
     * AES加密字符串
     *
     * @param password
     *            需要被加密的字符串
     * @param no
     *            机构号码
     * @return 密文
     */
    public static byte[] encrypt(String password, String no) {

        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者

            kgen.init(128, new SecureRandom(no.getBytes()));// 利用用户密码作为随机数初始化出
            // 128位的key生产者
            //加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行

            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥

            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥，如果此密钥不支持编码，则返回
            // null。

            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥

            Cipher cipher = Cipher.getInstance("AES");// 创建密码器

            byte[] byteContent = password.getBytes("utf-8");

            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化为加密模式的密码器

            byte[]  result = cipher.doFinal(byteContent);// 加密

            return result;

        } catch (Exception e){
            logger.error("AES加密失败!", e);
        }
        return null;
    }

    /**
     * 解密AES加密过的字符串
     *
     * @param password
     *            AES加密过的内容
     * @param no
     *            机构代码
     * @return 明文
     */
    public static byte[] decrypt(byte[] password, String no) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");// 创建AES的Key生产者
            kgen.init(128, new SecureRandom(no.getBytes()));
            SecretKey secretKey = kgen.generateKey();// 根据用户密码，生成一个密钥
            byte[] enCodeFormat = secretKey.getEncoded();// 返回基本编码格式的密钥
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");// 转换为AES专用密钥
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化为解密模式的密码器
            byte[] result = cipher.doFinal(password);
            return result; // 明文

        } catch (Exception e){
            logger.error("AES解密失败!", e);
        }
        return null;
    }
}
