package com.mxq;

import java.io.File;
import java.io.FileNotFoundException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

import com.aspose.words.Document;

//@SpringBootApplication
//@MapperScan("com.mxq.mapper")   //@MapperScan  用于扫描MyBatis的Mapper接口
public class App {

	public static void main(String[] args) throws FileNotFoundException {
		
		//SpringApplication.run(App.class, args);
		
		 File s = ResourceUtils.getFile("classpath:static/贵阳国家高新区2019年创新检测券申请指南.doc");
		 //File s1 = ResourceUtils.getFile("classpath:static/贵阳国家高新区2019年创新检测券申请指南.pdf");
		 System.out.println(s.getPath());
		 
		 try {
             //doc路径
            Document document = new Document(s.getPath());
            //pdf路径
            File outputFile = new File("e://ss.pdf");
            //操作文档保存
            document.save(outputFile.getAbsolutePath(), com.aspose.words.SaveFormat.PDF);
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
