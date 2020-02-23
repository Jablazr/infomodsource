package insanusnatura.world;

import insanusnatura.init.ModWorldGen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderInsanusNatura extends WorldProvider {
    @Override
    @SideOnly(Side.CLIENT)
    public net.minecraft.client.audio.MusicTicker.MusicType getMusicType() {
        return EnumHelperClient.addMusicType("music.game",
                (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(("music.game"))), 6000,
                24000);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float par1, float par2) {
        return new Vec3d(0.752941176471, 0.847058823529, 1);
    }


    @Override
    public DimensionType getDimensionType() {
        return ModWorldGen.INSANUSNATURA_DIM_TYPE;
    }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorInsanusNatura(this.world, this.world.getSeed() - ModWorldGen.INSANUSNATURA_DIM_ID);
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public boolean canRespawnHere() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean doesXZShowFog(int par1, int par2) {
        return false;
    }

    @Override
    public WorldSleepResult canSleepAt(EntityPlayer player, BlockPos pos) {
        return WorldSleepResult.ALLOW;
    }

    @Override
    protected void generateLightBrightnessTable() {
        float f = 0.5f;
        for (int i = 0; i <= 15; ++i) {
            float f1 = 1 - (float) i / 15f;
            this.lightBrightnessTable[i] = (1 - f1) / (f1 * 3 + 1) * (1 - f) + f;
        }
    }

    @Override
    public boolean doesWaterVaporize() {
        return false;
    }

    @Override
    public BiomeProvider getBiomeProvider() {
        return new BiomeProviderInsanusNatura(this.world.getSeed());
    }

    @Override
    public boolean canDoLightning(Chunk chunk) {
        return true;
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk) {
        return false;
    }

    @Override
    public boolean canSnowAt(BlockPos pos, boolean checkLight) {
        return false;
    }

    @Override
    public boolean canBlockFreeze(BlockPos pos, boolean byWater) {
        return false;
    }
}
