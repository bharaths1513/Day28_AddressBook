package Day28_AddressBook;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class Json_File {

	public void writeJSONFile(String file) throws IOException, ParseException {
		JSONArray arr = new JSONArray();
		FileWriter writer = new FileWriter(file);
		try {
			for (Contacts c : list) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("First Name:: ", c.getFirstName());
				jsonObject.put("Last Name:: ", c.getLastName());
				jsonObject.put("Email:: ", c.getEmailId());
				jsonObject.put("Address:: ", c.getAddress());
				jsonObject.put("City :: ", c.getCity());
				jsonObject.put("State :: ", c.getState());
				jsonObject.put("Zip Code:: ", c.getZip());
				jsonObject.put("Phone Number:: ", c.getPhoneNo());
				arr.add(jsonObject);
			}
			writer.write(arr.toJSONString());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readJSONFile(String file) throws Exception {
		JSONParser jsonP = new JSONParser();
		FileReader reader = new FileReader(file);
		try {
			Object obj = jsonP.parse(reader);
			JSONArray array = (JSONArray) obj;
			System.out.println(array);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
