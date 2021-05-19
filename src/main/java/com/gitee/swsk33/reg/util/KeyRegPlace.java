package com.gitee.swsk33.reg.util;

import com.gitee.swsk33.reg.RegAdd;
import com.gitee.swsk33.reg.exception.UninstallInfoDeficiencyException;
import com.gitee.swsk33.reg.param.RegDataType;
import com.gitee.swsk33.reg.param.RegPrimaryKey;
import com.gitee.swsk33.reg.param.UninstallInfo;

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
	 * @throws Exception 权限问题异常
	 */
	public static boolean addFileOrDirRightMenu(String name, String exec) throws Exception {
		String type = RegDataType.REG_SZ;
		if (exec.contains("%")) {
			type = RegDataType.REG_EXPAND_SZ;
		}
		boolean addOption = RegAdd.add(RegPrimaryKey.HKCR, "*\\shell\\" + name, name);
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
	 * @param iconPath 图标路径，可以是ico文件或者exe可执行文件，注意图标路径不需要用引号包围！（例如"D:\\a.ico"就是对的而不是"\"D:\\a.ico\""）
	 * @return 是否添加成功
	 * @throws Exception 权限问题异常
	 */
	public static boolean addFileOrDirRightMenu(String name, String exec, String iconPath) throws Exception {
		String valueType = RegDataType.REG_SZ;
		if (exec.contains("%")) {
			valueType = RegDataType.REG_EXPAND_SZ;
		}
		String iconPathType = RegDataType.REG_SZ;
		if (iconPath.contains("%")) {
			iconPathType = RegDataType.REG_EXPAND_SZ;
		}
		boolean addOption = RegAdd.add(RegPrimaryKey.HKCR, "*\\shell\\" + name, name);
		boolean addIcon = RegAdd.add(RegPrimaryKey.HKCR, "*\\shell\\" + name, iconPathType, "Icon", iconPath);
		boolean addCommand = RegAdd.add(RegPrimaryKey.HKCR, "*\\shell\\" + name + "\\command", valueType, exec);
		return addOption && addIcon && addCommand;
	}

	/**
	 * 添加文件夹背景/桌面右键菜单
	 * 
	 * @param name 右键菜单名
	 * @param exec 执行命令，最好用双引号包围
	 * @return 是否添加成功
	 * @throws Exception 权限问题抛出异常
	 */
	public static boolean addDirectoryBackgroundMenu(String name, String exec) throws Exception {
		String valueType = RegDataType.REG_SZ;
		if (exec.contains("%")) {
			valueType = RegDataType.REG_EXPAND_SZ;
		}
		boolean addOption = RegAdd.add(RegPrimaryKey.HKCR, "Directory\\Background\\shell\\" + name, name);
		boolean addCommand = RegAdd.add(RegPrimaryKey.HKCR, "Directory\\Background\\shell\\" + name + "\\command", valueType, exec);
		return addOption && addCommand;
	}

	/**
	 * 添加文件夹背景/桌面右键菜单，并指定菜单项图标
	 * 
	 * @param name     右键菜单名
	 * @param exec     执行命令，最好用双引号包围
	 * @param iconPath 图标路径，可以是icon文件也可以是可执行文件，注意图标的路径不需要用引号包围！（例如"D:\\a.ico"就是对的而不是"\"D:\\a.ico\""）
	 * @return 是否添加成功
	 * @throws Exception 权限问题抛出异常
	 */
	public static boolean addDirectoryBackgroundMenu(String name, String exec, String iconPath) throws Exception {
		String valueType = RegDataType.REG_SZ;
		if (exec.contains("%")) {
			valueType = RegDataType.REG_EXPAND_SZ;
		}
		String iconType = RegDataType.REG_SZ;
		if (iconPath.contains("%")) {
			iconType = RegDataType.REG_EXPAND_SZ;
		}
		boolean addOption = RegAdd.add(RegPrimaryKey.HKCR, "Directory\\Background\\shell\\" + name, name);
		boolean addIcon = RegAdd.add(RegPrimaryKey.HKCR, "Directory\\Background\\shell\\" + name, iconType, "Icon", iconPath);
		boolean addCommand = RegAdd.add(RegPrimaryKey.HKCR, "Directory\\Background\\shell\\" + name + "\\command", valueType, exec);
		return addOption && addIcon && addCommand;
	}

	/**
	 * 添加软件卸载信息（设置-应用中的卸载列表）
	 * 
	 * @param name            软件名
	 * @param installPath     软件安装位置
	 * @param uninstallString 软件卸载命令
	 * @return 是否添加成功
	 * @throws Exception 权限问题异常
	 */
	public static boolean addUninstallInfo(String name, String installPath, String uninstallString) throws Exception {
		String installPathType = RegDataType.REG_SZ;
		String uninstallType = RegDataType.REG_SZ;
		if (installPath.contains("%")) {
			installPathType = RegDataType.REG_EXPAND_SZ;
		}
		if (uninstallString.contains("%")) {
			uninstallType = RegDataType.REG_EXPAND_SZ;
		}
		String optionName = "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\" + name;
		boolean addOption = RegAdd.add(RegPrimaryKey.HKLM, optionName);
		boolean addName = RegAdd.add(RegPrimaryKey.HKLM, optionName, RegDataType.REG_SZ, "DisplayName", name);
		boolean addinstallPath = RegAdd.add(RegPrimaryKey.HKLM, optionName, installPathType, "InstallLocation", installPath);
		boolean adduninstallPath = RegAdd.add(RegPrimaryKey.HKLM, optionName, uninstallType, "UninstallString", uninstallString);
		return addOption && addName && addinstallPath && adduninstallPath;
	}

	/**
	 * 添加软件卸载信息（设置-应用中的卸载列表）
	 * 
	 * @param name            软件名
	 * @param installPath     软件安装位置
	 * @param uninstallString 软件卸载命令
	 * @param iconPath        软件图标
	 * @param version         软件版本
	 * @param size            软件大小（单位是kb）
	 * @return 是否添加成功
	 * @throws Exception 权限问题异常
	 */
	public static boolean addUninstallInfo(String name, String installPath, String uninstallString, String iconPath, String version, long size) throws Exception {
		String installPathType = RegDataType.REG_SZ;
		String uninstallType = RegDataType.REG_SZ;
		String iconType = RegDataType.REG_SZ;
		if (installPath.contains("%")) {
			installPathType = RegDataType.REG_EXPAND_SZ;
		}
		if (uninstallString.contains("%")) {
			uninstallType = RegDataType.REG_EXPAND_SZ;
		}
		if (iconPath.contains("%")) {
			iconType = RegDataType.REG_EXPAND_SZ;
		}
		String optionName = "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\" + name;
		boolean addOption = RegAdd.add(RegPrimaryKey.HKLM, optionName);
		boolean addName = RegAdd.add(RegPrimaryKey.HKLM, optionName, RegDataType.REG_SZ, "DisplayName", name);
		boolean addinstallPath = RegAdd.add(RegPrimaryKey.HKLM, optionName, installPathType, "InstallLocation", installPath);
		boolean adduninstallPath = RegAdd.add(RegPrimaryKey.HKLM, optionName, uninstallType, "UninstallString", uninstallString);
		boolean addIcon = RegAdd.add(RegPrimaryKey.HKLM, optionName, iconType, "DisplayIcon", iconPath);
		boolean addVersion = RegAdd.add(RegPrimaryKey.HKLM, optionName, RegDataType.REG_SZ, "DisplayVersion", version);
		boolean addSize = RegAdd.add(RegPrimaryKey.HKLM, optionName, RegDataType.REG_DWORD, "EstimatedSize", String.valueOf(size));
		return addOption && addName && addinstallPath && adduninstallPath && addIcon && addVersion && addSize;
	}

	/**
	 * 添加软件卸载信息（设置-应用中的卸载列表）
	 * 
	 * @param info 是UninstallInfo的实例，该类位于com.gitee.swsk33.reg.param之下，通过实例化该类并设定实例的属性（例如软件名，卸载命令等等）然后传入，其中软件显示名称和卸载命令是不能为空的项
	 * @return 是否添加成功
	 * @throws Exception 权限问题异常
	 */
	public static boolean addUninstallInfo(UninstallInfo info) throws Exception {
		if (info.getDisplayName() == null || info.getUninstallString() == null) {
			throw new UninstallInfoDeficiencyException();
		}
		String installPathType = RegDataType.REG_SZ;
		String uninstallType = RegDataType.REG_SZ;
		String iconType = RegDataType.REG_SZ;
		String modifyType = RegDataType.REG_SZ;
		if (info.getInstallPath().contains("%")) {
			installPathType = RegDataType.REG_EXPAND_SZ;
		}
		if (info.getUninstallString().contains("%")) {
			uninstallType = RegDataType.REG_EXPAND_SZ;
		}
		if (info.getDisplayIcon().contains("%")) {
			iconType = RegDataType.REG_EXPAND_SZ;
		}
		if (info.getModifyPath().contains("%")) {
			modifyType = RegDataType.REG_EXPAND_SZ;
		}
		String optionName = "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\" + info.getDisplayName();
		if (!RegAdd.add(RegPrimaryKey.HKLM, optionName)) {
			return false;
		}
		if (!RegAdd.add(RegPrimaryKey.HKLM, optionName, RegDataType.REG_SZ, "DisplayName", info.getDisplayName())) {
			return false;
		}
		if (!RegAdd.add(RegPrimaryKey.HKLM, optionName, uninstallType, "UninstallString", info.getUninstallString())) {
			return false;
		}
		if (info.getDisplayIcon() != null) {
			if (!RegAdd.add(RegPrimaryKey.HKLM, optionName, iconType, "DisplayIcon", info.getDisplayIcon())) {
				return false;
			}
		}
		if (info.getDisplayVersion() != null) {
			if (!RegAdd.add(RegPrimaryKey.HKLM, optionName, RegDataType.REG_SZ, "DisplayVersion", info.getDisplayVersion())) {
				return false;
			}
		}
		if (info.getPublisher() != null) {
			if (!RegAdd.add(RegPrimaryKey.HKLM, optionName, RegDataType.REG_SZ, "Publisher", info.getPublisher())) {
				return false;
			}
		}
		if (info.getEstimatedSize() != null) {
			if (!RegAdd.add(RegPrimaryKey.HKLM, optionName, RegDataType.REG_DWORD, "EstimatedSize", String.valueOf(info.getEstimatedSize()))) {
				return false;
			}
		}
		if (info.getInstallPath() != null) {
			if (!RegAdd.add(RegPrimaryKey.HKLM, optionName, installPathType, "InstallLocation", info.getInstallPath())) {
				return false;
			}
		}
		if (info.getModifyPath() != null) {
			if (!RegAdd.add(RegPrimaryKey.HKLM, optionName, modifyType, "ModifyPath", info.getModifyPath())) {
				return false;
			}
		}
		int noModify = 1;
		int noRepair = 1;
		if (!info.isNoModify()) {
			noModify = 0;
		}
		if (!info.isNoRepair()) {
			noRepair = 0;
		}
		if (!RegAdd.add(RegPrimaryKey.HKLM, optionName, RegDataType.REG_DWORD, "NoModify", String.valueOf(noModify)) || !RegAdd.add(RegPrimaryKey.HKLM, optionName, RegDataType.REG_DWORD, "NoRepair", String.valueOf(noRepair))) {
			return false;
		}
		return true;
	}

}