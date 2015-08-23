/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.nanstec.dao.imp;

import br.com.nanstec.dao.GrupoDao;
import br.com.nanstec.dao.UsuarioDao;
import br.com.nanstec.modelos.Grupo;
import br.com.nanstec.modelos.Usuario;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:**/applicationContext*.xml"})
public class TestUsuarioDao {

    private UsuarioDao usuarioDao;
    private GrupoDao grupoDao;
    private Long id = 3L;
	
    @Autowired
    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }    

    @Autowired
    public void setGrupoDao(GrupoDao grupoDao) {
        this.grupoDao = grupoDao;
    }
    /*
	@Test
	public void testSalvar() {
		Usuario usuario = null;
		usuario = usuarioDao.salvar(getUsuario());
		assertNotNull(usuario);
		assertEquals(id, usuario.getId());
		assertEquals("Teste", usuario.getLogin());
		
	}
	
	@Test
	public void testAtualizar() {
        Usuario usuario = usuarioDao.pesquisarPorId(id);
        usuario.setLogin("Teste 2");

        usuario = usuarioDao.atualizar(usuario);
        assertNotNull(usuario);
        assertEquals("Teste 2", usuario.getLogin());

	}

	private Usuario getUsuario() {
		Usuario usuario = new Usuario();
		usuario.setLogin("Teste");
		return usuario;
	}


	@Test
	public void testTodos() {
		List<Usuario> usuarios = usuarioDao.todos();
		assertNotNull(usuarios);
		assertEquals(1, usuarios.size());
		assertEquals("Teste 2", usuarios.get(0).getLogin());
		
	}
	
	@Test
	public void testListPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		List<Usuario> usuarios =
			usuarioDao.
			listPesqParam("SELECT p FROM Usuario p WHERE p.id=:id", params);
		assertNotNull(usuarios);
		assertEquals(1, usuarios.size());
		assertEquals("Teste 2", usuarios.get(0).getLogin());
		
	}
	
	@Test
	public void testPesqParam() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("id", id);  
		Usuario usuario =
			usuarioDao.
			pesqParam("SELECT p FROM Usuario p WHERE p.id=:id", params);
		assertNotNull(usuario);
		assertEquals("Teste 2", usuario.getLogin());
		
	}	

	@Test
	public void testExcluir() {
		Usuario usuario = usuarioDao.pesquisarPorId(id);
		usuarioDao.excluir(usuario);
		assertNull(usuarioDao.pesquisarPorId(id));
	}
     */
    @Test
	public void testParam() {
		Grupo g1 = new Grupo();
        g1.setNome("administrador");
        g1.setDescricao("Grupo de Administradores");
        Grupo g2 = new Grupo();
        g2.setNome("usuario");
        g2.setDescricao("Grupo de Usuários");
        Usuario u = new Usuario();
        u.setLogin("admin");
        u.setSenha("admin");
        u.setNome("Marcos Gabriel Mendes Lauande");
        u.setEmail("marcoslauande@hotmail.com");
        u.setGrupo(g1);
        grupoDao.salvar(g1);
        grupoDao.salvar(g2);
        usuarioDao.salvar(u);
	}

}