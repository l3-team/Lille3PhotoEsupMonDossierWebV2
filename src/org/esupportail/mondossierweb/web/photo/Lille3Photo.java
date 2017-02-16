package org.esupportail.mondossierweb.web.photo;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;

import java.io.*;
import java.net.*;

public class Lille3Photo implements IPhoto {
    /**
      * Un logger.
      */
    private static final Logger LOG = new LoggerImpl(Lille3Photo.class);
    /**
     * Une URL
     */
    private String photoUrl = "https://refphotos.univ.fr/";

    private String imageurl = "";
    private String tokenurl = "";

    /**
     * Retourne l'url pour la photo de l'individu dont le cod_ind est plac� en param�tre.
     * @param cod_ind
     * @param cod_etu
     * @return l'url pour r�cup�rer la photo.
     *
     */
    public Lille3Photo() {}

    public String getImageurl() {
        return this.imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTokenurl() {
        return this.tokenurl;
    }

    public void setTokenurl(String tokenurl) {
        this.tokenurl = tokenurl;
    }


    public String getUrlPhoto(String cod_ind, String cod_etu) {

        //String tokenUrl = this.photoUrl + "token/add/E" + cod_ind;
        String tokenUrl = this.tokenurl + cod_etu;
        String token = "";
        try {
                token = this.queryUrl(new URL(tokenUrl));
        } catch(Exception e) {
                token = "";
                LOG.error(e);
        }

        //return this.photoUrl + "image/" + token;
        return this.imageurl + token;
    }

    /**
     * retourne l'url pour la photo de l'individu dont le cod_ind est plac� en param�tre.
     * Avec une url pour le serveur et non pour l'affichage � l'�cran, pour le client.
     * @param cod_ind
     * @param cod_etu
     * @return l'url pour r�cup�rer la photo
     */
    public String getUrlPhotoTrombinoscopePdf(String cod_ind, String cod_etu) {
        return this.getUrlPhoto(cod_ind, cod_etu);
    }

    private String queryUrl(URL url) {

        try {
                StringBuilder result = new StringBuilder();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
                rd.close();
                return result.toString();
        } catch(Exception e) {
                LOG.error(e);
                return "";
        }
    }

}
