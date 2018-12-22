package com.bot.functions;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;

public class F {
	public Member getM(Guild g, String s)
	{
		String m1 = s.replaceAll("<", "");
		m1 = m1.replaceAll("!", "");
		m1 = m1.replaceAll(">", "");
		m1 = m1.replaceAll("@", "");
		m1 = m1.trim();
		return g.getMemberById(Long.parseLong(m1));
	}
}
