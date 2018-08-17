package com.summit.homs.util;

public class IResultUtil {
	public static IResult success(Object object) {
		IResult result = new IResult();
		result.setCode(IResultCodes.SC_OK);
		result.setMsg("成功");
		result.setData(object);
		return result;
	}

	public static IResult success() {
		return success(null);
	}

	public static IResult fail(Integer code, String msg) {
		IResult result = new IResult();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(null);
		return result;
	}
}
