package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.CartaoCredito;
import br.com.fujideia.iesp.tecback.service.CartaoCreditoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CartCred")
public class CartaoCreditoController {

    @Autowired
    private CartaoCreditoServico service;

    @PostMapping
    public ResponseEntity<CartaoCredito> salvar(@RequestBody CartaoCredito cartaoCredito){
        cartaoCredito = service.salvar(cartaoCredito);
        return ResponseEntity.ok(cartaoCredito);
    }
    @PutMapping
    public ResponseEntity<CartaoCredito> alterar(@RequestBody CartaoCredito cartaoCredito){
        cartaoCredito = service.salvar(cartaoCredito);
        return ResponseEntity.ok(cartaoCredito);
    }

    @GetMapping
    public ResponseEntity<List<CartaoCredito>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartaoCredito> consultar(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> excluir(@PathVariable("id") Integer id){
        if (service.excluir(id)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
