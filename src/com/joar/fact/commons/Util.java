package com.joar.fact.commons;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Util {

	public static String getStackTrace(Exception e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		if (e == null) {
			return "Not Exception";
		}
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sstrace = sw.toString(); // stack trace as a string
			pw.close();
			sw.close();
			return sstrace;
		} catch (Exception ex) {
			return ex.getMessage();
		}
	}
}
