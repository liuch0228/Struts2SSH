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
@RequestMapping("/mult")
public class MultController {

	//��ת���ϴ��ļ�ҳ��
	@RequestMapping("/toMultPage.do")
	public String goSinglePage(){
		return "multi";
	}
	
	@RequestMapping("/doUpload.do")
	public String doUpload(@RequestParam("multis")MultipartFile[] files, 
			HttpServletRequest req) throws IllegalStateException, IOException{
		//�ж��Ƿ���յ��˶��ļ�
		if (files.length>0) {
			//ͨ��request��ȡ�ļ��洢·��
			String realPath =  req.getSession().getServletContext().getRealPath("upload");
			for (MultipartFile file : files) {
				//�ж��ļ���Ϊ�յ�ʱ��,�����ϴ�����
				if(!file.isEmpty()){
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
			}
		}		
		return "upSuccess";		
	}
}










