package com.gsnotes.utils.export;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gsnotes.bo.Etudiant;
import com.gsnotes.web.models.PersonModel;
import com.gsnotes.web.models.StudentExcel;

public class UserExcelImporter {
	
	
	static String[] HEADERS = {"ID ETUDIANT","CNE", "NOM", "PRENOM","ID NIVEAU ACTUEL","TYPE"};
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	public List<StudentExcel> excelImport(){
		List<StudentExcel> listStudent=new ArrayList<>();
		long sid=0;
		String sname="";
		String sprenom="";
		String Type="";
		String scne="";
		long Niveau=0;
		
		String excelFilePath="C:\\Users\\pc\\Desktop\\wissal.xlsx";
		
		long start = System.currentTimeMillis();
		
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(excelFilePath);
			Workbook workbook=new XSSFWorkbook(inputStream);
			Sheet firstSheet=workbook.getSheetAt(0);
			int rowNmber=0;
			Iterator<Row> rowIterator=firstSheet.iterator();
			rowIterator.next();
			
			while(rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Iterator<Cell> cellIterator=nextRow.cellIterator();
				while(cellIterator.hasNext()) {
					Cell nextCell=cellIterator.next();
					int columnIndex=nextCell.getColumnIndex();
					
					switch (columnIndex) {
					case 0:
						sid=(long)nextCell.getNumericCellValue();
						System.out.println(sid);
						break;
					case 1:
						scne=nextCell.getStringCellValue();
						System.out.println(scne);
						
						break;
					case 2:
						sname=nextCell.getStringCellValue();
						System.out.println(sname);
						
						break;
					case 3:
						sprenom=nextCell.getStringCellValue();
						System.out.println(sprenom);
						break;
					case 4:
						Niveau=(long)nextCell.getNumericCellValue();
						System.out.println(Niveau);
						break;
					case 5:
						Type=nextCell.getStringCellValue();
						System.out.println(Type);
						break;
					
					case 6 :
					System.out.print("erreur file is not supported");
					workbook.close();
                    break;
					}
					
					
					
				}
				//le champs de l'eutdiant n'esst pas le meme
				listStudent.add(new StudentExcel(sid,scne,sname,sprenom,Niveau,Type));
			}
			
			workbook.close();
			long end = System.currentTimeMillis();
			System.out.printf("Import done in %d ms\n", (end - start));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return listStudent;
	}

}