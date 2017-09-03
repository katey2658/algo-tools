package com.busyzero.algo.security.des;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * des 对称加密算法
 * @author katey2658
 *
 */
public class DesSecurityUtils{
	
	/**
	 * jdk des算法
	 */
	public static void jdkDesc(String str){
		try {
			//生成key
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(56);
			SecretKey secretKey = generator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//Key 进行转换
			DESKeySpec spec=new DESKeySpec(bytesKey);
			SecretKeyFactory factroy=SecretKeyFactory.getInstance("DES");
			Key convertKey = factroy.generateSecret(spec);
			
			//加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertKey);
			byte[] result = cipher.doFinal(str.getBytes());
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertKey);
			result=cipher.doFinal(result);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
	}

}
