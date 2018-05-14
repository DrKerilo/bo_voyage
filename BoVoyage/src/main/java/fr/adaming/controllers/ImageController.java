package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import fr.adaming.service.IImageService;
import javassist.compiler.ast.Member;

@Controller
@RequestMapping("/imageCTRL")
@Scope("session")
public class ImageController {

	@Autowired
	IImageService iService;
	
	private static final String UPLOAD_DIRECTORY="/jdbc:mysql://localhost:3306/db_bo_voyage";
	private static final int THRESHOLD_SIZE = 1024*1024*3;
	
	// Chargement de l'image
	@RequestMapping("/uploadForm")
	public ModelAndView uploadForm(){
		return new ModelAndView("uploadForm");
	}
	
	// Sauvegarde de l'image 
	@RequestMapping("/Upload")
	public ModelAndView saveimage(@RequestParam("upFiles")MultipartFile[] files, HttpSession session) throws Exception{
		List<String> imges=new ArrayList<String>();
		for (MultipartFile file : files) {
			byte[] name = file.getBytes();
			String imge = "data:image/JPEG;base64,"+Base64.encodeBase64String(name);
			imges.add(imge);
		}
		return new ModelAndView("uploadForm", "imges", imges);
	}
	
}
