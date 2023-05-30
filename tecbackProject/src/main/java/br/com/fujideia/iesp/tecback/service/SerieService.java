package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Serie;
import br.com.fujideia.iesp.tecback.repository.SerieRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public Serie salvar(Serie serie){
        serie = repository.save(serie);
        return serie;
    }

    public Serie alterar(Serie serie){
        if (Objects.nonNull(serie.getId())){
            serie = repository.save(serie);
        } else{
            throw new NotFoundException();
        }
        return serie;
    }

    public List<Serie> listar(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try{
            repository.deleteById(id);
        } catch (Exception e){
            log.info("Erro ao realizar Exclusão : {}", e);
            return false;
        }
        return true;
    }

    public Serie consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }
}
