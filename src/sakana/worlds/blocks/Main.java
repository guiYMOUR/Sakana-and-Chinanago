package sakana.worlds.blocks;

import arc.Core;
import arc.audio.Sound;
import arc.graphics.g2d.Draw;
import arc.math.Mathf;
import arc.scene.ui.layout.Table;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.gen.Building;
import mindustry.gen.Sounds;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.world.Block;
import mindustry.world.Tile;
import sakana.contents.EUGet;

public class Main extends Block {
    public float LEFT = 10;
    public float UP = 10;
    public float rx = 0,
            ry = -20,
            ryt = 4;
    public float dt  = 0.005f;
    public float scl = 2;

    public Sound s = Sounds.none;
    public float v = 3;

    public Main(String name) {
        super(name);
        solid = false;
        update = true;
        configurable = true;
        hasShadow = customShadow = false;
        config(int[].class, (MainBuild tile, int[] ints) -> {
            tile.left = ints[0];
            tile.up = ints[1];
        });
    }

    @Override
    public boolean canBreak(Tile tile) {
        return true;
    }

    public class MainBuild extends Building{
        public float left = 0,
                up = 0;

        @Override
        public void updateTile() {
            left = Mathf.lerpDelta(left, 0, dt * LEFT/10);
            up = Mathf.lerpDelta(up, 0, dt * UP/10);
            if(Mathf.equal(left, 0, 0.01f)) left = 0;
            if(Mathf.equal(up, 0, 0.01f)) up = 0;
        }

        @Override
        public void draw() {
            Draw.rect(Core.atlas.find(name + "-base"), x, y);
            float sin = Mathf.sin(scl, 1);
            float dx = x + rx,
                dy = y + ry + ryt + Math.abs(sin) * up;
            float fx = EUGet.dx(dx, Math.abs(ry), left * sin + 90),
                fy = EUGet.dy(dy, Math.abs(ry), left * sin + 90);
            Draw.z(Layer.blockBuilding + 1);
            Drawf.shadow(Core.atlas.find(name), fx - 2, fy - 2, left * sin);
            Draw.rect(Core.atlas.find(name), fx, fy, left * sin);
        }

        @Override
        public void buildConfiguration(Table table) {
            configure(new int[]{(int) LEFT, (int) UP});
            deselect();
            if(s == Sounds.none) return;
            s.stop();
            s.at(x, y, 1, v);
        }

        @Override
        public int[] config() {
            return new int[]{(int) LEFT, (int) UP};
        }

        @Override
        public void write(Writes write) {
            super.write(write);
            write.f(left);
            write.f(up);
        }

        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);
            left = read.f();
            up = read.f();
        }
    }
}
