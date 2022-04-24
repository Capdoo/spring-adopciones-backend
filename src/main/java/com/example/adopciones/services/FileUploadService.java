package com.example.adopciones.services;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class FileUploadService {

	private String name;

	public FileUploadService() {
		super();

	}
	
	public void guardarImagen() throws IOException {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "unmsm234",
				"api_key", "872387794637319",
				"api_secret", "xF-9FwzZamaUbqtmWNbBcweiJoU",
				"secure", true));
		File file = new File("my_image.jpg");

		Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

	}
	
	
	
	
}
