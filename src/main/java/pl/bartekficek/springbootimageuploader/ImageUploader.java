package pl.bartekficek.springbootimageuploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import pl.bartekficek.springbootimageuploader.model.Image;
import pl.bartekficek.springbootimageuploader.repo.ImageRepo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {

    private Cloudinary cloudinary;
    private ImageRepo imageRepo;

    public ImageUploader(ImageRepo imageRepo) {
        this.imageRepo=imageRepo;

        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dv0am90tn",
                "api_key", "374195151217664",
                "api_secret", "04tZS5azq2b9PhZbMJr0ULEvCrA"));
    }

    public String uploadFileAndSaveToDb(String path) {
        File file = new File(path);
        Map uploadResult = null;
        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            imageRepo.save(new Image(uploadResult.get("url").toString()));
        } catch (IOException e) {
            //todo
        }
        return uploadResult.get("url").toString();
    }
}

//        File file = new File("/home/bartek/Desktop/LearningJava/Bykowski/Photo Hosting App/ImagesForExcercise/beach-boat.jpg");
