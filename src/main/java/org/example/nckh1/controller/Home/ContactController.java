package org.example.nckh1.controller.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send")
    public String sendContactEmail(@RequestParam("name") String name,
                                   @RequestParam("email") String email,
                                   @RequestParam("message") String message,
                                   Model model) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo("farmer365421@gmail.com");
            mailMessage.setSubject("Phản hồi từ người dùng: " + name);
            mailMessage.setText("Tên: " + name + "\nEmail: " + email + "\n\nNội dung: " + message);

            mailSender.send(mailMessage);
            model.addAttribute("successMessage", "Tin nhắn đã được gửi thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Có lỗi xảy ra khi gửi tin nhắn. Vui lòng thử lại sau.");
        }
        return "contact";
    }
}
