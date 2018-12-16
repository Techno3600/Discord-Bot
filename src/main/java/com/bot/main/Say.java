package com.bot.main;

import java.util.Arrays;
import java.util.List;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Say extends AdminCommand {
	public void onCommand(MessageReceivedEvent e, String[] args) {
		MessageChannel channel = e.getChannel();
		Message message = e.getMessage();
		String content = message.getContentRaw();
		String _m = content.replaceAll("-say", "");
		channel.sendMessage(_m).queue();
	}
	@Override
	public List<String> getAliases() { return Arrays.asList("-say", "-s"); }

	@Override
	public String getDescription() { return "Say something through bot."; }

	@Override
	public String getName() { return "Say Command"; }
	
	public Permission getPerm() {return Permission.MESSAGE_MANAGE; }

	@Override
	public List<String> getUsageInstructions() { return Arrays.asList("-say <message> - Say a message through bot."); }
}