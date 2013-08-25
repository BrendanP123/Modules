package Brendan.modules.Extra;
 
import java.util.Random;

import Brendan.modules.Values.WorldValues;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
 
public class WorldGen implements IWorldGenerator {
 
        @Override
        public void generate(Random random, int chunkX, int chunkZ, World world,
                        IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
                switch(world.provider.dimensionId){
                case -1: generateNether(world, random, chunkX * 16, chunkZ * 16); break;
                case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 2: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 3: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 4: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 5: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 6: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 7: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 8: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 9: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 10: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 11: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
                case 12: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 13: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 14: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 15: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 16: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 17: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 18: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 19: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;
    			case 20: generateSurface(world, random, chunkX * 16, chunkZ * 16); break;}}
 
        private void generateSurface(World world, Random random, int blockX, int blockZ) 
    	{
        	//Copper
    		for(int i = 0; i < 10; i++)
    		{
    			int posX = blockX + random.nextInt(16);
    			int posY = random.nextInt(60);
    			int posZ = blockZ + random.nextInt(16);
    			(new WorldGenMinable(WorldValues.BlockOreField.blockID, 0, 20)).generate(world, random, posX, posY, posZ);}
    			//Electrode
    			for(int i = 0; i < 10; i++)
    			{
    				int posX = blockX + random.nextInt(16);
    				int posY = random.nextInt(40);
    				int posZ = blockZ + random.nextInt(16);
    				(new WorldGenMinable(WorldValues.BlockOreField.blockID, 6, 16)).generate(world, random, posX, posY, posZ);}
    			//Lead
    			for(int i = 0; i < 10; i++)
    			{
    				int posX = blockX + random.nextInt(16);
    				int posY = random.nextInt(50);
    				int posZ = blockZ + random.nextInt(16);
    				(new WorldGenMinable(WorldValues.BlockOreField.blockID, 4, 20)).generate(world, random, posX, posY, posZ);}
    			//Titanium
    			for(int i = 0; i < 3; i++)
    			{
    				int posX = blockX + random.nextInt(16);
    				int posY = random.nextInt(30);
    				int posZ = blockZ + random.nextInt(16);
    				(new WorldGenMinable(WorldValues.BlockOreField.blockID, 5, 4)).generate(world, random, posX, posY, posZ);}
		for(int i = 0; i < 10; i++)
		{
			int posX = blockX + random.nextInt(16);
			int posY = random.nextInt(40);
			int posZ = blockZ + random.nextInt(16);
			(new WorldGenMinable(WorldValues.BlockOreField.blockID, 1, 20)).generate(world, random, posX, posY, posZ);}
		for(int i = 0; i < 10; i++)
		{
			int posX = blockX + random.nextInt(16);
			int posY = random.nextInt(30);
			int posZ = blockZ + random.nextInt(16);
			(new WorldGenMinable(WorldValues.BlockOreField.blockID, 2, 20)).generate(world, random, posX, posY, posZ);}
}
    	private void generateNether(World world, Random random, int blockX, int blockZ) 
    	{
    	}

 
}
