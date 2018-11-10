package com.gamingstuf.bot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class Main {
	public static void main(String[] args) throws Exception {
		try {
<<<<<<< HEAD
			JDA api = new JDABuilder(AccountType.BOT).setToken("").build();
=======
			JDA api = new JDABuilder(AccountType.BOT).setToken("").build();
>>>>>>> e30b5ec514f4b696d7fcc775ae7693764a617d5f
			api.addEventListener(new GS_Author());
			api.addEventListener(new GS_Debug());
			api.addEventListener(new GS_Say());
			api.addEventListener(new GS_Announce());
			api.addEventListener(new GS_Lock());
			api.addEventListener(new GS_Archive());
			//api.addEventListener(new GS_CSay());
			api.getPresence().setGame(Game.playing("the getting demonitized game"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
