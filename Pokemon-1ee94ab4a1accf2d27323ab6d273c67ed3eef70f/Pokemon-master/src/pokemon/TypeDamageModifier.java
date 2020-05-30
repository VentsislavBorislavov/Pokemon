package pokemon;

import java.util.HashMap;

public class TypeDamageModifier {
    private HashMap<Type,HashMap<Type,Double>> firstMap = new HashMap<Type,HashMap<Type,Double>>();
    private HashMap<Type,Double> secondMapEarth = new HashMap<>();
    private HashMap<Type,Double> secondMapPlant = new HashMap<>();
    private HashMap<Type,Double> secondMapWater = new HashMap<>();
    private HashMap<Type,Double> secondMapAir = new HashMap<>();
    private HashMap<Type,Double> secondMapFire = new HashMap<>();
    public TypeDamageModifier() {
        //=================================
        secondMapEarth.put(Type.EARTH,1.0);
        firstMap.put(Type.EARTH, secondMapEarth);

        secondMapEarth.put(Type.FIRE,2.0);
        firstMap.put(Type.EARTH, secondMapEarth);

        secondMapEarth.put(Type.AIR,0.25);
        firstMap.put(Type.EARTH, secondMapEarth);

        secondMapEarth.put(Type.WATER,1.0);
        firstMap.put(Type.EARTH, secondMapEarth);

        secondMapEarth.put(Type.PLANT,0.5);
        firstMap.put(Type.EARTH, secondMapEarth);
        //========================================
        secondMapPlant.put(Type.EARTH,2.0);
        firstMap.put(Type.PLANT, secondMapPlant);

        secondMapPlant.put(Type.FIRE,0.75);
        firstMap.put(Type.PLANT, secondMapPlant);

        secondMapPlant.put(Type.AIR,0.5);
        firstMap.put(Type.PLANT, secondMapPlant);

        secondMapPlant.put(Type.WATER,2.0);
        firstMap.put(Type.PLANT, secondMapPlant);

        secondMapPlant.put(Type.PLANT,1.0);
        firstMap.put(Type.PLANT, secondMapPlant);
        //=================================================
        secondMapWater.put(Type.EARTH,2.0);
        firstMap.put(Type.WATER, secondMapWater);

        secondMapWater.put(Type.FIRE,2.0);
        firstMap.put(Type.WATER, secondMapWater);

        secondMapWater.put(Type.AIR,1.0);
        firstMap.put(Type.WATER, secondMapWater);

        secondMapWater.put(Type.WATER,1.0);
        firstMap.put(Type.WATER, secondMapWater);

        secondMapWater.put(Type.PLANT,0.5);
        firstMap.put(Type.WATER, secondMapWater);
        //=================================================
        secondMapAir.put(Type.EARTH,1.0);
        firstMap.put(Type.AIR, secondMapAir);

        secondMapAir.put(Type.FIRE,1.0);
        firstMap.put(Type.AIR, secondMapAir);

        secondMapAir.put(Type.AIR,1.0);
        firstMap.put(Type.AIR, secondMapAir);

        secondMapAir.put(Type.WATER,1.0);
        firstMap.put(Type.AIR, secondMapAir);

        secondMapAir.put(Type.PLANT,2.0);
        firstMap.put(Type.AIR, secondMapAir);
        //=================================================
        secondMapFire.put(Type.EARTH,1.0);
        firstMap.put(Type.FIRE, secondMapFire);

        secondMapFire.put(Type.FIRE,1.0);
        firstMap.put(Type.FIRE, secondMapFire);

        secondMapFire.put(Type.AIR,1.0);
        firstMap.put(Type.FIRE, secondMapFire);

        secondMapFire.put(Type.WATER,0.25);
        firstMap.put(Type.FIRE, secondMapFire);

        secondMapFire.put(Type.PLANT,2.0);
        firstMap.put(Type.FIRE, secondMapFire);

    }
    public  double getDamageModifier(Type firstKey,Type secondKey){
        return firstMap.get(firstKey).get(secondKey);
    }

    public HashMap<Type, HashMap<Type, Double>> getFirstMap() {
        return firstMap;
    }


}
