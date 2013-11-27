package create;
import org.apache.axis.wsdl.WSDL2Java;


public class CreateMain {
	public static void main(String[] args) {
		String wsdl = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
        WSDL2Java.main(new String[] { "-o", "src","-p","com.fusheng.weather", wsdl });
	}

}
