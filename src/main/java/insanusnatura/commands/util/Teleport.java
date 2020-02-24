package insanusnatura.commands.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class Teleport extends Teleporter {
    private final WorldServer world;
    private double x,y,z;

    public Teleport(WorldServer world, double x, double y, double z) {
        super(world);
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {
        this.world.getBlockState(new BlockPos((int)this.x, (int) this.y, (int) this.z));
        entityIn.setPosition(x,y,z);
        entityIn.motionX = 0F;
        entityIn.motionY = 0F;
        entityIn.motionZ = 0F;
    }

    public static void teleportToDimension(EntityPlayer player, int dimension, double x, double y, double z) {
        int oldDimension = player.getEntityWorld().provider.getDimension();

        if (!player.world.isRemote) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;

            MinecraftServer server = player.getEntityWorld().getMinecraftServer();
            WorldServer worldServer = server.getWorld(dimension);
            player.addExperienceLevel(0);

            if (worldServer == null || worldServer.getMinecraftServer() == null) { //Dimension doesn't exist
                throw new IllegalArgumentException("Dimension: " + dimension + " doesn't exist!");
            }

            worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension, new Teleport(worldServer, x, y, z));
            player.setPositionAndUpdate(x, y, z);
            if (oldDimension == 1) {
                // For some reason teleporting out of the end does weird things. Compensate for that
                player.setPositionAndUpdate(x, y, z);
                worldServer.spawnEntity(player);
                worldServer.updateEntityWithOptionalForce(player, false);
            }
        }
    }
}