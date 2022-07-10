/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.File;

/**
 *
 * @author ezequeil
 */
public class CreadHPP {
    
    public static String HPP = 
        "#ifndef $HPP\n" +
        "#define $HPP\n" +
        "\n" +
        "#include <string>\n" +
        "#include <iostream>\n" +
        "\n" +
        "class $CLASS {\n" +
        "\n" +
        "	private:\n" +
        "\n" +
        "\n" +
        "	public:\n" +
        "		$CLASS();\n" +
        "		~$CLASS();\n" +
        "\n" +
        "};\n" +
        "\n" +
        "\n" +
        "#endif";
    
     public static String getText(String fileName)
    {
        String new_txt;
        String hpp;
        String class_name;
        
        hpp = fileName.replace(".hpp", "_HPP");
        hpp = hpp.toUpperCase();
        class_name = fileName.substring(0, fileName.indexOf(".hpp"));
        new_txt = HPP.replace("$HPP", hpp);
        new_txt = new_txt.replace("$CLASS", class_name);
        return (new_txt);
    }
}
