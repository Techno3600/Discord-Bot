package com.bot.main;

import java.util.Arrays;
import java.util.List;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.requests.Route;
import net.dv8tion.jda.core.requests.restaction.MessageAction;

public class Say extends AdminCommand {
	public void onCommand(MessageReceivedEvent e, String[] args) {
		MessageChannel channel = e.getChannel();
		Message message = e.getMessage();
		String content = message.getContentRaw();
		String _m = content.replaceAll("-say", "");
		channel.sendMessage(_m).queue();
		//MessageAction f = new MessageAction(e.getJDA(), Route.Messages.SEND_MESSAGE.compile(e.getChannel().getId()), e.getChannel());
	}
	@Override
	public List<String> getAliases() { return Arrays.asList("-say", "-s"); }

	@Override
	public String getName() { return "Say Command"; }
	
	public Permission getPerm() {return Permission.MESSAGE_MANAGE; }
}