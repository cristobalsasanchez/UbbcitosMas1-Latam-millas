package com.latam.millas.Model;

import javax.validation.constraints.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class InputRequest {


    //solo letraaas
    @NotNull
    @Size(min=6, max=6)
    private String pnr;

    @NotNull
    @Size(max=45)
    @Email
    private String user_email;

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    @Override
    public String toString() {
        return "InputRequest{" +
                "pnr='" + pnr + '\'' +
                ", user_email='" + user_email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputRequest that = (InputRequest) o;
        return Objects.equals(pnr, that.pnr) && Objects.equals(user_email, that.user_email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pnr, user_email);
    }

    /*
    //  Patrón para validar el email
        Pattern pat = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");

        // El email a validar
        String email = "cristobalsanchez@gmail.com";

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
        } else {
            System.out.println("El email ingresado es inválido.");
        }
     */
}
