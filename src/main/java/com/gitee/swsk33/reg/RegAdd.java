package com.gitee.swsk33.reg;

import com.gitee.swsk33.reg.exception.TypeErrorException;

/**
 * 添加注册表项
 *
 * @author swsk33
 *
 */
public class RegAdd {

	/**
	 * 在注册表里面添加空项
	 * 
	 * @param primaryKey 要操作的注册表主键，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       项名称
	 * @return 布尔值 添加成功返回true
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public static boolean add(String primaryKey, String name) throws Exception {
		boolean success = false;
		String cmd = "reg add \"" + primaryKey + InternalUtils.stringProcessing(name) + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
		run.waitFor();
		if (RegQuery.isRegExists(primaryKey, name)) {
			success = true;
		}
		return success;
	}

	/**
	 * 在注册表里面添加项并指定其默认项的值，字符串值类型
	 * 
	 * @param primaryKey 要操作的注册表主键，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       项名称
	 * @param data       指定默认项的值
	 * @return 布尔值 添加成功返回true
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public static boolean add(String primaryKey, String name, String data) throws Exception {
		boolean success = false;
		String cmd = "reg add \"" + primaryKey + InternalUtils.stringProcessing(name) + "\"" + " /d " + "\"" + InternalUtils.stringProcessing(data) + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(cmd);
		run.waitFor();
		if (RegQuery.queryDefault(primaryKey, name).contains(data)) {
			success = true;
		}
		return success;
	}

	/**
	 * 在注册表里面添加项并指定其默认值的类型和值
	 * 
	 * @param primaryKey 要操作的注册表主键，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       项名称
	 * @param type       默认值的类型，值位于com.gitee.swsk33.reg.param.RegDataType类中（例如RegDataType.REG_SZ即为REG_SZ字符串数据）
	 * @param data       默认值的值
	 * @return 布尔值 添加成功返回true
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public static boolean add(String primaryKey, String name, String type, String data) throws Exception {
		boolean success = false;
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ") || type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD") || type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY") || type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "reg add \"" + primaryKey + InternalUtils.stringProcessing(name) + "\"" + " /t " + "\"" + type + "\"" + " /d " + "\"" + InternalUtils.stringProcessing(data) + "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
			run.waitFor();
			if (RegQuery.queryDefault(primaryKey, name).contains(data) && RegQuery.queryDefault(primaryKey, name).contains(type)) {
				success = true;
			}
		} else {
			throw new TypeErrorException();
		}
		return success;
	}

	/**
	 * 在注册表里面添加项，并在项中添加键值，指定其中值的类型、名称和值（若该项已存在，则会在该项中添加值）
	 * 
	 * @param primaryKey 要操作的注册表主键，值位于com.gitee.swsk33.reg.param.RegPrimaryKey类中（例如RegPrimaryKey.HKCR即为HKEY_CLASSES_ROOT）
	 * @param name       项名称
	 * @param type       值的类型，值位于com.gitee.swsk33.reg.param.RegDataType类中（例如RegDataType.REG_SZ即为REG_SZ字符串数据）
	 * @param objectName 值的名称
	 * @param data       值的值
	 * @return 布尔值 添加成功返回true
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public static boolean add(String primaryKey, String name, String type, String objectName, String data) throws Exception {
		boolean success = false;
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ") || type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD") || type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY") || type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "reg add \"" + primaryKey + InternalUtils.stringProcessing(name) + "\"" + " /t " + "\"" + type + "\"" + " /v " + "\"" + InternalUtils.stringProcessing(objectName) + "\"" + " /d " + "\"" + InternalUtils.stringProcessing(data) + "\"" + " /f";
			Process run = Runtime.getRuntime().exec(cmd);
			run.waitFor();
			if (RegQuery.query(primaryKey, name, objectName).contains(data) && RegQuery.query(primaryKey, name, objectName).contains(type)) {
				success = true;
			}
		} else {
			throw new TypeErrorException();
		}
		return success;
	}

}