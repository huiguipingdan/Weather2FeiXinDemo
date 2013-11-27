package create;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.fusheng.weather.WeatherWebServiceLocator;
import com.fusheng.weather.WeatherWebServiceSoap_PortType;

public class MyWeatherTest {
	public String getWeatherData(String city) {
		ThreadUseRunnable t = new ThreadUseRunnable(city);
		t.run();
		return t.content_body;
	}
}

class ThreadUseRunnable implements Runnable {
	String city_t;
	String content_body;
	ThreadUseRunnable(String city) {
		city_t = city;
	}

	public void run() {
		System.out.println("Thread线程开始");
		try {
			String[] str = null ;
			String content_body_m = null ;
			String ncurl = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx"; //NC WS地址
			WeatherWebServiceLocator wwsl = new WeatherWebServiceLocator();
			WeatherWebServiceSoap_PortType wwss;
			wwss = wwsl.getWeatherWebServiceSoap(new URL(ncurl));
			str = wwss.getWeatherbyCityName(city_t);
			String prefix_str = "fusheng---";
			content_body_m = prefix_str+" "+str[0]+" "+str[1]+" "+str[5]+" "+str[6]+" "+str[7]+" "+str[10];
			System.out.println("Thread线程挂起4秒");
			Thread.sleep(4000);
			content_body = content_body_m;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
