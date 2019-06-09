package ice.ice_code_generator;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class GsonTest {
	public static void  main(String[] args){
		Gson gson = new Gson();
		String ss=gson.toJson(1);            // ==> 1
		ss=gson.toJson("abcd");       // ==> "abcd"
		ss=gson.toJson(new Long(10)); // ==> 10
		int[] values = { 1 };
		ss=gson.toJson(values);       // ==> [1]
		System.out.println(ss);
		// Deserialization
		int one = gson.fromJson("1", int.class);
		Integer two = gson.fromJson("1", Integer.class);
		Long three = gson.fromJson("1", Long.class);
		Boolean f = gson.fromJson("false", Boolean.class);
		String str = gson.fromJson("\"abc\"", String.class);
		String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);
		
		InputStream resourceAsStream = GsonTest.class.getResourceAsStream("/data/model.json");
		String script = null;
		try {
			script = IOUtils.toString(resourceAsStream,"UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IOUtils.closeQuietly(resourceAsStream);
		System.out.println(script);



	}
}
