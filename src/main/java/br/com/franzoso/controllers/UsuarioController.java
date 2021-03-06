package br.com.franzoso.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.franzoso.dao.UsuarioDao;
import br.com.franzoso.model.Usuario;
import br.com.franzoso.service.ServiceUsuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioRepositorio;
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		return mv;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/index");
		//mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@GetMapping("/indexlog")
	public ModelAndView indexlog() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/log");
		//mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView cadastrar() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		mv.setViewName("Login/cadastro");
		return mv;
	}
	
	@PostMapping("salvarUsuario")
	public ModelAndView cadastrar(Usuario usuario) throws Exception {
		ModelAndView mv = new ModelAndView();
		//serviceUsuario.salvarUsuario(usuario);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView logou() {
		return indexlog();
		}
	/*
	public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", new Usuario());
		if(br.hasErrors()) {
			mv.setViewName("Login/login");
		}
		 Usuario userLogin = serviceUsuario.loginUser(usuario.getUser(), Util.md5(usuario.getSenha()));
		Usuario userLogin = serviceUsuario.loginUser(usuario.getUser(), usuario.getSenha());
		/*if(userLogin == null) {
			mv.addObject("msg", "Usu??rio n??o encontrado. Tente novamente!");
		}else {
			session.setAttribute("usuarioLogado", userLogin);
			return index();
		}
		mv.addObject("nome", usuario.getUser());
		session.setAttribute("usuarioLogado", userLogin);
		return indexlog();
		*/
	
	
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return login();
	}
	/*
	@PostMapping("/index")
	public ModelAndView back() {
		return index();
	}*/
}
