package com.yabistro.client.ui.home;

import java.util.ArrayList;
import java.util.Random;

public class CafeNetBrands {

    public static ArrayList<Brand> brands = new ArrayList<>();
    public static final int COUNT = 5;


    static {
        brands.clear();
        for (int i = 1; i <= COUNT; i++) {
            brands.add(new Brand(i));
        }
    }

    public static class Brand {
        int i;
        String brandName;
        Menu brandMenu;

        public Brand(int i) {
            this.i = i;
            brandName = "Brand # " + i;
            brandMenu = new Menu();
        }
    }

    public static class Menu {
        ArrayList<String> menuList = new ArrayList<>();

        public Menu() {
            menuList.clear();
            int count = new Random().nextInt(10) + 10;
            for (int i = 0; i < count; i++) {
                menuList.add(new String("Menu Item # " + i));
            }
        }
    }
}