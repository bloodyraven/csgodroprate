package logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

	private BufferedWriter bw = null;
	private FileWriter fw = null;
	private String nameFile;
	
	public Logger(String path) {
		LocalDateTime ldt = LocalDateTime.now();
		this.nameFile=path+"\\csgodroprate"+ldt.getDayOfMonth()+"."+ldt.getMonthValue()+"."+ldt.getYear()+"_"+ldt.getHour()+"h"+ldt.getMinute()+".txt";
		System.out.println(nameFile);
	}
	
	public void write(String s) {
		try {
			File file = new File(nameFile);
			if(file.createNewFile()) {
				fw = new FileWriter(file);
			} else {
				fw = new FileWriter(file, true);
			}
			bw = new BufferedWriter(fw);
			bw.write(s+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
