package swsk33.reg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询注册表
 * 
 * @author swsk33
 *
 */
public class RegQuery {

	/**
	 * 查询注册表下的某项及其所有值的名称、类型和值
	 * 
	 * @param primaryKey 要操作的主键名
	 * @param name       查询的项名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String query(String primaryKey, String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /s";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
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
	 * @param primaryKey 要操作的主键名
	 * @param name       查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String query(String primaryKey, String name, String objectName) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /v " + "\"" + objectName + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
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
	 * @return Map&lt;String, String&gt; 查询的注册表项与值，Map对象的键是注册表项名，值就是这一项对应的值
	 * @throws Exception 权限问题抛出异常
	 */
	public Map<String, String> queryValue(String primaryKey, String name) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		String[] regValue = this.query(primaryKey, name).substring(2).split("\r\n\r\n");
		for (String eachValue : regValue) {
			String key = eachValue.substring(0, eachValue.indexOf("\r\n"));
			String value = eachValue.substring(eachValue.lastIndexOf("    "));
			result.put(key, value);
		}
		return result;
	}

	/**
	 * 查询注册表下的某项的默认值的信息
	 * 
	 * @param primaryKey 要操作的主键名
	 * @param name       查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public String queryDefaultValue(String primaryKey, String name) throws Exception {
		String result = "";
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
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
	 * 判断注册表下的某一项是否存在
	 * 
	 * @param primaryKey 要操作的主键名
	 * @param name       判断项的名称
	 * @return boolean 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isRegExists(String primaryKey, String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
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
	 * @param primaryKey 要操作的主键名
	 * @param name       判断项的名称
	 * @param objectName 判断的值的名称
	 * @return boolean 值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isRegExists(String primaryKey, String name, String objectName) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /v " + "\"" + objectName + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
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
	 * @param primaryKey 要操作的主键名
	 * @param name       判断项的名称
	 * @return boolean 默认值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public boolean isRegDefaultExists(String primaryKey, String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String cdr = br.readLine();
		String res = "";
		while (cdr != null) {
			res = res + cdr + "\r\n";
			cdr = br.readLine();
		}
		br.close();
		if (res.contains("数值未设置") || res.contains("��ֵδ����") || res.equals("")) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

}