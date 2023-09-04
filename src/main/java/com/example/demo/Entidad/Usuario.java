package com.example.demo.Entidad;

import javax.persistence.*;


@Entity
@Table(name="usuarios")
public class Usuario {

@Id
private String email;

@Column(name="nick", unique = true)
private String nick;

@Column(name="img")
private String img;

@Column(name="auth_id", unique = true)
private String auth_id;

@Column(name="rol")
private String rol;

    public Usuario() {
    }

    public Usuario(String email, String nick, String img, String auth_id, String rol) {
        this.email = email;
        this.nick = nick;
        this.img = img;
        this.auth_id = auth_id;
        this.rol=rol;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(String auth_id) {
        this.auth_id = auth_id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
