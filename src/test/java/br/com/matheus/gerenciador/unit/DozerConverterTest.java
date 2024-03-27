package br.com.matheus.gerenciador.unit;

import br.com.matheus.gerenciador.data.vo.v1.UsuarioVO;
import br.com.matheus.gerenciador.domain.model.Usuario;
import br.com.matheus.gerenciador.mapper.Mapeador;
import br.com.matheus.gerenciador.mapper.mocks.UsuarioMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DozerConverterTest {
    
    UsuarioMock inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new UsuarioMock();
    }

    @Test
    public void parseEntityToVOTest() {
        UsuarioVO VO = Mapeador.parseObject(inputObject.mockEntity(), UsuarioVO.class);
        assertEquals(LocalDate.of(2000, 1, 1), VO.getDataNascimento());
        assertEquals(Long.valueOf(0L), VO.getKey());
        assertEquals("Nome Test 0", VO.getNome());
        assertEquals("Email Test 0", VO.getEmail());
        assertEquals("Senha Test 0", VO.getSenha());
        assertEquals("Username Test 0", VO.getUsername());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<UsuarioVO> VOList  = Mapeador.parseListObjects(inputObject.mockEntityList(), UsuarioVO.class);
        UsuarioVO VOZero = VOList.get(0);

        assertEquals(LocalDate.of(2000, 1, 1), VOZero.getDataNascimento());
        assertEquals("Nome Test 0", VOZero.getNome());
        assertEquals("Email Test 0", VOZero.getEmail());
        assertEquals("Senha Test 0", VOZero.getSenha());
        assertEquals("Username Test 0", VOZero.getUsername());
        
        UsuarioVO VOSeven = VOList.get(7);

        assertEquals(LocalDate.of(2000, 1, 1), VOSeven.getDataNascimento());
        assertEquals("Nome Test 7", VOSeven.getNome());
        assertEquals("Email Test 7", VOSeven.getEmail());
        assertEquals("Senha Test 7", VOSeven.getSenha());
        assertEquals("Username Test 7", VOSeven.getUsername());
        
        UsuarioVO VOTen = VOList.get(10);

        assertEquals(LocalDate.of(2000, 1, 1), VOTen.getDataNascimento());
        assertEquals("Nome Test 10", VOTen.getNome());
        assertEquals("Email Test 10", VOTen.getEmail());
        assertEquals("Senha Test 10", VOTen.getSenha());
        assertEquals("Username Test 10", VOTen.getUsername());
    }

    @Test
    public void parseVOToEntityTest() {
        Usuario usuario = Mapeador.parseObject(inputObject.mockVO(), Usuario.class);
        assertEquals(LocalDate.of(2000, 1, 1), usuario.getDataNascimento());
        assertEquals("Nome Test 0", usuario.getNome());
        assertEquals("Email Test 0", usuario.getEmail());
        assertEquals("Senha Test 0", usuario.getSenha());
        assertEquals("Username Test 0", usuario.getUsername());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Usuario> ListUsuario = Mapeador.parseListObjects(inputObject.mockVOList(), Usuario.class);
        Usuario UsuarioZero = ListUsuario.get(0);

        assertEquals(LocalDate.of(2000, 1, 1), UsuarioZero.getDataNascimento());
        assertEquals("Nome Test 0", UsuarioZero.getNome());
        assertEquals("Email Test 0", UsuarioZero.getEmail());
        assertEquals("Senha Test 0", UsuarioZero.getSenha());
        assertEquals("Username Test 0", UsuarioZero.getUsername());

        Usuario UsuarioSeven = ListUsuario.get(7);

        assertEquals(LocalDate.of(2000, 1, 1), UsuarioSeven.getDataNascimento());
        assertEquals("Nome Test 7", UsuarioSeven.getNome());
        assertEquals("Email Test 7", UsuarioSeven.getEmail());
        assertEquals("Senha Test 7", UsuarioSeven.getSenha());
        assertEquals("Username Test 7", UsuarioSeven.getUsername());

        Usuario UsuarioTen = ListUsuario.get(10);

        assertEquals(LocalDate.of(2000, 1, 1), UsuarioTen.getDataNascimento());
        assertEquals("Nome Test 10", UsuarioTen.getNome());
        assertEquals("Email Test 10", UsuarioTen.getEmail());
        assertEquals("Senha Test 10", UsuarioTen.getSenha());
        assertEquals("Username Test 10", UsuarioTen.getUsername());
    }
}
