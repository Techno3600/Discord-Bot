package com.divine.bot;

import java.util.Arrays;
import java.util.List;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Listener extends AdminCommand {
	private static List<Role> r;
	@Override
	public List<String> getAliases() { return Arrays.asList("!promote"); }

	@Override
	public String getName() { return "Promote Command"; }
	
	@Override
	public Permission getPerm() { return Permission.MANAGE_SERVER; }

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		if (args.length == 3)
			
		{
			Guild g = e.getGuild();
			String m1 = args[2].replaceAll("<", "");
			m1 = m1.replaceAll("!", "");
			m1 = m1.replaceAll(">", "");
			m1 = m1.replaceAll("@", "");
			m1 = m1.trim();
			Long l = Long.parseLong(m1);
			Member m = g.getMemberById(l);
			try {
				if (args[1].equalsIgnoreCase("staff")) { r = getRole(g, m, args[1]); }
				else if (args[1].equalsIgnoreCase("media")) { r = getRole(g, m, args[1]); }
				else { e.getChannel().sendMessage("Incorrect Usage. !promote <track> <@user> \\n Track: media, staff.").queue(); }
			} catch (IllegalArgumentException q) { e.getChannel().sendMessage("Incorrect Usage. !promote <track> <@user> \\n Track: media, staff.").queue(); }
			
			if (r.isEmpty()) { e.getChannel().sendMessage("Promotion Error - That role is already the highest role in that tack.").queue(); }
			
			g.getController().addRolesToMember(m, r).reason("Promotion Command. Initiated by " + e.getAuthor().getName()).complete();
			if (r.size() == 3)
			{
				g.getController().removeSingleRoleFromMember(m, r.get(2)).reason("Promotion Command. Initiated by " + e.getAuthor().getName()).complete();
			}
			e.getChannel().sendMessage(getMsg(m, r.get(0).getColorRaw(), e.getMember()).build()).queue();
		} else
		{
			e.getChannel().sendMessage("!promote <track> <@user> \n Track: media, staff.").queue();
		}
		
		
		
	}
	private List<Role> getRole(Guild g, Member m, String track)
	{
		Role media250 = g.getRoleById(207565303704584195L);
		Role media2k = g.getRoleById(296419655721943041L);
		Role staffJMod = g.getRoleById(418598981128421376L);
		Role staffMod = g.getRoleById(207565951439339522L);
		Role staffDev = g.getRoleById(518072415050399745L);
		
		Role mediaGroup = g.getRoleById(497578812972859402L);
		Role staffGroup = g.getRoleById(497579287054909463L);
		
		if (track.equalsIgnoreCase("staff"))
		{
			if (m.getRoles().contains(staffJMod)) { return Arrays.asList(staffMod, staffGroup, staffJMod); }
			else if (m.getRoles().contains(staffMod)) { return Arrays.asList(staffDev, staffGroup, staffMod); } 
			else if (m.getRoles().contains(staffDev)) { return Arrays.asList(); }
			else { return Arrays.asList(staffJMod, staffGroup); }
		} else if (track.equalsIgnoreCase("media"))
		{
			if (m.getRoles().contains(media250)) { return Arrays.asList(media2k, mediaGroup); }
			else if (m.getRoles().contains(media2k)) { return Arrays.asList(); }
			else { return Arrays.asList(media250, mediaGroup); }
		} else
		{
			return null;
		}
	}
	private EmbedBuilder getMsg(Member m, int hex, Member a)
	{
		EmbedBuilder f = new EmbedBuilder();
		f.setAuthor("Staff Action");
		f.setTitle("Promotion!");
		f.setColor(hex);
		f.setDescription(m.getAsMention() + " has been promoted to " + r.get(0).getName() + "!");
		f.setFooter("This was an automated action initiated by " + a.getEffectiveName() + ".", "https://cdn.discordapp.com/icons/207553852147236864/c2d53e9f467990658a8010dd2c8c0442.png");
		return f;
	}
}
