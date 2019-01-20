package com.bot.main;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Slowmode extends AdminCommand {
	@Override
	public List<String> getAliases() { return Arrays.asList("!slowdown", "!sm", "!slowmode", "!sd"); }

	@Override
	public String getName() { return "Slowmode Command"; }
	
	@Override
	public Permission getPerm() {return Permission.MESSAGE_MANAGE; }
	private static int i;
	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		if (args.length == 1)
		{
			if (e.getTextChannel().getSlowmode() == 0)
			{
				e.getChannel().sendMessage("No time entered, defaulting to `5 seconds`.").queue();
				e.getTextChannel().getManager().setSlowmode(5).complete();
				e.getChannel().sendMessage(message(e.getMember(), e.getTextChannel(), 5, true).build()).queue();
			} else
			{
				e.getTextChannel().getManager().setSlowmode(0).complete();
				e.getChannel().sendMessage(message(e.getMember(), e.getTextChannel(), 0, false).build()).queue();
			}
		} else if (args.length == 2)
		{
			try {
				i = Integer.parseInt(args[1]);
			} catch (Exception e1) { e.getChannel().sendMessage("Invalid argument. Must be an integer.").queue(); }
			if (!(i == 0))
			{
				e.getTextChannel().getManager().setSlowmode(i).complete();
				e.getChannel().sendMessage(message(e.getMember(), e.getTextChannel(), i, true).build()).queue();
			} else
			{
				e.getTextChannel().getManager().setSlowmode(0).complete();
				e.getChannel().sendMessage(message(e.getMember(), e.getTextChannel(), 0, false).build()).queue();
			}
			
		} else { e.getChannel().sendMessage("Incorrect Usage. `-slowdown(-sm, -sd, -slowdown) <int>`").queue(); }
	}
	
	
	private EmbedBuilder message(Member m, TextChannel c, int s, boolean b)
	{
		EmbedBuilder f = new EmbedBuilder();
		f.setAuthor("Staff Action");
		f.setTitle("Channel Cooldown");
		if (b == false)
		{
			f.setDescription("Slowmode has ended.");
			f.setColor(Color.GREEN);
		} else
		{
			f.setDescription("Slowmode has taken effect on " + c.getAsMention() + " with a cooldown of `" + s + " seconds`.");
			f.setColor(Color.RED);
		}
		f.setFooter("Command actioned by " + m.getEffectiveName() + ".", "https://cdn.discordapp.com/icons/207553852147236864/c2d53e9f467990658a8010dd2c8c0442.png");
		return f;
	}
}
