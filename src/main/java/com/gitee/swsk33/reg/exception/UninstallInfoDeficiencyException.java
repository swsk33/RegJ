package com.gitee.swsk33.reg.exception;

/**
 * 卸载信息缺失异常
 * 
 * @author swsk33
 *
 */
public class UninstallInfoDeficiencyException extends Exception {

	private static final long serialVersionUID = 2004224982419499479L;

	public UninstallInfoDeficiencyException() {
		super("卸载信息中的显示名称和卸载命令不能为空！");
	}

}