package distributed.mall.common.utils.email;

import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <b><code>EmailUtil</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/10/28 15:47.
 *
 * @author xxx
 * @since dubbomall ${PROJECT_VERSION}
 */
public class EmailUtil {
    private static final Logger logger = LoggerFactory.getLogger(EmailUtil.class);

    private static final String EMAIL_FROM = "3315665065@qq.com";
    private static final String HOST = "smtp.qq.com";
    //授权码，在第三方软件登录时的密码登录    zdwphlqvxcmscjgg
    private static final String PASSWORD = "zdwphlqvxcmscjgg";
    private static ExecutorService executorService = Executors.newFixedThreadPool(20);


    public static void sendActiveUserCode(final String emailTo, final String code) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                activeUserCode(emailTo, code);
            }
        });
//        //判断线程池中的所有线程是否都执行完了，防止中途因为主线程退出而终止放邮件的线程
//        executorService.shutdown();
//        while(!executorService.isTerminated()){
//
//        }
    }

    private static void activeUserCode(String emailTo, String code) {
        logger.info("正在发送用户注册激活码到邮箱" + emailTo);
        Properties properties = System.getProperties();// 获取系统属性

        properties.setProperty("mail.smtp.host", HOST);// 设置邮件服务器
        properties.setProperty("mail.smtp.auth", "true");// 打开认证

        try {
//                QQ邮箱需要下面这段代码，163邮箱不需要
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);


            // 1.获取默认session对象
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(EMAIL_FROM, PASSWORD); // 发件人邮箱账号、授权码
                }
            });

            // 2.创建邮件对象
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(EMAIL_FROM));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            // 2.3设置邮件主题
            message.setSubject("DubboMall商城账号激活");
            // 2.4设置邮件内容
            String content = "<html><head></head><body><h3>DubboMall商城欢迎您,激活用户请点击以下链接</h3><h5><a href='http://127.0.0.1:8080/sso/activeUser?activeUserCode="
                    + code + "'>点击激活账户" + "</a></h5></body></html>";
            message.setContent(content, "text/html;charset=UTF-8");
            // 3.发送邮件
            Transport.send(message);
            logger.info("发送用户注册激活码到邮箱" + emailTo + "完成");
        } catch (Exception e) {
            logger.error("发送邮件到" + emailTo + "失败", e);
        }
    }

    public static void main(String[] args) {
//        EmailUtil.sendActiveUserCode("1372348027@qq.com","455454555");
        EmailUtil.activeUserCode("1372348027@qq.com", "455454555");
    }
}
