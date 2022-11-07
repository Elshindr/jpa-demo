package fr.diginamic.recensement.entites;

/**
 * The enum Categorie.
 */
public enum Categorie {

    /**
     * Moyen categorie.
     */
    MOYEN("Moyen"),
    /**
     * Petit categorie.
     */
    PETIT("Petit"),
    /**
     * Grand categorie.
     */
    GRAND("Grand");

    private String taille;

    Categorie(String taille) {
        this.taille = taille;
    }

    /**
     * Gets taille.
     *
     * @return the taille
     */
    public String getTaille() {
        return taille;
    }

    /**
     * Sets taille.
     *
     * @param taille the taille
     */
    public void setTaille(String taille) {
        this.taille = taille;
    }


}
