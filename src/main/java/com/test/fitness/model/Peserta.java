package com.test.fitness.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Peserta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "email")
    private String email;

    @Column(name = "passwd")
    private String password;

    @Column(name = "nohp")
    private String noHP;

    // @Column(name = "kartu_kredit")
    // private KartuKredit kartuKredit;

    // @Enumerated(EnumType.STRING)
    // private Status status;
    @Column(name = "tervalidasi")
    private Boolean tervalidasi;

    @Column(name = "otp")
    private int otp;

    @Column(name = "nomor_kartu")
    private String nomorKartu;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "expiry_date")
    private String expiryDate;

    @Column(name = "nama_pemegang_kartu")
    private String namaPemegangKartu;

    public String getUserName() {
        return email;
    }
}
