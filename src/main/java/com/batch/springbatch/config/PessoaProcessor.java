package com.batch.springbatch.config;

import com.batch.springbatch.model.Pessoa;
import org.springframework.batch.item.ItemProcessor;

public class PessoaProcessor implements ItemProcessor<Pessoa, Pessoa> {

    @Override
    public Pessoa process(Pessoa pessoa) throws Exception {
        String formattedTelefone;
        String formattedProfissao;
        if (pessoa.getTelefone().length() == 11) {
            formattedTelefone = pessoa.getTelefone().replaceFirst("(\\d{2})(\\d{5})(\\d+)", "($1)$2-$3");//(55)99001-2233
            pessoa.setTelefone(formattedTelefone);
        }
        formattedProfissao = pessoa.getProfissao();
        formattedProfissao = formattedProfissao.substring(0,1).toUpperCase() + formattedProfissao.substring(1).toLowerCase();
        pessoa.setProfissao(formattedProfissao);
        return pessoa;
    }
}

