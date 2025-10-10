package br.com.aulas;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class StatusControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testStatusGetOk() throws Exception{
        MvcResult resultado = mockMvc.perform(
                MockMvcRequestBuilders.get("/status?nome=Felipe")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andReturn();

        String mensagemFinal = "Bem vindo, Felipe !";
        String textoResultado = resultado.getResponse().getContentAsString();

        assert(mensagemFinal.equals(textoResultado));
    }

    @Test
    public void testStatusGetSemParametros() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/status")
        ).andExpect(
                MockMvcResultMatchers.status().is(400)
        );
    }

    @Test
    public void testStatusPostOk() throws Exception{
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Felipe");

        String contentJson = new Gson().toJson(pessoa);

        MvcResult resultado = mockMvc.perform(
                MockMvcRequestBuilders.post("/status")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(contentJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andReturn();

        String mensagemFinal = "Servidor Funcionando! Requisição POST Ola Felipe";
        String textoResultado = resultado.getResponse().getContentAsString();

        assert(mensagemFinal.equals(textoResultado));
    }

    @Test
    public void testStatusPostSemParametros() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.post("/status")
        ).andExpect(
                MockMvcResultMatchers.status().is(400)
        );
    }

    @Test
    public void testStatusPuttOk() throws Exception{
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Felipe");

        String contentJson = new Gson().toJson(pessoa);

        MvcResult resultado = mockMvc.perform(
                MockMvcRequestBuilders.put("/status")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(contentJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andReturn();

        String mensagemFinal = "Servidor Funcionando! Requisição PUT Ola Felipe";
        String textoResultado = resultado.getResponse().getContentAsString();

        assert(mensagemFinal.equals(textoResultado));
    }

    @Test
    public void testStatusPutSemParametros() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.put("/status")
        ).andExpect(
                MockMvcResultMatchers.status().is(400)
        );
    }

    @Test
    public void testStatusDeleteOk() throws Exception{
        MvcResult resultado = mockMvc.perform(
                MockMvcRequestBuilders.delete("/status/Felipe")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andReturn();

        String mensagemFinal = "Usuario deletado, Felipe!";
        String textoResultado = resultado.getResponse().getContentAsString();

        assert(mensagemFinal.equals(textoResultado));
    }

    @Test
    public void testStatusDeleteSemParametros() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.post("/status")
        ).andExpect(
                MockMvcResultMatchers.status().is(400)
        );
    }



}
