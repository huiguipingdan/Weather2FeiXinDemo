package util;

import java.io.UnsupportedEncodingException;

public class Encoding {
	public static final String UTF_8 = "UTF-8";
	public String changeCharset(String str, String newCharset)
	throws UnsupportedEncodingException {
		if (str != null) {
			//��Ĭ���ַ���������ַ�����
			byte[] bs = str.getBytes();
			//���µ��ַ����������ַ���
			return new String(bs, newCharset);
		}
		return null;
	}	

	public String toUTF_8(String str) throws UnsupportedEncodingException{
		return this.changeCharset(str, UTF_8);
	}	
}
