package com.inno.ilyadmt.youknownothingjs.Models;

import java.util.ArrayList;

/**
 * Created by mjazz on 21.07.2017.
 */

public class CharacterDAO {
    private String url;
    private String name;
    private String culture;
    private String born;
    private String died;
    private ArrayList<String> titles;
    private ArrayList<String> aliases;
    private String father;

    public CharacterDAO(String url, String name) {
        this.url = url;
        this.name = name;
    }

    private String mother;
    private String playedBy;

    public CharacterDAO(String url) {
        this.url = url;
    }

    public CharacterDAO(String url, String name, String culture, String born, String died, ArrayList<String> titles, ArrayList<String> aliases, String father, String mother, String playedBy) {
        this.url = url;
        this.name = name;
        this.culture = culture;
        this.born = born;
        this.died = died;
        this.titles = titles;
        this.aliases = aliases;
        this.father = father;
        this.mother = mother;
        this.playedBy = playedBy;
    }

    public CharacterDAO(String url, String name, String culture, String born, String died, ArrayList<String> titles, ArrayList<String> aliases) {

        if(name.equals("")) name = "Unknown";
        if(born.equals("")) born = "Unknown";
        if(died.equals("")) died = "Unknown";
        if(culture.equals("")) culture = "Unknown";

        this.url = url;
        this.name = name;
        this.culture = culture;
        this.born = born;
        this.died = died;
        this.titles = titles;
        this.aliases = aliases;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public void setDied(String died) {
        this.died = died;
    }


    public void setFather(String father) {
        this.father = father;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public void setPlayedBy(String playedBy) {
        this.playedBy = playedBy;
    }

    public String getUrl() {

        return url;
    }

    public String getName() {
        return name;
    }

    public String getCulture() {
        return culture;
    }

    public String getBorn() {
        return born;
    }

    public String getDied() {
        return died;
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    public void setAliases(ArrayList<String> aliases) {
        this.aliases = aliases;
    }

    public ArrayList<String> getTitles() {

        return titles;
    }

    public ArrayList<String> getAliases() {
        return aliases;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String getPlayedBy() {
        return playedBy;
    }
}
