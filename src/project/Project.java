/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ezequeil
 */
public class Project {

   private String  lines;
    private String folder;
    private final ArrayList<String> files;
    private final ArrayList<ProjectFile> projectFiles;
    
    public Project()
    {
        files = new ArrayList<>();
        projectFiles = new ArrayList<>();
        lines = "";
    }
    
    
    public void addLine(String line)
    {
        lines += line;
    }
    
    public void create()
    {
        if (lines.contains(":") && lines.contains("/"))
            folder = lines.substring(lines.indexOf(":") + 1, lines.indexOf("/")).trim();
        lines = lines.substring(lines.indexOf("/") + 1, lines.length()).trim();
        lines = lines.substring(lines.indexOf(":") + 1, lines.indexOf("Forbidden")).trim();
        files.addAll(Arrays.asList( lines.split(",")));
        create_files_projects();
    }
    
    private  void create_files_projects()
    {
        String fileName;
        if (folder == null)
            return;
        for (int i = 0; i < files.size(); i++) {
            fileName = files.get(i).trim();
            if (fileName.contains(".{h"))
            {
                fileName = fileName.substring(0, fileName.indexOf("."));
                fileName += ".hpp";
                getProjectFiles().add(new ProjectFile(folder, fileName, files));
                files.set(i, fileName);
            }
        }
        for(int i = 0; i < files.size(); i++) 
        {
            fileName = files.get(i).trim();
            if (!fileName.contains("*"))
            {
                if ("Makefile".equals(fileName) || fileName.contains(".cpp"))   
                    getProjectFiles().add(new ProjectFile(folder, fileName, files));
            }
        }           
    }

    /**
     * @return the folder
     */
    public String getFolder() {
        return folder;
    }

    /**
     * @return the files
     */
    public ArrayList<String> getFiles() {
        return files;
    }
   
    /**
     * @return the projectFiles
     */
    public ArrayList<ProjectFile> getProjectFiles() {
        return projectFiles;
    }
    
    
    @Override
    public String toString() {
        return lines;
    }
    
}
