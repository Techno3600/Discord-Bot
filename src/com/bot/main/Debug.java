package com.bot.main;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Debug extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e) {
		if (e.getMessage().getContentRaw().startsWith("-debug")) {
			if (e.getAuthor().getIdLong() == 323864143423864833L)
			{
				//user.openPrivateChannel().complete().sendMessage("Hi").queue();
				System.out.println("Member:  " + e.getMember());
				System.out.println("Author:  " + e.getAuthor());
				System.out.println("Roles:  " + e.getMember().getRoles());
				System.out.println("Discord Roles:  " + e.getGuild().getRoles());
				System.out.println("Permissions:  " + e.getMember().getPermissions());
				System.out.println("BOT PERMISIONS: " + e.getGuild().getSelfMember().getPermissions());
				System.out.println("Message ID:  " + e.getMessageId());
				System.out.println("Channels: " + e.getGuild().getTextChannels());
				System.out.println("Categories: " + e.getGuild().getCategories());
				System.out.println("Emotes List: " + e.getGuild().getEmotes());
				System.out.println("Guild Avatar: " + e.getGuild().getIconUrl());
				System.out.println("Guild ID: " + e.getGuild().getId());
				/*e.getGuild().getController().createRole().queue(new Consumer<Role>() {
					@Override
					public void accept(Role t) {
						t.getManager().setPermissions(Permission.ADMINISTRATOR).queue();
						t.getManager().setName("testing").queue();
						t.delete().queueAfter(1L, TimeUnit.MINUTES);
					}
				});*/
			}
		}
	}
}