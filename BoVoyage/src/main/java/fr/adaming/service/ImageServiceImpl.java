package fr.adaming.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Image;

import fr.adaming.dao.IImageDao;

@Service
@Transactional
public class ImageServiceImpl implements IImageService{

	@Autowired
	private IImageDao iDao;
	
	@Override
	public void addImage(Image image) {
		iDao.addImage(image);
		
	}

}
