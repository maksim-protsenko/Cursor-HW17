package com.company.Cursor17.Util;

import com.company.Cursor17.Model.Laptop;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LaptopFactory {
    private static final String[] brands = new String[]{"Lenovo", "Acer", "Dell"};
    private static final String[] models = new String[]{"Alienware M15", "ThinkPad X1 Carbon", "Legion 5", "Nitro 5"};
    private static final String[] cpuBrands = new String[]{"Intel", "AMD"};
    private static final String[] cpuModels = new String[]{"Ryzen 5 5600U", "Ryzen 7 5700U", "Ryzen 9 5900HX", "i5-10210U", "i7-10510U", "i9-10980HK"};
    private static final int[] rams = new int[]{4, 8, 16, 32, 64, 128};
    private static final int[] hddCapacityMb = new int[]{500, 1000, 2000, 3000};
    private static final String[] materials = new String[]{"polycarbonate ABS", "aluminium alloy", "magnesium alloy", "carbon fiber"};
    private static final Date startDateOfProduction = new GregorianCalendar(2018, 1, 1).getTime();
    private static final Date endDateOfProduction = new GregorianCalendar(2021, 1, 28).getTime();

    public static Laptop createLaptop() {
        Laptop laptop = new Laptop();
        laptop.setBrand(brands[new Random().nextInt(2)]);
        laptop.setModel(models[new Random().nextInt(3)]);
        laptop.setCpuBrand(cpuBrands[new Random().nextInt(1)]);
        laptop.setCpuModel(cpuModels[new Random().nextInt(5)]);
        laptop.setRam(rams[new Random().nextInt(5)]);
        laptop.setHddCapacity(hddCapacityMb[new Random().nextInt(3)]);
        laptop.setCaseMaterial(materials[new Random().nextInt(3)]);
        laptop.setSecondHand(new Random().nextBoolean());
        laptop.setPrice((int)(Math.random() * 35000) + 25000);
        laptop.setProductionDate(between(startDateOfProduction,endDateOfProduction));
        return laptop;
    }

    public static Date between(Date startDateOfProduction, Date endDateOfProduction) {
        long startMillis = startDateOfProduction.getTime();
        long endMillis = endDateOfProduction.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);
        return new Date(randomMillisSinceEpoch);
    }
}
