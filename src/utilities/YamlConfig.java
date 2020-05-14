package utilities;

import java.io.FileInputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;


public class YamlConfig {
	
	private static Yaml yamlData;
	private static Map<String, String> mapYaml;
	
	public static Map<String, String> setYamlFile(String path) throws Exception{
		try{
			FileInputStream yamlFile=new FileInputStream(path);
			yamlData = new Yaml();
			mapYaml=yamlData.load(yamlFile);
			return mapYaml;
		}
		catch(Exception e){
			Log.info("class YamlConfig | Method setYamlFile | Exception desc: "+e.getMessage());
			throw(e);
		}
	}
	
	public static String getYamlData(String key) throws Exception{

		try{
			String yamlData=mapYaml.get(key);
			return yamlData;
		}catch(Exception e){
			Log.info("class YamlConfig|Method getYamlData| Exception desc:"+e.getMessage());
			return "";
		}		
		
	}
}
