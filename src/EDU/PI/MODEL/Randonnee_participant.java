/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDU.PI.MODEL;

/**
 *
 * @author mokhtar
 */
public class Randonnee_participant {
    
    private Profil profil;
    private Randonnee randonnee;

    public Randonnee_participant() {
    }

    public Randonnee_participant(Profil profil, Randonnee randonnee) {
        this.profil = profil;
        this.randonnee = randonnee;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Randonnee getRandonnee() {
        return randonnee;
    }

    public void setRandonnee(Randonnee randonnee) {
        this.randonnee = randonnee;
    }

    @Override
    public String toString() {
        return "Randonnee_participant{" + "profil=" + profil.toString() + ", randonnee=" + randonnee.toString() + '}';
    }

    
    
    
}
