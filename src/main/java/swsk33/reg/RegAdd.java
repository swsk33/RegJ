package swsk33.reg;

import swsk33.reg.exception.TypeErrorException;

/**
 * 添加注册表项
 * 
 * @author swsk33
 *
 */
public class RegAdd {

	private RegQuery query = new RegQuery();

	/**
	 * 处理注册表值字符串的方法。
	 * 一般注册表值的双百分号（例如%Path%）会被识别成变量并直接代值，而我们想单纯地插入%Path%，用^%可以插入百分号。但如果用双引号括起来，^号也会被一起插入。因此这个方法用于把%变成"^%"，那么字符串值"C:\\Program
	 * Files;%Path%"会变成"C:\\Program Files;"^%"Path"^%""，即可把变量原封不动地插入。
	 * 
	 * @param origin 传入字符串
	 * @return 字符串
	 */
	private String stringProcessing(String origin) {
		origin = origin.replace("%", "\"^%\"");
		return origin;
	}

	/**
	 * 在注册表里面添加空项
	 * 
	 * @param primaryKey 要操作的注册表主键
	 * @param name       项名称
	 * @return 布尔值 添加成功返回true
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public boolean add(String primaryKey, String name) throws Exception {
		boolean success = false;
		String cmd = "cmd /c reg add \"" + primaryKey + name + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(this.stringProcessing(cmd));
		run.waitFor();
		if (query.isRegExists(primaryKey, name)) {
			success = true;
		}
		return success;
	}

	/**
	 * 在注册表里面添加项并指定其默认项的值，字符串值类型
	 * 
	 * @param primaryKey 要操作的注册表主键
	 * @param name       项名称
	 * @param data       指定默认项的值
	 * @return 布尔值 添加成功返回true
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public boolean add(String primaryKey, String name, String data) throws Exception {
		boolean success = false;
		String cmd = "cmd /c reg add \"" + primaryKey + name + "\"" + " /d " + "\"" + data + "\"" + " /f";
		Process run = Runtime.getRuntime().exec(this.stringProcessing(cmd));
		run.waitFor();
		if (query.queryDefault(primaryKey, name).contains(data)) {
			success = true;
		}
		return success;
	}

	/**
	 * 在注册表里面添加项并指定其默认值的类型和值
	 * 
	 * @param primaryKey 要操作的注册表主键
	 * @param name       项名称
	 * @param type       默认值的类型
	 * @param data       默认值的值
	 * @return 布尔值 添加成功返回true
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public boolean add(String primaryKey, String name, String type, String data) throws Exception {
		boolean success = false;
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"" + primaryKey + name + "\"" + " /t " + "\"" + type + "\"" + " /d " + "\""
					+ data + "\"" + " /f";
			Process run = Runtime.getRuntime().exec(this.stringProcessing(cmd));
			run.waitFor();
			if (query.queryDefault(primaryKey, name).contains(data)
					&& query.queryDefault(primaryKey, name).contains(type)) {
				success = true;
			}
		} else {
			throw new TypeErrorException();
		}
		return success;
	}

	/**
	 * 在注册表里面添加项并指定项中值的类型、名称和值（若该项已存在，则会在该项中添加值）
	 * 
	 * @param primaryKey 要操作的注册表主键
	 * @param name       项名称
	 * @param type       值的类型
	 * @param objectName 值的名称
	 * @param data       值的值
	 * @return 布尔值 添加成功返回true
	 * @throws Exception 没有管理员权限时抛出异常
	 */
	public boolean add(String primaryKey, String name, String type, String objectName, String data) throws Exception {
		boolean success = false;
		if (type.equalsIgnoreCase("REG_SZ") || type.equalsIgnoreCase("REG_MULTI_SZ")
				|| type.equalsIgnoreCase("REG_EXPAND_SZ") || type.equalsIgnoreCase("REG_DWORD")
				|| type.equalsIgnoreCase("REG_QWORD") || type.equalsIgnoreCase("REG_BINARY")
				|| type.equalsIgnoreCase("REG_NONE")) {
			String cmd = "cmd /c reg add \"" + primaryKey + name + "\"" + " /t " + "\"" + type + "\"" + " /v " + "\""
					+ objectName + "\"" + " /d " + "\"" + data + "\"" + " /f";
			Process run = Runtime.getRuntime().exec(this.stringProcessing(cmd));
			run.waitFor();
			if (query.query(primaryKey, name, objectName).contains(data)
					&& query.query(primaryKey, name, objectName).contains(type)) {
				success = true;
			}
		} else {
			throw new TypeErrorException();
		}
		return success;
	}

}