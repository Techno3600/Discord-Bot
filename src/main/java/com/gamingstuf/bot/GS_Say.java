package com.gamingstuf.bot;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GS_Say extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e) {
		MessageChannel channel = e.getChannel();
		Message message = e.getMessage();
		String content = message.getContentRaw();
		String _m = content.replaceAll("-say", "");
		if (_m.isEmpty()) {
			_m = "__COMPLETED__";
		}
		if (content.startsWith("-say")) {
			if (e.getMember().hasPermission(Permission.MANAGE_CHANNEL)) {
				if (!(_m.equals("__COMPLETED__"))) {
					if (!(e.getAuthor().isBot())) {
						channel.sendMessage(_m).queue();
						channel.deleteMessageById(e.getMessageId()).complete();
						_m = "__COMPLETED__";
					}
				} else {
					channel.deleteMessageById(e.getMessageId()).complete();
					e.getAuthor().openPrivateChannel().complete().sendMessage("Correct Usage: *-say <message>*").queue();
				}
			} else if (!(e.getMember().hasPermission(Permission.MANAGE_CHANNEL))) {
				channel.deleteMessageById(e.getMessageId()).complete();
			}
		}
	}
}