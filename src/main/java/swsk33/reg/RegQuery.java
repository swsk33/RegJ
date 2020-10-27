package swsk33.reg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 查询注册表
 * 
 * @author swsk33
 *
 */
public class RegQuery {

	private String charSet = "UTF-8";

	private String getCharSet() {
		return charSet;
	}

	private void setCharSet(String charSet) {
		this.charSet = charSet;
	}

	public RegQuery() {
		Locale locale = Locale.getDefault();
		if (locale.getLanguage().equals("zh")) {
			setCharSet("GBK");
		} else {
			setCharSet("UTF-8");
		}
	}

	/**
	 * 查询注册表下的某项及其所有值的名称、类型和值
	 * 
	 * @param primaryKey 要查询的主键名
	 * @param name       查询的项名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String query(String primaryKey, String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /s";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream(), getCharSet());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 查询注册表下的某项的值的信息
	 * 
	 * @param primaryKey 要查询的主键名
	 * @param name       查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String query(String primaryKey, String name, String objectName) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /v " + "\"" + objectName + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream(), getCharSet());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 精确查询注册表的值，查询注册表某一项的值及其子项的值
	 * 
	 * @param primaryKey 要查询的注册表主键
	 * @param name       要查询的项名称
	 * @return Map&lt;String, Map&lt;String, String&gt;&gt;
	 *         查询的注册表项与值，Map对象的键是注册表项名，值也是一个Map对象，为该项下所有值的集合，这个Map对象中键是注册表该项之下的值的名称，值即为对应值
	 * @throws Exception 权限问题抛出异常
	 */
	public Map<String, Map<String, String>> queryValue(String primaryKey, String name) throws Exception {
		Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
		String queryValue = this.query(primaryKey, name);
		String[] regValue = queryValue.substring(2, queryValue.length() - 4).split("\r\n\r\n");
		for (String eachValue : regValue) {
			String key = eachValue.substring(0, eachValue.indexOf("\r\n"));
			String[] values = eachValue.substring(eachValue.indexOf("\r\n") + 2).split("\r\n");
			Map<String, String> kvs = new HashMap<String, String>();
			for (String valueOrigin : values) {
				valueOrigin = valueOrigin.substring(4);
				String keyName = valueOrigin.substring(0, valueOrigin.indexOf("    "));
				String value = valueOrigin.substring(valueOrigin.lastIndexOf("    ") + 4);
				kvs.put(keyName, value);
			}
			result.put(key, kvs);
		}
		return result;
	}

	/**
	 * 精确查询注册表的值，查询注册表某一项之下的值的值
	 * 
	 * @param primaryKey 要查询的注册表主键
	 * @param name       要查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询的结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryValue(String primaryKey, String name, String objectName) throws Exception {
		String queryValue = this.query(primaryKey, name, objectName);
		return queryValue.substring(queryValue.lastIndexOf("    ") + 4, queryValue.length() - 4);
	}

	/**
	 * 查询注册表下的某项的默认值的信息
	 * 
	 * @param primaryKey 要查询的主键名
	 * @param name       查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryDefault(String primaryKey, String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream(), getCharSet());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		while (cdr != null) {
			result = result + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		return result;
	}

	/**
	 * 精确查询注册表的值，查询注册表某一项默认值的值
	 * 
	 * @param primaryKey 要查询的主键名
	 * @param name       查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryDefaultValue(String primaryKey, String name) throws Exception {
		String result = this.queryDefault(primaryKey, name);
		return result.substring(result.lastIndexOf("    ") + 4, result.length() - 4);
	}

	/**
	 * 判断注册表下的某一项是否存在
	 * 
	 * @param primaryKey 要查询的主键名
	 * @param name       判断项的名称
	 * @return boolean 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isRegExists(String primaryKey, String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream(), getCharSet());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断注册表下的某一项的值是否存在
	 * 
	 * @param primaryKey 要查询的主键名
	 * @param name       判断项的名称
	 * @param objectName 判断的值的名称
	 * @return boolean 值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isRegExists(String primaryKey, String name, String objectName) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /v " + "\"" + objectName + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream(), getCharSet());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.equals("" + "\r\n" + "" + "\r\n" + "") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断注册表下的某一项的默认值是有内容（不为空）
	 * 
	 * @param primaryKey 要查询的主键名
	 * @param name       判断项的名称
	 * @return boolean 默认值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isRegDefaultExists(String primaryKey, String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream(), getCharSet());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.contains("数值未设置") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

}