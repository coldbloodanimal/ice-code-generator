

@Data
public class ${class_name} {
<#list fields as item>

    @ColumnWidth(20)
    @ExcelProperty(value = "${item.display}",index = ${item?index})
    private String ${item.name};
</#list>
}

