package xstreamvo;

import java.util.List;

import lombok.Data;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * @FileName : ServerInfo.java
 * @Project : spring_test
 * @작성자 : nklee
 * @프로그램설명 :
 */
@Data
public class GameInfo {

	@XStreamAlias("id")
	@XStreamAsAttribute
	private int id;

	@XStreamAlias("server")
	@XStreamImplicit
	private List<ServerInfo> serverList;
}
