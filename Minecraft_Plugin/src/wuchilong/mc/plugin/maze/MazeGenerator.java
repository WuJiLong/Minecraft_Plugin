package wuchilong.mc.plugin.maze;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

public class MazeGenerator extends ChunkGenerator{
	Random rand;
	long seed;
	public MazeGenerator(long seed) {
		this.seed=seed;
		rand=new Random(seed);
	}
	@Override
	public ChunkData generateChunkData(World world , Random random, int x, int z, BiomeGrid grid){
		ChunkData chunk = createChunkData(world);
		chunk.setRegion(0, 0, 0, 	1, 120, 16, Material.COBBLESTONE);
		chunk.setRegion(0, 0, 0, 	16, 120, 1, Material.COBBLESTONE);
		chunk.setRegion(0, 0, 15, 	16, 120, 16, Material.COBBLESTONE);
		chunk.setRegion(15, 0, 0, 	16, 120, 16, Material.COBBLESTONE);
		return chunk;
	}
}
