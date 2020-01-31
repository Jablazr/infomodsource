package insanusnatura.init;

import insanusnatura.objects.items.*;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item MAGICAL_ORB = new BaseItem("magical_orb");
    public static final Knife KNIFE = new Knife();
    public static final MagentaFeather MAGENTA_FEATHER = new MagentaFeather();
    public static final Tube TUBE = new Tube();
    public static final Flute FLUTE = new Flute();
    public static final BlankPrint BLANK_PRINT = new BlankPrint();
    public static final MusicalPrint MUSICAL_PRINT = new MusicalPrint();
    public static final MysticalDust MYSTICAL_DUST = new MysticalDust();
    public static final MysticalFlute MYSTICAL_FLUTE = new MysticalFlute();
    public static final VineBracelet VINE_BRACELET = new VineBracelet();
}
