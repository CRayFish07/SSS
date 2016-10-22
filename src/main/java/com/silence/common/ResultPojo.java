package com.silence.common;

/**
 * @description：用于封装返回给小机的结果（JSON数据）
 * 
 */
public class ResultPojo<T> {
	private T data;

	private String errorCode;

	private String errorInfo;

	public ResultPojo() {
		this.data = null;

		this.errorCode = SystemCode.SUCCESS; // 默认为请求成功！

		this.errorInfo = "操作成功！";
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
}
