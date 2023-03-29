package ice.tool;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class JsonToJava2 {
    public static void main(String[] args) throws IOException {
        JCodeModel codeModel = new JCodeModel();

        URL source = JsonToJava2.class.getResource("/schema/test.json");
        //URL source = new URL("http://json-schema.org/learn/examples/address.schema.json");
        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() { // set config option by overriding method
                return true;
            }
        };

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, "ClassName", "com.example", source);

        codeModel.build(Files.createTempDirectory("test").toFile());
    }



}
