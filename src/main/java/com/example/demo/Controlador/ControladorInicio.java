package com.example.demo.Controlador;

import com.example.demo.Entidad.Usuario;
import com.example.demo.Servicio.ServicioEstudiante;
import com.example.demo.Servicio.usuarioServicio;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControladorInicio {

    usuarioServicio userServicio;
    ServicioEstudiante estServicio;

    public ControladorInicio(ServicioEstudiante estServicio,usuarioServicio userServicio) {
        this.userServicio = userServicio;
        this.estServicio = estServicio;
    }

    @GetMapping("/inicio") //Ruta Raiz
    public String index(Model model, @AuthenticationPrincipal OidcUser principal) {

        if (principal != null) {
            System.out.println(principal.getClaims());
            //Usuario user = this.userServicio.getCrearUsuario(principal.getClaims().get("email")); //trae el correo de auth0
            Usuario user = this.userServicio.getCrearUsuario(principal.getClaims());
            model.addAttribute("user",user);
            if(user.getRol().equals("Estudiante")){ //Consultar que rol es y redirige a la interfaz de ese usuario
                return "redirect:/GestionLibros.html";
            }else{
                return "redirect:/GestionPrestamos.html";
            }
        }
        else{
            return "redirect:/";
        }
            //System.out.println(principal.getClaims());//Trae informacion del usuario de inicio de sesio

    }
}
