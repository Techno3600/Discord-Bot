package com.ci.bot;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CI_Join extends ListenerAdapter {
	public void onGuildMemberJoin(GuildMemberJoinEvent e)
	{
		e.getGuild().getController().addSingleRoleToMember(e.getMember(), e.getGuild().getRoleById(526618293868691456L)).complete();
		e.getGuild().getTextChannelById(461226213143478272L).sendMessage(msg(e.getMember()).build()).queue();
	}
	private EmbedBuilder msg(Member m)
	{
		EmbedBuilder f = new EmbedBuilder();
		f.setAuthor("New User!");
		f.setColor(Color.CYAN);
		f.setDescription(m.getAsMention() + " (" + m.getEffectiveName() + ") has joined the discord!");
		f.setFooter("This was an automated action initiated by a user joining.", "https://cdn.discordapp.com/icons/461206102982393876/c166ca0206eb6c7e83cc348616d0894d.png");
		return f;
		
	}
}
