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


        String ss="\t\t\t{\n" +
                "\t\t\t\t\"id\": \"b94781dbd9891228aa9210600fdb4177\",\n" +
                "\t\t\t\t\"current\": 0,\n" +
                "\t\t\t\t\"size\": 0,\n" +
                "\t\t\t\t\"parentId\": \"0\",\n" +
                "\t\t\t\t\"ancestors\": \"[0]\",\n" +
                "\t\t\t\t\"code\": \"org-person\",\n" +
                "\t\t\t\t\"name\": \"组织人员\",\n" +
                "\t\t\t\t\"type\": \"C\",\n" +
                "\t\t\t\t\"router\": \"\",\n" +
                "\t\t\t\t\"openType\": \"0\",\n" +
                "\t\t\t\t\"frame\": false,\n" +
                "\t\t\t\t\"cached\": true,\n" +
                "\t\t\t\t\"visible\": true,\n" +
                "\t\t\t\t\"icon\": \"hos-icon-menu\",\n" +
                "\t\t\t\t\"weight\": 0,\n" +
                "\t\t\t\t\"remark\": null,\n" +
                "\t\t\t\t\"categoryLocation\": \"left\",\n" +
                "\t\t\t\t\"pageProperties\": null,\n" +
                "\t\t\t\t\"advancedJs\": null,\n" +
                "\t\t\t\t\"category\": \"base\",\n" +
                "\t\t\t\t\"hasPagePreset\": true,\n" +
                "\t\t\t\t\"leaf\": false\n" +
                "\t\t\t}";
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
