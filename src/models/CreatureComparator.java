package models;

/**
 * Credit to: Yishai (answered Sep 14 '09)
 * From: http://stackoverflow.com/questions/1421322/how-do-i-sort-a-list-by-different-parameters-at-different-timed#1421537
 */

import java.util.Comparator;

enum CreatureComparator implements Comparator<CreatureModel>{
    STRENGTH_SORT{
        public int compare(CreatureModel c1, CreatureModel c2){
            return Integer.valueOf(c1.getStrength()).compareTo(c2.getStrength());
        }
    },
    ENERGY_SORT{
        public int compare(CreatureModel c1, CreatureModel c2){
            return Integer.valueOf(c1.getEnergy()).compareTo(c2.getEnergy());
        }
    };


    public static Comparator<CreatureModel> decending(final Comparator<CreatureModel> other){
        return new Comparator<CreatureModel>() {
            public int compare(CreatureModel c1, CreatureModel c2) {
                return -1 * other.compare(c1, c2);
            }
        };
    }


    public static Comparator<CreatureModel> getComparator(final CreatureComparator... multipleOptions) {
        return new Comparator<CreatureModel>() {
            public int compare(CreatureModel o1, CreatureModel o2) {
                for (CreatureComparator option : multipleOptions) {
                    int result = option.compare(o1, o2);
                    if (result != 0) {
                        return result;
                    }
                }
                return 0;
            }
        };
    }
}
