package com.other.bot;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import com.bot.functions.F;
import com.bot.main.WizCommand;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Spam extends WizCommand {

	@Override
	public List<String> getAliases() {
		return Arrays.asList("!spam");
	}

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		int i = Integer.parseInt(args[1]);
		EmbedBuilder f = new EmbedBuilder();
		f.setAuthor("Admin Action");
		f.setTitle("SPAM");
		f.setColor(Color.RED);
		f.setDescription("WARNING. SPAM IS ABOUT TO COMMENCE. TAKE SHELTER AND SUBSCRBE TO PEWDIEPIE.");
		f.setFooter("This was an automated action initiated by an Administrator", e.getGuild().getIconUrl());
		e.getChannel().sendMessage(f.build()).queue(new Consumer<Message>() {
			@Override
			public void accept(Message t) {
				t.pin().queue();
				t.addReaction("\u26A0").queue();
			}
		});
		for (int i1 = 0; i1 < i; i1++)
		{
			e.getChannel().sendMessage(F.getM(e.getGuild(), args[2]).getAsMention()).queueAfter(10, TimeUnit.SECONDS);
		}
	}

}
