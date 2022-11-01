package com.example.student.utils;

import com.example.student.entity.PictureEntity;
import com.example.student.mapper.PictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Repository
@RestController
@RequestMapping("/picture")
public class Picture {
    @Autowired
    private PictureMapper pictureMapper;

    /**
     *
     * @param file
     * @param attributes
     * @return 上传图片
     * @throws IOException
     */
    @PostMapping("/upload")
    public Object UploadPicture(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {
        System.out.printf("传入的图片",file);
        if (file.isEmpty()){
            return "上传内容为空";
        }
        //上传对应的文件或图片到指定的文件夹
        File savePOs = new File("src/main/resources/static/images");
        if (!savePOs.exists()){   //不存在，则创建该文件夹
            savePOs.mkdir();
        }
        //获取存放位置的规范路径
        String realPath = savePOs.getCanonicalPath();
        File file1 = new File(realPath + "/" + System.currentTimeMillis() + file.getOriginalFilename());
        file.transferTo(file1);
        attributes.addFlashAttribute("message","添加成功！");
        String fileUrl = "file://" + realPath+ "/" + file1.getName();
        //拿到对应的实体类
        PictureEntity pictureEntity = new PictureEntity();
        pictureEntity.setPictureUrl(fileUrl);
        pictureMapper.insert(pictureEntity);
        PictureEntity pictureEntity1 = pictureMapper.selectById(pictureEntity.getId());
        return Result.success(pictureEntity1);
    }
}
