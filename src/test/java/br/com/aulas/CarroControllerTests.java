package br.com.aulas;

import br.com.aulas.entities.CarroEntity;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class CarroControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testRecuperarTodosCarros() throws Exception{
        MvcResult resultado = mockMvc.perform(
                MockMvcRequestBuilders.get("/carros")
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andReturn();
        String textoResultado = resultado.getResponse().getContentAsString();
        Gson gson = new Gson();

        List<CarroEntity> listaCarros = Arrays.asList(gson.fromJson(textoResultado, CarroEntity[].class));

        assert (listaCarros != null);

    }

    @Test
    public void testAdicionarCarroOk() throws Exception{
        CarroEntity carro = new CarroEntity();

        carro.setModelo("Veloster2026");
        carro.setNome("Veloster");
        carro.setAnoFabricacao(2025);
        carro.setAnoModelo(2025);

        String contentJson = new Gson().toJson(carro);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/carros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(contentJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andReturn();

    }

    @Test
    public void testAdicionarCarro500() throws Exception{
        CarroEntity carro = new CarroEntity();

        carro.setId(5L);
        carro.setModelo("Veloster2026");
        carro.setNome("Veloster");
        carro.setAnoFabricacao(2025);
        carro.setAnoModelo(2025);

        String contentJson = new Gson().toJson(carro);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/carros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(contentJson)
        ).andExpect(
                MockMvcResultMatchers.status().is(500)
        ).andReturn();

    }

    @Test
    public void testAdicionarCarroSemCampoOnbrigatorio() throws Exception{
        CarroEntity carro = new CarroEntity();

        carro.setModelo("Veloster2026");
        //carro.setNome("Veloster");
        carro.setAnoFabricacao(2025);
        carro.setAnoModelo(2025);

        String contentJson = new Gson().toJson(carro);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/carros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(contentJson)
        ).andExpect(
                MockMvcResultMatchers.status().is(500)
        ).andReturn();

    }

    @Test
    public void testAtualizarCarroOk() throws Exception{
        CarroEntity carro = new CarroEntity();
        carro.setId(24L);
        carro.setModelo("Veloster2026");
        carro.setNome("Saveiro");
        carro.setAnoFabricacao(2026);
        carro.setAnoModelo(2025);

        String contentJson = new Gson().toJson(carro);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/carros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(contentJson)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        ).andReturn();

    }

    @Test
    public void testApagarCarroOk() throws Exception {
        Integer id = 23;
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/carros/"+id)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );

    }

    @Test
    public void testApagarCarroSemId() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/carros/")
        ).andExpect(
                MockMvcResultMatchers.status().is(404)
        );

    }



}
