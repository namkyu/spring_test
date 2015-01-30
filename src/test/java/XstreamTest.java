import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

import org.junit.Test;

import xstreamvo.Games;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * @FileName : XstreamTest.java
 * @Project : spring_test
 * @작성자 : nklee
 * @프로그램설명 :
 */
public class XstreamTest {

	@Test
	public void specDescription() throws Exception {
		XStream xStream = new XStream();
		xStream.processAnnotations(Games.class);

		FileInputStream is = new FileInputStream("E:\\test\\xstream\\test.xml");
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");

		Games gameInfo = (Games) xStream.fromXML(isr);
		System.out.println(gameInfo);
	}

	@Test
	public void autoDetectTest() {
		XStream xStream = new XStream();
		xStream.autodetectAnnotations(true);
		RendezvousMessage msg = new RendezvousMessage(15, 111, "kyu", "Y", "a", "b");
		System.out.println(xStream.toXML(msg));
	}

}

@Data
@XStreamAlias("message")
class RendezvousMessage {

	@XStreamAlias("messageTypeAlias")
	private int messageType;

	@XStreamOmitField
	@XStreamAlias("omitFieldTest")
	private int omitFieldTest;

	@XStreamAsAttribute
	private String name;

	@XStreamImplicit(itemFieldName = "part")
	private List<String> content;

	@XStreamConverter(ConvertTest.class)
	private String convertTest;

	public RendezvousMessage(int messageType, int omitFieldTest, String name, String convertTest, String... content) {
		this.messageType = messageType;
		this.omitFieldTest = omitFieldTest;
		this.name = name;
		this.convertTest = convertTest;
		this.content = Arrays.asList(content);
	}

}
