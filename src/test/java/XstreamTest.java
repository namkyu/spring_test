import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import xstreamvo.Games;

import com.thoughtworks.xstream.XStream;

/**
 * @FileName : XstreamTest.java
 * @Project : spring_test
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class XstreamTest {

	public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {

		XStream xStream = new XStream();
		xStream.processAnnotations(Games.class);

		FileInputStream is = new FileInputStream("E:\\test\\xstream\\test.xml");
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");

		Games gameInfo = (Games) xStream.fromXML(isr);
		System.out.println(gameInfo);
	}

}
