package com.gitee.swsk33.reg.exception;

/**
 * 注册表类型错误异常
 * 
 * @author swsk33
 *
 */
public class TypeErrorException extends Exception {

	private static final long serialVersionUID = -1396944163316796410L;

	public TypeErrorException() {
		super("数据类型错误！必须是REG_SZ（字符串值）,REG_MULTI_SZ（多字符串值）,REG_EXPAND_SZ（可扩展字符串值）,REG_DWORD（DWORD值）,REG_QWORD（QWORD值）,REG_BINARY（二进制值）或者REG_NONE（无）(可不分大小写)");
	}

}