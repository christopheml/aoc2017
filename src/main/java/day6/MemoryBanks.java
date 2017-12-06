package day6;

import java.util.Arrays;

public class MemoryBanks {

    private final int[] banks;

    private MemoryBanks(int[] values, int size) {
        banks = Arrays.copyOf(values, size);
    }

    public static MemoryBanks of(int[] values, int size) {
        return new MemoryBanks(values, size);
    }

    public void cycle() {
        int index = indexOfBankWithMostBlocks();
        reallocateFrom(index);
    }

    private void reallocateFrom(int index) {
        int blocksToReallocate = clearBank(index);
        while (blocksToReallocate > 0) {
            index = (++index) % banks.length;
            banks[index]++;
            blocksToReallocate--;
        }
    }

    private int clearBank(int index) {
        int blocksToReallocate = banks[index];
        banks[index] = 0;
        return blocksToReallocate;
    }

    private int indexOfBankWithMostBlocks() {
        int maximum = Integer.MIN_VALUE;
        int maximumIndex = 0;
        for (int index = 0; index < banks.length; ++index) {
            if (banks[index] > maximum) {
                maximum = banks[index];
                maximumIndex = index;
            }
        }
        return maximumIndex;
    }

    public int[] dump() {
        return Arrays.copyOf(banks, banks.length);
    }

    public int getState() {
        return Arrays.hashCode(banks);
    }

}
