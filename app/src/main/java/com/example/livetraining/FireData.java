package com.example.livetraining;

import java.io.Serializable;

public class FireData implements Serializable {
    private String weaponName;
    private String whoFire;
    private String whoFired;
    private String damage;

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getWhoFire() {
        return whoFire;
    }

    public void setWhoFire(String whoFire) {
        this.whoFire = whoFire;
    }

    public String getWhoFired() {
        return whoFired;
    }

    public void setWhoFired(String whoFired) {
        this.whoFired = whoFired;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }
}
