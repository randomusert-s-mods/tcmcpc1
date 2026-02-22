package io.github.randomusert.mods.tcmpc1.init;


import io.github.randomusert.mods.tcmpc1.tincraftmodpackcore1;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(tincraftmodpackcore1.MODID);



    public static final DeferredBlock<Block> COMPRESSED_TIN_BLOCK_X1 = BLOCKS.register("compressed_tin_block_x1",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(2.5f)
                    .sound(SoundType.STONE)
                    .explosionResistance(0.1f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> COMPRESSED_TIN_BLOCK_X2 = BLOCKS.register("compressed_tin_block_x2",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(2.5f)
                    .sound(SoundType.STONE)
                    .explosionResistance(0.1f)
                    .requiresCorrectToolForDrops()));



    public static final DeferredBlock<Block> COMPRESSED_TIN_BLOCK_X3 = BLOCKS.register("compressed_tin_block_x3",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(10f)
                    .explosionResistance(100f)
                    .noLootTable()));

}
