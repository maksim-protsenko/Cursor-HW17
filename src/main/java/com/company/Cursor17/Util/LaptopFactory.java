package com.company.Cursor17.Util;

import com.company.Cursor17.Model.Laptop;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LaptopFactory {

    private static final List<String> brands = new ArrayList<String>(Arrays.asList("Lenovo", "Acer", "Dell"));
    private static final List<String> models = new ArrayList<String>(Arrays.asList("Alienware M15", "ThinkPad X1 Carbon", "Legion 5", "Nitro 5"));
    private static final List<String> cpuBrands = new ArrayList<String>(Arrays.asList("Intel", "AMD"));
    private static final List<String> cpuModels = new ArrayList<String>(Arrays.asList("Ryzen 5 5600U", "Ryzen 7 5700U", "Ryzen 9 5900HX", "i5-10210U", "i7-10510U", "i9-10980HK"));
    private static final List<Integer> rams = new ArrayList<Integer>(Arrays.asList(4, 8, 16, 32, 64, 128));
    private static final List<Integer> hddCapacityMb = new ArrayList<Integer>(Arrays.asList(500, 1000, 2000, 3000));
    private static final List<String> materials = new ArrayList<String>(Arrays.asList("polycarbonate ABS", "aluminium alloy", "magnesium alloy", "carbon fiber"));
    private static final Date startDateOfProduction = new GregorianCalendar(2018, 1, 1).getTime();
    private static final Date endDateOfProduction = new GregorianCalendar(2021, 1, 28).getTime();

    public static Laptop createLaptop() {
        Laptop laptop = new Laptop();
        Random randomizer = new Random();

        laptop.setBrand(brands.get(randomizer.nextInt(brands.size())));
        laptop.setModel(models.get(randomizer.nextInt(models.size())));
        laptop.setCpuBrand(cpuBrands.get(randomizer.nextInt(cpuBrands.size())));
        laptop.setCpuModel(cpuModels.get(randomizer.nextInt(cpuModels.size())));
        laptop.setRam(rams.get(randomizer.nextInt(rams.size())));
        laptop.setHddCapacity(hddCapacityMb.get(randomizer.nextInt(hddCapacityMb.size())));
        laptop.setCaseMaterial(materials.get(randomizer.nextInt(materials.size())));
        laptop.setSecondHand(randomizer.nextBoolean());
        laptop.setPrice((int) (Math.random() * 35000) + 25000);
        laptop.setProductionDate(between(startDateOfProduction, endDateOfProduction));
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
