/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.File;

import project.ProjectFile;

import java.util.ArrayList;

/**
 *
 * @author ezequeil
 */
public class CreadCPP {
    
    public static String CPP = "#include \"$class.hpp\"\n" +
            "\n" +
            "$class::$class()\n" +
            "{\n" +
            "}\n" +
            "\n" +
            "$class::~$class()\n" +
            "{\n \n\n"+
            "}";

    public static String getText(String fileName) {
        String class_name;

        fileName = fileName.replace(".cpp", "").trim();
        class_name = CPP.replace("$class", fileName);
        return (class_name);
    }

    public static String getTextMain() {
        String class_name;

        class_name = "" +
                "\n" +
                "\n" +
                "int main(void){" +
                "\n" +
                "\n" +
                "}";

        return (class_name);
    }
}
