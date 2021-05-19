package com.gitee.swsk33.reg;

/**
 * 内部实用类
 * 
 * @author swsk33
 *
 */
class InternalUtils {

	/**
	 * 处理注册表值字符串的方法，将特殊字符转义储存。 一般调用cmd是变量引用会被展开（例如%Path%），而直接使用Process调用命令就不会。
	 * 
	 * @param origin 传入字符串
	 * @return 字符串
	 */
	public static String stringProcessing(String origin) {
		StringBuilder result = new StringBuilder("");
		for (char eachChar : origin.toCharArray()) {
			if (eachChar == '\"') {
				result.append("\\\"");
			} else if (eachChar == '\'') {
				result.append("\\\'");
			} else {
				result.append(eachChar);
			}
		}
		return result.toString();
	}

}