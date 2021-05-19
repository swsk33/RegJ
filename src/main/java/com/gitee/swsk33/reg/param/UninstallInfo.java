package com.gitee.swsk33.reg.param;

/**
 * 应用程序卸载信息
 * 
 * @author swsk33
 *
 */
public class UninstallInfo {

	/**
	 * 显示名称
	 */
	private String displayName;

	/**
	 * 显示图标
	 */
	private String displayIcon;

	/**
	 * 显示版本
	 */
	private String displayVersion;

	/**
	 * 发布者
	 */
	private String publisher;

	/**
	 * 软件大小（单位kb）
	 */
	private long EstimatedSize;

	/**
	 * 软件安装位置
	 */
	private String installPath;

	/**
	 * 卸载命令
	 */
	private String uninstallString;

	/**
	 * 修改命令
	 */
	private String modifyPath;

	/**
	 * 是否禁用修改
	 */
	private boolean noModify = true;

	/**
	 * 是否禁用修复
	 */
	private boolean noRepair = true;

	public String getDisplayName() {
		return displayName;
	}

	/**
	 * 设定显示名称
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayIcon() {
		return displayIcon;
	}

	/**
	 * 设定显示图标
	 */
	public void setDisplayIcon(String displayIcon) {
		this.displayIcon = displayIcon;
	}

	public String getDisplayVersion() {
		return displayVersion;
	}

	/**
	 * 设定软件版本
	 */
	public void setDisplayVersion(String displayVersion) {
		this.displayVersion = displayVersion;
	}

	public String getPublisher() {
		return publisher;
	}

	/**
	 * 设定发布者
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public long getEstimatedSize() {
		return EstimatedSize;
	}

	/**
	 * 设定软件大小（单位kb）
	 */
	public void setEstimatedSize(long estimatedSize) {
		EstimatedSize = estimatedSize;
	}

	public String getInstallPath() {
		return installPath;
	}

	/**
	 * 设定软件安装位置
	 */
	public void setInstallPath(String installPath) {
		this.installPath = installPath;
	}

	public String getUninstallString() {
		return uninstallString;
	}

	/**
	 * 设定卸载命令
	 */
	public void setUninstallString(String uninstallString) {
		this.uninstallString = uninstallString;
	}

	public String getModifyPath() {
		return modifyPath;
	}

	/**
	 * 设定修改命令
	 */
	public void setModifyPath(String modifyPath) {
		this.modifyPath = modifyPath;
	}

	public boolean isNoModify() {
		return noModify;
	}

	/**
	 * 设定是否禁用修改（默认是）
	 */
	public void setNoModify(boolean noModify) {
		this.noModify = noModify;
	}

	public boolean isNoRepair() {
		return noRepair;
	}

	/**
	 * 设定是否禁用修复（默认是）
	 */
	public void setNoRepair(boolean noRepair) {
		this.noRepair = noRepair;
	}

}