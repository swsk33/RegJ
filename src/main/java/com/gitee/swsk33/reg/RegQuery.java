package com.gitee.swsk33.reg;

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

	private static String charSet = "UTF-8";

	public RegQuery() {
		Locale locale = Locale.getDefault();
		if (locale.getLanguage().equals("zh")) {
			charSet = "GBK";
		} else {
			charSet = "UTF-8";
		}
	}

	/**
	 * 查询注册表下的某项及其所有值的名称、类型和值
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.utils.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       查询的项名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public static String query(String primaryKey, String name) throws Exception {
		String result = "";
		if (isRegExists(primaryKey, name)) {
			String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /s";
			Process run = Runtime.getRuntime().exec(cmd);
			InputStreamReader isr = new InputStreamReader(run.getInputStream(), charSet);
			BufferedReader br = new BufferedReader(isr);
			String cdr = br.readLine();
			while (cdr != null) {
				result = result + cdr + "\r\n";
				cdr = br.readLine();
			}
			br.close();
		}
		return result;
	}

	/**
	 * 查询注册表下的某项的值的信息
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.utils.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public static String query(String primaryKey, String name, String objectName) throws Exception {
		String result = "";
		if (isRegExists(primaryKey, name, objectName)) {
			String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /v " + "\"" + objectName + "\"";
			Process run = Runtime.getRuntime().exec(cmd);
			InputStreamReader isr = new InputStreamReader(run.getInputStream(), charSet);
			BufferedReader br = new BufferedReader(isr);
			String cdr = br.readLine();
			while (cdr != null) {
				result = result + cdr + "\r\n";
				cdr = br.readLine();
			}
			br.close();
		}
		return result;
	}

	/**
	 * 精确查询注册表的值，查询注册表某一项的值及其子项的值
	 * 
	 * @param primaryKey 要查询的注册表主键，值位于com.gitee.swsk33.reg.utils.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       要查询的项名称
	 * @return Map&lt;String, Map&lt;String, String&gt;&gt;
	 *         查询的注册表项与值，Map对象的键是注册表项名，值也是一个Map对象，为该项下所有值的集合，这个Map对象中键是注册表该项之下的值的名称，值即为对应值
	 * @throws Exception 权限问题抛出异常
	 */
	public static Map<String, Map<String, String>> queryValue(String primaryKey, String name) throws Exception {
		Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
		if (isRegExists(primaryKey, name)) {
			String queryValue = query(primaryKey, name);
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
		} else {
			result = null;
		}
		return result;
	}

	/**
	 * 精确查询注册表的值，查询注册表某一项之下的值的值
	 * 
	 * @param primaryKey 要查询的注册表主键，值位于com.gitee.swsk33.reg.utils.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       要查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询的结果
	 * @throws Exception 权限问题抛出异常
	 */
	public static String queryValue(String primaryKey, String name, String objectName) throws Exception {
		String result = "";
		if (isRegExists(primaryKey, name, objectName)) {
			String queryValue = query(primaryKey, name, objectName);
			result = queryValue.substring(queryValue.lastIndexOf("    ") + 4, queryValue.length() - 4);
		}
		return result;
	}

	/**
	 * 查询注册表下的某项的默认值的信息
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.utils.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public static String queryDefault(String primaryKey, String name) throws Exception {
		String result = "";
		if (isRegExists(primaryKey, name)) {
			String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /ve";
			Process run = Runtime.getRuntime().exec(cmd);
			InputStreamReader isr = new InputStreamReader(run.getInputStream(), charSet);
			BufferedReader br = new BufferedReader(isr);
			String cdr = br.readLine();
			while (cdr != null) {
				result = result + cdr + "\r\n";
				cdr = br.readLine();
			}
			br.close();
		}
		return result;
	}

	/**
	 * 精确查询注册表的值，查询注册表某一项默认值的值
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.utils.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public static String queryDefaultValue(String primaryKey, String name) throws Exception {
		String result = "";
		if (isRegExists(primaryKey, name)) {
			String queryValue = queryDefault(primaryKey, name);
			result = queryValue.substring(queryValue.lastIndexOf("    ") + 4, queryValue.length() - 4);
		}
		return result;
	}

	/**
	 * 判断注册表下的某一项是否存在
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.utils.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       判断项的名称
	 * @return boolean 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public static boolean isRegExists(String primaryKey, String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream(), charSet);
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
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.utils.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       判断项的名称
	 * @param objectName 判断的值的名称
	 * @return boolean 值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public static boolean isRegExists(String primaryKey, String name, String objectName) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /v " + "\"" + objectName + "\"";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream(), charSet);
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
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.utils.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       判断项的名称
	 * @return boolean 默认值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public static boolean isRegDefaultExists(String primaryKey, String name) throws Exception {
		boolean result = false;
		String cmd = "cmd /c reg query \"" + primaryKey + name + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(cmd);
		InputStreamReader isr = new InputStreamReader(run.getInputStream(), charSet);
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