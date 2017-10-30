package com.zy.creditindex.controller.indexandidri;



import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import java.io.File;

import java.io.FileOutputStream;


/**
 * 下载pdf
 * @author huaqin
 * @date 2017/10/27
 */
@Controller
@RequestMapping("/mp")
public class DownLoadAction {
    @RequestMapping("/downloadPDF")
    @ResponseBody
    public String download(String creditRisk) throws DocumentException, Exception {
        /*创建文件*/
        Document document = new Document();
        /*建立一个书写器*/
        PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("E:/指数介绍.pdf"));
        /*打开文件*/
        document.open();
        try {
            /*设置标题*/
            document.addTitle("指数介绍");
            /*设置作者*/
            document.addAuthor("新华财讯中心");
            /*设置关键字*/
            document.addKeywords("指数");
            /*创建时间*/
            document.addCreationDate();
            /*应用程序*/
            document.addCreator("hd.com");
             /*添加内容*/
            Anchor anchorTarget = new Anchor("指数介绍");
            anchorTarget.setName("BackToTop");
            Paragraph paragraph1 = new Paragraph();

            String font_cn = getChineseFont();  
            BaseFont bf = BaseFont.createFont(font_cn+",1", //注意这里有一个,1
                     BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);  
            Font font = new Font(bf,12);
            paragraph1.setSpacingBefore(50);
            paragraph1.add(anchorTarget);
            document.add(paragraph1);
            document.add(new Paragraph(creditRisk,font));
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return "true";
    }
    private String getChineseFont(){  
  
        //宋体（对应css中的 属性 font-family: SimSun; /*宋体*/）  
        String font1 ="C:/Windows/Fonts/simsun.ttc";  
        //判断系统类型，加载字体文件  
        java.util.Properties prop = System.getProperties();  
        String osName = prop.getProperty("os.name").toLowerCase();  
        System.out.println(osName);  
        if (osName.indexOf("linux")>-1) {  
            font1="/usr/share/fonts/simsun.ttc";  
        }  
        if(!new File(font1).exists()){  
            throw new RuntimeException("字体文件不存在,影响导出pdf中文显示！"+font1);  
        }  
        return font1;  
    }  
}
