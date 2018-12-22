package com.divine.bot;

import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Help extends AdminCommand {

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		StringBuilder m = new StringBuilder();
		m.append("---**Commands**---");
		m.append("!server <lock/unlock> - Toggle server lockdown. (J-Mod+) \n");
		m.append("!promote <track media/staff> <@user> - Promote users. (Admin+)\n");
		m.append("!slowmode(sm, slowdown, sd) <int second> - Slowdown Chat. (J-Mod+)\n");
		m.append("-status <Game GAME> <String status> Possible games: WATCHING, LISTENING, PLAYING - Change bot status. (Admin+)\n");
		m.append("!archive(a) - Move channel to Archived category. (Admin+)\n");
		m.append("-shutdown - Shutdown bot if problem. (Admin+)\n");
		m.append("!help(h) - Help Command. (J-Mod+)\n");
		e.getChannel().sendMessage(m).queue();
		
	}

	@Override
	public List<String> getAliases() { return Arrays.asList("!h", "!help"); }

	@Override
	public String getName() { return "Help Command"; }

	@Override
	public Permission getPerm() { return Permission.MESSAGE_MANAGE; }

}
