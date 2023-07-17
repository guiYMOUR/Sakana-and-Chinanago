package sakana.contents;

import arc.audio.Sound;
import mindustry.Vars;
import mindustry.mod.Mods;
import sakana.sakana;

public class MSounds {
    public static Mods.LoadedMod s = Vars.mods.getMod(sakana.class);
    public static Sound
            chinanago = new Sound(), sakana = new Sound();

    public static void load(){
        chinanago = loadSound("chinanago.mp3");
        sakana = loadSound("sakana.mp3");
    }

    public static Sound loadSound(String name){
        return new Sound(s.root.child("sounds").child(name));
    }
}
