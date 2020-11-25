package pl.bartekficek.springbootimageuploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {

    private Cloudinary cloudinary;

    public ImageUploader() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dv0am90tn",
                "api_key", "374195151217664",
                "api_secret", "04tZS5azq2b9PhZbMJr0ULEvCrA"));
    }

    public String uploadFile(String path) {
        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        } catch (IOException e) {
            //todo
        }
        return uploadResult.get("url").toString();
    }
}

//        File file = new File("/home/bartek/Desktop/LearningJava/Bykowski/Photo Hosting App/ImagesForExcercise/beach-boat.jpg");
