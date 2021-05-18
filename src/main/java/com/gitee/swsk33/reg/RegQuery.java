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

	static {
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
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       查询的项名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public static String query(String primaryKey, String name) throws Exception {
		String result = "";
		String command = "cmd /c reg query \"" + primaryKey + InternalUtils.stringProcessing(name) + "\"" + " /s";
		Process run = Runtime.getRuntime().exec(command);
		InputStreamReader inputStream = new InputStreamReader(run.getInputStream(), charSet);
		BufferedReader reader = new BufferedReader(inputStream);
		String eachLine = "";
		while ((eachLine = reader.readLine()) != null) {
			result = result + eachLine + "\r\n";
		}
		inputStream.close();
		reader.close();
		return result.trim();
	}

	/**
	 * 查询注册表下的某项的值的信息
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public static String query(String primaryKey, String name, String objectName) throws Exception {
		String result = "";
		String command = "cmd /c reg query \"" + primaryKey + InternalUtils.stringProcessing(name) + "\"" + " /v " + "\"" + InternalUtils.stringProcessing(objectName) + "\"";
		Process run = Runtime.getRuntime().exec(command);
		InputStreamReader inputStream = new InputStreamReader(run.getInputStream(), charSet);
		BufferedReader reader = new BufferedReader(inputStream);
		String eachLine = "";
		while ((eachLine = reader.readLine()) != null) {
			result = result + eachLine + "\r\n";
		}
		inputStream.close();
		reader.close();
		return result.trim();
	}

	/**
	 * 精确查询注册表的值，查询注册表某一项的值及其子项的值
	 * 
	 * @param primaryKey 要查询的注册表主键，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       要查询的项名称
	 * @return Map&lt;String, Map&lt;String, String&gt;&gt;
	 *         查询的注册表项与值，Map对象的键是注册表项名，值也是一个Map对象，为该项下所有值的集合，这个Map对象中键是注册表该项之下的值的名称，值即为对应值
	 * @throws Exception 权限问题抛出异常
	 */
	public static Map<String, Map<String, String>> queryValue(String primaryKey, String name) throws Exception {
		Map<String, Map<String, String>> result = new HashMap<String, Map<String, String>>();
		if (isRegExists(primaryKey, name)) {
			String queryValue = query(primaryKey, name);
			String[] regValue = queryValue.split("\r\n\r\n");
			for (String eachValue : regValue) {
				String key = "";
				Map<String, String> kvs = null;
				if (eachValue.contains("\r\n")) {
					key = eachValue.substring(0, eachValue.indexOf("\r\n"));
					String[] values = eachValue.substring(eachValue.indexOf("\r\n") + 2).split("\r\n");
					kvs = new HashMap<String, String>();
					for (String valueOrigin : values) {
						valueOrigin = valueOrigin.trim();
						String[] eachValueInfo = valueOrigin.split("    ");
						String keyName = "";
						String value = "";
						keyName = eachValueInfo[0];
						if (eachValueInfo.length == 3) {
							value = eachValueInfo[2];
						} else {
							value = "";
						}
						kvs.put(keyName, value);
					}
				} else {
					key = eachValue;
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
	 * @param primaryKey 要查询的注册表主键，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       要查询的项名称
	 * @param objectName 待查询的值的名字
	 * @return String 查询的结果
	 * @throws Exception 权限问题抛出异常
	 */
	public static String queryValue(String primaryKey, String name, String objectName) throws Exception {
		String result = "";
		if (!isRegValueBlank(primaryKey, name, objectName)) {
			String queryValue = query(primaryKey, name, objectName);
			result = queryValue.substring(queryValue.lastIndexOf("    ") + 4, queryValue.length());
		}
		return result;
	}

	/**
	 * 查询注册表下的某项的默认值的信息
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public static String queryDefault(String primaryKey, String name) throws Exception {
		String result = "";
		String command = "cmd /c reg query \"" + primaryKey + InternalUtils.stringProcessing(name) + "\"" + " /ve";
		Process run = Runtime.getRuntime().exec(command);
		InputStreamReader inputStream = new InputStreamReader(run.getInputStream(), charSet);
		BufferedReader reader = new BufferedReader(inputStream);
		String eachLine = "";
		while ((eachLine = reader.readLine()) != null) {
			result = result + eachLine + "\r\n";
		}
		inputStream.close();
		reader.close();
		return result.trim();
	}

	/**
	 * 精确查询注册表的值，查询注册表某一项默认值的值
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       查询项的名称
	 * @return String 查询结果
	 * @throws Exception 权限问题抛出异常
	 */
	public static String queryDefaultValue(String primaryKey, String name) throws Exception {
		String result = "";
		if (isRegExists(primaryKey, name)) {
			String queryValue = queryDefault(primaryKey, name);
			result = queryValue.substring(queryValue.lastIndexOf("    ") + 4, queryValue.length());
		}
		return result;
	}

	/**
	 * 检测注册表某一项下的指定的值是否为空白（值存在而无内容）
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       项的名称
	 * @param objectName 值的名称
	 * @return 当值的值为空白或者值不存在时为true
	 * @throws Exception 权限问题异常
	 */
	public static boolean isRegValueBlank(String primaryKey, String name, String objectName) throws Exception {
		boolean result = false;
		if (isRegExists(primaryKey, name, objectName)) {
			String queryResult = query(primaryKey, name, objectName);
			queryResult = queryResult.substring(queryResult.indexOf("\r\n") + 2, queryResult.length()).trim();
			if (queryResult.split("    ").length == 2) {
				result = true;
			}
		} else {
			result = true;
		}
		return result;
	}

	/**
	 * 判断注册表下的某一项是否存在
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       判断项的名称
	 * @return boolean 项是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public static boolean isRegExists(String primaryKey, String name) throws Exception {
		return !query(primaryKey, name).equals("");
	}

	/**
	 * 判断注册表下的某一项的值是否存在
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       判断项的名称
	 * @param objectName 判断的值的名称
	 * @return boolean 值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public static boolean isRegExists(String primaryKey, String name, String objectName) throws Exception {
		return !query(primaryKey, name, objectName).equals("");
	}

	/**
	 * 判断注册表下的某一项的默认值是有内容（不为空）
	 * 
	 * @param primaryKey 要查询的主键名，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       判断项的名称
	 * @return boolean 默认值是否存在
	 * @throws Exception 权限问题抛出异常
	 */
	public static boolean isRegDefaultExists(String primaryKey, String name) throws Exception {
		return !queryDefault(primaryKey, name).equals("") && !queryDefault(primaryKey, name).contains("数值未设置");
	}

}