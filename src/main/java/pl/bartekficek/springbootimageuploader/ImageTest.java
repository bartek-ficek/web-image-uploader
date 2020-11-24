package pl.bartekficek.springbootimageuploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ImageTest {

    public static void main(String[] args) throws IOException {


        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dv0am90tn",
                "api_key", "374195151217664",
                "api_secret", "04tZS5azq2b9PhZbMJr0ULEvCrA"));

        File file = new File("/home/bartek/Desktop/LearningJava/Bykowski/Photo Hosting App/ImagesForExcercise/beach-boat.jpg");
        Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
    }

}
