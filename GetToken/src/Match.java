/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ArmandoPC
 */
public class Match {

    private String pattern;
    private int name;

    public Match(String pattern, int name) {
        this.pattern = pattern;
        this.name = name;
    }

    /**
     * @return the name
     */
    public int getName() {
        return name;
    }

    /**
     * @param aName the name to set
     */
    public void setName(int aName) {
        this.name = aName;
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

}
