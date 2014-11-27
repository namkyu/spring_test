package xstreamvo;

import lombok.Data;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @FileName : ServerInfo.java
 * @Project : spring_test
 * @작성자 : nklee
 * @프로그램설명 :
 */
@Data
@XStreamAlias("server")
public class ServerInfo {

	@XStreamAlias("id")
	@XStreamAsAttribute
	private int id;

	@XStreamAlias("dbname")
	@XStreamAsAttribute
	private String dbname;
}
