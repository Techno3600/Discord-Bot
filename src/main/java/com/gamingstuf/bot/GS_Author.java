package com.gamingstuf.bot;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GS_Author extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e) {
		MessageChannel channel = e.getChannel();
		Message message = e.getMessage();
		String content = message.getContentRaw();
		if (content.startsWith("-author")) {
			EmbedBuilder _e = new EmbedBuilder();
			_e.setAuthor(e.getAuthor().getName());
			_e.setColor(Color.BLUE);
			_e.setThumbnail(e.getGuild().getMemberById("323864143423864833").getUser().getEffectiveAvatarUrl());
			_e.setDescription("I was created by Wiz_Techno.");
			channel.sendMessage(_e.build()).queue();
			
		}
	}
}