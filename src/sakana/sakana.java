package sakana;

import sakana.contents.MBlocks;
import mindustry.mod.*;
import sakana.contents.MSounds;

public class sakana extends Mod{
    public sakana() {
    }

    @Override
    public void init() {
    }

    @Override
    public void loadContent(){

        MSounds.load();
        MBlocks.load();
    }

}
