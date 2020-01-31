package insanusnatura.init;

import insanusnatura.objects.items.*;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();


    public static Item MAGICAL_ORB = new BaseItem("magical_orb");
    public static Knife KNIFE = new Knife();
    public static MagentaFeather MAGENTA_FEATHER = new MagentaFeather();
    public static Tube TUBE = new Tube();
    public static Flute FLUTE = new Flute();
    public static BlankPrint BLANK_PRINT = new BlankPrint();
    public static MusicalPrint MUSICAL_PRINT = new MusicalPrint();
    public static MysticalDust MYSTICAL_DUST = new MysticalDust();
    public static MysticalFlute MYSTICAL_FLUTE = new MysticalFlute();


}
