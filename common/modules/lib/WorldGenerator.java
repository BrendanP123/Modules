package common.modules.lib;

import java.util.Random;

import common.modules.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * World Generation. Generates Copper, Tin, Silver and Lead
 * 
 * @author Sparkst3r
 *
 */
public class WorldGenerator implements IWorldGenerator {

	/**
	 * Generate the world and populate the world with AnotherWorld ores
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		//chunkX/Z is the first block in the chunk, this calculates the whole chunk
		int chunkX16 = chunkX * 16;
		int chunkZ16 = chunkZ * 16;

		//If the world is not the end or the nether, Generate in this world.
		if (!(world.provider.dimensionId == -1) || !(world.provider.dimensionId == 1)) {
			//Generate Copper Ore
			generateCopper(random, chunkX16, chunkZ16, world, chunkProvider, chunkProvider);
			generateTin(random, chunkX16, chunkZ16, world, chunkProvider, chunkProvider);
			generateSilverAndLead(random, chunkX16, chunkZ16, world, chunkProvider, chunkProvider);
		}
	}

	/**
	 * 	Generate Copper Ore
	 * 
	 */
	public void generateCopper(Random random, int chunkX16, int chunkZ16, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int block = 0; block < 12; block++) {
			int xCoord = chunkX16 + random.nextInt(16);
			int yCoord = random.nextInt(40);
			int zCoord = chunkZ16 + random.nextInt(16);
			new WorldGenMinable(ModBlocks.BlockOreField.blockID, 0 , 12, Block.stone.blockID).generate(world, random, xCoord, yCoord, zCoord);
		}
	}

	/**
	 * 	Generate Tin Ore
	 * 
	 */
	public void generateTin(Random random, int chunkX16, int chunkZ16, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int block = 0; block < 9; block++) {
			int xCoord = chunkX16 + random.nextInt(16);
			int yCoord = random.nextInt(30);
			int zCoord = chunkZ16 + random.nextInt(16);
			new WorldGenMinable(ModBlocks.BlockOreField.blockID, 1, 12, Block.stone.blockID).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
	/**
	 * Generates Silver and Lead Ore
	 * 
	 */
	public void generateSilverAndLead(Random random, int chunkX16, int chunkZ16, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int block = 0; block < 7; block++) {
			int xCoord = chunkX16 + random.nextInt(16);
			int yCoord = random.nextInt(20);
			int zCoord = chunkZ16 + random.nextInt(16);
			int xCoord1 = chunkX16 + random.nextInt(16);
			int yCoord1 = random.nextInt(25);
			int zCoord1 = chunkZ16 + random.nextInt(16);
			random.nextInt(30);
			random.nextInt(23);
			int xCoordSilver = xCoord + (random.nextInt(2) - random.nextInt(4));
			int yCoordSilver = yCoord + (random.nextInt(2) - random.nextInt(4));
			int zCoordSilver = zCoord + (random.nextInt(2) - random.nextInt(4));
			new WorldGenMinable(ModBlocks.BlockOreField.blockID, 2, 8, Block.stone.blockID).generate(world, random, xCoordSilver, yCoordSilver, zCoordSilver);
			new WorldGenMinable(ModBlocks.BlockOreField.blockID, 3, 8, Block.stone.blockID).generate(world, random, xCoordSilver, yCoordSilver, zCoordSilver);
			new WorldGenMinable(ModBlocks.BlockOreField.blockID, 4, 1, Block.stone.blockID).generate(world, random, xCoord1, yCoord1, zCoord1);
		}
	}



}