package insanusnatura.util;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class Reference {
    public static final String MOD_ID = "insanusnatura";
    public static final String NAME = "Insanus Natura";
    public static final String VERSION = "1.0.0";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";
    public static final String CLIENT_PROXY_CLASS = "insanusnatura.proxy.ClientProxy";
    public static final String COMMON_PROXY_CLASS = "insanusnatura.proxy.CommonProxy";
    public static final SimpleNetworkWrapper PACKET_HANDLER = NetworkRegistry.INSTANCE.newSimpleChannel("insanusnatura:a");
}
