package top.javahai.chatroom;

import com.github.binarywang.java.emoji.EmojiConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@SpringBootTest
class ChatroomApplicationTests {

  //测试密码加密
  @Test
  void contextLoads() {
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    String encode = encoder.encode("123");
    System.out.println(encode);
  }

  @Test
  void test01(){
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(simpleDateFormat.format(new Date()));
    System.out.println(new Date());
  }
  //测试emoji的转码
  @Test
void test02(){
    EmojiConverter emojiConverter = EmojiConverter.getInstance();
    String str="\uE423 \uE424 \uE425An ??awesome ??string with a few ??emojis!";
    String html = emojiConverter.toHtml(str);
    System.out.println(html);
}
  @Autowired
  JavaMailSender javaMailSender;
  //测试邮件发送
@Test
   void test03(){
    SimpleMailMessage msg=new SimpleMailMessage();
    //邮件的主题
    msg.setSubject("这是测试邮件主题");
    //邮件的内容
    msg.setText("这是测试邮件内容:\nsecond try");
    //邮件的发送方，对应配置文件中的spring.mail.username
    msg.setFrom("1258398543@qq.com");
    //邮件发送时间
    msg.setSentDate(new Date());
    //邮件接收方
    msg.setTo("jinhaihuang824@aliyun.com");
    //执行发送
    javaMailSender.send(msg);
}
//测试生成四个随机数
  @Test
  void test04(){
    Random random = new Random();
    StringBuilder code=new StringBuilder();
    for (int i = 0; i < 4; i++) {
      int num = random.nextInt(10);
      code.append(num);
    }
    System.out.println(code);
  }
}
