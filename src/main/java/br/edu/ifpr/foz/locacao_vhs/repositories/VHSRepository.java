package br.edu.ifpr.foz.locacao_vhs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpr.foz.locacao_vhs.models.VHS;

@Repository
public interface VHSRepository extends JpaRepository<VHS, Long> {
}
