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

	//��ת���ϴ��ļ�ҳ��
	@RequestMapping("/toSinglePage.do")
	public String goSinglePage(){
		return "single";
	}
	
	@RequestMapping("/doUpload.do")
	public String doUpload(@RequestParam("singleFile")MultipartFile file, 
			HttpServletRequest req) throws IllegalStateException, IOException{
		//�ж��ļ���Ϊ�յ�ʱ��,�����ϴ�����
		if(!file.isEmpty()){
			//ͨ��request��ȡ�ļ��洢·��
			String realPath =  req.getSession().getServletContext().getRealPath("upload");
			System.out.println(realPath);
			//��ȡ�ļ���
			String oFname = file.getOriginalFilename();
			System.out.println(oFname);
			//��ȡ�ļ���׺��
			String suffix = oFname.substring(oFname.indexOf("."), oFname.length());
			System.out.println(suffix);
			//ͨ��UUID+suffix����µ��ļ����������ظ�
			String newFname = UUID.randomUUID().toString()+suffix;
			System.out.println(newFname);
			//����һ���ļ�
			File tempFile = new File(realPath+"/"+newFname);
			//�ļ�ת��
			file.transferTo(tempFile);
		}
		
		return "upSuccess";
		
	}
}










