package com.drm.exception;

import java.sql.SQLException;

public class CheckedExceptionAgnosticV2 {
	public static void main(String[] args) {
		throw new RuntimeException(new SQLException());
	}
}
