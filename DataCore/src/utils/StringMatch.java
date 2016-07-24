/**
 * 
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Vaygr
 *
 */
public class StringMatch {

	/**
	 * 
	 */
	public StringMatch() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<String> getTokens(String target, String pattern){
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokenSplitter = Pattern.compile(pattern);
		Matcher m = tokenSplitter.matcher(target);
		
		while ( m.find() ){
			tokens.add(m.group());
		}
		
		return tokens;
	}

}
