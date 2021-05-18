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
	 * @param exec 启动项可执行路径或者路径+参数（建议用双引号包围，即为：\"路径\" 或者是：\"路径\" \"参数\"）
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

	/**
	 * 添加文件或者文件夹右键菜单
	 * 
	 * @param name 右键菜单显示名
	 * @param exec 执行命令（一般是"可执行文件路径" "参数"的格式，此处在编程时可以写作：\"可执行文件路径\"
	 *             \"参数\"，其中参数中右键被选中的文件表示为"%l"<br>
	 *             例如，用cmd打开右键选择的文件（夹），那么exec值为：\"C:\\Windows\\System32\\cmd.exe\"
	 *             "%l"
	 * @return 是否添加成功
	 * @exception 权限问题异常
	 */
	public static boolean addFileOrDirRightMenu(String name, String exec) throws Exception {
		String type = RegDataType.REG_SZ;
		if (exec.contains("%")) {
			type = RegDataType.REG_EXPAND_SZ;
		}
		boolean addOption = RegAdd.add(RegPrimaryKey.HKCR, "*\\shell\\" + name, RegDataType.REG_SZ, name);
		boolean addCommand = RegAdd.add(RegPrimaryKey.HKCR, "*\\shell\\" + name + "\\command", type, exec);
		return addOption && addCommand;
	}

	/**
	 * 添加文件或者文件夹右键菜单，并指定文件右键菜单项图标
	 * 
	 * @param name     右键菜单显示名
	 * @param exec     执行命令（一般是"可执行文件路径" "参数"的格式，此处在编程时可以写作：\"可执行文件路径\"
	 *                 \"参数\"，其中参数中右键被选中的文件表示为"%l"<br>
	 *                 例如，用cmd打开右键选择的文件（夹），那么exec值为：\"C:\\Windows\\System32\\cmd.exe\"
	 *                 "%l"
	 * @param iconPath 图标路径，可以是ico文件或者exe可执行文件，注意路径不需要用引号包围！（例如"D:\\a.ico"就是对的而不是"\"D:\\a.ico\""）
	 * @return 是否添加成功
	 * @exception 权限问题异常
	 */
	public static boolean addFileOrDirRightMenu(String name, String exec, String iconPath) throws Exception {
		String type = RegDataType.REG_SZ;
		if (exec.contains("%")) {
			type = RegDataType.REG_EXPAND_SZ;
		}
		boolean addOption = RegAdd.add(RegPrimaryKey.HKCR, "*\\shell\\" + name, RegDataType.REG_SZ, name);
		boolean addIcon = RegAdd.add(RegPrimaryKey.HKCR, "*\\shell\\", type, "Icon", iconPath);
		boolean addCommand = RegAdd.add(RegPrimaryKey.HKCR, "*\\shell\\" + name + "\\command", type, exec);
		return addOption && addIcon && addCommand;
	}

}