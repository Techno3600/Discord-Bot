package com.mf.bot;

import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Commands extends AdminCommand {
	
	public void onCommand(MessageReceivedEvent e, String[] args) {
		StringBuilder f = new StringBuilder();
		f.append("Commands: \n");
		f.append("Say Command: -say (message) \n");
		f.append("Shutdown Command: -shutdown \n");
		f.append("Slowmode Command: -slowdown/sm (int) \n");
		f.append("Author Command: -author \n");
		f.append("Shutdown Command: -shutdown \n");
		f.append("Debug Command: -debug \n");
		e.getChannel().sendMessage(f).queue();	
	}
	@Override
	public List<String> getAliases() { return Arrays.asList("-commands", "-c"); }

	@Override
	public String getName() { return "Command Lister Command"; }

	@Override
	public Permission getPerm() {return Permission.MESSAGE_MANAGE; }
}
