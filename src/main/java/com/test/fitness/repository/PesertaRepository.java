package com.test.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.fitness.model.Peserta;

@Repository
public interface PesertaRepository extends JpaRepository<Peserta, Long> {
    @Query("from Peserta where email = ?1")
    public Peserta findByEmail(String email);

    @Query("from Peserta where email = ?1")
    public Peserta findByUserName(String userName);
}
