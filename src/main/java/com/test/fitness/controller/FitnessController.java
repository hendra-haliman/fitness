package com.test.fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.fitness.model.Peserta;
import com.test.fitness.service.PesertaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class FitnessController {
    @Autowired
    private PesertaService pesertaService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/showLoginPage")
    public String showLogin() {
        return "login";
    }

    // @PostMapping("/authenticateUser")
    // public String authenticateUser() {
    // // TODO: process POST request

    // return "test";
    // }

    @GetMapping("/register")
    public String showRegister(Model model) {
        Peserta peserta = new Peserta();
        model.addAttribute("peserta", peserta);

        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@Valid @ModelAttribute("kendaraan") Peserta peserta, BindingResult errors,
            RedirectAttributes redirectAttributes, @RequestParam(value = "action", required = true) String action,
            Model model) {
        if (errors.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", "FAILED");
            return "register";
        }

        Peserta savedPeserta = pesertaService.findByEmail(peserta.getEmail());
        if (savedPeserta != null) {
            redirectAttributes.addFlashAttribute("message", "EMAIL_EXISTS");
            model.addAttribute("peserta", peserta);
            return "redirect:register";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        peserta.setPassword(encoder.encode(peserta.getPassword()));
        pesertaService.addPeserta(peserta);
        redirectAttributes.addFlashAttribute("message", "SUCCESS");
        return "redirect:register";
    }

    @GetMapping("/forgotPassword")
    public String showForgotPassword() {
        return "forgot_password";
    }

}
