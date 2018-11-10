package com.gamingstuf.bot;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GS_Archive extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e) {
		MessageChannel channel = e.getChannel();
		Message message = e.getMessage();
		String content = message.getContentRaw();
		if (content.startsWith("-a")) {
			String _m = content.replaceAll("-a", "");
			_m = _m.replaceAll("#", "");
			_m = _m.replaceAll("<", "");
			_m = _m.replaceAll(">", "");
			_m = _m.trim();
			long _c = 0;
			try {
				_c = Long.parseLong(_m);
			} catch (Exception e2) {
				e.getAuthor().openPrivateChannel().complete().sendMessage("Correct Usage: *-a <channel>*, ``<channel>`` have a ``#``, Example: ``#commands`` but NOT: ``commands``").queue();
				channel.deleteMessageById(e.getMessageId()).complete();
			}
			if (e.getMember().hasPermission(Permission.MANAGE_CHANNEL)) {
				if (!(_m.isEmpty())) {
					if (!(e.getAuthor().isBot())) {
						if (e.getGuild().getTextChannelById(_c) != null) {
							TextChannel _t = e.getGuild().getTextChannelById(_c);
								if (e.getGuild().getCategoryById(500153831666221056L).getTextChannels().contains(_t)) {
									//_t.getGuild().getCategoryById(500153831666221056L).move
								} else {
									channel.sendMessage("Category Doesn't Contain Channel Error").queue();
								}
							} else {
								channel.sendMessage("Text Channel Error").queue();
							}
					}
				} else {
					channel.deleteMessageById(e.getMessageId()).complete();
					e.getAuthor().openPrivateChannel().complete().sendMessage("Correct Usage: *-a <channel>*").queue();
					channel.sendMessage("_m Empty Error").queue();
				}
			} else if (!(e.getMember().hasPermission(Permission.MANAGE_CHANNEL))) {
				channel.deleteMessageById(e.getMessageId()).complete();
				channel.sendMessage("No Perms Error").queue();
			}
		}
	}
}