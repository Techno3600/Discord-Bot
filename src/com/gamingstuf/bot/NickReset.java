package com.gamingstuf.bot;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class NickReset extends AdminCommand {

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		e.getChannel().sendMessage(nickEmbed(e.getGuild()).build()).queue();
		for (Member m : e.getGuild().getMembers())
		{
			try {
				e.getChannel().sendMessage(m.getAsMention() + "'s previous nickname: " + m.getNickname()).queue();
				m.getGuild().getController().setNickname(m, null).reason("Nick reset").queue();
			} catch (Exception c)
			{
			}
		}
	}

	@Override
	public List<String> getAliases() { return Arrays.asList("!rn", "!resetnick"); }

	@Override
	public String getName() { return "Reset Name Command"; }

	@Override
	public Permission getPerm() { return Permission.MANAGE_SERVER; }
	
	private EmbedBuilder nickEmbed(Guild g)
	{
		EmbedBuilder f = new EmbedBuilder();
		f.setAuthor("Admin Action");
		f.setTitle("Server Nickname Reset");
		f.setColor(Color.RED);
		f.setDescription("All nicknames are being reset...");
		f.setFooter("This command was actioned by an Administrator", g.getIconUrl());
		return f;
	}

}
