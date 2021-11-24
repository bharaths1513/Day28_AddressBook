package Day28_AddressBook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Csv_File {

	public void writeCSVFile(String file) {
		File fileWrite = new File(file);
		try {
			FileWriter outputfile = new FileWriter(fileWrite);
			CSVWriter writer = new CSVWriter(outputfile);

			for (Contacts c : list) {
				String[] data = { c.getFirstName(), c.getLastName(), c.getEmailId(), c.getAddress(), c.getCity(),
						c.getState(), c.getZip(), String.valueOf(c.getPhoneNo()) };
				writer.writeNext(data);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readCSVFile(String file) {
		try (Reader reader = Files.newBufferedReader(Paths.get(file)); CSVReader csvreader = new CSVReader(reader);) {
			List<String[]> readcsv = csvreader.readAll();
			for (String[] nextRecord : readcsv) {
				System.out.println("First Name:: " + nextRecord[0]);
				System.out.println("Last Name:: " + nextRecord[1]);
				System.out.println("Email:: " + nextRecord[2]);
				System.out.println("Address:: " + nextRecord[3]);
				System.out.println("City:: " + nextRecord[4]);
				System.out.println("State:: " + nextRecord[5]);
				System.out.println("Zip code:: " + nextRecord[6]);
				System.out.println("Phone Number:: " + nextRecord[7]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
