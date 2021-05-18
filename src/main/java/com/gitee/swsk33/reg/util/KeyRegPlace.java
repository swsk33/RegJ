package com.gitee.swsk33.reg.util;

import com.gitee.swsk33.reg.RegAdd;
import com.gitee.swsk33.reg.param.RegDataType;
import com.gitee.swsk33.reg.param.RegPrimaryKey;

/**
 * 常规关键位置的注册表操作
 * 
 * @author swsk33
 *
 */
public class KeyRegPlace {

	/**
	 * 添加开机启动项
	 * 
	 * @param name 启动项名称
	 * @param exec 启动项可执行路径（建议用双引号包围，即为：\\\"路径\\\"）
	 * @return 是否添加成功
	 * @throws Exception 权限问题可能导致异常
	 */
	public static boolean addBootOption(String name, String exec) throws Exception {
		String type = RegDataType.REG_SZ;
		if (exec.contains("%")) {
			type = RegDataType.REG_EXPAND_SZ;
		}
		return RegAdd.add(RegPrimaryKey.HKLM, "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", type, name, exec);
	}

}