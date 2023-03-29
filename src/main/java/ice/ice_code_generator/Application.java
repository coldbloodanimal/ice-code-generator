package ice.ice_code_generator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ice.tool.DataTypeConverter;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;

import com.google.gson.Gson;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import ice.tool.CamelNamed;
import ice.tool.TheStringUtil;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application
{

	public static final String DATA_TYPE="DATA_TYPE";
	public static final String COLUMN_NAME="COLUMN_NAME";
	public static final String COLUMN_COMMENT="COLUMN_COMMENT";

    public static void main(String[] args) throws Exception {


    	ApplicationContext application=SpringApplication.run(Application.class, args);

        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */

        /* Create and adjust the configuration singleton */
    	JdbcTemplate jdbcTemplate=application.getBean(JdbcTemplate.class);
        String table_schema="test";
        String tablename="world_user";
    	Map<String, Object> tableInfoFromDB=getTableInfoFromDB(jdbcTemplate,table_schema,tablename);


    	String configpath="data/config_zy.json";
    	Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
    	Map<String, Object> map=getTableInfoFromConfig(cfg,configpath);

    	map=merge(map,tableInfoFromDB);
		map.put("table_name",map.get("TABLE_NAME"));

    	for(String key:map.keySet()) {
    		System.out.println(key+":"+map.get(key));
    	}


        /* Get the template (uses cache internally) */

		//生成主页面
//        Template pc_page_main = cfg.getTemplate("pc_page_main.ftlh");
//        File results=new File(ResourceUtils.getURL("results").getPath());
        File projectFile=new File("");
        //String fileName=ClassLoader.getSystemClassLoader().getResource("results").getPath()+"\\"+(String) map.get("module")+"\\"+(String) map.get("module")+".jsp";
        //存储到源代码的对应目录中

        String folderName=projectFile.getAbsolutePath()+"\\src\\main\\resources\\results"+"\\"+(String) map.get("module_name");
        File folder=new File(folderName);
        if(!folder.exists()){
        	folder.mkdir();
        }

		//生成pc Service
        Template pc_js = cfg.getTemplate("pc_serviceImpl_zhongying.ftlh");
        String PCJSfileName=folderName+"\\"+map.get("module_name")+"ServiceImpl.java";
        System.out.println(PCJSfileName);
        File PCJSFile=new File(PCJSfileName);
        PCJSFile.createNewFile();
        // FileOutputStream fos=new FileOutputStream(PCMainFile);
        FileWriterWithEncoding PCJSFileOut = new FileWriterWithEncoding(PCJSFile,"UTF-8");
        pc_js.process(map, PCJSFileOut);




        //生成mapper
        Template template = cfg.getTemplate("pc_mapper_zhongying.ftlh");
        String fileName=folderName+"\\"+map.get("module_name")+"Mapper.java";
        System.out.println(fileName);
        File file=new File(fileName);
        file.createNewFile();
        // FileOutputStream fos=new FileOutputStream(PCMainFile);
        FileWriterWithEncoding fileWriterWithEncoding = new FileWriterWithEncoding(file,"UTF-8");
        template.process(map, fileWriterWithEncoding);

		//生成entity
		template = cfg.getTemplate("pc_entity.ftlh");
		fileName=folderName+"\\"+map.get("module_name")+"Entity.java";
		System.out.println(fileName);
		file=new File(fileName);
		file.createNewFile();
		// FileOutputStream fos=new FileOutputStream(PCMainFile);
		fileWriterWithEncoding = new FileWriterWithEncoding(file,"UTF-8");
		template.process(map, fileWriterWithEncoding);

		//生成entity
		template = cfg.getTemplate("pc_model.ftlh");
		fileName=folderName+"\\"+map.get("module_name")+"Model.java";
		System.out.println(fileName);
		file=new File(fileName);
		file.createNewFile();
		// FileOutputStream fos=new FileOutputStream(PCMainFile);
		fileWriterWithEncoding = new FileWriterWithEncoding(file,"UTF-8");
		template.process(map, fileWriterWithEncoding);
		//生成js
		template = cfg.getTemplate("pc_service_zhongying.ftlh");
		fileName=folderName+"\\I"+map.get("module_name")+"Service.java";
		System.out.println(fileName);
		file=new File(fileName);
		file.createNewFile();
		// FileOutputStream fos=new FileOutputStream(PCMainFile);
		fileWriterWithEncoding = new FileWriterWithEncoding(file,"UTF-8");
		template.process(map, fileWriterWithEncoding);

        //生成Controller
        template = cfg.getTemplate("pc_controller_zhongying.ftlh");
        fileName=folderName+"\\"+map.get("module_name")+"Resource.java";
        System.out.println(fileName);
        file=new File(fileName);
        file.createNewFile();
        // FileOutputStream fos=new FileOutputStream(PCMainFile);
        fileWriterWithEncoding = new FileWriterWithEncoding(file,"UTF-8");
        template.process(map, fileWriterWithEncoding);

        //生成js
        template = cfg.getTemplate("pc_js_zhongying.ftlh");
        fileName=folderName+"\\"+map.get("module_name")+".js";
        System.out.println(fileName);
        file=new File(fileName);
        file.createNewFile();
        // FileOutputStream fos=new FileOutputStream(PCMainFile);
        fileWriterWithEncoding = new FileWriterWithEncoding(file,"UTF-8");
        template.process(map, fileWriterWithEncoding);

        //生成html
        template = cfg.getTemplate("pc_html_zhongying.ftlh");
        fileName=folderName+"\\"+map.get("module_name")+".html";
        System.out.println(fileName);
        file=new File(fileName);
        file.createNewFile();
        // FileOutputStream fos=new FileOutputStream(PCMainFile);
        fileWriterWithEncoding = new FileWriterWithEncoding(file,"UTF-8");
        template.process(map, fileWriterWithEncoding);




    }

    /**
     * 将配置文件和数据库的表信息合并,默认使用数据库,配置文件优先级更高,
     * */
	private static Map<String, Object> merge(Map<String, Object> map, Map<String, Object> tableInfoFromDB) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> configcolumns=(List<Map<String, Object>>) map.get("columns");
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> DBcolumns=(List<Map<String, Object>>) tableInfoFromDB.get("columns");


		//取并集，先取左侧config
		if(configcolumns==null) {
			map.put("columns", DBcolumns);
		}else {
			for(Map<String,Object> c:configcolumns){
				//boolean flag=false;
//				inner:
				for(Map<String,Object> dbc:DBcolumns) {
					if(c.get(COLUMN_NAME).equals(dbc.get(COLUMN_NAME))) {
						//flag=true;
//						Map<String,Object> t=c;
//						c=dbc;
						for(String key:dbc.keySet()) {
							if(c.get(key)==null) {
								c.put(key, dbc.get(key));
							}
						}
						continue;
					}
				}
			}
			//取并集，取右侧DB
			for(Map<String,Object> dbc:DBcolumns){
				boolean flag=false;
				for(Map<String,Object> c:configcolumns ) {
					if(dbc.get(COLUMN_NAME).equals(c.get(COLUMN_NAME))) {
						flag=true;
						break;
					}
				}
				if(!flag) {
					configcolumns.add(dbc);
				}
			}
		}


		@SuppressWarnings("unchecked")
		Map<String,Object> table=(Map<String, Object>) tableInfoFromDB.get("table");
		//合并其它属性
		for(String key:table.keySet()) {
			if(!key.equals("columns")) {
				if(map.get(key)==null) {
					map.put(key, table.get(key));
				}
			}
		}
		caculate(map);
		columnNameCamel(map);
		return map;
	}



	/**
	 * 将列的名称改为骆驼命名
	 *
	 *
	 * */
	private static void columnNameCamel(Map<String, Object> map) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> columns=(List<Map<String, Object>>) map.get("columns");
		for(Map<String,Object> c:columns){
			c.put("COLUMN_NAME_PURE", c.get("COLUMN_NAME"));
			c.put("COLUMN_NAME", CamelNamed.camel((String) c.get("COLUMN_NAME")));

		}
	}

	/**
	 * 生成缺省module_name,module_description,module_shortcut缺少，通过表生成
	 * */
	private static void caculate(Map<String, Object> map) {
/*		String[] keys= {"module_name","module_description","module_shortcut"};
		for(String key:keys) {
			String value=(String) map.get(key);
			map.put(key, CamelNamed.camel(value));
		}*/
		String tablename=(String) map.get("table_name");
		if(ObjectUtils.isEmpty(tablename)){
			tablename=(String) map.get("TABLE_NAME");
		}
		if(map.get("module_name")==null) {
			map.put("module_name", TheStringUtil.firstWordCaseUpper(CamelNamed.camel(tablename)));
		}
		if(map.get("module_description")==null) {
			String value=(String) map.get("table_comment");
			map.put("module_description", ObjectUtils.isEmpty(getCoreName(value))?"":getCoreName(value));
		}
		if(map.get("module_shortcut")==null) {
			String value=(String) map.get("table_comment");
			map.put("module_shortcut", getCoreName(value));
		}
		if(map.get("module_name_entity")==null) {
			map.put("module_name_entity", TheStringUtil.firstWordCaseUpper(CamelNamed.camel(tablename))+"Entity");
		}
		if(map.get("module_name_model")==null) {
			map.put("module_name_model", TheStringUtil.firstWordCaseUpper(CamelNamed.camel(tablename))+"Model");
		}

	}
	/**
	 * 从注解中获得想要的关键字
	 * */
	public static String getCoreName(String s){
		try{
			Pattern pattern=Pattern.compile("\\S*-(\\S*)表?");
			Matcher m=pattern.matcher(s);
			m.find();
			String result=m.group(1);
			return result;
		}catch (Exception e){
			return s;
		}

	}

	@SuppressWarnings("unchecked")
	private static Map<String, Object> getTableInfoFromConfig(Configuration cfg,String configpath) {
		Map<String, Object> map = null;
		try {
	        String script;
			File templates=new File(ClassLoader.getSystemClassLoader().getResource("templates").getPath());
			cfg.setDirectoryForTemplateLoading(templates);
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			cfg.setLogTemplateExceptions(false);
			cfg.setWrapUncheckedExceptions(true);
			URL url=ResourceUtils.getURL("classpath:"+configpath);
			script = null;
			Gson gson = new Gson();
			script = IOUtils.toString(url,"UTF-8");
			map=gson.fromJson(script, HashMap.class);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IOUtils.closeQuietly();
		}


		return map;
	}

	private static Map<String, Object> getTableInfoFromDB(JdbcTemplate jdbcTemplate, String table_schema,
			String tablename) {
		Map<String, Object> result=new HashMap<String, Object>();
        String tablesql="SELECT table_name,table_comment FROM information_schema.TABLES WHERE table_schema=? AND table_name LIKE ? ";
        String sql="SELECT*FROM information_schema.COLUMNS WHERE table_schema=? AND table_name like ?";
        //SELECT*FROM information_schema.COLUMNS WHERE table_schema=yyxm AND table_name like erp_notice
        List<Map<String,Object>> columns = jdbcTemplate.query(sql,new Object[] { table_schema,tablename },new RowMapper<Map<String,Object>>() {
            public Map<String,Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Map<String,Object> map = new HashMap<String,Object>();
            	map.put("DATA_TYPE", rs.getString("DATA_TYPE"));
            	map.put("COLUMN_NAME", rs.getString("COLUMN_NAME"));
            	map.put("COLUMN_COMMENT", rs.getString("COLUMN_COMMENT"));
				map.put("COLUMN_JAVA_DATATYPE", DataTypeConverter.sqlDatatypeConvertToJavaDatatype(rs.getString("COLUMN_TYPE")));
                return map;
            }
        });
//        for(Map<String,Object> r:columns) {
//        	System.out.println(r.get("COLUMN_NAME"));
//        }
//
        Map<String,Object> tableinfo = jdbcTemplate.queryForMap(tablesql,new Object[] { table_schema,tablename });

        result.put("columns", columns);
        result.put("table", tableinfo);
//
//        System.out.print(tableinfo.get("table_name"));
//        System.out.print(tableinfo.get("table_comment"));
		return result;
	}
}
