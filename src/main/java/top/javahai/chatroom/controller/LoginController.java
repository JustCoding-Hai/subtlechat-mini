package top.javahai.chatroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.javahai.chatroom.config.VerificationCode;
import top.javahai.chatroom.entity.RespBean;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * @author Hai
 * @date 2020/6/16 - 17:33
 */
@RestController
public class LoginController {
  /**
   * 获取验证码图片写到响应的输出流中，保存验证码到session
   * @param response
   * @param session
   * @throws IOException
   */
  @GetMapping("/verifyCode")
  public void getVerifyCode(HttpServletResponse response, HttpSession session) throws IOException {
    VerificationCode code = new VerificationCode();
    BufferedImage image = code.getImage();
    String text = code.getText();
    session.setAttribute("verify_code",text);
    VerificationCode.output(image,response.getOutputStream());
  }

//  @Autowired
//  JavaMailSender javaMailSender;
//  /**
//   * 获取邮箱验证码，并保存到本次会话
//   * @param session
//   */
//  @GetMapping("/admin/mailVerifyCode")
//  public RespBean getMailVerifyCode(HttpSession session){
//    //获取随机的四个数字
//    StringBuilder code=new StringBuilder();
//    for (int i = 0; i <4; i++) {
//      code.append(new Random().nextInt(10));
//    }
//   //邮件内容
//    SimpleMailMessage msg = new SimpleMailMessage();
//    msg.setSubject("微言聊天室管理端验证码验证");
//    msg.setText("本次登录的验证码："+code);
//    msg.setFrom("发送者的邮箱地址");
//    msg.setSentDate(new Date());
//    msg.setTo("接受者的邮箱地址");
//    //保存验证码到本次会话
//    session.setAttribute("mail_verify_code",code.toString());
//    //发送到邮箱
//    try {
//      javaMailSender.send(msg);
//      return RespBean.ok("验证码已发送到邮箱，请注意查看！");
//    }catch (Exception e){
//      e.printStackTrace();
//      return RespBean.error("服务器出错啦！请稍后重试！");
//    }
//  }
}
