package net.sansdw.create_gs.registry;

import com.simibubi.create.api.connectivity.ConnectivityHandler;
import com.simibubi.create.api.contraption.BlockMovementChecks;
import net.sansdw.create_gs.content.vault.TieredVaultBlock;

public class GSMovementChecks {
    public static void register() {
        BlockMovementChecks.registerAttachedCheck((state, world, pos, direction) -> {
            if (state.getBlock() instanceof TieredVaultBlock && ConnectivityHandler.isConnected(world, pos, pos.relative(direction))) return BlockMovementChecks.CheckResult.SUCCESS;
            return BlockMovementChecks.CheckResult.PASS;
        });
    }
}
