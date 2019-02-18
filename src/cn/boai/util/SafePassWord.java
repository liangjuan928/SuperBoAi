package cn.boai.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class SafePassWord {
	 /**
  	 * ��������
  	 * @throws Exception 
  	 */
  	public static  String encodePassword(String pass ,String encodestr) throws Exception{
  		 KeyGenerator kgen = KeyGenerator.getInstance("AES");
  		
          kgen.init(128, new SecureRandom(pass.getBytes()));
                                                                  // 128λ��key������
          

            SecretKey secretKey = kgen.generateKey();

           byte[] enCodeFormat = secretKey.getEncoded();
           SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

           Cipher cipher = Cipher.getInstance("AES");

          byte[] byteContent = encodestr.getBytes();

           cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] result = cipher.doFinal(byteContent);

             return bytesToHexFun3(result);    
  	}
	/**
 	 * ��������
 	 */
 	public static String decodePassword(String pass ,String encodestr) throws Exception{
 		       KeyGenerator kgen = KeyGenerator.getInstance("AES");   // ����AES��Key������
 		             kgen.init(128, new SecureRandom(pass.getBytes()));
 		             SecretKey secretKey = kgen.generateKey();    // �����û����룬����һ����Կ
 	                byte[] enCodeFormat = secretKey.getEncoded();    // ���ػ��������ʽ����Կ
 		            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");   // ת��ΪAESר����Կ
 		            Cipher cipher = Cipher.getInstance("AES");   // ����������
 		             cipher.init(Cipher.DECRYPT_MODE, key);       // ��ʼ��Ϊ����ģʽ��������
 		             //��ʮ�������ַ���ת��Ϊ�ֽ������ٽ���
 		             byte[] b=toBytes(encodestr);
 		            byte[] result = cipher.doFinal(b);  
 		            return new String(result); // ����   
 	}
 	/**
 	 * �ֽ�����ת��Ϊʮ������
 	 * @param bytes
 	 * @return
 	 */
 	 public static String bytesToHexFun3(byte[] bytes) {
 		StringBuffer sb = new StringBuffer();  
 	    for(int i = 0; i < bytes.length; i++) {  
 	        String hex = Integer.toHexString(bytes[i] & 0xFF);  
 	        if(hex.length() < 2){  
 	            sb.append(0);  
 	        }  
 	        sb.append(hex);   
 	    }  
 	    return sb.toString();    
     }
 	 
 	 /**
 	  * ��ʮ�������ַ���ת��Ϊ�ֽ�����
 	  * @param str
 	  * @return
 	  */
 	public static byte[] toBytes(String str) { 
 		int hexlen = str.length();  
 	    byte[] result;  
 	    if (hexlen % 2 == 1){  
 	        //����  
 	        hexlen++;  
 	        result = new byte[(hexlen/2)];  
 	       str="0"+str;  
 	    }else {  
 	        //ż��  
 	        result = new byte[(hexlen/2)];  
 	    }  
 	    int j=0;  
 	    for (int i = 0; i < hexlen; i+=2){  
 	        result[j]= (byte) Integer.parseInt(str.substring(i,i+2),16);
 	        j++;  
 	    }  
 	    return result;   
 	
 		}
}
