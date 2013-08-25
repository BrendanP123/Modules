package Brendan.modules.Extra;

import java.util.logging.Level;


import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundHandler {

@ForgeSubscribe
public void onSoundLoad(SoundLoadEvent event){

for (String soundFile : Sounds.soundFiles){

try{

event.manager.soundPoolSounds.addSound(soundFile);
}
catch (Exception e){

FMLLog.log(Level.WARNING, e, soundFile + " has failed loading sound So No Sound For You Mhahahaha: ");

}

}

}

}
