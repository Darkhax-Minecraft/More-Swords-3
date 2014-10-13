package net.darkhax.moreswords.util.data;

import java.util.Calendar;

import net.darkhax.moreswords.util.Utils;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public enum EnumSwordData {

    CANADA("Canada Day", "#ff0000", "ffffff", "#ff0000", createCalendar(7, 1)), MURICA("Independence Day", "E0162B", "FFFFFF", "0052A5", createCalendar(7, 4)), STRAYA("Australia Day", "002B7F", "E8112D", "FFFFFF", createCalendar(1, 26)), GERMANY("German Unity Day", "000000", "ff0000", "ffff00", createCalendar(9, 3)), PRIDE("Pride Day", "000000", "0000000", "000000", createCalendar(6, 28));

    EnumSwordData(String name, String hex1, String hex2, String hex3, Calendar date) {

        this.eventName = name;
        this.hex1 = hex1;
        this.hex2 = hex2;
        this.hex3 = hex3;
        this.date = date;
    }

    public static Calendar currentDate = Calendar.getInstance();
    private String eventName = "";
    private String hex1 = "";
    private String hex2 = "";
    private String hex3 = "";
    private Calendar date = null;

    /**
     * Specialized method to check if it is currently the same day.
     * 
     * @param eventDate: The day being checked.
     * @return true/false: Depends on if day is the same.
     */
    public static boolean isToday(Calendar eventDate) {

        System.out.println("Calculated Date: " + currentDate.get(Calendar.MONTH) + " " + eventDate.get(Calendar.MONTH));
        if ((currentDate.get(Calendar.MONTH) + 1) == eventDate.get(Calendar.MONTH) && currentDate.get(Calendar.DAY_OF_MONTH) == eventDate.get(Calendar.DAY_OF_MONTH))
            return true;

        else
            return false;
    }

    /**
     * Creates a calculator event.
     * 
     * @param year: The year for the event. (not used by msm)
     * @param month: The month for the event.
     * @param day: The day for the event.
     * @return Calendar: A new Calendar containing data.
     */
    public static Calendar createCalendar(int month, int day) {

        Calendar date = Calendar.getInstance();
        date.clear();
        date.set(1969, month, day);
        return date;
    }

    public static ItemStack checkForOngoingEvent(ItemStack stack) {

        System.out.println("Date is: " + (currentDate.get(Calendar.MONTH) + 1) + " " + currentDate.get(Calendar.DAY_OF_MONTH));
        Utils.prepareStackTag(stack);
        stack.setStackDisplayName("Test1");
        for (EnumSwordData data : values()) {

            if (isToday(data.date)) {

                stack.setStackDisplayName("Test2");
                NBTTagCompound tag = stack.stackTagCompound;
                tag.setString("eventName", data.eventName);
                tag.setString("hex1", data.hex1);
                tag.setString("hex2", data.hex2);
                tag.setString("hex3", data.hex3);
                tag.setInteger("month", data.date.MONTH);
                tag.setInteger("day", data.date.DAY_OF_MONTH);
            }
        }

        return stack;
    }
}