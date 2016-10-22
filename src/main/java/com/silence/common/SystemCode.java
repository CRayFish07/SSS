package com.silence.common;

/**
 * @description：系统状态码定义
 */
public class SystemCode {

	private SystemCode() {
	}

	/*
	 * ********权限控制（100***）
	 */
	public static final String LOGIN_TIMEOUT = "100001"; // 登录超时

	public static final String NO_PERMISSION = "100002"; // 没有操作权限

	/*
	 * ********综合类型（101***）
	 */
	public static final String INVALID_PARAMETER = "101001"; // 参数错误

	public static final String SUCCESS = "101002"; // 操作成功

	/*
	 * ********服务器异常（102***）
	 */
	public static final String UNKNOWN_EXCEPTION = "102001"; // 未知异常

	public static final String IO_EXCEPTION = "102101"; // IO异常

	public static final String RUNTIME_EXCEPTION = "102201"; // 运行时异常

	public static final String DATABASE_EXCEPTION = "1023701"; // 数据库异常

	public static final String HTTP_EXCEPTION = "102801"; // http请求异常

	public static final String CACHE_EXCEPTION = "102901"; // 缓存操作异常

	/*
	 * ********服务器错误（103***）
	 */
	public static final String UNKNOWN_ERROR = "103001"; // 未知错误
}
