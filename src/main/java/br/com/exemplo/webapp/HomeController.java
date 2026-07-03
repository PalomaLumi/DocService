package br.com.exemplo.webapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    private static final String VERSAO = "v2.0";

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titulo", "Projeto Java Web funcionando!");
        model.addAttribute("mensagem", "Deploy realizado com sucesso pelo Jenkins:    MUITO OBRIGA PELA AJUDA PROFESSOR !!!!");
        model.addAttribute("subtitulo", "Spring Boot + Maven + WAR + Apache Tomcat");
        model.addAttribute("aluna", "Paloma Lumi Costa");
        model.addAttribute("versao", VERSAO);
        model.addAttribute("dataHora", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        return "index";
    }

    @GetMapping("/status")
    @ResponseBody
    public String status() {
        return "Aplicacao online - " + VERSAO;
    }
}
