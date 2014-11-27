package xstreamvo;

import java.util.List;

import lombok.Data;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * @FileName : GameInfo.java
 * @Project : spring_test
 * @작성자 : nklee
 * @프로그램설명 :
 */
@Data
@XStreamAlias("games")
public class Games {

	@XStreamImplicit
	@XStreamAlias("game")
	private List<GameInfo> gameList;

}
