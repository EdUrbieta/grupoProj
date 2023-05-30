package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_CartaoCredito")
public class CartaoCredito implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String numCartao;

    private String nomeTitular;

    private String codSeguranca;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalDate valCartao;
}
