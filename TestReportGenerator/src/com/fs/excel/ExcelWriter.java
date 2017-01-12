package com.fs.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.fs.columns.Columns;

public class ExcelWriter {

	private String   fileLocation;
	private String   fileName;
	private Workbook workBook;
	private Sheet	sheet;
	private File	 excelFile;

	public ExcelWriter(String fileLocation, String fileName) {
		setFileLocation(fileLocation);
		setFileName(fileName);
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void createExcelFile() throws IOException {

		String osName = System.getProperty("os.name");
		String filePath = "";
		filePath = fileLocation + File.separator + fileName;
		excelFile = new File(filePath);
		if (!excelFile.exists())
			excelFile.createNewFile();
		if (fileName.endsWith("xlsx"))
			workBook = new XSSFWorkbook();
		else if (fileName.endsWith("xls"))
			workBook = new HSSFWorkbook();
	}

	public void createSheet(String sheetName) {
		workBook.createSheet(sheetName);
	}

	public void selectSheet(int sheetIndex) {
		sheet = workBook.getSheetAt(sheetIndex);
	}

	public void selectSheet(String sheetName) {
		sheet = workBook.getSheet(sheetName);
	}

	public void writeHeader() throws IOException {
		Row headerRow = sheet.createRow(0);
		List<Columns> columnList = Arrays.asList(Columns.values());
		List<String> headerList = new ArrayList<>(columnList.size());
		for (int i = 0; i < columnList.size(); i++)
			headerList.add("");
		for (Columns column : columnList)
		{
			headerList.set(column.getColSequence() - 1, column.getColName());
		}
		writeToRow(headerRow, headerList);
	}

	public void writeToExcel(HashMap<Columns, String> rowContentMap) throws IOException {
		if (headerNotPresent())
			writeHeader();
		Row currentRow = sheet.createRow(sheet.getLastRowNum() + 1);
		List<String> rowContentList = getWriteToRowContentList(rowContentMap);
		writeToRow(currentRow, rowContentList);
	}

	public void writeToRow(Row row, List<String> rowContentList) throws IOException {
		int rowNum = row.getRowNum();
		for (int i = 0; i < rowContentList.size(); i++)
		{
			CellStyle style = workBook.createCellStyle();
			style.setBorderBottom(CellStyle.BORDER_MEDIUM);
			style.setBorderTop(CellStyle.BORDER_MEDIUM);
			style.setBorderRight(CellStyle.BORDER_MEDIUM);
			style.setBorderLeft(CellStyle.BORDER_MEDIUM);
			style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			Cell cell = row.createCell(i);
			cell.setCellValue(rowContentList.get(i).toString());
			if (rowNum == 0)
			{
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
				Font cellFont = workBook.createFont();
				cellFont.setItalic(true);
				cellFont.setBold(true);
				cellFont.setColor(HSSFColor.WHITE.index);
				style.setFont(cellFont);
			}
			if (i == (Columns.TESTRESULT.getColSequence() - 1))
			{
				style.setAlignment(CellStyle.ALIGN_CENTER);
				if (rowContentList.get(i).trim().equals("PASSED"))
				{
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
				}
				else if (rowContentList.get(i).trim().equals("FAILED"))
				{
					style.setFillPattern(CellStyle.SOLID_FOREGROUND);
					style.setFillForegroundColor(IndexedColors.RED.getIndex());
				}
			}
			row.getCell(i).setCellStyle(style);
		}
		FileOutputStream out = new FileOutputStream(excelFile);
		workBook.write(out);
		out.flush();
		out.close();
	}

	public boolean headerNotPresent() {

		if (sheet.getFirstRowNum() == sheet.getLastRowNum())
			return true;
		return false;
	}

	private List<String> getWriteToRowContentList(HashMap<Columns, String> rowContentMap) {

		List<String> tmp = new ArrayList<String>();
		for (int i = 0; i < Columns.values().length; i++)
			tmp.add("");
		Set<Columns> columnSet = rowContentMap.keySet();
		for (Columns column : columnSet)
			tmp.set(column.getColSequence() - 1, rowContentMap.get(column));
		return tmp;
	}

	public void closeWorkbook() throws IOException {

		workBook.close();
	}
}
