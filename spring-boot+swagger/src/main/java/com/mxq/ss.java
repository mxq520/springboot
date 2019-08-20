package com.mxq;

import java.io.File;

import com.aspose.words.Document;

public class ss {

	public String doc_html(String path1,String path2) {
		// TODO Auto-generated method stub
		 try {
             //doc路径
            Document document = new Document(path1);
            //pdf路径
            File outputFile = new File(path2);
            //操作文档保存
            document.save(outputFile.getAbsolutePath(), com.aspose.words.SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
        }
		 return path2;
	}

}
