package com.produtosbackend.Resources;

import com.produtosbackend.Models.Produto;
import com.produtosbackend.Repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
public class ProdutoResource {
    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value="Retorna uma lista de Produtos")
    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @ApiOperation(value="Retorna um produto unico")
    @GetMapping("/produto/{id}")
    public Produto listaProdutoUnico(@PathVariable(value="id") long id){
        return produtoRepository.findById(id);
    }

    @ApiOperation(value="Salva um produto")
    @PostMapping("/produto")
    public Produto salvaProduto(@RequestBody @Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    @ApiOperation(value="Deleta um produto")
    @DeleteMapping("/produto")
    public void deletaProduto(@RequestBody @Valid Produto produto) {
        produtoRepository.delete(produto);
    }

    @ApiOperation(value="Atualiza um produto")
    @PutMapping("/produto")
    public Produto atualizaProduto(@RequestBody @Valid Produto produto) {
        return produtoRepository.save(produto);
    }
}
