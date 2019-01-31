package com.bot.main;

import com.ci.bot.CI_Join;
import com.ci.bot.CI_Lockdown;
import com.ci.bot.CI_NotifRanks;
import com.ci.bot.CI_Verify;
import com.fan.bot.Fan_NotifRoles;
import com.gamingstuf.bot.GS_No_U;
import com.gamingstuf.bot.GS_RoleNotif;
import com.gamingstuf.bot.NickReset;
import com.mf.bot.MF_Archive;
import com.mf.bot.MF_Mentionable;
import com.mf.bot.MF_Ole;
import com.mf.bot.MF_Verify;
import com.mf.bot.MF_VoiceText;
import com.other.bot.Spam;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class Main {
	public static void main(String[] args) throws Exception {
		try {
			JDA mf = new JDABuilder(AccountType.BOT).setToken("").build();
			mf.addEventListener(new Author());
			mf.addEventListener(new Debug());
			mf.addEventListener(new Say());
			mf.addEventListener(new Slowmode());
			mf.addEventListener(new Shutdown());
			mf.addEventListener(new MF_VoiceText());
			mf.addEventListener(new MF_Mentionable());
			mf.addEventListener(new Status());
			mf.addEventListener(new Test());
			mf.addEventListener(new MF_Archive());
			mf.addEventListener(new MF_Verify());
			mf.addEventListener(new MF_Ole());
			System.out.println("Loaded Mineplex Forumers Bot.");
			mf.getPresence().setGame(Game.watching("Wiz break the discord"));
			JDA gs = new JDABuilder(AccountType.BOT).setToken("").build();
			gs.addEventListener(new Author());
			gs.addEventListener(new Debug());
			gs.addEventListener(new Say());
			gs.addEventListener(new GS_No_U());
			gs.addEventListener(new GS_RoleNotif());
			gs.addEventListener(new Shutdown());
			gs.addEventListener(new Status());
			gs.addEventListener(new NickReset());
			gs.getPresence().setGame(Game.playing("the getting demonitized game"));
			System.out.println("Loaded Gaming Stuf Bot.");
			JDA ci = new JDABuilder(AccountType.BOT).setToken("").build();
			ci.addEventListener(new Say());
			ci.addEventListener(new CI_Lockdown());
			ci.addEventListener(new Debug());
			ci.addEventListener(new CI_NotifRanks());
			ci.addEventListener(new Shutdown());
			ci.addEventListener(new Status());
			ci.addEventListener(new CI_Join());
			ci.addEventListener(new CI_Verify());
			ci.getPresence().setGame(Game.watching("the forums"));
			System.out.println("Loaded Community Integrity Bot.");
			JDA fan = new JDABuilder(AccountType.BOT).setToken("").build();
			fan.addEventListener(new Fan_NotifRoles());
			fan.addEventListener(new Say());
			fan.addEventListener(new Debug());
			fan.addEventListener(new Status());
			fan.getPresence().setGame(Game.watching("anything but Jack"));
			System.out.println("Loaded JackSucksAtLife's Member Discord Bot.");
			/*JDA divine = new JDABuilder(AccountType.BOT).setToken("").build();
			divine.addEventListener(new Voice()); //Voice Channel Manager
			divine.addEventListener(new GS_Author()); //Author Command
			divine.addEventListener(new GS_Debug()); //Debug Command
			divine.addEventListener(new Say()); //Say Command
			divine.addEventListener(new Shutdown()); //Shutdown Command
			divine.addEventListener(new Divine_Lockdown()); //Server Lockdown
			divine.addEventListener(new Listener()); //Promotion Command
			//divine.addEventListener(new Join()); //Verification Manager
			divine.addEventListener(new Status()); //Bot Management
			divine.addEventListener(new Restricter()); //#submit-suggestions Manager
			divine.addEventListener(new Slowmode()); //Slowmode Command
			divine.addEventListener(new uwu()); //Some stupid troll command that people hate.
			divine.addEventListener(new Looper()); //Spam Commnad
			divine.addEventListener(new Help()); //Help Command
			divine.addEventListener(new Archive()); //Archive Command
			divine.addEventListener(new ChannelCreator()); //Channel Create Command (still in works)
			divine.addEventListener(new ModTag());
			divine.addEventListener(new Filter());
			divine.getPresence().setGame(Game.watching("Emma's bad YT vids"));
			System.out.println("Loaded DivinePegasi's Hangout Bot");*/
            /*JDA GameInsights = new JDABuilder(AccountType.BOT).setToken("").build();
            GameInsights.addEventListener(new Status());
            GameInsights.addEventListener(new GS_Debug());
            GameInsights.addEventListener(new Say());
            GameInsights.addEventListener(new Shutdown());
            Runtime.getRuntime().exec("java -jar verify.jar");
            System.out.println("Loaded Game Insights + Auxillary Jar File");*/
			JDA mcd = new JDABuilder(AccountType.BOT).setToken("").build();
			mcd.addEventListener(new Spam());
			mcd.addEventListener(new Say());
			mcd.addEventListener(new Debug());
			mcd.addEventListener(new Status());
			mcd.addEventListener(new Shutdown());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}