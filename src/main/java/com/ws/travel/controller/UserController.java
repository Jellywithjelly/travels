package com.ws.travel.controller;

import com.ws.travel.utils.CreateImageCode;
import com.ws.travel.utils.ValidateImageCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName:
 * @Description:
 * @Author: ws
 * @Date: create in 17:08 2020/6/10 0010
 * @Modifycd By:
 */
@Controller
@RequestMapping("/user")
@CrossOrigin // 允许跨域
public class UserController {

    @GetMapping("/getImage")
    public void getImgage(HttpServletResponse response, HttpSession session) throws IOException {
        /*//获取验证码
        String code = ValidateImageCodeUtils.getSecurityCode();
        // 验证码存入session
        session.setAttribute("code",code);
        //生成图片
        BufferedImage image = ValidateImageCodeUtils.createImage(code);
        //响应浏览器 设置响应类型
        response.setContentType("image/png");
        ImageIO.write(image,"png",response.getOutputStream());*/

        CreateImageCode createImageCode = new CreateImageCode();
         //获取验证码
        String code = createImageCode.getCode();
        // 验证码存入session
        session.setAttribute("code",code);
        //生成图片
        BufferedImage image = createImageCode.getBuffImg();
        //响应浏览器 设置响应类型
        response.setContentType("image/png");
        ImageIO.write(image,"png",response.getOutputStream());

    }


}
