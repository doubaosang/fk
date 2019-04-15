package com.chentuo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * @author jian198001
 * @version 1.2
 */
public class StringUtil {

	public static String dot2separator(String str) {

		return StringUtils.replace(str, ".", "/");

	}

	public static List<Map<String, Object>> getTag(String str, String varStart,
			String varEnd) {

		if (StringUtils.isBlank(str)) {

			return null;

		}

		int startPos = 0;

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		while ((startPos = StringUtils.indexOf(str, varStart, startPos)) != -1) {

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("startPos", startPos);

			int start = startPos;

			startPos = StringUtils.indexOf(str, varEnd, startPos);

			if (startPos == -1) {

				break;

			}

			map.put("endPos", startPos + StringUtils.length(varEnd));

			String substring = StringUtils.substring(str,
					start + StringUtils.length(varStart), startPos);

			map.put("substring", substring);

			list.add(map);

		}

		return list;

	}

	public static String replaceTag(String str, String varStart, String varEnd,
			Map<String, String> map) {

		if (StringUtils.isBlank(str)) {

			return str;

		}

		if (map == null || map.isEmpty()) {

			return str;

		}

		int startPos = 0;

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		while ((startPos = StringUtils.indexOf(str, varStart, 0)) != -1) {

			int start = startPos;

			startPos = StringUtils.indexOf(str, varEnd, startPos);

			if (startPos == -1) {

				break;

			}

			int end = startPos + StringUtils.length(varEnd);

			String substring = StringUtils.substring(str,
					start + StringUtils.length(varStart), startPos);

			if (StringUtils.isBlank(substring)) {

				continue;

			}

			String subFront = StringUtils.substring(str, 0, start);

			String subEnd = StringUtils.substring(str, end,
					StringUtils.length(str));

			String value = map.get(substring);

			str = subFront + value + subEnd;

		}

		return str;

	}

	public static String separator2dot(String str) {

		str = StringUtils.replace(str, "\\", ".");

		return StringUtils.replace(str, "/", ".");

	}

	public static String uppercase2underscore(String str) {

		str = StringUtils.replace(str, "A", "_a");

		str = StringUtils.replace(str, "B", "_b");

		str = StringUtils.replace(str, "C", "_c");

		str = StringUtils.replace(str, "D", "_d");

		str = StringUtils.replace(str, "E", "_e");

		str = StringUtils.replace(str, "F", "_f");

		str = StringUtils.replace(str, "G", "_g");

		str = StringUtils.replace(str, "H", "_h");

		str = StringUtils.replace(str, "I", "_i");

		str = StringUtils.replace(str, "J", "_j");

		str = StringUtils.replace(str, "K", "_k");

		str = StringUtils.replace(str, "L", "_l");

		str = StringUtils.replace(str, "M", "_m");

		str = StringUtils.replace(str, "N", "_n");

		str = StringUtils.replace(str, "O", "_o");

		str = StringUtils.replace(str, "P", "_p");

		str = StringUtils.replace(str, "Q", "_q");

		str = StringUtils.replace(str, "R", "_r");

		str = StringUtils.replace(str, "S", "_s");

		str = StringUtils.replace(str, "T", "_t");

		str = StringUtils.replace(str, "U", "_u");

		str = StringUtils.replace(str, "V", "_v");

		str = StringUtils.replace(str, "W", "_w");

		str = StringUtils.replace(str, "X", "_x");

		str = StringUtils.replace(str, "Y", "_y");

		str = StringUtils.replace(str, "Z", "_z");

		str = str.toUpperCase();

		return str;

	}

	public static void main(String[] args) {

		String str = "private String AREA_NAME = null;     private String ACTION = null;     private String CHECK_ITEM = null;     private String RISK_REASON   = null;     private String CONTROL_MEASURE   = null;     private String ERROR_MESSAGE   = null;     private String PERSON   = null;     private String CHECK_MESSAGE   = null;     private String RISK_LEVEL   = null;     private String PERIOD   = null;     private String MANAGER   = null;     private String DESCRIPTIONS  = null; ";

	}

}
