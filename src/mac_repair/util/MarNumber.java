package mac_repair.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The purpose of this class is to keep track of the current MAR form number.
 */
public class MarNumber
{
    // Starts off with default value of 001.
    public static AtomicInteger num = new AtomicInteger(1);
}