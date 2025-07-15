package br.edu.ifpr.foz.locacao_vhs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpr.foz.locacao_vhs.models.VHS;
import br.edu.ifpr.foz.locacao_vhs.repositories.VHSRepository;
import br.edu.ifpr.foz.locacao_vhs.TapeStatus;

@Service
public class VHSService {

    @Autowired
    private VHSRepository vhsRepository;

    public List<VHS> findAll() {
        return vhsRepository.findAll();
    }

    public VHS findById(Long id) {
        return vhsRepository.findById(id).orElse(null);
    }

    public void save(VHS vhs) {
        vhsRepository.save(vhs);
    }

    public void deleteById(Long id) {
        vhsRepository.deleteById(id);
    }

    public void alterarStatus(Long id, String novoStatus) {
        VHS vhs = findById(id);
        if (vhs != null) {
            vhs.setStatus(TapeStatus.valueOf(novoStatus.toUpperCase()));
            vhsRepository.save(vhs);
        }
    }
}
