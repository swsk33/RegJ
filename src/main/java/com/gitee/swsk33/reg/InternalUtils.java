package com.gitee.swsk33.reg;

/**
 * 内部实用类
 * 
 * @author swsk33
 *
 */
class InternalUtils {

	/**
	 * 处理注册表值字符串的方法。
	 * 一般注册表值的双百分号（例如%Path%）会被识别成变量并直接代值，而我们想单纯地插入%Path%，用^%可以插入百分号。但如果用双引号括起来，^号也会被一起插入。因此这个方法用于把%变成"^%"，那么字符串值"C:\\Program
	 * Files;%Path%"会变成"C:\\Program Files;"^%"Path"^%""，即可把变量原封不动地插入。
	 * 于此同时，还将把命令中的特殊字符变成字符串形式储存的转义字符。例如"会转换成\"等等。
	 * 
	 * @param origin 传入字符串
	 * @return 字符串
	 */
	public static String stringProcessing(String origin) {
		StringBuilder result = new StringBuilder("");
		for (char eachChar : origin.toCharArray()) {
			if (eachChar == '%') {
				result.append("\"^%\"");
			} else if (eachChar == '\"') {
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