package br.senac.go.resources;

import br.senac.go.domain.Pessoa;
import br.senac.go.domain.PessoaFisica;
import br.senac.go.generics.GenericOperationsResource;
import br.senac.go.services.PessoaFisicaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/pessoafisica")
@Api(value = "Operações para manipulação dos dados de pessoa física",
        tags = "pessoafisica ")
public class PessoaFisicaResource implements
        GenericOperationsResource<PessoaFisica, Integer> {

    private static final Logger LOGGER = Logger.getLogger(PessoaFisicaResource.class.getName());

    private PessoaFisicaService pessoaFisicaService;

    /**
     * Quando a pessoa for mandar um post, a aplicação
     * recebe uma entidade(E) e retorna a entidade (e) com o campo
     * id preenchido
     *
     * @param entity
     * @return
     */
    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
            "application/xml;charset=UTF-8"},
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value = "${resource.pessoafisica-post}",
            notes = "Criar dados de pessoa física.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Requisição feita com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Pessoa.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo."),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Pessoa.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Pessoa.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Pessoa.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Pessoa.class)
    })
    public PessoaFisica post(@RequestBody @Validated PessoaFisica entity) {
        LOGGER.log(Level.INFO, "PessoaFisica.post inicado {} ", entity);

        PessoaFisica pessoaFisicaPersitida = this.pessoaFisicaService.create(entity);

        LOGGER.log(Level.INFO, "PessoaResource.post concluído {} ", pessoaFisicaPersitida);

        return pessoaFisicaPersitida;
    }

    /**
     * Retorna uma lista de entidades
     *
     * @return
     */
    @Override
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public List<PessoaFisica> get() {
        LOGGER.log(Level.INFO, "Exemplo do GET:");
        return null;
    }


    /**
     * Atualiza TODO o registro
     *
     * @param entity
     * @param id
     */
    @Override
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void put(@RequestBody @Validated PessoaFisica entity,
                    @PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do PUT: %s | %d", entity, id));

        this.pessoaFisicaService.updatePut(entity, id);
    }

    /**
     * Atualiza parcialmente um registro
     *
     * @param entity
     * @param id
     */
    @Override
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void patch(@RequestBody @Validated PessoaFisica entity,
                      @PathVariable("id") Integer id) throws Exception {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do PATCH: %s | %d", entity, id));
        this.pessoaFisicaService.updatePatch(entity, id);
    }

    /**
     * Deleta um registro no banco;
     *
     * @param entity
     */
    @Override
    @DeleteMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@RequestBody @Validated PessoaFisica entity) {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do DELETE: %s", entity));
    }

    /**
     * Deleta um registro no banco pelo identificador
     *
     * @param id
     */
    @Override
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do DELETE: %d", id));
    }
}

