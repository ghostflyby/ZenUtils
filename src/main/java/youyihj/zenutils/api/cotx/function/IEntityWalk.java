package youyihj.zenutils.api.cotx.function;

import com.teamacronymcoders.contenttweaker.api.ctobjects.blockpos.IBlockPos;
import com.teamacronymcoders.contenttweaker.api.ctobjects.world.IWorld;
import crafttweaker.api.entity.IEntity;
import stanhebben.zenscript.annotations.ZenClass;

/**
 * @author youyihj
 */
@FunctionalInterface
@ZenClass("mods.zenutils.cotx.IEntityWalk")
public interface IEntityWalk {
    void call(IWorld world, IBlockPos pos, IEntity entity);
}
