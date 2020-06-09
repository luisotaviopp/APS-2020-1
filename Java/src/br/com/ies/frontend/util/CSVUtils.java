package br.com.ies.frontend.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVUtils {
	
	public static Boolean saveToCSV(File file, String[][] values, String[] columns) {
		PrintWriter pw = null;
		try {
	        try {
	            pw = new PrintWriter(file);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        StringBuilder builder = new StringBuilder();
	        
	        for (int i = 0; i < columns.length; i++) {
				builder.append(String.valueOf(columns[i]));
				
				if((columns.length - 1) != i) {
					builder.append(",");
				}
			}
	        
	        builder.append("%n");

	        for (int i = 0; i < values.length; i++) {
				for (int j = 0; j < values[i].length; j++) {
					String val = String.valueOf(values[i][j]);
					
					if(val.contains(",")) {
						val = val.replaceAll(",", ".");
					}
					
					builder.append(val);
					
					if((values[i].length - 1) != j) {
						builder.append(",");
					}
				}
				
				builder.append("%n");
			}
	        
	        pw.write(String.format(builder.toString()));
	        pw.close();
	        
	        return true;
		} catch (Exception e) {
			e.printStackTrace();
			
			if(pw != null) {
				pw.close();
			}
			
			return false;
		}
	}
	
}
