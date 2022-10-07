package kafka.example.kafkaservice.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@AllArgsConstructor
public class EmailService {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;


    public void send(){
        File file = new File("D:\\proposal.pdf");

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setText("Testing Kafka");
            helper.setTo("youremail@gmail.com");
            helper.setSubject("Test Push Attachment File From Kafka");
            helper.setFrom("youremail@gmail.com");
            helper.addAttachment("proposal1.pdf", file);
            helper.addAttachment("proposal2.pdf", file);
            mailSender.send(mimeMessage);

        }catch (MessagingException e){
            LOGGER.error("failed to send email : " + e);
            throw new IllegalStateException("failed to send email");
        }
    }
}
