package ice.tool;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class JsonToJava {
    public static void main(String[] args) throws IOException {
        JCodeModel codeModel = new JCodeModel();


        String ss="{\n" +
                "\t\"file_name\": \"fed6a9d853e0873be8f.jpg\",\n" +
                "\t\"file_name_o\": \"原文件名称.jpg\",\n" +
                "\t\"file_type\": \".jpg\",\n" +
                "\t\"file_path\": \"/file/img/\",\n" +
                "\t\"file_size\": 220,\n" +
                "\t\"size_unit\": \"KB\"\n" +
                "}";
        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() { // set config option by overriding method
                return true;
            }
        };

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        String className="ClassName";
        mapper.generate(codeModel, className, "com.example", ss);
        File projectFile=new File("");
        String folderName=projectFile.getAbsolutePath()+"\\src\\main\\resources\\results";
        File folder=new File(folderName);
        System.out.println(folderName);
        codeModel.build(Files.createTempDirectory("required").toFile());
        codeModel.build(folder);
        //codeModel.build(folder);
    }



}
