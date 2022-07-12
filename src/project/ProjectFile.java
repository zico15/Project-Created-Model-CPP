/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import project.File.CreadCPP;
import project.File.CreadHPP;
import project.File.CreadMake;
import java.util.ArrayList;

/**
 *
 * @author ezequeil
 */
public final class ProjectFile {
    
    private String fileName;
    private String txt;
   
    public ProjectFile(String dirName, String fileName, ArrayList<String> files)
    {
        setFileName(fileName);
       
        created_txt(dirName, files);
    } 
    
    private void created_txt(String dirName, ArrayList<String> files) {
        if ("Makefile".equals(fileName))
            setTxt(CreadMake.getText(dirName, files));
        else if (fileName.contains(".hpp"))
            setTxt(CreadHPP.getText(fileName));
        else if (fileName.contains(".cpp"))
        {
            String na = fileName.replace(".cpp", ".hpp");
            System.out.println("=================");
            System.out.println("file hpp: " + na + "   " +fileName);
            if (files.contains(na))
                setTxt(CreadCPP.getText(fileName));
            else if (fileName.equals("main.cpp"))
                setTxt(CreadCPP.getTextMain());
            else
                setTxt("");
        }
        else
            setTxt("");
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the txt
     */
    public String getTxt() {
        return txt;
    }

    /**
     * @param txt the txt to set
     */
    public void setTxt(String txt) {
        this.txt = txt;
    }
    
    @Override
    public String toString() {
        return "fileName: " + getFileName() + " txt: " + getTxt();
    }
    
}
