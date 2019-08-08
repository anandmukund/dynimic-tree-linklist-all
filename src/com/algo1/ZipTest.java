package com.algo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class ZipTest
{
    List<String> fileList;
    private static final String INPUT_ZIP_FILE = "D:\\Test\\Test.zip";
    private static final String OUTPUT_FOLDER = "D:\\Test\\UnZip\\real";

    public static void main( String[] args )
    {
    	List l =  new ArrayList<>();
    	change("eransd");
    	ZipTest unZip = new ZipTest();
    	unZip.unZipIt(INPUT_ZIP_FILE,OUTPUT_FOLDER);
    }

    /**
     * Unzip it
     * @param zipFile input zip file
     * @param output zip file output folder
     */
    public void unZipIt(String zipFile, String outputFolder){
     byte[] buffer = new byte[1024];
     try{
    	File folder = new File(OUTPUT_FOLDER);
    	if(!folder.exists()){
    		folder.mkdir();
    	}
    	ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
    	ZipEntry ze = zis.getNextEntry();
    	while(ze!=null){
    	   String fileName = ze.getName();
           File newFile = new File(outputFolder + File.separator + fileName);
            new File(newFile.getParent()).mkdirs();
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zis.read(buffer)) > 0) {
       		fos.write(buffer, 0, len);
            }
            fos.close();
            ze = zis.getNextEntry();
    	}
        zis.closeEntry();
    	zis.close();
    }catch(IOException ex){
       ex.printStackTrace();
    }
   }
    
    
    public static void change (Object t){
    	Object e = t;
    	Object p = t;
    	e.toString();
    	if(p instanceof List){
    		System.out.println("lelota");
    	}
    }
    private void moveFile(File srcFile, File destFolder) throws IOException {
        // copy the file to archive directory
        //FileUtils.copyFileToDirectory(srcFile, destFolder, false);
        // delete file from input directory
        srcFile.delete();
    }
   
}