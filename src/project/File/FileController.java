/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.File;

import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import project.Project;
import static project.File.CreadMake.MAKE;
/**
 *
 * @author ezequeil
 */
public class FileController {

    
    public static File saveFileProject(Component parent)
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("save to file directory");   
 
        int userSelection = fileChooser.showSaveDialog(parent);
 
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            return (fileToSave);
        }
        return (null);
    }
    
    public static File openFilePDF(Component parent){
    
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMinimumSize(new Dimension(800, 400));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf")); 
        fileChooser.setAcceptAllFileFilterUsed(true);
 
        int result = fileChooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return (selectedFile);
        }
        return (null);
    }
    
    public static ArrayList<Project> read_pdf(File file, JProgressBar progress)
    {
         ArrayList<Project> projects = new ArrayList<>();
         Project p = null;
        if (!file.exists())
                return (projects);
        try (PDDocument document = PDDocument.load(file)) {
            if (!document.isEncrypted()) {
			
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);

                String lines[] = pdfFileInText.split("\\r?\\n");
                progress.setMaximum(lines.length);
                for (String line : lines) {
                    if (line.contains("Turn-in directory"))
                        p = new Project();
                    if (p != null)
                       p.addLine(line);
                     if (line.contains("Forbidden functions") && p != null)
                     {
                         p.create();
                         projects.add(p);
                         p = null;
                     }
                    progress.setValue(progress.getValue() + 1);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return (projects);
    }
    
    public static void write_file(File file, String txt)
    {
        try (FileWriter write = new FileWriter(file)){
            write.write(txt);
            write.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    
    public static File cread_file(File dir, String fileName)
    {
        dir = new File(dir, fileName.trim());
        if (dir.exists())
             return null;
         try {
                   dir.createNewFile();
                   return (dir);
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
   
}