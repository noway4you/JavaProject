import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class sql_1 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/DataFileService.aspx?UnitId=877");
			URLConnection connect = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(connect.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(bin));
			
			String line;
			StringBuffer sb = new StringBuffer();
			while((line = reader.readLine())!=null) {
				sb.append(line);
			}
			bin.close();
			parseJSON(sb.toString());
		} catch (Exception e) {
			System.out.println("error => " + e);
		}
	}
	
	static void parseJSON(String json) {
		
		JSONArray root = new JSONArray(json);
		
		String url = "jdbc:mysql://127.0.0.1:3306/db1";
		Properties property = new Properties();
		property.put("user","root");
		property.put("password","root");
		
		try {
			Connection connect = DriverManager.getConnection(url,property);
			String sql = "insert into db_1 (刊物名稱,出版年月,刊物網址,檔案類型)" + "values(?,?,?,?)";
			PreparedStatement state = connect.prepareStatement(sql);
			
			for(int i=0;i<root.length();i++) {
				JSONObject element = root.getJSONObject(i);
				
				String name = element.getString("刊物名稱");
				String date = element.getString("出版年月");
				String html = element.getString("刊物網址");
				String type = element.getString("檔案類型");
				
				state.setString(1,name);
				state.setString(2,date);
				state.setString(3,html);
				state.setString(4,type);
				
				state.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println("error => " + e);
		}
	}
}
