package com.gamingstuf.bot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class Main {
	public static void main(String[] args) throws Exception {
		try {
			JDA api = new JDABuilder(AccountType.BOT).setToken("").build();
			api.addEventListener(new GS_Author());
			api.addEventListener(new GS_Debug());
			api.addEventListener(new GS_Say());
			api.addEventListener(new GS_Announce());
			api.addEventListener(new GS_WizPerms());
			api.addEventListener(new GS_Lock());
			api.addEventListener(new GS_Archive());
			//api.addEventListener(new GS_CSay());
			api.getPresence().setGame(Game.playing("the getting demonitized game"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
