package com.test.fitness.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.fitness.model.Peserta;
import com.test.fitness.repository.PesertaRepository;

@Service
public class PesertaService implements UserDetailsService {
    @Autowired
    private PesertaRepository pesertaRepository;

    public Peserta findByEmail(String email) {
        return pesertaRepository.findByEmail(email);
    }

    public Peserta addPeserta(Peserta peserta) {
        return pesertaRepository.save(peserta);
    }

    public Peserta findByUserName(String username) {
        return pesertaRepository.findByUserName(username);
    }

    public Peserta savePeserta(Peserta peserta) {
        return pesertaRepository.save(peserta);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Peserta peserta = pesertaRepository.findByUserName(username);
        if (peserta == null) {
            throw new UsernameNotFoundException("Invalid email atau password");
        }

        return new User(peserta.getEmail(), peserta.getPassword(), new ArrayList<>());

    }
}
