/**
 * 
 */
package testsuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

/**
 * @author Vaygr
 *
 */
public class DataLoader {
	/**
	 * 
	 */
	public DataLoader() {
		// ToDo:
	}
	
	public static List<String> LoadData(String filename){
		try {
			File file = new File(filename);
			return Files.readAllLines(file.toPath());
		}
		catch (IOException ex){
			return null;
		}
	}

}
