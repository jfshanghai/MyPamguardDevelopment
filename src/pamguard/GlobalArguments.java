package pamguard;

import java.util.HashMap;

/**
 * Global parameter pairs set at startup time.<br>
 * These are the arguments passed to the command line. <br>Basically all going into a static hash map
 * @author dg50
 *
 */
public class GlobalArguments {
	
	/**
	 * Flag to say we're running batch jobs (viewer OR normal) 
	 */
	public static final String BATCHFLAG = "-batch";
	
	/**
	 * Flag used when opening the psfx that's going to control viewer offline
	 * tasks. Used in modules to make sure they load and register tasks. 
	 */
	public static final String BATCHVIEW = "-bv";

	static HashMap<String, String> globalFlags = new HashMap<>();
	
	/**
	 * Set a global parameter value
	 * @param name value name
	 * @param value parameter value
	 */
	public static void setParam(String name, String value) {
		globalFlags.put(name, value);
	}
	
	/**
	 * Get a global parameter value
	 * @param name value name
	 * @return value in original String format
	 */
	public static String getParam(String name) {
		return globalFlags.get(name);
	}
	
	/**
	 * Get a param read as an integer
	 * @param name
	 * @return value as integer or null if not set. Throws exception if invalid integer. 
	 */
	public static Integer getParamI(String name) {
		String val = getParam(name);
		if (val == null) {
			return null;
		}
		return Integer.valueOf(val);
	}
	
	/**
	 * Is the batch flag set ?
	 * @return
	 */
	public static boolean isBatch() {
		return getParam(BATCHFLAG) != null;
	}
	
}
