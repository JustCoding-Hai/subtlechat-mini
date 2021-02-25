package top.javahai.chatroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import top.javahai.chatroom.entity.GroupMsgContent;
import top.javahai.chatroom.entity.RespBean;

import java.util.Date;

/**
 * 邮箱服务控制器
 * @author Hai
 * @date 2020/6/29 - 18:42
 */
@RestController
@RequestMapping("/mail")
public class MailController {

  @Autowired
  JavaMailSender javaMailSender;
  /**
   * 发送反馈消息给系统管理员
   * @param msg
   * @return
   */
  @PostMapping("/feedback")
  public RespBean sendFeedbackToMail(@RequestBody GroupMsgContent msg){
    SimpleMailMessage message = new SimpleMailMessage();
    message.setSubject("来自用户的意见反馈");
    //读取信息
    StringBuilder formatMessage = new StringBuilder();
    formatMessage.append("用户编号："+msg.getFromId()+"\n");
    formatMessage.append("用户昵称："+msg.getFromName()+"\n");
    formatMessage.append("反馈内容："+msg.getContent());
    System.out.println(">>>>>>>>>>>>>>"+formatMessage+"<<<<<<<<<<<<<<<<<<");
    //设置邮件消息
    message.setText(formatMessage.toString());
    message.setFrom("1258398543@qq.com");
    message.setTo("jinhaihuang824@aliyun.com");
    message.setSentDate(new Date());
    try {
      javaMailSender.send(message);
      return RespBean.ok("邮件发送成功！感谢你的反馈~");
    }catch (Exception e){
      return RespBean.error("系统异常，请稍后重试！");
    }
  }
}
