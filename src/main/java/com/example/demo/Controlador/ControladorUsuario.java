package com.example.demo.Controlador;

import com.example.demo.Entidad.Usuario;
import com.example.demo.Servicio.ServicioEstudiante;
import com.example.demo.Servicio.usuarioServicio;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class ControladorUsuario {

    usuarioServicio userServicio;
    ServicioEstudiante estServicio;

    public ControladorUsuario(ServicioEstudiante estServicio, usuarioServicio userServicio) {
        this.userServicio = userServicio;
        this.estServicio = estServicio;
    }

    @GetMapping("/user")
    public Usuario usuario(@AuthenticationPrincipal OidcUser principal) {
            System.out.println(principal.getClaims());
            String email = (String) principal.getClaims().get("email");
            Usuario user = this.userServicio.buscarEmail(email);
            return user;

    }



  /*  @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        // Realiza la revocación del token de acceso en Auth0
        // ...

        // Invalida la sesión y redirige a la página de inicio o donde quieras
        request.getSession().invalidate();
        return "redirect:/index";
    }*/
}
