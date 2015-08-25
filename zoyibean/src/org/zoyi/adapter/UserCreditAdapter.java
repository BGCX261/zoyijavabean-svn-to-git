package org.zoyi.adapter;

import org.zoyi.hibernate.BenifitActivityDAO;
import org.zoyi.vo.BenifitActivity;
import org.zoyi.vo.Userinfo;

public class UserCreditAdapter {
	public static org.zoyi.vo.UserCredit toVo(org.zoyi.po.UchomeUserevent uu) {
		org.zoyi.vo.UserCredit uc = new org.zoyi.vo.UserCredit();
		uc.setBaid(uu.getId().getEventid());
		BenifitActivity ba = new BenifitActivity();
		ba.setId(uu.getId().getEventid());
		ba.setActivityName(new BenifitActivityDAO()
				.get(uu.getId().getEventid()).getTitle());
		uc.setBenifitActivity(ba);
		uc.setCredit(uu.getCredit());
		uc.setDarkmind(uu.getDarkmind());
		uc.setGetCreditDate(uu.getGetcreditdate());
		uc.setUid(uu.getId().getUid());
		Userinfo ui = new Userinfo();
		ui.setUserId(uu.getId().getUid());
		ui.setUsername(uu.getUsername());
		uc.setUserinfo(ui);
		return uc;
	}

	public static org.zoyi.po.UchomeUserevent toPo(org.zoyi.vo.UserCredit uc) {
		org.zoyi.po.UchomeUserevent uu = new org.zoyi.po.UchomeUserevent();
		uu.setCredit(uc.getCredit());
		uu.setDarkmind(uc.getDarkmind());
		uu.setDateline((int) new java.util.Date().getTime() / 1000);
		uu.setGetcreditdate(uc.getGetCreditDate());
		uu.setId(new org.zoyi.po.UchomeUsereventId(uc.getBaid(), uc.getUid()));
		uu.setUsername(uc.getUserinfo().getUsername());
		return uu;
	}
}
