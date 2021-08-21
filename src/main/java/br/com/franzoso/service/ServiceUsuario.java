package br.com.franzoso.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.franzoso.Exceptions.CriptoExistException;
import br.com.franzoso.Exceptions.EmailExistsException;
import br.com.franzoso.dao.UsuarioDao;
import br.com.franzoso.model.Usuario;
import br.com.franzoso.util.Util;

@Service
public class ServiceUsuario {

	@Autowired
	private UsuarioDao repositorioUsuario;

	public void salvarUsuario(Usuario user) throws Exception {

		try {

			if (repositorioUsuario.findByEmail(user.getEmail()) != null) {
				throw new EmailExistsException("Já existe um email cadastrado para: " + user.getEmail());
			}

			user.setSenha(Util.md5(user.getSenha()));

		} catch (NoSuchAlgorithmException e) {
			throw new CriptoExistException("Error na criptografia da senha");
		}
		repositorioUsuario.save(user);
	}

	public Usuario loginUser(String user, String senha) throws ServiceExc{
		Usuario userLogin = repositorioUsuario.buscarLogin(user, senha);
		return userLogin;
	}

}
