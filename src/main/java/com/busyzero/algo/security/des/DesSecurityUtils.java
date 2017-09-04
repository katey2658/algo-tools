package com.busyzero.algo.security.des;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
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
 * des 加密
 * 
 * @author katey2658
 *
 */
public class DesSecurityUtils {
	/** 默认keygen 位置 */
	private static final String DEFAULT_KEYGEN_FILE = "keygen.text";

	/**
	 * 按默认地址生成密钥
	 * 
	 * @return
	 */
	public static SecretKey generateSecretKey() {
		return generateSecretKey(DEFAULT_KEYGEN_FILE);
	}

	/**
	 * 生成密钥
	 * 
	 * @param path
	 * @return
	 */
	public static SecretKey generateSecretKey(String file) {
		try {
			// 生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			// 设置长度
			keyGenerator.init(56);
			SecretKey key = keyGenerator.generateKey();
			byte[] keyBytes = key.getEncoded();

			// key 转换
			DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			SecretKey secretKey = factory.generateSecret(desKeySpec);

			// 进行序列化
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
			outputStream.writeObject(secretKey);
			outputStream.close();
			return secretKey;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据默认地址去取密钥
	 * @return
	 */
	public static SecretKey getSecretKey(){
		return getSecretKey(DEFAULT_KEYGEN_FILE);
	}

	/**
	 * 根据文件路径获取密钥
	 * 
	 * @param file
	 * @return
	 */
	public static SecretKey getSecretKey(String file) {
		ObjectInputStream outputStream = null;
		try {
			outputStream = new ObjectInputStream(new FileInputStream(file));
			SecretKey secretKey = (SecretKey) outputStream.readObject();
			outputStream.close();
			return secretKey;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 按默认地址密钥解密
	 * @param encryptStr
	 * @return
	 */
	public static String jdkDesDecrypt(final String encryptStr){
		return jdkDesDecrypt(encryptStr,DEFAULT_KEYGEN_FILE);
	}
	/**
	 * 解密
	 * 
	 * @param encryptStr
	 * @param file
	 * @return
	 */
	public static String jdkDesDecrypt(final String encryptStr, String file) {
		SecretKey secretKey = getSecretKey(file);
		// 解密
		byte[] result = null;
		try {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			result = cipher.doFinal(encryptStr.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		return new String(result);
	}

	/**
	 * Des 加密：jdk
	 * 
	 * @param originalStr
	 * @return
	 */
	public static String jdkDesEncrypt(final String originalStr, SecretKey secretKey) {
		try {
			// 加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] result = cipher.doFinal(originalStr.getBytes());
			return new String(result);
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
