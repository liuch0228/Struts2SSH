package cn.bdqn.xsh.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/single")
public class SingleController {

	//跳转到上传文件页面
	@RequestMapping("/toSinglePage.do")
	public String goSinglePage(){
		return "single";
	}
	
	@RequestMapping("/doUpload.do")
	public String doUpload(@RequestParam("singleFile")MultipartFile file, 
			HttpServletRequest req) throws IllegalStateException, IOException{
		//判断文件不为空的时候,进行上传处理
		if(!file.isEmpty()){
			//通过request获取文件存储路径
			String realPath =  req.getSession().getServletContext().getRealPath("upload");
			System.out.println(realPath);
			//获取文件名
			String oFname = file.getOriginalFilename();
			System.out.println(oFname);
			//获取文件后缀名
			String suffix = oFname.substring(oFname.indexOf("."), oFname.length());
			System.out.println(suffix);
			//通过UUID+suffix组成新的文件名，避免重复
			String newFname = UUID.randomUUID().toString()+suffix;
			System.out.println(newFname);
			//创建一个文件
			File tempFile = new File(realPath+"/"+newFname);
			//文件转换
			file.transferTo(tempFile);
		}
		
		return "upSuccess";
		
	}
}










