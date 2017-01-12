package com.fs.columns;

import java.util.Arrays;
import java.util.List;

public enum Columns {
	
	TESTCASENAME(1, "Test Case Name"), TESTCASEDESCRIPTION(2, "Description"), TESTSTARTTIME(3, "Start Time"), TESTENDTIME(4, "End Time"), TESTLOG(5, "Test Logs"), TESTRESULT(6, "Result"), TESTERRORMESSAGE(7, "Error Messages");

	private Integer colSequence;
	private String  colName;

	Columns(Integer colSequence, String colName) {

		this.colSequence = colSequence;
		this.colName = colName;
	}

	public Integer getColSequence() {

		return colSequence;
	}

	public String getColName() {

		return colName;
	}
	
	@Override
	public String toString() {

		String completeReturnString = "";
		List<Columns> columnList = Arrays.asList(values());
		int i = 0;
		for (Columns columnObj : columnList)
		{
			i++;
			if (i == 0)
				completeReturnString = "{" + i + "," + columnObj.getColName() + "} , ";
			else if (i == columnList.size())
				completeReturnString += "{" + i + "," + columnObj.getColName() + "}";
			else
				completeReturnString += "{" + i + "," + columnObj.getColName() + "} , ";
		}
		return completeReturnString;
	}
}
