package models;

/**
 * Compare creatures based on their strength anf energy
 *
 * Credit to: Yishai (answered Sep 14 '09)
 * From: http://stackoverflow.com/questions/1421322/how-do-i-sort-a-list-by-different-parameters-at-different-timed#1421537
 */

import java.util.Comparator;

enum CreatureComparator implements Comparator<Creature>{

    /**
     * Sort creatures by strength. Creature with more strength should perform its turn first
     */
    STRENGTH_SORT{
        public int compare(Creature c1, Creature c2){
            return Integer.valueOf(c1.getStrength()).compareTo(c2.getStrength());
        }
    },

    /**
     * Sort creature by energy. Creatures with the same strength should be compared by their energy level
     */
    ENERGY_SORT{
        public int compare(Creature c1, Creature c2){
            return Integer.valueOf(c1.getEnergy()).compareTo(c2.getEnergy());
        }
    };


    /**
     * Decending sort order. Not sure if this will be used. Copied from the stackOverFlow
     *
     * @param other
     * @return
     */
    public static Comparator<Creature> decending(final Comparator<Creature> other){
        return new Comparator<Creature>() {
            public int compare(Creature c1, Creature c2) {
                return -1 * other.compare(c1, c2);
            }
        };
    }

    /**
     * Get comparator. Copied from the stackOverFlow
     * @param multipleOptions
     * @return
     */
    public static Comparator<Creature> getComparator(final CreatureComparator... multipleOptions) {
        return new Comparator<Creature>() {
            public int compare(Creature o1, Creature o2) {
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
