package com.bot.main;

import com.ci.bot.CI_Clear;
import com.ci.bot.CI_NotifRanks;
import com.ci.bot.Lockdown;
import com.divine.bot.Channel_Lockdown;
import com.divine.bot.Divine_Lockdown;
import com.divine.bot.Join;
import com.divine.bot.Voice;
import com.divine.bot.Listener;
import com.divine.bot.Restricter;
import com.fan.bot.F_Assign;
import com.gamingstuf.bot.No_U;
import com.gamingstuf.bot.RoleNotif;
import com.mf.bot.Commands;
import com.mf.bot.GS_Author;
import com.mf.bot.Mentionable;
import com.mf.bot.Ping;
import com.mf.bot.Slowmode;
import com.mf.bot.VoiceText;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class Main {
	public static void main(String[] args) throws Exception {
		try {
			JDA mf = new JDABuilder(AccountType.BOT).setToken("").build();
			mf.addEventListener(new GS_Author());
			mf.addEventListener(new GS_Debug());
			mf.addEventListener(new Say());
			mf.addEventListener(new Ping());
			mf.addEventListener(new Slowmode());
			mf.addEventListener(new Shutdown());
			mf.addEventListener(new Commands());
			mf.addEventListener(new VoiceText());
			mf.addEventListener(new Mentionable());
			mf.addEventListener(new Status());
			mf.getPresence().setGame(Game.watching("Wiz break the discord"));
			JDA gs = new JDABuilder(AccountType.BOT).setToken("").build();
			gs.addEventListener(new GS_Author());
			gs.addEventListener(new GS_Debug());
			gs.addEventListener(new Say());
			gs.addEventListener(new No_U());
			gs.addEventListener(new RoleNotif());
			gs.addEventListener(new Shutdown());
			gs.addEventListener(new Status());
			gs.getPresence().setGame(Game.playing("the getting demonitized game"));
			JDA ci = new JDABuilder(AccountType.BOT).setToken("").build();
			ci.addEventListener(new Say());
			ci.addEventListener(new Lockdown());
			ci.addEventListener(new GS_Debug());
			ci.addEventListener(new CI_NotifRanks());
			ci.addEventListener(new CI_Clear());
			ci.addEventListener(new Shutdown());
			ci.addEventListener(new Status());
			ci.getPresence().setGame(Game.watching("the forums"));
			JDA fan = new JDABuilder(AccountType.BOT).setToken("").build();
			fan.addEventListener(new F_Assign());
			fan.addEventListener(new Say());
			fan.addEventListener(new GS_Debug());
			fan.addEventListener(new Status());
			fan.getPresence().setGame(Game.watching("anything but Jack"));
			JDA divine = new JDABuilder(AccountType.BOT).setToken("").build();
			divine.addEventListener(new Voice());
			divine.addEventListener(new GS_Author());
			divine.addEventListener(new GS_Debug());
			divine.addEventListener(new Say());
			divine.addEventListener(new Shutdown());
			divine.addEventListener(new Divine_Lockdown());
			divine.addEventListener(new Listener());
			divine.addEventListener(new Join());
			divine.addEventListener(new Status());
			divine.addEventListener(new Channel_Lockdown());
			divine.addEventListener(new Restricter());
			divine.getPresence().setGame(Game.watching("Emma's bad YT vids"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}