package sakana.contents;

import arc.audio.Sound;
import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.meta.BuildVisibility;
import sakana.worlds.blocks.Main;

import static mindustry.type.ItemStack.with;

public class MBlocks {
    public static Block
        sakana, chinanago;
    public static void load(){
        sakana = new Main("sakana"){{
            requirements(Category.effect, with(Items.silicon, 10));
            size = 5;
            LEFT = 40;
            UP = 0;
            dt = 0.002f;
            ryt = 6;
        }};

        chinanago = new Main("chinanago"){{
            requirements(Category.effect, with(Items.silicon, 10));
            size = 5;
            LEFT = 6;
            UP = 15;
            scl = 4;
        }};
    }
}
