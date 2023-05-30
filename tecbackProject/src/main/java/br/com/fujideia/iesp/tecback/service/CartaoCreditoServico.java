package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.CartaoCredito;
import br.com.fujideia.iesp.tecback.repository.CartaoCreditoRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CartaoCreditoServico {

    @Autowired
    private CartaoCreditoRepository repository;

    public CartaoCredito salvar(CartaoCredito cartaoCredito){
        cartaoCredito = repository.save(cartaoCredito);
        return cartaoCredito;
    }

    public CartaoCredito alterar(CartaoCredito cartaoCredito){
        if (Objects.nonNull(cartaoCredito.getId())){
            cartaoCredito = repository.save(cartaoCredito);
        } else {
            throw new NotFoundException();
        }
        return cartaoCredito;
    }

    public List<CartaoCredito> listar(){
        return repository.findAll();
    }

    public Boolean excluir(Integer id){
        try {
            repository.deleteById(id);
        } catch (Exception e){
            log.info("Erro ao realizar Exclusão: {}", e);
            return false;
        }
        return true;
    }

    public CartaoCredito consultarPorId(Integer id){
        return repository
                .findById(id)
                .orElseThrow(NotFoundException::new);
    }
}
